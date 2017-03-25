package com.example.gsanchez.androidschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        RecyclerView toDoRecyclerView = (RecyclerView) findViewById(R.id.todo_list);
        List<ToDoItem> items = getItems();
        toDoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        toDoRecyclerView.setAdapter(new ToDoAdapter(this, items));

    }

    private List<ToDoItem> getItems(){
        List<ToDoItem> items = new ArrayList<>();
        ToDoItem item1 = new ToDoItem("Hola, mundo.", "25/3/2017", "Hermosillo, Son.");
        ToDoItem item2 = new ToDoItem("Hola, perro.", "25/3/2018", "Cumpas, Son.");
        ToDoItem item3 = new ToDoItem("Holis.", "25/3/2019", "Guaymas, Son.");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        return items;
    }
}