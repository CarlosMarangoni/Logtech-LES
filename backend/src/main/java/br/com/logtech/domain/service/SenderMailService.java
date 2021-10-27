package br.com.logtech.domain.service;

import br.com.logtech.domain.model.Entrega;
import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.ProdutoNota;
import br.com.logtech.domain.repository.EntregaRepository;
import br.com.logtech.domain.repository.NotaFiscalRepository;
import br.com.logtech.domain.repository.ProdutoNotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class SenderMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private ProdutoNotaRepository produtoNotaRepository;

    @Async
    public void enviar(Entrega entrega) {
        NotaFiscal nota = entrega.getEntregaPK().getNota();

        List<ProdutoNota> produtosNota = produtoNotaRepository.findAllByProdutoNotaPK_NotaFiscal(nota);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String emailCliente = nota.getCliente().getEmail();
        String mensagem = "";
        BigDecimal total = BigDecimal.ZERO;
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message,true);


            String assuntoEmail = "Entrega realizada! Pesquisa de satisfação";
            helper.setSubject(assuntoEmail);
            mensagem += "<span style='font-size:40px'>Olá, os produtos encomendados foram entregues!</span><br>"
                    + "<b style='font-size:30px'>Recibo: </b><br>"
                    + "<div style='display:flex;justity-content:center; font-size:20px;color:black'><table style='width:700px;text-align:center;'><thead><tr>"
                    + "<th>Quantidade</th><th>Descrição</th><th>Preço unitário</th>"
                    + "</tr></thead>"; //Header da tabela do email

            mensagem += "<tbody>";
            for(ProdutoNota i : produtosNota) {
                mensagem += "<tr><td>"+ i.getQuantidade() +"</td><td>"
                        + i.getProdutoNotaPK().getProduto().getDescricao()+"</td><td>" //Itens do recibo
                        +"R$ " + df.format(i.getValorUnitario()) + "</td>";
                total = total.add(i.getValorUnitario());
            }

            mensagem += "</tbody></table></div>" + "<br>" + "<span style='font-size:30px'>Total:" +"R$ " + df.format(total) +"</span><br><br>";

            mensagem += "<p>Seu feedback é muito importante para nós, deixe uma <a href='www.google.com.br'>Pesquisa de Satistação</a></p>";

            helper.setText(mensagem,true);
            helper.setFrom(emailFrom);
            helper.setTo(emailCliente);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }
}
