package com.api.workshopmongo.services;

import com.api.workshopmongo.domain.User;
import com.api.workshopmongo.dto.UserDTO;
import com.api.workshopmongo.repository.UserRepository;
import com.api.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired ///serviço acessa o repositório
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));

    }

    public User Insert(User obj) {
        return repo.insert(obj);
    }

    public User FromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}


