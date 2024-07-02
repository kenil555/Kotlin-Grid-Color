package com.kotlintask.interviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Button buttonCreateGrid;
    private RecyclerView recyclerView;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        buttonCreateGrid = findViewById(R.id.buttonCreateGrid);
        recyclerView = findViewById(R.id.recyclerView);


        buttonCreateGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNumber.getText().toString();
                if (!TextUtils.isEmpty(input)) {
                    int gridSize = Integer.parseInt(input);
                    createGrid(gridSize);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createGrid(int gridSize) {
        gridAdapter = new GridAdapter(gridSize);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridSize));
        recyclerView.setAdapter(gridAdapter);
    }
}