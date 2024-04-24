
package me.gabu.pix.chave.service;

import java.util.Collection;
import java.util.UUID;

import me.gabu.pix.chave.core.model.Chave;

public interface ChaveService {

    public Chave criarChave(Chave chave, String usuario);

    public Chave consultarChave(UUID chaveId);

    public Chave atualizarChave(Chave chave, String usuario);

    public Collection<Chave> listarchave(String nome);

    public void apagarChave(UUID chaveId, String usuario);

}
