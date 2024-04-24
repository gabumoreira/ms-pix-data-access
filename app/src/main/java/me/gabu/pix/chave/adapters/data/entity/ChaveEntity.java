package me.gabu.pix.chave.adapters.data.entity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
@Table(name = "TBPX_CHAV")
public class ChaveEntity {

    @Id
    @Column(name = "id", columnDefinition = "uuid")
    protected UUID id;

    @Column(name = "CHAR_TIPO_CHAV", columnDefinition = "varchar(9)")
    private String tipoChave;
    @Column(name = "CHAR_TIPO_CONT", columnDefinition = "varchar(10)")
    private String tipoConta;
    @Column(name = "CHAR_VALO_CHAV", columnDefinition = "varchar(77)")
    private String valorChave;
    @Column(name = "NUME_AGEN", columnDefinition = "decimal(4,0)")
    private BigInteger agencia;
    @Column(name = "NUME_CONT", columnDefinition = "decimal(8,0)")
    private BigInteger conta;
    @Column(name = "CHAR_NOME", columnDefinition = "varchar(30)")
    private String nome;
    @Column(name = "CHAR_SOBR_NOME", columnDefinition = "varchar(45)")
    private String sobrenome;

    private boolean habilitada;

    @Column(name = "DATE_CREA", columnDefinition = "date")
    protected LocalDate dataCriacao;
    @Column(name = "DATE_ATUA", columnDefinition = "date")
    protected LocalDate dataAlteracao;
    @Column(name = "CHAR_USR_CREA", columnDefinition = "varchar(77)")
    protected String usuarioCriacao;
    @Column(name = "DATE_USR_ATUA", columnDefinition = "varchar(77)")
    protected String usuarioAlteracao;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
        dataCriacao = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = LocalDate.now();
    }

    @PostPersist
    public void postPersist() {
        log.info("[ENTITY] [POS-PERSIST] Usuario {} cadastrou chave pix {}", usuarioCriacao, this);
    }

    @PostUpdate
    public void postUpdate() {
        log.info("[ENTITY] [POS-UPDATE] Usuario {} atualizou chave pix {}", usuarioAlteracao, this);
    }

    @PostRemove
    public void postRemoval() {
        log.info("[ENTITY] [POS-REMOVAL] Usuario {} apagou chave pix {}", usuarioAlteracao, this);
    }

}
