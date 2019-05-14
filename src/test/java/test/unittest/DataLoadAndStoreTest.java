package test.unittest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import test.question.dataMgr.DataLoadAndStore;


public class DataLoadAndStoreTest {
    @Test
    public void testLoadData() {
        final String arrayInput = "key1=value1;key2=value2\nkeyA=valueA";
        final DataLoadAndStore question1 = new DataLoadAndStore();
        final HashMap<?, ?>[] arr = question1.load(arrayInput);
        final String arrayOutput = question1.store(arr);

        assertEquals(arrayInput, arrayOutput);
    }

    @Test
    public void testLoadEmptyData() {
        final String arrayInput = StringUtils.EMPTY;

        final DataLoadAndStore question1 = new DataLoadAndStore();
        final HashMap<?, ?>[] arr = question1.load(arrayInput);
        final String arrayOutput = question1.store(arr);

        assertEquals(arrayInput, arrayOutput);
    }

    @Test
    public void testStoreData() {
        final HashMap<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");

        final HashMap<String, String> map2 = new HashMap<>();
        map2.put("key3", "value3");
        map2.put("key4", "value4");

        final HashMap<?, ?>[] array = new HashMap[2];
        array[0] = map1;
        array[1] = map2;

        final DataLoadAndStore dataMgr = new DataLoadAndStore();
        final String stored = dataMgr.store(array);
        assertEquals("key1=value1;key2=value2\nkey3=value3;key4=value4", stored);
    }

    @Test
    public void testStoreEmptyData() {
        final HashMap<?, ?>[] array = new HashMap[0];

        final DataLoadAndStore dataMgr = new DataLoadAndStore();
        final String stored = dataMgr.store(array);
        assertEquals(StringUtils.EMPTY, stored);
    }
}
