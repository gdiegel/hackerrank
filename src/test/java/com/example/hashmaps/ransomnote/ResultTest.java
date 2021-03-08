package com.example.hashmaps.ransomnote;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void ShouldPrintYesWhenSimpleNoteCanBeFormed() {
        final String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        final String[] note = {"give", "one", "grand", "today"};
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Result.checkMagazine(magazine, note);
        assertThat(out.toString()).isEqualTo("Yes");
    }

    @Test
    void ShouldPrintYesWhenComplexNoteCanBeFormed() {
        final String[] magazine = {"apgo", "clm", "w", "lxkvg", "mwz", "elo", "bg", "elo", "lxkvg", "elo", "apgo", "apgo", "w", "elo", "bg"};
        final String[] note = {"elo", "lxkvg", "bg", "mwz", "clm", "w"};
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Result.checkMagazine(magazine, note);
        assertThat(out.toString()).isEqualTo("Yes");
    }

    @Test
    void ShouldPrintNoWhenNoteCanNotBeFormed() {
        final String[] magazine = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        final String[] note = {"ive", "got", "some", "coconuts"};
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Result.checkMagazine(magazine, note);
        assertThat(out.toString()).isEqualTo("No");
    }

    @Test
    void ShouldPrintNoWhenNoteCanNotBeFormedDueToDuplicateWordsInNote() {
        final String[] magazine = {"two", "times", "three", "is", "not", "four"};
        final String[] note = {"two", "times", "two", "is", "four"};
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        Result.checkMagazine(magazine, note);
        assertThat(out.toString()).isEqualTo("No");
    }
}