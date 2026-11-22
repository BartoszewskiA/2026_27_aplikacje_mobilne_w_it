package com.example.w04p01;

import android.os.Bundle;import android.widget.ImageView;import android.widget.RadioButton;import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton_01, radioButton_02, radioButton_03, radioButton_04;
    ImageView imageView;

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
        radioGroup = findViewById(R.id.radioGroup_01);
        radioButton_01 = findViewById(R.id.radioButton_01);
        radioButton_02 = findViewById(R.id.radioButton_02);
        radioButton_03 = findViewById(R.id.radioButton_03);
        radioButton_04 = findViewById(R.id.radioButton_04);
        imageView = findViewById(R.id.imageView_01);

        imageView.setImageResource(R.drawable.rys_01);
        radioButton_01.setChecked(true);

        obsluga_radiobuttonow();
    }
    private void obsluga_radiobuttonow() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                    if(i==R.id.radioButton_01)
                        imageView.setImageResource(R.drawable.rys_01);
                    else if(i==R.id.radioButton_02)
                        imageView.setImageResource(R.drawable.rys_02);
                    else if(i==R.id.radioButton_03)
                        imageView.setImageResource(R.drawable.rys_03);
                    else if(i==R.id.radioButton_04)
                        imageView.setImageResource(R.drawable.rys_04);
            }});
    }
}