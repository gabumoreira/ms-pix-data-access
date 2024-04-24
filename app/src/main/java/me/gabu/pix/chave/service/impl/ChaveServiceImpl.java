package me.gabu.pix.chave.service.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.core.exceptions.NotFoundException;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.usecases.AtualizarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ConsultarChaveUseCase;
import me.gabu.pix.chave.core.usecases.CriarChaveUseCase;
import me.gabu.pix.chave.core.usecases.InativarChaveUseCase;
import me.gabu.pix.chave.core.usecases.ListarChaveUseCase;
import me.gabu.pix.chave.service.ChaveService;

@Service
@AllArgsConstructor
public class ChaveServiceImpl implements ChaveService {

    private final CriarChaveUseCase criarChave;
    private final ConsultarChaveUseCase consultarChave;
    private final AtualizarChaveUseCase atualizarChave;
    private final ListarChaveUseCase listarchave;
    private final InativarChaveUseCase apagarChave;

    @Override
    public Chave criarChave(Chave chave, String usuario) {
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

}
