package me.gabu.pix.chave.core.usecases;

import java.math.BigInteger;
import java.util.Collection;

import me.gabu.pix.chave.core.model.Chave;

public interface ListarChaveUseCase {

    Collection<Chave> run(String nome);
    Collection<Chave> run(BigInteger agencia, BigInteger conta);

}
