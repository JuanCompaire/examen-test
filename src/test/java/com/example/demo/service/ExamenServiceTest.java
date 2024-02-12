package com.example.demo.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExamenServiceTest {

ExamenService service;
@Test
void testAgeChecker(){
    //GIVEN
    Date fechaNacimiento = new Date(1990, 10, 10);
    Date now = new Date(2021, 10, 10);
    //WHEN
    Long years = service.ageChecker(fechaNacimiento, now);
    //THEN
    assertEquals(31, years);
}

@Test
void testDivisionChecker(){
    //GIVEN
    Integer dividendo = 10;
    Integer divisor = 2;
    //WHEN
    Integer result = service.divisionChecker(dividendo, divisor);
    //THEN
    assertEquals(5, result);
}

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        service = new ExamenService();

    }

    @AfterEach
    void tearDown() throws Exception {
    }



}
