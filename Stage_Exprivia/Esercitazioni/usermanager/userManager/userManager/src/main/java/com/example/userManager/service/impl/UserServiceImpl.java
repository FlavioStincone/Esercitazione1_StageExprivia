package com.example.userManager.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userManager.mapper.UserMapper;
import com.example.userManager.model.dto.UserDTO;
import com.example.userManager.model.entity.User;
import com.example.userManager.repository.UserRepository;
import com.example.userManager.service.IUser;

@Service
public class UserServiceImpl implements IUser {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    //Uso Dei Logger
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserDTO> getUsers() {
        // Restituisce tutte gli utenti presenti
        List<UserDTO> usersDTO = mapper.toListDTO(repository.findAll());
        
        return usersDTO;
        //return repository.findAll().stream().map(mapper::toDTO).toList(); //(senza utilizzare il metodo toListDTO nel mapper)
    }

    @Override
    public UserDTO getUser(int id) {
        // Restituisce un utente specifica in base all'id
        logger.info("Fetching user with id: {"+ id +"}");
        return repository.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Crea l'utente
        logger.info("Creating new user: {"+ userDTO.getName() +"}");
        User user = mapper.toEntity(userDTO);
        repository.save(user);

        return mapper.toDTO(user);
    }

    @Override
public UserDTO updateUser(int id, UserDTO userDTO) {
    Optional<User> existingUser = repository.findById(id);

    if (existingUser.isPresent()) {
        User userToUpdate = existingUser.get();

        userToUpdate.setName(userDTO.getName());
        userToUpdate.setEmail(userDTO.getEmail());

        User updatedUser = repository.save(userToUpdate);

        return mapper.toDTO(updatedUser);
    }

    // Meglio lanciare un'eccezione o restituire Optional
    return null;
}

    @Override
    public boolean deleteUser(int id) {
        // Elimina l'utente 
        if (repository.existsById(id)) {
            logger.info("Deleting user with id: {"+ id +"}");
            repository.deleteById(id);
            return true;
        }
        return false; 
    }



}
