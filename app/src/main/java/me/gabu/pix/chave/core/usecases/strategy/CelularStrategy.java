package me.gabu.pix.chave.core.usecases.strategy;

import org.springframework.stereotype.Component;

import me.gabu.pix.chave.core.model.TipoChave;

@Component
public class CelularStrategy implements ChaveStrategy {

    @Override
    public boolean match(TipoChave tipo) {
        return TipoChave.CELULAR.equals(tipo);
    }

    @Override
    public String getRegex() {
        return "^\\+\\d{1,3}\\d{1,3}\\d{9}$";
    }

    @Override
    public Integer getLimite() {
        return 16;
    }

    @Override
    public Boolean validate(String chave) {
        return Boolean.TRUE;
    }

}
