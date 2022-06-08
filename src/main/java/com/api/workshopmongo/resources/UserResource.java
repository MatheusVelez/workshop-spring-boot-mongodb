package com.api.workshopmongo.resources;

import com.api.workshopmongo.domain.User;
import com.api.workshopmongo.dto.UserDTO;
import com.api.workshopmongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

///Controlador REST

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    ///Aqui o Controlador Rest acessa os serviços.
    @Autowired
    private UserServices service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }
}
