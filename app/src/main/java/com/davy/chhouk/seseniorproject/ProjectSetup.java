package com.davy.chhouk.seseniorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class ProjectSetup extends AppCompatActivity {
    Boolean isSave = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_setup);

        Intent i = getIntent();
        if (i != null) {
            isSave = i.getStringExtra("type").equalsIgnoreCase("edit");
        }

        System.out.println("ISAVE " + isSave);

        Button saveButton = findViewById(R.id.btn_save);
        saveButton.setText(isSave ? "Save" : "Create");
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
