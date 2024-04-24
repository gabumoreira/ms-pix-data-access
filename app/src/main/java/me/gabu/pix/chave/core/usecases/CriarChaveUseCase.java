package me.gabu.pix.chave.core.usecases;

import me.gabu.pix.chave.core.model.Chave;

public interface CriarChaveUseCase {
    Chave run(Chave chave, String usuario);
}
