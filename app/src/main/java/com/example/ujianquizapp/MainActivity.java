package com.example.ujianquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ujianquizapp.adapter.QuestionAdapter;
import com.example.ujianquizapp.entity.Questions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    QuestionAdapter questionAdapter;
    private ArrayList<Questions> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rcv);

        addQ();
        questionAdapter = new QuestionAdapter(MainActivity.this,array);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv.setLayoutManager(layoutManager);
        rcv.setAdapter(questionAdapter);

    }

    private void addQ() {
        array = new ArrayList<>();
        array.add(new Questions("Introduction to Java", "Easy, Basic Java"));
        array.add(new Questions("Introduction to Java II", "Easy, Basic Java"));
    }


}