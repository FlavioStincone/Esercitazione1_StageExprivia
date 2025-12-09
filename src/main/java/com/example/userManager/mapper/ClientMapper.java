package com.example.userManager.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.userManager.model.dto.ClientDTO;
import com.example.userManager.model.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    
    Client toEntity(ClientDTO clientDTO);
    
    List<ClientDTO> toListDTO(List<Client> clients);
    
    List<Client> toListEntity(List<ClientDTO> clientsDTO);
}