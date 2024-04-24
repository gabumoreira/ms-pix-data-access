package me.gabu.pix.chave.core.usecases.strategy;

import java.util.regex.Pattern;

import me.gabu.pix.chave.core.exceptions.UnprocessableEntityException;
import me.gabu.pix.chave.core.model.Chave;
import me.gabu.pix.chave.core.model.TipoChave;

public interface ChaveStrategy {

    public boolean match(TipoChave tipo);

    public String getRegex();

    public Integer getLimite();

    public Boolean validate(String chave);

    public default void validate(Chave chave) throws UnprocessableEntityException {
        final var pattern = Pattern.compile(getRegex());
        final var matcher = pattern.matcher(chave.getChave());

        if (!matcher.matches())
            throw new UnprocessableEntityException("[" + chave.getChave() + "] não atende o padrão de [" + chave.getTipoChave() + "] ");

        if (chave.getChave().length() > getLimite())
            throw new UnprocessableEntityException("[" + chave.getChave() + "] maior que o limite de [" + getLimite() + "] ");

        if (Boolean.FALSE.equals(validate(chave.getChave())))
            throw new UnprocessableEntityException("[" + chave.getChave() + "] não atende o padrão de [" + chave.getTipoChave() + "] ");
    }

}
