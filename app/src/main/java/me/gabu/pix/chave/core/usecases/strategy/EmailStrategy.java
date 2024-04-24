package me.gabu.pix.chave.core.usecases.strategy;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.core.model.TipoChave;

@Service
@AllArgsConstructor
public class EmailStrategy implements ChaveStrategy {

    @Override
    public boolean match(TipoChave tipo) {
        return TipoChave.EMAIL.equals(tipo);
    }

    @Override
    public String getRegex() {
        return "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    }

    @Override
    public Integer getLimite() {
        return 77;
    }

    @Override
    public Boolean validate(String chave) {
        return Boolean.TRUE;
    }

}
