package me.gabu.pix.chave.core.usecases.strategy;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.gabu.pix.chave.core.model.TipoChave;

@Service
@AllArgsConstructor
public class AleatoriaStrategy implements ChaveStrategy {

    @Override
    public boolean match(TipoChave tipo) {
        return TipoChave.ALEATORIA.equals(tipo);
    }

    @Override
    public String getRegex() {
        return "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    }

    @Override
    public Integer getLimite() {
        return 36;
    }

    @Override
    public Boolean validate(String chave) {
        try {
            UUID.fromString(chave);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
