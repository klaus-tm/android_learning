package com.example.lab8_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class addNotes extends AppCompatActivity {
    EditText notita;
    Button addNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        notita = findViewById(R.id.notita);
        addNotes = findViewById(R.id.addNotes);

        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notita.getText().toString().trim().isEmpty())
                    Toast.makeText(com.example.lab8_9.addNotes.this, "Notita este goala!", Toast.LENGTH_SHORT).show();
                else {
                    File file = new File(getFilesDir(), "Notite.txt");
                    try {
                        FileWriter fileWriter = new FileWriter(file, true);
                        fileWriter.write(notita.getText().toString() + "\n");
                        fileWriter.flush();
                        fileWriter.close();

                        Toast.makeText(addNotes.this, "Notita salvata cu succes!", Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(addNotes.this, "Nu s-a putut salva Notita!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}