package com.trantor.addressbookapi.service;

import com.trantor.addressbookapi.Dto.ContactDto;
import com.trantor.addressbookapi.DtoMapper.SourceToDestMapper;
import com.trantor.addressbookapi.model.ContactEntity;
import com.trantor.addressbookapi.repositories.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerContactRepository customerRepo;

    public ContactDto saveCustomer(ContactDto dto) {
        return SourceToDestMapper.MAPPER.entityToDto(customerRepo.save(SourceToDestMapper.MAPPER.dtoToEntity(dto)));
    }

    public List<ContactDto> getCustomer(String firstName) {
        return SourceToDestMapper.MAPPER.entityToDtoList(customerRepo.findByFirstName(firstName));
    }

    public List<ContactDto> getAllCustomer() {
        return SourceToDestMapper.MAPPER.entityToDtoList(customerRepo.findAll());

    }

    public String updateCustomer(Long id) {
        ContactEntity entity = customerRepo.findById(id).get();
        entity.setIsActive("N");
        customerRepo.save(entity);
        return "updated successfully";

    }
}
