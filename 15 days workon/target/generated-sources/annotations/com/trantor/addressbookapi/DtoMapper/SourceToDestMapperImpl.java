package com.trantor.addressbookapi.DtoMapper;

import com.trantor.addressbookapi.Dto.ContactDto;
import com.trantor.addressbookapi.model.ContactEntity;
import com.trantor.addressbookapi.model.MobileEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-01T14:15:57+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
public class SourceToDestMapperImpl implements SourceToDestMapper {

    @Override
    public ContactEntity dtoToEntity(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setContactId( contactDto.getContactId() );
        contactEntity.setFirstName( contactDto.getFirstName() );
        contactEntity.setLastName( contactDto.getLastName() );
        contactEntity.setEmailAddress( contactDto.getEmailAddress() );
        contactEntity.setCreatedBy( contactDto.getCreatedBy() );
        contactEntity.setCreatedDate( contactDto.getCreatedDate() );
        contactEntity.setUpdatedBy( contactDto.getUpdatedBy() );
        contactEntity.setUpdatedDate( contactDto.getUpdatedDate() );
        contactEntity.setIsActive( contactDto.getIsActive() );
        List<MobileEntity> list = contactDto.getMobileEntities();
        if ( list != null ) {
            contactEntity.setMobileEntities( new ArrayList<MobileEntity>( list ) );
        }

        return contactEntity;
    }

    @Override
    public ContactDto entityToDto(ContactEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ContactDto contactDto = new ContactDto();

        contactDto.setContactId( entity.getContactId() );
        contactDto.setFirstName( entity.getFirstName() );
        contactDto.setLastName( entity.getLastName() );
        contactDto.setEmailAddress( entity.getEmailAddress() );
        contactDto.setCreatedBy( entity.getCreatedBy() );
        contactDto.setCreatedDate( entity.getCreatedDate() );
        contactDto.setUpdatedBy( entity.getUpdatedBy() );
        contactDto.setUpdatedDate( entity.getUpdatedDate() );
        contactDto.setIsActive( entity.getIsActive() );
        List<MobileEntity> list = entity.getMobileEntities();
        if ( list != null ) {
            contactDto.setMobileEntities( new ArrayList<MobileEntity>( list ) );
        }

        return contactDto;
    }

    @Override
    public List<ContactDto> entityToDtoList(List<ContactEntity> contactEntities) {
        if ( contactEntities == null ) {
            return null;
        }

        List<ContactDto> list = new ArrayList<ContactDto>( contactEntities.size() );
        for ( ContactEntity contactEntity : contactEntities ) {
            list.add( entityToDto( contactEntity ) );
        }

        return list;
    }
}
