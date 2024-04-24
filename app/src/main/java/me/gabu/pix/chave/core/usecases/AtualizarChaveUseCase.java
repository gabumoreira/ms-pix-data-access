package me.gabu.pix.chave.core.usecases;

import me.gabu.pix.chave.core.model.Chave;

public interface AtualizarChaveUseCase {
    Chave run(Chave chave, String usuario);
}
