package me.gabu.pix.chave.core.usecases;

import java.math.BigInteger;

public interface ContarChaveUseCase {
    Integer run(BigInteger agencia, BigInteger conta);
}
