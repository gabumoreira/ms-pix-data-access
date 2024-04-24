package me.gabu.pix.chave.adapters.data.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "TBPX_CHAV")
public class ChaveEntity extends BaseEntity {

    private String tipoChave;
    private String tipoConta;
    private String chave;
    private BigInteger agencia;
    private BigInteger conta;
    private String nome;
    private String sobrenome;

    private boolean habilitada;

}
