package me.gabu.pix.chave.adapters.data.dao.impl;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabu.pix.chave.adapters.data.dao.ChaveDAO;
import me.gabu.pix.chave.adapters.data.entity.ChaveEntity;
import me.gabu.pix.chave.adapters.data.entity.mapper.ChaveEntityMapper;
import me.gabu.pix.chave.adapters.data.repository.ChaveRepository;
import me.gabu.pix.chave.core.exceptions.NotFoundException;
import me.gabu.pix.chave.core.model.Chave;

@Slf4j
@Service
@AllArgsConstructor
public class ChaveDAOImpl implements ChaveDAO {

    private final ChaveRepository repository;

    @Override
    public Chave findById(UUID id) {
        ChaveEntity chaveEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Chave Pix não encontrada"));
        return getMapper().chaveEntityToChave(chaveEntity);
    }

    @Override
    public Chave save(Chave chave) {
        ChaveEntity chaveEntity = getMapper().chaveToChaveEntity(chave);
        log.info("[DAO] [PERSIST] [{}]", chave);
        return getMapper().chaveEntityToChave(repository.save(chaveEntity));
    }

    @Override
    public Collection<Chave> listAll() {
        return getMapper().chaveEntityToChave(repository.findAll());
    }

    @Override
    public Collection<Chave> findByNome(String name) {
        return getMapper().chaveEntityToChave(repository.findByNome(name));
    }

    @Override
    public Chave update(Chave chave) {
        ChaveEntity chaveEntity = getMapper().chaveToChaveEntity(chave);
        log.info("[DAO] [UPDATE] [{}]", chave);
        return getMapper().chaveEntityToChave(repository.save(chaveEntity));
    }

    @Override
    public void delete(Chave chave) {
        repository.deleteById(chave.getId());
    }

    protected ChaveEntityMapper getMapper() {
        return ChaveEntityMapper.INSTANCE;
    }
}
