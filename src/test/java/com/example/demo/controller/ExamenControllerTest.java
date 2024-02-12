package com.example.demo.controller;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

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
    void testNavitageError(){
        Model model = new ExtendedModelMap();
        String route = "error";
        String navigate = controller.navigate(route, model);
        assertEquals("error", navigate);

        assertNotNull(model.getAttribute("examen"));
        assertInstanceOf(Examen.class, model.getAttribute("examen"));
    }


    @Test
    void testAgeMenorEdad(){
        Date fechaNacimiento = new Date(2005, 10, 10);
        Model model = new ExtendedModelMap();
        Examen examen = new Examen(1, 10, 2, null);
        examen.setFechaNacimiento(fechaNacimiento);
        Date today =  new Date();
        today.getDate();
        Long age = 16L;
        when(service.ageChecker(examen.getFechaNacimiento(), today)).thenReturn(age);

//SALE MAL EL test, ya que se mete en la exception, porque el formato de la fecha o algo lo tengo mal
        assertNotNull(age);
        assertTrue(age < 18);
        assertEquals(age,16L);
        assertEquals(age,16);
        System.out.println(age);

        String agePage = controller.age(examen, model);
        assertEquals("underAge", agePage);
    }

    @Test
    void testAgeGetJob(){
        Date fechaNacimiento = new Date(2000, 10, 10);
        Model model = new ExtendedModelMap();
        Examen examen = new Examen(1, 10, 2, null);
        examen.setFechaNacimiento(fechaNacimiento);
        Date today = new Date();
        today.getDate();
        Long age = 23L;
        when(service.ageChecker(examen.getFechaNacimiento(), today)).thenReturn(age);

//SALE MAL EL test, ya que se mete en la exception, porque el formato de la fecha o algo lo tengo mal
        assertNotNull(age);
        assertTrue(age > 18 && age < 67);
        assertEquals(age,23L);
        assertEquals(age,23);
        System.out.println(age);

        String agePage = controller.age(examen, model);
        assertEquals("getAJobNow", agePage);
    }

    @Test
    void testAgeRetired() {
        Date fechaNacimiento = new Date(1950, 10, 10);
        Model model = new ExtendedModelMap();
        Examen examen = new Examen(1, 10, 2, null);
        examen.setFechaNacimiento(fechaNacimiento);
        Date today = new Date();
        today.getDate();
        Long age = 70L;
        when(service.ageChecker(examen.getFechaNacimiento(), today)).thenReturn(age);

//SALE MAL EL test, ya que se mete en la exception, porque el formato de la fecha o algo lo tengo mal
        assertNotNull(age);
        assertTrue(age > 67);
        assertEquals(age,70L);
        assertEquals(age,70);
        System.out.println(age);

        String agePage = controller.age(examen, model);
        assertEquals("retired", agePage);
    }

    @Test
    void testDivision(){

        Model model = new ExtendedModelMap();
        Examen examen = new Examen(1, 10, 2, null);
        Integer result = 5;
        when(service.divisionChecker(examen.getDividendo(), examen.getDivisor())).thenReturn(result);

        assertNotNull(result);
        assertInstanceOf(Integer.class, result);
        assertNotNull(result);
        assertEquals(5, result);
        System.out.println(result);

        String divisionPage = controller.division(examen, model);
        assertEquals("resultOperation", divisionPage);
    }



    @Test
    void testIndex(){
        Model model = new ExtendedModelMap();
        String index = controller.index(model);
        assertEquals("index", index);
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
