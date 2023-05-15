package com.example.lab8_9;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class prieteni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prieteni);

        Button addPrieten = findViewById(R.id.addFriends);
        Button searchPrieten = findViewById(R.id.searchFriend);
        Button viewPrieten = findViewById(R.id.viewFriends);
        Button deletePrieten = findViewById(R.id.deleteFriend);
        Button deleteTotiPrieten = findViewById(R.id.deleteAllFriends);
        Button back = findViewById(R.id.back_friends);

        addPrieten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(prieteni.this, addPrieteni.class);
                startActivity(intent);
            }
        });

        searchPrieten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(prieteni.this, searchPrieteni.class);
                startActivity(intent);
            }
        });

        viewPrieten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(prieteni.this, viewPrieteni.class);
                startActivity(intent);
            }
        });

        deletePrieten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(prieteni.this, deletePrieteni.class);
                startActivity(intent);
            }
        });

        deleteTotiPrieten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Stergere Prieteni");
                builder.setMessage("Esti sigur ca vrei sa stergi toti prietenii?");
                builder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Database db = new Database(prieteni.this);
                        db.deleteAll();
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