package com.example.web_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView wb;
    EditText link;
    Button load;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wb = findViewById(R.id.web_view);
        link = findViewById(R.id.editTextTextPersonName);
        load = findViewById(R.id.button);
        url = link.getText().toString();
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wb.loadUrl("https://www.youtube.com/");
            }
        });
    }
}