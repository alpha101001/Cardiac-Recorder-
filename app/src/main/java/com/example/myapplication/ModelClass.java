package com.example.myapplication;

public class ModelClass implements Comparable<ModelClass>{

    private String date="";
    private String time="";
    private int systolic=0;
    private int diastolic=0;
    private int heartRate=0;
    private String comment="";


    public ModelClass(String date, String time, int systolic, int diastolic, int heart_rate, String comment) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heart_rate;
        this.comment = comment;
    }

    public ModelClass(String date, String time, int systolic, int diastolic, int heart_rate) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heart_rate;
        this.comment = "";
    }



    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getSystolic() {
        return systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public String getComment() {
        return comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public void setHeart_rate(int heart_rate) {
        this.heartRate = heart_rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int compareTo(ModelClass record) {
        return this.date.compareTo(record.getDate());
    }

}
