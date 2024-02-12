package com.example.demo.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ExamenTest {

    Examen examen;



    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date fecha = sdf.parse("2021-10-10");


    ExamenTest() throws ParseException {
    }

    @Test
    void tesGetIdWhenIsNotEmpty() throws ParseException {
        Examen exam = new Examen(1, 10, 2, null);

        exam.setFechaNacimiento(fecha);
        assertEquals(1, exam.getId());
    }

    @Test
    void testSetIdWhenIsNotEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        exam.setId(2);
        assertEquals(2, exam.getId());
    }

    @Test
    void testSetIdWhenIsEmpty() {
        Examen exam = new Examen(null, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        exam.setId(2);
        assertEquals(2, exam.getId());
    }

    @Test
    void testGetIdWhenIsEmpty() {
        Examen exam = new Examen(null, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        assertNull(exam.getId());
    }

    @Test
    void testGetDividendoWhenIsNotEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        assertEquals(10, exam.getDividendo());
    }

    @Test
    void testGetDividendoWhenIsEmpty() {
        Examen exam = new Examen(1, null, 2, null);
        exam.setFechaNacimiento(fecha);
        assertNull(exam.getDividendo());
    }

    @Test
    void testSetDividendoWhenIsNotEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        exam.setDividendo(20);
        assertEquals(20, exam.getDividendo());
    }

    @Test
    void testSetDividendoWhenIsEmpty() {
        Examen exam = new Examen(1, null, 2, null);
        exam.setFechaNacimiento(fecha);
        exam.setDividendo(20);
        assertEquals(20, exam.getDividendo());
    }
    @Test
    void testGetDivisorWhenIsNotEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        assertEquals(2, exam.getDivisor());
    }

    @Test
    void testGetDivisorWhenIsEmpty() {
        Examen exam = new Examen(1, 10, null, null);
        exam.setFechaNacimiento(fecha);
        assertNull(exam.getDivisor());
    }

    @Test
    void testSetDivisorWhenIsNotEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        exam.setDivisor(20);
        assertEquals(20, exam.getDivisor());
    }

    @Test
    void testSetDivisorWhenIsEmpty() {
        Examen exam = new Examen(1, 10, null, null);
        exam.setFechaNacimiento(fecha);
        exam.setDivisor(20);
        assertEquals(20, exam.getDivisor());
    }

    @Test
    void testGetFechaNacimientoWhenIsNotEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        exam.setFechaNacimiento(fecha);
        assertEquals(fecha, exam.getFechaNacimiento());
    }

    @Test
    void testGetFechaNacimientoWhenIsEmpty() {
        Examen exam = new Examen(1, 10, 2, null);
        assertNull(exam.getFechaNacimiento());
    }

    @Test void testFechaPosterior() throws ParseException {
        Examen exam = new Examen(1, 10, 2, fecha);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate fechaHoy = LocalDate.now();
        Date fechahoy = sdf.parse(fechaHoy.toString());
        Boolean result = fechahoy.after(fecha);
        assertTrue(result);
    }

    @Test void testFechaAnterior() throws ParseException {
        Examen exam = new Examen(1, 10, 2, fecha);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate fechaHoy = LocalDate.now();
        Date fechahoy = sdf.parse(fechaHoy.toString());
        Boolean result = fecha.before(fechahoy);
        assertTrue(result);
    }

    @Test
    void testToString(){
        Examen exam = new Examen(1, 10, 2, fecha);
        assertEquals("Examen [id=1, dividendo=10, divisor=2, fechaNacimiento=Sun Oct 10 00:00:00 CEST 2021]", exam.toString());
    }




}