package com.trantor.addressbookapi.externalservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trantor.addressbookapi.Dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalService {

    @Autowired
    RestTemplate restTemplate;

    ObjectMapper objectMapper = null;

    public ContactDto[] getAllContact() {

        final String uri = "http://10.50.2.201:8085/search/isRemote=n";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, ContactDto[].class);
    }

    public ContactDto[] getContactByName(String name) {
        final String uri = "http://10.50.2.201:8085/search/isRemote=n";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri + name, ContactDto[].class);


    }

    public ContactDto saveContact(ContactDto dto) throws JsonProcessingException {
        final String uri = "http://10.50.2.201:8085/save/isRemote=n";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(dto);

        HttpEntity<String> httpEntity = new HttpEntity<>(value, httpHeaders);
        String response = restTemplate.postForObject(uri, httpEntity, String.class);
        return objectMapper.readValue(response, ContactDto.class);
    }

    public String updateCustomer(Long id) {

        final String uri = "http://10.50.2.201:8085/update/";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of((MediaType.APPLICATION_JSON)));
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(uri + id + "/isRemote=n", HttpMethod.PUT, httpEntity, String.class);
        return "Updated Successfully";

    }
}
