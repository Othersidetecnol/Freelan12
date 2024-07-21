package com.example.freelan1.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelan1.R;

public class EntradaCarteiraActivity extends AppCompatActivity {

    private EditText editTextValor;
    private EditText editTextDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrad_carteira);

        editTextValor = findViewById(R.id.editTextValor);
        editTextDescricao = findViewById(R.id.editTextDescricao);
        Button buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(v -> {
            String valorStr = editTextValor.getText().toString();
            String descricao = editTextDescricao.getText().toString();

            if (!valorStr.isEmpty() && !descricao.isEmpty()) {
                float valor = Float.parseFloat(valorStr);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("valor", valor);
                resultIntent.putExtra("descricao", descricao);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
