package br.com.logtech.domain.service;

import br.com.logtech.domain.exception.EntradaInvalidaException;
import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Endereco;
import br.com.logtech.domain.model.Entrega;
import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.Romaneio;
import br.com.logtech.domain.model.dto.RomaneioForm;
import br.com.logtech.domain.model.maps.PlaceDetails;
import br.com.logtech.domain.model.maps.PlaceDetailsResponse;
import br.com.logtech.domain.model.pk.EntregaPK;
import br.com.logtech.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RomaneioService {

    private final String geocodeAPI = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    @Value("${logtech.location.latitude}")
    private String latitudePartida;

    @Value("${logtech.location.longitude}")
    private String longitudePartida;

    @Value("${google.maps.apikey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RomaneioRepository romaneioRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public Romaneio cadastrar(RomaneioForm romaneioForm) {
        Romaneio romaneio = new Romaneio();
        AtomicInteger atomicSum = new AtomicInteger(0);
        romaneio.setLatitudePartida(latitudePartida);
        romaneio.setLongitudePartida(longitudePartida);
        romaneio.setMotorista(funcionarioRepository.findById(romaneioForm.getMotoristaId()).orElseThrow(() -> new EntradaInvalidaException("Funcionario nao encontrado.")));
        romaneio.setVeiculo(veiculoRepository.findById(romaneioForm.getVeiculoId()).orElseThrow(() -> new EntradaInvalidaException("Veiculo nao encontrado.")));
        romaneioRepository.save(romaneio);
        romaneioForm.getNotas().forEach(n -> {
            NotaFiscal notaFiscal = notaFiscalRepository.findById(n.getIdNota()).orElseThrow(() -> new EntradaInvalidaException("Nota fiscal nao encontrada."));
            EntregaPK entregaPk = new EntregaPK(notaFiscal, romaneio);
            Entrega entrega = new Entrega(entregaPk);
            entrega.setSequencia(atomicSum.incrementAndGet());
            PlaceDetailsResponse detalhesEndereco = getCoordenadas(notaFiscal);
            if (detalhesEndereco.getStatus().equals("OK")) {
                PlaceDetails[] coordenadas = detalhesEndereco.getResults();
                entrega.setLatitude(coordenadas[0].getGeometry().getLocation().getLat());
                entrega.setLongitude(coordenadas[0].getGeometry().getLocation().getLng());
                entregaRepository.save(entrega);
                romaneio.getNotas().add(entrega);
            } else {
                throw new EntradaInvalidaException("Endereco invalido.");
            }
        });
        return romaneio;

    }

    public PlaceDetailsResponse getCoordenadas(NotaFiscal notaFiscal) {
        Endereco endereco = notaFiscal.getEndereco();
        String requisicao = endereco.getLogradouro() + "," + endereco.getNumero() +
                "," + endereco.getCidade() + "," + endereco.getEstado();
        requisicao = requisicao.replace(" ", "+");
        PlaceDetailsResponse response = restTemplate.getForObject(geocodeAPI + requisicao + "&key=" + apiKey, PlaceDetailsResponse.class);


        return response;
    }

    public Entrega entregar(Long romaneioId, Long notaId) {
        Romaneio romaneio = romaneioRepository.findById(romaneioId).orElseThrow(() -> new PageNotFoundException("Pagina nao encontrada. Verifique se o Romaneio existe."));
        NotaFiscal nota = notaFiscalRepository.findById(notaId).orElseThrow(() -> new PageNotFoundException("Pagina nao encontrada. Verifique se a nota fiscal está atrelada ao Romaneio."));
        List<Entrega> entregas = entregaRepository.findAllByEntregaPK_Romaneio(romaneio);
        for (Entrega e : entregas) {
            if (e.getEntregaPK().getNota().equals(nota)) {
                e.setDataChegada(OffsetDateTime.now());
                entregaRepository.save(e);
                return e;
            }
        }


        throw new PageNotFoundException("Pagina nao encontrada.");
    }
}
