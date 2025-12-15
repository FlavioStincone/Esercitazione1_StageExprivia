package com.example.userManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.userManager.mapper.ClientMapper;
import com.example.userManager.model.dto.ClientDTO;
import com.example.userManager.model.entity.Client;
import com.example.userManager.repository.ClientRepository;
import com.example.userManager.service.impl.ClientServiceImpl;

@SpringBootTest
class ClientServiceTest { 
    
    private ClientServiceImpl clientServiceImpl;

    @Mock
    private ClientRepository mockRepository;

    @Mock
    private ClientMapper mockMapper;

	@BeforeEach
    void setup(){

        this.mockRepository = mock(ClientRepository.class);
        this.mockMapper = mock(ClientMapper.class);

        this.clientServiceImpl = new ClientServiceImpl(mockRepository, mockMapper);
    }

    @Nested
    class getClientsMethod{

        @Test
        void should_ReturCorrectListClient(){
        //given
        List<Client> clientsEntity = Arrays.asList(new Client("Lista1", "Lista1@gmail.com", "1234"), new Client("Lista2", "Lista2@gmail.com", "1234") );
        List<ClientDTO> expected = Arrays.asList(new ClientDTO("Lista1", "Lista1@gmail.com", "1234", null), new ClientDTO("Lista2", "Lista2@gmail.com", "1234", null) );

        when(mockRepository.findAll()).thenReturn(clientsEntity);
        when(mockMapper.toListDTO(clientsEntity)).thenReturn(expected);

        //When
        List<ClientDTO> clients = clientServiceImpl.getClients();

        //then
        assertEquals(expected, clients);

        }
    }

    @Nested
    class getClientMethod{

        @Test
        void should_ReturnNull_WhenIdNotFound()
        {
            //given
            when(mockRepository.findById(1L)).thenReturn(Optional.empty());

            //when
            ClientDTO actual = clientServiceImpl.getClient(1L);

            //then
            assertNull(actual);
            
        }

        @Test
        void should_ReturnCorrectClient() {
            

            //given
            Client clientEntity = new Client("Test", "Test@gmail.com", "1234");
            ClientDTO expected = new ClientDTO("Test", "Test@gmail.com", "1234", null);

            when(mockRepository.findById(1L)).thenReturn(Optional.of(clientEntity));
            when(mockMapper.toDTO(clientEntity)).thenReturn(expected);

            //when
            ClientDTO actual = clientServiceImpl.getClient(1L);

            //then
            assertEquals(expected, actual);
        }

        //??? Nei Test conviene fare Chiamte Multiple, oppure bisogna fare un @Test per ogni Caso Specifico ???
        @Disabled 
        @Test
        void should_ReturnCorrectClient_when_CalledMultipleTimes(){

            //given
            Client clientEntity = new Client("Test", "Test@gmail.com", "1234");
            ClientDTO expectedSecond = new ClientDTO("Test", "Test@gmail.com", "1234", null);

            when(mockRepository.findById(1L))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(clientEntity));

            when(mockMapper.toDTO(clientEntity)).thenReturn(expectedSecond);

            //when
            ClientDTO actualFirst = clientServiceImpl.getClient(1L);
            ClientDTO actualSecond = clientServiceImpl.getClient(1L);

            //then
            assertAll(
                () -> assertNull(actualFirst),
                () -> assertEquals(expectedSecond, actualSecond)
            );

        }

    }

}
