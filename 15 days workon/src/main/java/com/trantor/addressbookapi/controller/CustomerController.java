package com.trantor.addressbookapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trantor.addressbookapi.Dto.ContactDto;
import com.trantor.addressbookapi.externalservice.ExternalService;
import com.trantor.addressbookapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ExternalService externalService;

    @PostMapping("/customer_save/{isRemote}")
    public ContactDto saveCustomer(@RequestBody ContactDto dto, @PathVariable("isRemote") String flag) throws JsonProcessingException {
        if (flag.equals("y")) {
            return externalService.saveContact(dto);
        } else {
            return customerService.saveCustomer(dto);
        }


    }

    @GetMapping("/getCustomer/{name}/{isRemote}")
    public List<ContactDto> getCustomer(@PathVariable("name") String name, @PathVariable("isRemote") String flag) {
        if ((flag.equals("y"))) {
            return List.of(externalService.getContactByName(name));
        } else {
            return customerService.getCustomer(name);
        }
    }

    @GetMapping("/getAllCustomer/{isRemote}")
    public List<ContactDto> getAllCustomer(@PathVariable("isRemote") String isRemote) {
        if (isRemote.equals("y")) {
            return List.of(externalService.getAllContact());
        } else {
            return customerService.getAllCustomer();
        }

    }

    @PutMapping("/updateCustomer/{contactId}/{isRemote}")
    public String updateCustomer(@PathVariable("contactId") Long contactId, @PathVariable("isRemote") String flag) {
        if (flag.equals("y")) {
            return externalService.updateCustomer(contactId);
        } else {
            return customerService.updateCustomer(contactId);
        }
    }


}
