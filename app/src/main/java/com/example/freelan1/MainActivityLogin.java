package com.example.freelan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLogin extends AppCompatActivity {

    Button buttonAbrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


        buttonAbrir = findViewById(R.id.btn_esqueceu_senha);
        buttonAbrir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                // Cria um novo Intent para iniciar a atividade TesteDicas
                Intent intent = new Intent(MainActivityLogin.this, TesteDicas.class);
                // Inicia a nova atividade
                startActivity(intent);
                }
            }
        );
    }



}
