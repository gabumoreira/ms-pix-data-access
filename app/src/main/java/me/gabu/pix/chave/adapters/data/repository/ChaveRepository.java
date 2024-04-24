package me.gabu.pix.chave.adapters.data.repository;

import java.math.BigInteger;
import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.gabu.pix.chave.adapters.data.entity.ChaveEntity;

@Repository
public interface ChaveRepository extends JpaRepository<ChaveEntity, UUID> {

    ChaveEntity findByValorChave(String valorChave);

    Collection<ChaveEntity> findByAgenciaAndConta(BigInteger agencia, BigInteger conta);
    
    Integer countByAgenciaAndConta(BigInteger agencia, BigInteger conta);
}