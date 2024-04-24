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
        final var matcher = pattern.matcher(chave.getValorChave());

        if (!matcher.matches())
            throw new UnprocessableEntityException("[" + chave.getValorChave() + "] não atende o padrão de [" + chave.getTipoChave() + "] ");

        if (chave.getValorChave().length() > getLimite())
            throw new UnprocessableEntityException("[" + chave.getValorChave() + "] maior que o limite de [" + getLimite() + "] ");

        if (Boolean.FALSE.equals(validate(chave.getValorChave())))
            throw new UnprocessableEntityException("[" + chave.getValorChave() + "] não atende o padrão de [" + chave.getTipoChave() + "] ");
    }

}
