package me.gabu.pix.chave.core.model;

import java.math.BigInteger;
import java.util.UUID;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.gabu.pix.chave.service.validations.Create;
import me.gabu.pix.chave.service.validations.Update;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Chave extends Auditoria {

    private static final String MSG_NULO = "não deve ser nulo";
    private static final String MSG_RANGE = "tem um limite de digitos";

    @NotNull(groups = Update.class, message = MSG_NULO)
    private UUID id;

    @NotNull(groups = { Update.class, Create.class }, message = MSG_NULO)
    private String chave;

    @NotNull(groups = { Update.class, Create.class }, message = MSG_NULO)
    private TipoChave tipoChave;

    @NotNull(groups = { Update.class, Create.class }, message = MSG_NULO)
    private TipoChave tipoConta;

    @NotNull(groups = Update.class, message = MSG_NULO)
    @Digits(groups = { Update.class, Create.class }, integer = 4, message = MSG_RANGE, fraction = 0)
    private BigInteger agencia;

    @NotNull(groups = Update.class, message = MSG_NULO)
    @Digits(groups = { Update.class, Create.class }, integer = 8, message = MSG_RANGE, fraction = 0)
    private BigInteger conta;

    @NotBlank(groups = { Update.class, Create.class }, message = MSG_NULO)
    private String nome;
    private String sobrenome;

    private boolean habilitada;
}
