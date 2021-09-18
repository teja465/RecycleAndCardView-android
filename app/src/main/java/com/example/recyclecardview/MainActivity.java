package com.example.recyclecardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager HzlayoutManager;
    EditText etName,etSurname;
    Button btnSubmit;
    ArrayList<Person> persons = new ArrayList<Person>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(etName.getText().toString().trim() !=null && etSurname.getText().toString().trim() != null){
                    Person newPerson = new Person(etName.getText().toString().trim(),
                            etSurname.getText().toString().trim(),"bus");
                    persons.add(newPerson);
                    myAdapter.notifyDataSetChanged();
                }
                Log.d("AddpersonButton","clicked " + String.valueOf(persons.size()));
                Log.d("Name",etName.getText().toString());
                Log.d("Surname",etSurname.getText().toString());
            }
        });

        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));



        recyclerView = findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        HzlayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new PersonAdapter(this, persons);
        recyclerView.setAdapter(myAdapter);


    }

    public void clickeCardItem(int i){
        Toast.makeText(getApplicationContext(), "clicked  "+persons.get(i).getName(), Toast.LENGTH_SHORT).show();
    }
}