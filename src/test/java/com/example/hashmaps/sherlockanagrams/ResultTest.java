package com.example.hashmaps.sherlockanagrams;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void shouldSolveForMom() {
        final int numberOfAnagrams = Result.sherlockAndAnagrams("mom");
        System.out.println(MessageFormat.format("Number of anagrams: [{0}]", numberOfAnagrams));
        assertThat(numberOfAnagrams).isEqualTo(2);
    }

    @Test
    void shouldSolveForSimpleAnagram() {
        final int numberOfAnagrams = Result.sherlockAndAnagrams("abba");
        System.out.println(MessageFormat.format("Number of anagrams: [{0}]", numberOfAnagrams));
        assertThat(numberOfAnagrams).isEqualTo(4);
    }

    @Test
    void shouldSolveForComplexAnagram() {
        final int numberOfAnagrams = Result.sherlockAndAnagrams("ifailuhkqq");
        System.out.println(MessageFormat.format("Number of anagrams: [{0}]", numberOfAnagrams));
        assertThat(numberOfAnagrams).isEqualTo(3);
    }

    @Test
    void shouldSolveForFourLetterStringOfSameLetters() {
        final int numberOfAnagrams = Result.sherlockAndAnagrams("kkkk");
        System.out.println(MessageFormat.format("Number of anagrams: [{0}]", numberOfAnagrams));
        assertThat(numberOfAnagrams).isEqualTo(10);
    }

    @Test
    void shouldSolveForFourLetterStringCdCd() {
        final int numberOfAnagrams = Result.sherlockAndAnagrams("cdcd");
        System.out.println(MessageFormat.format("Number of anagrams: [{0}]", numberOfAnagrams));
        assertThat(numberOfAnagrams).isEqualTo(5);
    }

    @Test
    void shouldSolveForHeavyInput(){
        final int numberOfAnagrams = Result.sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel");
        System.out.println(MessageFormat.format("Number of anagrams: [{0}]", numberOfAnagrams));
        assertThat(numberOfAnagrams).isEqualTo(399);
    }
}