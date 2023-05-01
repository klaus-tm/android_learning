package com.example.lab8_9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class scoala extends AppCompatActivity {
    List<Double>note = new ArrayList<>();
    private static final int ADD_NOTA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoala);

        Button addNote = findViewById(R.id.addNote);
        Button calcMedie = findViewById(R.id.calcMedie);
        Button back = findViewById(R.id.back_school);
        TextView medie = findViewById(R.id.medie);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scoala.this, addNota.class);
                startActivityForResult(intent, ADD_NOTA_REQUEST_CODE);
            }
        });

        calcMedie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double sum = 0.0;
                for (Double nota : note)
                    sum += nota;
                medie.setText("Medie: " + String.valueOf(sum/note.size()));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTA_REQUEST_CODE && resultCode == RESULT_OK){
            note.add(data.getDoubleExtra("nota", 0));
        }
    }
}