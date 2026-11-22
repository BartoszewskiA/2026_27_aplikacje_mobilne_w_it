package com.example.w07p02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton_01, imageButton_02, imageButton_03;
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
        imageButton_01 = findViewById(R.id.imageButton_01);
        imageButton_02 = findViewById(R.id.imageButton_02);
        imageButton_03 = findViewById(R.id.imageButton_03);
        imageButton_01.setOnClickListener(v -> otworz_url());
        imageButton_02.setOnClickListener(v -> otworz_mape());
        imageButton_03.setOnClickListener(v -> dzwon());
    }

    private void otworz_mape() {
        Uri geo = Uri.parse("geo:52.237049, 21.017532");
        Intent intencja = new Intent(Intent.ACTION_VIEW);
        intencja.setData(geo);
        startActivity(intencja);
    }

    private void dzwon() {
        String numer = "123456789";
        Intent intencja = new Intent(Intent.ACTION_DIAL);
        intencja.setData(Uri.parse("tel:" + numer));
        startActivity(intencja);
    }

    private void otworz_url() {
        String adres = "https://bartoszewskia.github.io/uthrad/";
        Uri uri = Uri.parse(adres);
//        Intent intencja = new Intent(Intent.ACTION_VIEW, uri);
        Intent intencja = new Intent(Intent.ACTION_VIEW);
        intencja.setData(uri);
        startActivity(intencja);
    }
}