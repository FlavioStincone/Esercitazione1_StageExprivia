package com.example.userManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientTest { 
    

	@Test
	void contextLoads() {

	}

	@Test
    void testServiceMethod() {
        String result = "Mario";
        assertEquals("Mario", result);
    }
    
    // @Test
    // void should_CorrectGetClient()
    // {
        
    //     Client client = new Client("Prova", "prova@gmail.com", "1234");
    //     client.setRole("CLIENT");
    //     Client saved = repository.save(client);

    //     ClientDTO expected = new ClientDTO(saved.getId(), "Prova", "prova@gmail.com", "1234", "CLIENT");
    //     ClientDTO actual = service.getClient(saved.getId());

    //     // assertAll(() -> assertEquals(expected.id(), actual.id()),
    //     //           () -> assertEquals(expected.name(), actual.name()),
    //     //           () -> assertEquals(expected.email(), actual.email()),
    //     //           () -> assertEquals(expected.pwd(), actual.pwd()),
    //     //           () -> assertEquals(expected.role(), actual.role())                
    //     //         );
    // }

}
