package me.gabu.pix.chave.adapters.http.in.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gabu.pix.chave.core.model.TipoChave;

@Getter
@Setter
@ToString
@ApiModel("Chave")
public class ChaveDTO {

    @ApiModelProperty("ID do chave no padrão UUID")
    private UUID id;

    @ApiModelProperty("Tipo de chave")
    private TipoChave tipoChave;
    @ApiModelProperty("Tipo da conta da chave")
    private TipoChave tipoConta;
    @ApiModelProperty("Valor da chave")
    private String chave;

    @ApiModelProperty("Agencia da chave (até 4 digitos)")
    private BigInteger agencia;
    @ApiModelProperty("Conta da chave (até 8 digitos)")
    private BigInteger conta;

    @ApiModelProperty("Nome do chave")
    private String nome;
    @ApiModelProperty("Nacionalidade do chave")
    private String sobrenome;

    @ApiModelProperty("Usuario responsavel pelo cadastro do chave no sistema")
    private String usuarioCriacao;
    @ApiModelProperty("Usuario responsavel pela ultima alteração do chave no sistema")
    private String usuarioAlteracao;

    @ApiModelProperty("Data do cadastro do chave no sistema")
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDate dataCriacao;
    @ApiModelProperty("Data da ultima alteração do chave no sistema")
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDate dataAlteracao;

    @ApiModelProperty("Indicador se a chave esta habilitada ou não")
    private boolean habilitada;
}
