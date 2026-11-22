package com.example.w05p02_preferens;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText_01;
    TextView textView_01;
    Button btn_zapisz, btn_odczytaj, btn_usun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView_01 = findViewById(R.id.textView_01);
        editText_01 = findViewById(R.id.editText_01);
        btn_zapisz = findViewById(R.id.btn_zapisz);
        btn_odczytaj = findViewById(R.id.btn_odczytaj);
        btn_usun = findViewById(R.id.btn_usun);
        btn_zapisz.setOnClickListener(v -> zapisz_notatke());
        btn_odczytaj.setOnClickListener(v -> odczytaj_notatke());
        btn_usun.setOnClickListener(v -> usun_notatke());


    }

    private void usun_notatke() {
        SharedPreferences sharedPreferences = getSharedPreferences("notatki", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("notatka");
        // editor.clear();
        editor.commit();
        Toast.makeText(this, "Notatkę usunięto", Toast.LENGTH_SHORT).show();
    }

    private void odczytaj_notatke() {
        SharedPreferences sharedPreferences = getSharedPreferences("notatki", Context.MODE_PRIVATE);
        String s = sharedPreferences.getString("notatka", "Brak zapisanej notatki");
        textView_01.setText(s);
    }

    private void zapisz_notatke() {
        SharedPreferences sharedPreferences = getSharedPreferences("notatki", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("notatka", editText_01.getText().toString());
        editor.commit();
        Toast.makeText(this, "Notatkę zapisano", Toast.LENGTH_SHORT).show();
    }
}