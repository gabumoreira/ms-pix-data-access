package me.gabu.pix.chave.adapters.data.entity;

import java.time.LocalDate;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaEntity {

    protected LocalDate dataCriacao;
    protected LocalDate dataAlteracao;
    protected String usuarioCriacao;
    protected String usuarioAlteracao;

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
