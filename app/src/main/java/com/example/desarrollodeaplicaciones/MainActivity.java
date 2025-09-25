package com.example.desarrollodeaplicaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Arrays;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View g1 = findViewById(R.id.incGroup1);
        ((TextView) g1.findViewById(R.id.tvGroupTitle)).setText("Viaje a Brasil 2026");
        ((TextView) g1.findViewById(R.id.tvGroupMembers)).setText("Ana, Carlos, María");
        ((TextView) g1.findViewById(R.id.tvGroupAmount)).setText("$450.50");

        View g2 = findViewById(R.id.incGroup2);
        ((TextView) g2.findViewById(R.id.tvGroupTitle)).setText("Asado con amigos");
        ((TextView) g2.findViewById(R.id.tvGroupMembers)).setText("Pedro, Luis, Sofía");
        ((TextView) g2.findViewById(R.id.tvGroupAmount)).setText("-$312.00");

        View g3 = findViewById(R.id.incGroup3);
        ((TextView) g3.findViewById(R.id.tvGroupTitle)).setText("Viaje en auto");
        ((TextView) g3.findViewById(R.id.tvGroupMembers)).setText("Carmen, Diego");
        ((TextView) g3.findViewById(R.id.tvGroupAmount)).setText("$89.75");


        RecyclerView rv = findViewById(R.id.rvGroups);
        if (rv != null) {
            rv.setLayoutManager(new LinearLayoutManager(this));

            rv.setAdapter(new GroupsAdapter(Arrays.asList(

                    new Group("Viaje a Brasil 2026","Ana, Carlos, María", 450.50, false),
                    new Group("Asado con amigos","Pedro, Luis, Sofía",   -312.00, false),
                    new Group("Viaje en auto","Carmen, Diego",            89.75, true)
            )));
        }



        BottomNavigationView bottom = findViewById(R.id.bottomBar);
        bottom.setSelectedItemId(R.id.nav_home);  // resalta "Inicio"

        bottom.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) return true;
            if (id == R.id.nav_expenses) {
                startActivity(new Intent(this, ExpensesActivity.class));
                overridePendingTransition(0,0);
                finish();
                return true;
            }
            if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                overridePendingTransition(0,0);
                finish();
                return true;
            }
            return false;
        });
    }



    }

