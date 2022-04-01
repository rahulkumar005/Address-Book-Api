package com.trantor.addressbookapi.DtoMapper;

import com.trantor.addressbookapi.Dto.ContactDto;
import com.trantor.addressbookapi.model.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SourceToDestMapper {

    SourceToDestMapper MAPPER = Mappers.getMapper(SourceToDestMapper.class);

    ContactEntity dtoToEntity(ContactDto contactDto);

    ContactDto entityToDto(ContactEntity entity);

    List<ContactDto> entityToDtoList(List<ContactEntity> contactEntities);

}
