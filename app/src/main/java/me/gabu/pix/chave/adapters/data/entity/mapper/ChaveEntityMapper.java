package me.gabu.pix.chave.adapters.data.entity.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.pix.chave.adapters.data.entity.ChaveEntity;
import me.gabu.pix.chave.core.model.Chave;

@Mapper
public interface ChaveEntityMapper {

    ChaveEntityMapper INSTANCE = Mappers.getMapper(ChaveEntityMapper.class);

    ChaveEntity modelToEntity(Chave chave);

    Chave entityToModel(ChaveEntity chaveEntity);

    Collection<ChaveEntity> modelToEntity(Collection<Chave> chave);

    Collection<Chave> entityToModel(Collection<ChaveEntity> chaveEntity);

}
