package br.com.logtech.domain.service;

import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.dto.NotaFiscalForm;
import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    public NotaFiscal cadastrar(NotaFiscalForm notaFiscalForm) {
        NotaFiscal notaFiscal = NotaFiscal.toModel(notaFiscalForm);
        return notaFiscalRepository.save(notaFiscal);
    }
}
