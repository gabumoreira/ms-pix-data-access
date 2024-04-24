package me.gabu.pix.chave.core.exceptions;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

    @Getter
    private final Collection<String> messages;

    public UnprocessableEntityException(String mensagem) {
        super(mensagem);
        messages = Arrays.asList(mensagem);
    }

    public UnprocessableEntityException(Collection<String> mensagens) {
        messages = mensagens;
    }

    private static final long serialVersionUID = 1L;

}
