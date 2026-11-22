package com.example.w07p01_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_otworz;
    Button btn_otworz_i_przeslij;
    EditText editText;
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
        btn_otworz = findViewById(R.id.a1_btn_01);
        btn_otworz_i_przeslij = findViewById(R.id.a1_btn_02);
        editText = findViewById(R.id.a1_editText_01);

        btn_otworz.setOnClickListener(v -> {
            Intent intencja =new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intencja);
        });
        btn_otworz_i_przeslij.setOnClickListener(v -> przeslij());

    }

    private void przeslij() {
        String dana = editText.getText().toString();
        Intent intencja = new Intent(MainActivity.this, MainActivity3.class);
        intencja.putExtra("dana", dana);
        intencja.putExtra("liczba", 5);
        startActivity(intencja);
    }
}