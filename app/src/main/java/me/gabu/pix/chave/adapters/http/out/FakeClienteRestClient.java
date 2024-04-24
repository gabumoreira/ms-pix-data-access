package me.gabu.pix.chave.adapters.http.out;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class FakeClienteRestClient {

    // Fake Rest Cliente que validaria se é uma conta PF ou PJ
    public Boolean isCPF(BigInteger agencia, BigInteger conta) {
        return BigInteger.ONE.add(agencia).add(conta).bitCount() % 2 == 0;
    }
}
