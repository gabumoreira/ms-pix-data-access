package me.gabu.pix.chave.core.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auditoria {

    protected LocalDate dataCriacao;
    protected LocalDate dataAlteracao;
    protected String usuarioCriacao;
    protected String usuarioAlteracao;

}
