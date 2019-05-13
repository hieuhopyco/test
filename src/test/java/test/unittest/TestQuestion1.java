package test.unittest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import test.questions.Question1;


public class TestQuestion1 {
    @Test
    public void testCase1() {
        final String arrayInput = "key1=value1;key2=value2\nkey3=value3\nkey4=value4;key5=value5";
        final Question1 question1 = new Question1();
        final HashMap<String, String>[] arr = question1.load(arrayInput);
        final String arrayOutput = question1.store(arr);

        assertEquals(arrayInput, arrayOutput);
    }

    @Test
    public void testCase2() {
        final String arrayInput = "key1=value1;key2=value2@@@\n@@@@#2=value3\nkey4=value4;key5=value5";
        final Question1 question1 = new Question1();
        final HashMap<String, String>[] arr = question1.load(arrayInput);
        final String arrayOutput = question1.store(arr);

        assertEquals(arrayInput, arrayOutput);
    }
}
