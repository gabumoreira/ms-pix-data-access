package me.gabu.pix.chave.core.usecases.impl;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.usecases.ListarChaveUseCase;

@Service
@AllArgsConstructor
public class ListarchaveUseCaseImpl implements ListarChaveUseCase {

    private final ChaveDAO dao;

    @Override
    public Collection<Chave> run(String nome) {

        if (StringUtils.hasLength(nome))
            return dao.findByNome(nome);

        return dao.listAll();
    }

    @Override
    public Collection<Chave> run(BigInteger agencia, BigInteger conta) {
        return dao.listByAgenciaConta(agencia, conta);
    }

}
