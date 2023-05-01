package com.example.lab8_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class viewNotes extends AppCompatActivity {
    List<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);

        try {
            File file = new File(getFilesDir(), "Notite.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                notes.add(line);
            }
            Exception Exception = null;
            if (notes.isEmpty())
                throw Exception;
            bufferedReader.close();
        } catch (Exception e){
            Toast.makeText(this, "Nu exista notite!", Toast.LENGTH_SHORT).show();
        }

        RecyclerView recyclerView = findViewById(R.id.reciclerViewNotite);
        FileDataAdapter adapter = new FileDataAdapter(notes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}