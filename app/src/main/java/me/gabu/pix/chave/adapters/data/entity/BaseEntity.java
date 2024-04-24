package me.gabu.pix.chave.adapters.data.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseEntity extends AuditoriaEntity {

    @Id
    protected UUID id;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
        dataCriacao = LocalDate.now();
    }

}
