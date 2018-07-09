package com.example.vince.carelearning.exercises.label;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vince.carelearning.R;

public class LabelActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner endometriumSpinner;
    Spinner vaginaSpinner;
    Spinner uterusSpinner;
    Spinner fallopianTubeSpinner;
    Spinner infundibulumSpinner;
    Spinner ovarySpinner;
    Spinner cervixSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        cervixSpinner = findViewById(R.id.cervix_spinner);
        infundibulumSpinner = findViewById(R.id.infundibulim_spinner);
        endometriumSpinner = findViewById(R.id.endometrium_spinner);
        fallopianTubeSpinner = findViewById(R.id.fallopian_tube_spinner);
        ovarySpinner = findViewById(R.id.ovary_spinner);
        uterusSpinner = findViewById(R.id.uterus_spinner);
        vaginaSpinner = findViewById(R.id.vagina_spinner);

        cervixSpinner.setOnItemSelectedListener(this);
        infundibulumSpinner.setOnItemSelectedListener(this);
        endometriumSpinner.setOnItemSelectedListener(this);
        fallopianTubeSpinner.setOnItemSelectedListener(this);
        ovarySpinner.setOnItemSelectedListener(this);
        uterusSpinner.setOnItemSelectedListener(this);
        vaginaSpinner.setOnItemSelectedListener(this);

        String[] parts = getResources().getStringArray(R.array.female_genital_system_array);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, parts);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        // attaching data adapter to spinner
        cervixSpinner.setAdapter(dataAdapter);
        infundibulumSpinner.setAdapter(dataAdapter);
        endometriumSpinner.setAdapter(dataAdapter);
        fallopianTubeSpinner.setAdapter(dataAdapter);
        ovarySpinner.setAdapter(dataAdapter);
        uterusSpinner.setAdapter(dataAdapter);
        vaginaSpinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
