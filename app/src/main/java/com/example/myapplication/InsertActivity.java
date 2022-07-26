package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertActivity extends AppCompatActivity {



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;
    ArrayList<ModelClass> arrayList;
    ModelClass modelClass;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    EditText date,time,systolic,diastolic,heartRate,comment;
    Button saveButton;

    String dateStr,timeStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        date = findViewById(R.id.idateValue);
        time = findViewById(R.id.itimeValue);
        systolic = findViewById(R.id.isystolicValue);
        diastolic = findViewById(R.id.idiastolicValue);
        heartRate = findViewById(R.id.iheartRateValue);
        comment = findViewById(R.id.icommentValue);
        saveButton = findViewById( R.id.addButton);
        retrieveData();

        saveButton.setOnClickListener(v -> {
            dateStr = date.getText().toString();
            timeStr = time.getText().toString();

            if (CheckFieldValidity()) {
                int sysInt = Integer.parseInt(systolic.getText().toString());
                int diasInt = Integer.parseInt(diastolic.getText().toString());
                int heartInt = Integer.parseInt(heartRate.getText().toString());
                String commentStr = comment.getText().toString();
                modelClass = new ModelClass(dateStr,timeStr,sysInt,diasInt,heartInt,commentStr);
                arrayList.add(modelClass);
                MainActivity.arrayList.add(modelClass);
                MainActivity.recyclerAdapter.notifyDataSetChanged();
                Toast.makeText(InsertActivity.this,"Record added!",Toast.LENGTH_SHORT).show();
                PreferenceManager.getDefaultSharedPreferences(this).edit().clear().commit();
                saveData();


                finish();
            }
        });
    }
    private boolean CheckFieldValidity() {
        if (date.length() == 0) {
            date.setError("This field is required");
            return false;
        }

        if (time.length() == 0) {
            time.setError("This field is required");
            return false;
        }

        if (systolic.length() == 0) {
            systolic.setError("This field is required");
            return false;
        }

        String s1 = systolic.getText().toString();
        int n1 = Integer.parseInt(s1);
        if(n1<0)
        {
            systolic.setError("Invalid data input");
            return false;
        }
        if(n1>250)
        {
            systolic.setError("Invalid data input");
            return false;
        }


        if (diastolic.length() == 0) {
            diastolic.setError("This field is required");
            return false;
        }

        String s2 = diastolic.getText().toString();
        int n2 = Integer.parseInt(s2);
        if(n2<0)
        {
            diastolic.setError("Invalid data input");
            return false;
        }
        if(n2>200)
        {
            diastolic.setError("Invalid data input");
            return false;
        }

        if (heartRate.length() == 0) {
            heartRate.setError("This field is required");
            return false;
        }

        String s3 = heartRate.getText().toString();
        int n3 = Integer.parseInt(s3);

        if(n3<0)
        {
            heartRate.setError("Invalid data input");
            return false;
        }

        if(n3>150)
        {
            heartRate.setError("Invalid data input");
            return false;
        }

        String formatDate = "^(0[1-9]|[12][0-9]|3[01]|[1-9])\\/(0[1-9]|1[0-2]|[1-9])\\/([12][0-9]{3})$";
        String formatTime = "^([01][0-9]|2[0-3])\\:([0-5][0-9])";

        Matcher matcherObj = Pattern.compile(formatDate).matcher(dateStr);
        if (!matcherObj.matches()){
            date.setError("Invalid date! input in 'dd/mm/yyyy' format");
            return false;
        }
        Matcher matcherObj2 = Pattern.compile(formatTime).matcher(timeStr);
        if (!matcherObj2.matches()){
            time.setError("Invalid time! input in 'hh:mm' format");
            return false;
        }

        return true;
    }

    private void retrieveData()
    {
        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        gson = new Gson();
        String jsonString = sharedPreferences.getString("record",null);
        Type type = new TypeToken<ArrayList<ModelClass>>(){}.getType();
        arrayList = gson.fromJson(jsonString,type);
        if(arrayList ==null)
        {
            arrayList = new ArrayList<>();
        }
    }
    private void saveData()
    {
        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String jsonString = gson.toJson(arrayList);
        editor.putString("record",jsonString);
        editor.apply();
    }
}