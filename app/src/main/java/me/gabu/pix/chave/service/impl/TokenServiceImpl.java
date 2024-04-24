package me.gabu.pix.chave.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import me.gabu.pix.chave.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String[] CHARACTERS = {
            "Ryu", "Ken", "Chun-Li", "Guile", "Zangief", 
            "Dhalsim", "Blanka", "E. Honda", "Balrog", 
            "Vega", "Sagat", "M. Bison", "Akuma"
        };

    @Override
    public String recuperarUsuario(String token) {
        // Serviço dummy, nada para ver aqui
        return CHARACTERS[ThreadLocalRandom.current().nextInt(CHARACTERS.length)];
    }

    @Override
    public void validaToken(String token) {
        // Serviço dummy, nada para ver aqui
    }

}
