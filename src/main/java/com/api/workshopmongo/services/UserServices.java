package com.api.workshopmongo.services;

import com.api.workshopmongo.domain.User;
import com.api.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired ///serviço acessa o repositório
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }
}
