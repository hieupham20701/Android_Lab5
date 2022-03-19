package com.example.lab5;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class CustomListViewActicity extends AppCompatActivity {
    private List<Donut> donutList;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView = (ListView) findViewById(R.id.lstView);
        donutList = new ArrayList<>();
        donutList.add(new Donut(1,"TastyDonut","Spicy tasty donut family","16.5"));
        donutList.add(new Donut(2,"Pink Donut","Spicy tasty donut family","15.0"));
        donutList.add(new Donut(3,"Floating Donut","Spicy tasty donut family","20.0"));
        donutList.add(new Donut(4,"Floating Donut","Spicy tasty donut family","21.0"));
        donutList.add(new Donut(5,"Pink Donut","Spicy tasty donut family","22.0"));
        donutList.add(new Donut(6,"Floating Donut","Spicy tasty donut family","22.3"));
        donutList.add(new Donut(7,"Pink Donut","Spicy tasty donut family","11.0"));


        DonutAdapter adapter =new DonutAdapter(this, R.layout.item_donut, donutList);
        listView.setAdapter(adapter);
        Button buttonDonut = (Button) findViewById(R.id.btnDonut);
        Button buttonPink = (Button) findViewById(R.id.btnPinkDonut);
        Button buttonFloating = (Button)  findViewById(R.id.btnFloating);
        EditText inputEven  =findViewById(R.id.txtSearch);

        inputEven.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.allDonut();
                setActiveButton(buttonDonut,buttonPink, buttonFloating);
            }
        });
        buttonPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.filterPinkDonut();
                setActiveButton(buttonPink, buttonDonut, buttonFloating);

            }
        });
        buttonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.filterFloating();
                setActiveButton(buttonFloating,buttonDonut,buttonPink);
            }
        });
    }

    public void setActiveButton(Button buttonActive, Button btn1, Button btn2) {
        buttonActive.setBackgroundColor(Color.BLUE);
        buttonActive.setTextColor(Color.WHITE);
        btn1.setBackgroundColor(Color.parseColor("#D1CBCB"));
        btn1.setTextColor(Color.BLACK);
        btn2.setTextColor(Color.BLACK);
        btn2.setBackgroundColor(Color.parseColor("#D1CBCB"));
    }




}
