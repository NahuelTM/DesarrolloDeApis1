package com.example.desarrollodeaplicaciones;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ExpensesActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        BottomNavigationView bottom = findViewById(R.id.bottomBar);
        bottom.setSelectedItemId(R.id.nav_expenses);

        bottom.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0,0);
                finish();
                return true;
            }
            if (id == R.id.nav_expenses) return true;
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
