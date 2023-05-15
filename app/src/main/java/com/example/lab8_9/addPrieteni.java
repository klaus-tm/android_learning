package com.example.lab8_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addPrieteni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prieteni);
        EditText Nume = findViewById(R.id.nameFriend);
        EditText Numar = findViewById(R.id.numberFriend);
        Button add = findViewById(R.id.adaugaPrieten);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(view.getContext());
                db.add(Nume.getText().toString().trim(), Numar.getText().toString().trim());
                finish();
            }
        });
    }
}