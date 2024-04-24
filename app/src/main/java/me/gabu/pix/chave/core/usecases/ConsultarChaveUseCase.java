package me.gabu.pix.chave.core.usecases;

import java.util.UUID;

import me.gabu.pix.chave.core.model.Chave;

public interface ConsultarChaveUseCase {
    Chave run(UUID chaveId);
    Chave run(String valorChave);
}
