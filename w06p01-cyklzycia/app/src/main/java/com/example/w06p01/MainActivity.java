package com.example.w06p01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView_01;
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        String text = textView_01.getText().toString();
        text += "\n onStart";
        textView_01.setText(text);
    }
    @Override
    protected void onResume() {
        super.onResume();
        String text = textView_01.getText().toString();
        text += "\n onResume";
        textView_01.setText(text);
    }
    @Override
    protected void onPause() {
        super.onPause();
        String text = textView_01.getText().toString();
        text += "\n onPause";
        textView_01.setText(text);
    }
    @Override
    protected void onStop() {
        super.onStop();
        String text = textView_01.getText().toString();
        text += "\n onStop";
        textView_01.setText(text);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        String text = textView_01.getText().toString();
        text += "\n onDestroy";
        textView_01.setText(text);
    }
}

