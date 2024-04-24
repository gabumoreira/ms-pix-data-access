package me.gabu.pix.chave.core.usecases.strategy;

import java.util.InputMismatchException;

import org.springframework.stereotype.Service;

import me.gabu.pix.chave.core.model.TipoChave;

@Service
public class CPFStrategy implements ChaveStrategy {

    @Override
    public boolean match(TipoChave tipo) {
        return TipoChave.CPF.equals(tipo);
    }

    @Override
    public String getRegex() {
        return "^(0{0,3}[1-9]|0?[1-9]\\d{1,2}){3}(0{0,2}[1-9]|0?[1-9]\\d)$";
    }

    @Override
    public Integer getLimite() {
        return 11;
    }

    //Calculo padrão de internet
    @Override
    public Boolean validate(String chave) {
        if (chave.equals("00000000000") || chave.equals("11111111111") || chave.equals("22222222222")
                || chave.equals("33333333333") || chave.equals("44444444444") || chave.equals("55555555555")
                || chave.equals("66666666666") || chave.equals("77777777777") || chave.equals("88888888888")
                || chave.equals("99999999999") || (chave.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (chave.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (chave.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if ((dig10 == chave.charAt(9)) && (dig11 == chave.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
