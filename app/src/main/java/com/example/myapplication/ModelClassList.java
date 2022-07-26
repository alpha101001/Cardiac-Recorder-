package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ModelClassList {
    private List<ModelClass> records = new ArrayList<>();

    /**
     * Adding a record in the list
     * @param record
     *  ADDS THE RECORD
     *
     */
    public void addRecord (ModelClass record) {
        if(records.contains(record)) {
            throw new IllegalArgumentException();
        } else {
            records.add(record);
        }
    }

    /**
     * Deletes an existing RECORD to the list
     * @param record
     *      DELETES THE RECORD
     */
    public void deleteRecord (ModelClass record) {
        if(records.contains(record)) {
            records.remove(record);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method is for returning a sorted list
     * @return
     *      returns a sorted list of records
     */
    public List<ModelClass> getRecords() {
        List<ModelClass> recordList = records;
        Collections.sort(recordList);
        return recordList;
    }
}

