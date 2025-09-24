package com.example.desarrollodeaplicaciones;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Arrays;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rvGroups);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new GroupsAdapter(Arrays.asList(
                new Group("Viaje a Brasil 2026","Ana, Carlos, María", 450.50, false),
                new Group("Asado con amigos","Pedro, Luis, Sofía",   -312.00, false),
                new Group("Viaje en auto","Carmen, Diego",            89.75, true)
        )));
    }

}