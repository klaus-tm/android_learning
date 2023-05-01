package com.example.lab8_9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class notite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notite);

        Button addNotes = findViewById(R.id.addInfo);
        Button viewNotes = findViewById(R.id.viewInfo);
        Button deleteNotes = findViewById(R.id.deleteInfo);
        Button back = findViewById(R.id.back_notes);

        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notite.this, addNotes.class);
                startActivity(intent);
            }
        });

        viewNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notite.this, com.example.lab8_9.viewNotes.class);
                startActivity(intent);
            }
        });

        deleteNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Stergere notite");
                builder.setMessage("Esti sigur ca vrei sa stergi notitele?");
                builder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            File file = new File(getFilesDir(), "Notite.txt");
                            FileWriter fileWriter = new FileWriter(file);
                            fileWriter.write("");
                            fileWriter.flush();
                            fileWriter.close();

                            Toast.makeText(notite.this, "Toate notitele au fost sterse!", Toast.LENGTH_SHORT).show();
                        } catch (Exception e){
                            Toast.makeText(notite.this, "Nu s-au putut sterge notitele!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Nu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}