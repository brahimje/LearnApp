package com.example.learnapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Déclaration des vues
    private ImageView iconImageView;
    private EditText idEditText;
    private TextInputLayout idInputLayout;  // Change to TextInputLayout
    private EditText passwordEditText;
    private TextInputLayout passwordInputLayout;  // Change to TextInputLayout
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialisation des vues
        iconImageView = findViewById(R.id.iconImageView);
        idEditText = findViewById(R.id.idEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Initialize TextInputLayouts
        idInputLayout = findViewById(R.id.idInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);

        // Gestionnaire d'événements pour le bouton de connexion
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifier l'authentification
                if (validateFields()) {
                    if (checkCredentials(idEditText.getText().toString().trim(), passwordEditText.getText().toString().trim())) {
                        // Les champs sont valides, implémentez votre logique d'authentification ici
                        Intent intent = new Intent(LoginActivity.this, ModulesActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    // Fonction pour valider les champs
    private boolean validateFields() {
        // Réinitialiser les messages d'erreur
        idInputLayout.setError("");
        passwordInputLayout.setError("");

        // Récupérer les valeurs des champs
        String id = idEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Vérifier si les champs sont vides
        if (TextUtils.isEmpty(id)) {
            idInputLayout.setError("Veuillez entrer votre identifiant.");
            return false;
        } else {
            idInputLayout.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            passwordInputLayout.setError("Veuillez entrer votre mot de passe.");
            return false;
        } else {
            passwordInputLayout.setError(null);
        }

        return true;
    }
    private boolean checkCredentials(String id, String password) {
        // Vérifier si les identifiants sont valides
        // Check credentials
        if ("abcd".equals(id) && "efgh".equals(password)) {
            // Authentication successful
            Log.d("LoginActivity", "Authentication successful");
            Toast.makeText(this, "Authentication successful", Toast.LENGTH_LONG).show();
            return true;
        } else {
            // Incorrect credentials
            Log.d("LoginActivity", "Incorrect credentials");
            Toast.makeText(this, "Incorrect credentials", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
