package com.sdacademy.javalub15.services.validators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorConstraintTest {

    private PasswordValidatorConstraint passwordValidatorConstraint;

    @Before
    public void setUp() throws Exception {
        passwordValidatorConstraint = new PasswordValidatorConstraint();
    }

    @Test
    public void testShouldReturnTrueIfPasswordLengthIsMoreThanThreeAndLessThanTenAndContainsDigit() {
        //given
        String correctPassword = "abc123";

        //when
        boolean valid = passwordValidatorConstraint.isValid(correctPassword, null);

        //then
        assertTrue(valid);
    }

    @Test
    public void testShouldReturnFalseIfPasswordLengthIsLessThanThree() {
        //given
        String password = "ab";

        //when
        boolean valid = passwordValidatorConstraint.isValid(password, null);

        //then
        assertFalse(valid);
    }

    @Test
    public void testShouldReturnFalseIfPasswordLengthIsMoreThanTen() {
        //given
        String password = "qwewqeqweqeqweqewqwe";

        //when
        boolean valid = passwordValidatorConstraint.isValid(password, null);

        //then
        assertFalse(valid);
    }

    @Test
    public void testShouldReturnFalseIfPasswordNotContainDigit() {
        //given
        String password = "testtest";

        //when
        boolean valid = passwordValidatorConstraint.isValid(password, null);

        //then
        assertFalse(valid);
    }

    @Test
    public void testShouldReturnFalseIfPasswordIsNull() {
        //given
        String password = null;

        //when
        boolean valid = passwordValidatorConstraint.isValid(password, null);

        //then
        assertFalse(valid);
    }
}