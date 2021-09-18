package com.example.recyclecardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager HzlayoutManager;
    ArrayList<Person> persons = new ArrayList<Person>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));
        persons.add(new Person("sai", "bbgr", "plane"));
        persons.add(new Person("yesh", "hydr", "bus"));
        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));
        persons.add(new Person("sai", "bbgr", "plane"));
        persons.add(new Person("yesh", "hydr", "bus"));
        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));
        persons.add(new Person("sai", "bbgr", "plane"));
        persons.add(new Person("yesh", "hydr", "bus"));
        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));
        persons.add(new Person("sai", "bbgr", "plane"));
        persons.add(new Person("yesh", "hydr", "bus"));
        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));
        persons.add(new Person("sai", "bbgr", "plane"));
        persons.add(new Person("yesh", "hydr", "bus"));
        persons.add(new Person("john", "rambo", "bus"));
        persons.add(new Person("teja", "Reddy", "plane"));
        persons.add(new Person("ravi", "teja", "bus"));
        persons.add(new Person("sai", "bbgr", "plane"));
        persons.add(new Person("yesh", "hydr", "bus"));

        recyclerView = findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        HzlayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new PersonAdapter(this, persons);
        recyclerView.setAdapter(myAdapter);


    }

    public void clickeCardItem(int i){
        Toast.makeText(getApplicationContext(), "click  "+persons.get(i).getName(), Toast.LENGTH_SHORT).show();
    }
}