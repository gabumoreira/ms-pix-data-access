package me.gabu.pix.chave.adapters.http.in.dto.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import me.gabu.pix.chave.adapters.http.in.dto.ChaveDTO;
import me.gabu.pix.chave.core.model.Chave;

@Mapper
public interface ChaveDTOMapper {

    ChaveDTOMapper INSTANCE = Mappers.getMapper(ChaveDTOMapper.class);

    ChaveDTO modelToDto(Chave chave);

    Chave dtoToModel(ChaveDTO chavedto);

    Collection<ChaveDTO> modelToDto(Collection<Chave> chave);

}
