package me.gabu.pix.chave.core.usecases.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.usecases.AtualizarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ConsultarChaveUseCase;
import me.gabu.pix.chave.service.ValidationService;
import me.gabu.pix.chave.service.validations.ValidationEnum;

@Slf4j
@Service
@AllArgsConstructor
public class AtualizarChaveUseCaseImpl implements AtualizarChaveUseCase {

    private final ChaveDAO dao;
    private final ConsultarChaveUseCase consultarUC;
    private final ValidationService validator;

    @Override
    public Chave run(Chave chave, String usuario) {
        final var registroAnterior = consultarUC.run(chave.getId());

        validator.validate(chave, ValidationEnum.UPDATE);

        log.info("[USECASE] [UPDATE]\nRegistro anterior: {} \nRegistro recebido: {}", registroAnterior, chave);

        chave.setId(registroAnterior.getId());
        chave.setTipoChave(registroAnterior.getTipoChave());
        chave.setValorChave(registroAnterior.getValorChave());
        chave.setUsuarioAlteracao(usuario);
        chave.setUsuarioCriacao(registroAnterior.getUsuarioCriacao());
        chave.setDataCriacao(registroAnterior.getDataCriacao());

        return dao.update(chave);
    }

}
