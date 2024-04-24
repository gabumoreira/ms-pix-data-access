package me.gabu.pix.chave.adapters.data.dao;

import java.util.Collection;
import java.util.UUID;

import me.gabu.pix.chave.core.model.Chave;

public interface ChaveDAO {

    public Chave findById(UUID id);
    public Chave save(Chave chave);
    public Collection<Chave> listAll();
    public Collection<Chave> findByNome(String name);
    public Chave update(Chave chave);
    public void delete(Chave chave);
}
