package me.gabu.pix.chave.adapters.data.entity.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.pix.chave.adapters.data.entity.ChaveEntity;
import me.gabu.pix.chave.core.model.Chave;

@Mapper
public interface ChaveEntityMapper {

    ChaveEntityMapper INSTANCE = Mappers.getMapper(ChaveEntityMapper.class);

    ChaveEntity chaveToChaveEntity(Chave chave);

    Chave chaveEntityToChave(ChaveEntity chaveEntity);

    Collection<ChaveEntity> chaveToChaveEntity(Collection<Chave> chave);

    Collection<Chave> chaveEntityToChave(Collection<ChaveEntity> chaveEntity);

}
