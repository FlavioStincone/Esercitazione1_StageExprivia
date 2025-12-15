package com.example.userManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
        ClientDTO clientDTO = new ClientDTO("Test", "Test@gmail.com", "1234", null);
        when(mockRepository.findById(1L)).thenReturn(Optional.of(clientEntity));
        when(mockMapper.toDTO(clientEntity)).thenReturn(clientDTO);

        String expectedName =  "Test";
        String expectedEmail = "Test@gmail.com";
        String expectedPwd = "1234";

        //when
        ClientDTO actual = clientServiceImpl.getClient(1L);

        //then
        assertAll(
                  () -> assertEquals(expectedName, actual.name()),
                  () -> assertEquals(expectedEmail, actual.email()),
                  () -> assertEquals(expectedPwd, actual.pwd())
        );
    }


}
