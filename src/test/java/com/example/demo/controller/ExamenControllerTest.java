package com.example.demo.controller;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ExamenControllerTest {

    ExamenController controller;

    @Mock
    private ExamenService service;

    @Test
    void testNavigateAgeChecker(){
        Model model = new ExtendedModelMap();
        String route = "ageChecker";
        String navigate = controller.navigate(route, model);
        assertEquals("ageChecker", navigate);

        assertNotNull(model.getAttribute("examen"));
        assertInstanceOf(Examen.class, model.getAttribute("examen"));

    }

    @Test
    void testNavigateDivisionChecker(){
        Model model = new ExtendedModelMap();
        String route = "divisionChecker";
        String navigate = controller.navigate(route, model);
        assertEquals("divisionChecker", navigate);

        assertNotNull(model.getAttribute("examen"));
        assertInstanceOf(Examen.class, model.getAttribute("examen"));


    }

    @Test
    void testAge(){
        Model model = new ExtendedModelMap();
        Examen examen = new Examen();

        String finPage = controller.age(examen, model);
        assertEquals("error", finPage);

    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        controller = new ExamenController();
        controller.setService(service);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

}
