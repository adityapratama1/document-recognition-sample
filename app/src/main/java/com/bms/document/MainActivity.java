package com.bms.document;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bms.documentrecognition.engine.DocumentResults;
import com.bms.documentrecognition.recognition.DocumentRecognition;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan = (Button) findViewById(R.id.scan_button);
        scan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.scan_button){
            DocumentRecognition document = new DocumentRecognition(this, "qSCXngqe59xaEwpVSHO5FtWLNgyj4DNah3kqt4tIeJV1qsieRybSsq9dSNKW");
            document.initiateScan();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        DocumentResults results = DocumentRecognition.parseActivityResult(requestCode,resultCode,data);
        Toast.makeText(this, results.getLines(), Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
