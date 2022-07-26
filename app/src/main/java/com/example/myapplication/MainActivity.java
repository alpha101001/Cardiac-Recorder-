
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
        insertButton = findViewById(R.id.insertButton);
        retrieveData();
        modelClass = new ModelClass("jjdj","ddjd",10,20,40,"hellow");
        //arrayList.add(modelClass);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(this,arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerAdapter.setCustomClickListener(new RecyclerAdapter.CustomClickListener() {
            @Override
            public void cusOnClick(int position, View v) {
                Intent intent = new Intent(MainActivity.this, ViewDetailsActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
            @Override
            public void onDeleteClick(int position) {
                arrayList.remove(position);
                recyclerAdapter.notifyItemRemoved(position);
                saveData();
                Toast.makeText(MainActivity.this,"Deleted successful!",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onEditClick(int position) {

                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }

        });
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InsertActivity.class));
            }

        });

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
    private void retrieveData()
    {
        sharedPreferences = getSharedPreferences("shared",MODE_PRIVATE);
        gson = new Gson();
        String jsonString = sharedPreferences.getString("record",null);
        Type type = new TypeToken<ArrayList<ModelClass>>(){}.getType();
        arrayList = gson.fromJson(jsonString,type);
        if(arrayList ==null)
        {
            arrayList = new ArrayList<ModelClass>();
        }
    }
}