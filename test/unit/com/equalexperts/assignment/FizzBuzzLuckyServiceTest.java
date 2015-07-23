package com.equalexperts.assignment;


import com.equalexperts.assignment.validators.RangeValidation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzLuckyServiceTest {

    private IFizzBuzzLuckyService fizzBuzz;

    @Mock
    private RangeValidation rangeValidation;

    @Before
    public void init() {
        fizzBuzz = new FizzBuzzLuckyService(rangeValidation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForInvalidRanges() {
        doThrow(IllegalArgumentException.class).when(rangeValidation).validateRange(anyInt(), anyInt());
        fizzBuzz.execute(0, 2);
    }

    @Test
    public void shouldTransformWithNumbers() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(1, 2), "1 2");
    }

    @Test
    public void shouldTransformWithLucky() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(1, 3), "1 2 lucky");
    }

    @Test
    public void shouldTransformWithFizz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(6, 7), "fizz 7");
    }

    @Test
    public void shouldTransformWithBuzz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(4, 5), "4 buzz");
    }

    @Test
    public void shouldTransformWithLuckyAndFizzAndBuzzAndFizzBuzz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(1, 16), "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16");
    }
}
