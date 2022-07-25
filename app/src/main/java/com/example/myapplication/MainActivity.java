
package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public static RecyclerAdapter recyclerAdapter;
    AlphabeticIndex.Record record;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;
    public static ArrayList<ModelClass> arrayList;
    FloatingActionButton insertButton;
    ModelClass modelClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


 }


}