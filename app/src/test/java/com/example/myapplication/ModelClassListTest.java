package com.example.myapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ModelClassListTest {



    /**
     * testing addRecord method
     */
    @Test
    public void testAddRecord() {
        ModelClassList recordList = new ModelClassList();
        ModelClass record1 = new ModelClass("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);
        assertEquals(1, recordList.getRecords().size());

        ModelClass record2 = new ModelClass("13-2-2000","05:30",120,97,78,"other");
        recordList.addRecord(record2);
        assertEquals(2, recordList.getRecords().size());

        assertTrue(recordList.getRecords().contains(record1));
        assertTrue(recordList.getRecords().contains(record2));
    }

    /**
     * testing deleteRecord method
     */
    @Test
    public void testDeleteRecord() {
        ModelClassList recordList = new ModelClassList();
        ModelClass record1 = new ModelClass("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);
        assertEquals(1, recordList.getRecords().size());

        ModelClass record2 = new ModelClass("17-2-2000","9:20",120,97,78,"other");
        recordList.addRecord(record2);
        assertEquals(2, recordList.getRecords().size());

        assertTrue(recordList.getRecords().contains(record1));
        assertTrue(recordList.getRecords().contains(record2));

        recordList.deleteRecord(record1);
        assertEquals(1, recordList.getRecords().size());
        assertFalse(recordList.getRecords().contains(record1));

        recordList.deleteRecord(record2);
        assertEquals(0, recordList.getRecords().size());
        assertFalse(recordList.getRecords().contains(record2));
    }

    /**
     * testing addRecord method for exceptions
     */
    @Test
    public void testAddRecordException() {
        ModelClassList recordList = new ModelClassList();
        ModelClass record1 = new ModelClass("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);

        assertThrows(IllegalArgumentException.class, () -> recordList.addRecord(record1));
    }

    /**
     * testing deleteRecord method for exceptions
     */
    @Test
    public void testDeleteRecordException() {
        ModelClassList recordList = new ModelClassList();
        ModelClass record1 = new ModelClass("1-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);

        recordList.deleteRecord(record1);

        assertThrows(IllegalArgumentException.class, () -> recordList.deleteRecord(record1));
    }

    /**
     * testing getRecords method
     */
    @Test
    public void testSortRecords() {
        ModelClassList recordList = new ModelClassList();
        ModelClass record1 = new ModelClass("13-1-2000","10:20",89,67,67,"dummy");
        recordList.addRecord(record1);

        assertEquals(0, record1.compareTo(recordList.getRecords().get(0)));

        ModelClass record2 = new ModelClass("10-1-2000","9:20",120,97,78,"other");
        recordList.addRecord(record2);

        assertEquals(0, record2.compareTo(recordList.getRecords().get(0)));
        assertEquals(0, record1.compareTo(recordList.getRecords().get(1)));
    }
}

