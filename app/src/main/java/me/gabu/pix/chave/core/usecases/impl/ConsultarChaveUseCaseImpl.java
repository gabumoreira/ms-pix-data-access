package me.gabu.pix.chave.core.usecases.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.usecases.ConsultarChaveUseCase;

@Service
@AllArgsConstructor
public class ConsultarChaveUseCaseImpl implements ConsultarChaveUseCase {

    private final ChaveDAO dao;

    @Override
    public Chave run(UUID chaveId) {
        return dao.findById(chaveId);
    }

}
