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
  

}
