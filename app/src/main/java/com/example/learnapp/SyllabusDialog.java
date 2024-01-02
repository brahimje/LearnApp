package com.example.learnapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SyllabusDialog extends Dialog {

    private String moduleTitle;
    private String creditValue;
    private String descriptionValue;

    public SyllabusDialog(Context context, String moduleTitle, String creditValue, String descriptionValue) {
        super(context);
        this.moduleTitle = moduleTitle;
        this.creditValue = creditValue;
        this.descriptionValue = descriptionValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_syllabus);

        TextView textDialogTitle = findViewById(R.id.textDialogTitle);
        textDialogTitle.setText(moduleTitle);

        TextView textCreditValue = findViewById(R.id.textCreditValue);
        textCreditValue.setText(creditValue);

        TextView textDescriptionValue = findViewById(R.id.textDescriptionValue);
        textDescriptionValue.setText(descriptionValue);

        Button btnSeeDetails = findViewById(R.id.btnSeeDetails);
        btnSeeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic to see module details
                // You can open a new activity or show additional information here
                dismiss(); // Close the dialog after seeing details
            }
        });
    }
}
