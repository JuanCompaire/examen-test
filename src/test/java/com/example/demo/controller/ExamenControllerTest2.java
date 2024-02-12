package com.example.demo.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.servlet.ModelAndView;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExamenControllerTest2 {

    @Autowired
    ExamenController controller;

    @Autowired
    MockMvc mockmvc;

    void testNavigateDivisionChecker() {
        MockHttpServletRequestBuilder requestBuilder = get("/navigate")
                                                        .queryParam("to","divisionChecker");
        try{
             MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
             ModelAndView modelAndView =  mvcResult.getModelAndView();
             assertEquals("divisionChecker",modelAndView.getViewName());
             assertNotNull(modelAndView.getModel().get("examen"));

        } catch (Exception e){
            e.printStackTrace();
            fail("no deberia lanzar excepcion");
        }
    }

    void testNavigateAgeChecker() {
        MockHttpServletRequestBuilder requestBuilder = get("/navigate")
                                                        .queryParam("to","ageChecker");
        try{
             MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
             ModelAndView modelAndView =  mvcResult.getModelAndView();
             assertEquals("ageChecker",modelAndView.getViewName());
             assertNotNull(modelAndView.getModel().get("examen"));

        } catch (Exception e){
            e.printStackTrace();
            fail("no deberia lanzar excepcion");
        }
    }

    void testDivision(){
        MockHttpServletRequestBuilder requestBuilder = get("/division")
                                                        .queryParam("dividendo","10")
                                                        .queryParam("divisor","2");
        try{
             MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
             ModelAndView modelAndView =  mvcResult.getModelAndView();
             assertEquals("divisionChecker",modelAndView.getViewName());
             assertNotNull(modelAndView.getModel().get("msg"));

        } catch (Exception e){
            e.printStackTrace();
            fail("no deberia lanzar excepcion");
        }


    }

    void testAgeGetAJob(){
        MockHttpServletRequestBuilder requestBuilder = get("/age")
                                                        .queryParam("fechaNacimiento","1990-01-01");
        try{
             MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
             ModelAndView modelAndView =  mvcResult.getModelAndView();
             assertEquals("getAJobNow",modelAndView.getViewName());

        } catch (Exception e){
            e.printStackTrace();
            fail("no deberia lanzar excepcion");
        }
    }

    void testAgeUnderAge(){
        MockHttpServletRequestBuilder requestBuilder = get("/age")
                                                        .queryParam("fechaNacimiento","2010-01-01");
        try{
             MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
             ModelAndView modelAndView =  mvcResult.getModelAndView();
             assertEquals("underAge",modelAndView.getViewName());

        } catch (Exception e){
            e.printStackTrace();
            fail("no deberia lanzar excepcion");
        }
    }

    void testAgeRetired(){
        MockHttpServletRequestBuilder requestBuilder = get("/age")
                                                        .queryParam("fechaNacimiento","1950-01-01");
        try{
             MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
             ModelAndView modelAndView =  mvcResult.getModelAndView();
             assertEquals("retired",modelAndView.getViewName());

        } catch (Exception e){
            e.printStackTrace();
            fail("no deberia lanzar excepcion");
        }
    }
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {

    }

    @AfterEach
    void tearDown() throws Exception {
    }
}
