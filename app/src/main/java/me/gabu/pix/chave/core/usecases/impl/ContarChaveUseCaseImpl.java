package me.gabu.pix.chave.core.usecases.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.core.usecases.ContarChaveUseCase;

@Service
@AllArgsConstructor
public class ContarChaveUseCaseImpl implements ContarChaveUseCase {

    private final ChaveDAO dao;

    @Override
    public Integer run(BigInteger agencia, BigInteger conta) {
        return dao.countByAgenciaConta(agencia, conta);
    }

}
