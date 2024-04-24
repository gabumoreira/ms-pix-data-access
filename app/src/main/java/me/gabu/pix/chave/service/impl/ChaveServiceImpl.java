package me.gabu.pix.chave.service.impl;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.adapters.http.out.FakeClienteRestClient;
import me.gabu.pix.chave.core.exceptions.NotFoundException;
import me.gabu.pix.chave.core.exceptions.UnprocessableEntityException;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.usecases.AtualizarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ConsultarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ContarChaveUseCase;
import me.gabu.pix.chave.core.usecases.CriarChaveUseCase;
import me.gabu.pix.chave.core.usecases.InativarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ListarChaveUseCase;
import me.gabu.pix.chave.service.ChaveService;

@Service
@AllArgsConstructor
public class ChaveServiceImpl implements ChaveService {

    private static final int LIMITE_PF = 5;
    private static final int LIMITE_PJ = 20;
    
    private final CriarChaveUseCase criarChave;
    private final ContarChaveUseCase contarChave;
    private final ConsultarChaveUseCase consultarChave;
    private final AtualizarChaveUseCase atualizarChave;
    private final ListarChaveUseCase listarchave;
    private final InativarChaveUseCase apagarChave;

    private final FakeClienteRestClient rest;

    @Override
    public Chave criarChave(Chave chave, String usuario) {
        final var chavesCadastradas = contarChave.run(chave.getAgencia(), chave.getConta());
        final var isPF = rest.isCPF(chave.getAgencia(), chave.getConta());

        if(Boolean.TRUE.equals(isPF) && chavesCadastradas >= LIMITE_PF)
            throw new UnprocessableEntityException("Chave Pix overflow PF: " + LIMITE_PF);

        if(Boolean.FALSE.equals(isPF) && chavesCadastradas >= LIMITE_PJ)
            throw new UnprocessableEntityException("Chave Pix overflow PJ: " + LIMITE_PJ);

        if(consultarChave.run(chave.getValorChave()) != null)
            throw new UnprocessableEntityException("Chave Pix já existe");

        return criarChave.run(chave, usuario);
    }

    @Override
    public Chave consultarChave(UUID chaveId) {
        return Optional.ofNullable(consultarChave.run(chaveId)).orElseThrow(() -> new NotFoundException("[" + chaveId + "] Not Found"));
    }

    @Override
    public Chave atualizarChave(Chave chave, String usuario) {
        return atualizarChave.run(chave, usuario);
    }

    @Override
    public Collection<Chave> listarchave(String nome) {
        return listarchave.run(nome);
    }

    @Override
    public void apagarChave(UUID chaveId, String usuario) {
        apagarChave.run(chaveId, usuario);
    }

    @Override
    public Collection<Chave> listarChaves(BigInteger agencia, BigInteger conta) {
        return listarchave.run(agencia, conta);
    }

}
