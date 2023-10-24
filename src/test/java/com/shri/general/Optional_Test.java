package com.shri.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.InvalidApplicationException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class Optional_Test {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "test";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name));
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("test");
        assertEquals(name, "test");
    }

    @Test
    public void whenOrElseWorks_thenCorrect1() {
        String name = Optional.ofNullable("john1").orElse("john2");
        assertEquals(name, "john1");
    }


    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    @Test
    public void whenOrElseGetWorks_thenCorrect1() {
        String name = Optional.ofNullable("john1").orElseGet(() -> "john2");
        assertEquals("john1", name);
    }
}