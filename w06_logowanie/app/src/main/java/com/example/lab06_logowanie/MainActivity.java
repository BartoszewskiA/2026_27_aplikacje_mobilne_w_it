package com.example.lab06_logowanie;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    TextView textView_info;
    EditText editText_login;
    Button btn_zaloguj;
    Button btn_wyloguj;

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
        textView_info = findViewById(R.id.textView_info);
        editText_login = findViewById(R.id.editText_login);
        btn_zaloguj = findViewById(R.id.btn_zaloguj);
        btn_wyloguj = findViewById(R.id.btn_wyloguj);
        btn_zaloguj.setOnClickListener(v -> zaloguj());
        btn_wyloguj.setOnClickListener(v -> wyloguj());
        sprawdzanie_logowania();
    }

    private void wyloguj() {
        SharedPreferences sharedPreferences = getSharedPreferences("logowanie", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("zalogowany", false);
        editor.putString("login", "");
        editor.apply();
        sprawdzanie_logowania();
    }

    private void zaloguj() {
        LocalTime czas = LocalTime.now();
        int godzina = czas.getHour();
        int minuta = czas.getMinute();
        int sekunda = czas.getSecond();
        String name = editText_login.getText().toString();
        if (name.isEmpty()) name = "gość";
        SharedPreferences sharedPreferences = getSharedPreferences("logowanie", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("zalogowany", true);
        editor.putString("login", name);
        editor.putInt("godzina", godzina);
        editor.putInt("minuta", minuta);
        editor.putInt("sekunda", sekunda);
        editor.apply();
        sprawdzanie_logowania();
    }

    private void sprawdzanie_logowania() {
        SharedPreferences sharedPreferences = getSharedPreferences("logowanie", MODE_PRIVATE);
        boolean zalogowany = sharedPreferences.getBoolean("zalogowany", false);
        String login = sharedPreferences.getString("login", "");
        if (zalogowany) {
            int godzina = sharedPreferences.getInt("godzina", 0);
            int minuta = sharedPreferences.getInt("minuta", 0);
            int sekunda = sharedPreferences.getInt("sekunda", 0);
            textView_info.setText("zalogowany jako: " + login + "\n" + godzina + ":" + minuta + ":" + sekunda);
            editText_login.setVisibility(GONE);
            btn_zaloguj.setVisibility(GONE);
            btn_wyloguj.setVisibility(VISIBLE);
        } else {
            textView_info.setText("niezalogowany");
            editText_login.setVisibility(VISIBLE);
            btn_zaloguj.setVisibility(VISIBLE);
            btn_wyloguj.setVisibility(GONE);
        }
    }
}