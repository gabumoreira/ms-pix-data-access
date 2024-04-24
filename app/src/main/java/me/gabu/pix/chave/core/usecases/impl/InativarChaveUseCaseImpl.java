package me.gabu.pix.chave.core.usecases.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.core.usecases.InativarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ConsultarChaveUseCase;

@Slf4j
@Service
@AllArgsConstructor
public class InativarChaveUseCaseImpl implements InativarChaveUseCase {

    private final ChaveDAO dao;
    private final ConsultarChaveUseCase consultarUC;

    @Override
    public void run(UUID chaveId, String usuario) {
        log.info("[USECASE] [DELETE] {}", chaveId);
        final var chave =  consultarUC.run(chaveId);
        chave.setHabilitada(false);
        dao.update(chave);
    }

}
