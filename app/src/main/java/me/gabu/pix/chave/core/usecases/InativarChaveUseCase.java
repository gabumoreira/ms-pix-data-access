package me.gabu.pix.chave.core.usecases;

import java.util.UUID;

public interface InativarChaveUseCase {
    void run(UUID chaveId, String usuario);
}
