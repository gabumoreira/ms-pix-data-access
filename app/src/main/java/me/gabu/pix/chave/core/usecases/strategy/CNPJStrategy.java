package me.gabu.pix.chave.core.usecases.strategy;

import java.util.InputMismatchException;

import org.springframework.stereotype.Component;

import me.gabu.pix.chave.core.model.TipoChave;

@Component
public class CNPJStrategy implements ChaveStrategy {

    @Override
    public boolean match(TipoChave tipo) {
        return TipoChave.CNPJ.equals(tipo);
    }

    @Override
    public String getRegex() {
        return "^0*(\\\\d{1,12})$";
    }

    @Override
    public Integer getLimite() {
        return 14;
    }

    // Calculo padrão de internet
    @Override
    public Boolean validate(String chave) {
        if (chave.equals("00000000000000") || chave.equals("11111111111111") || chave.equals("22222222222222")
                || chave.equals("33333333333333") || chave.equals("44444444444444") || chave.equals("55555555555555")
                || chave.equals("66666666666666") || chave.equals("77777777777777") || chave.equals("88888888888888")
                || chave.equals("99999999999999") || (chave.length() != 14))
            return (false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = (int) (chave.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else
                dig13 = (char) ((11 - r) + 48);

            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (chave.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else
                dig14 = (char) ((11 - r) + 48);
            if ((dig13 == chave.charAt(12)) && (dig14 == chave.charAt(13)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
