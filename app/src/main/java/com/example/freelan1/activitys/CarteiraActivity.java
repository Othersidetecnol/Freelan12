package com.example.freelan1.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.*;
import com.example.freelan1.R;



import java.util.ArrayList;
import java.util.List;

public class CarteiraActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NOVA_RECEITA = 1;

    private TextView textViewSaldo;
    private ListView listViewHistorico;
    private BarChart barChart;
    private List<String> historico;
    private float saldo = 1500.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteira);

        textViewSaldo = findViewById(R.id.textViewSaldo);
        Button buttonNovaReceita = findViewById(R.id.buttonNovaReceita);
        listViewHistorico = findViewById(R.id.listViewHistorico);
        barChart = findViewById(R.id.barChart);

        historico = new ArrayList<>();

        buttonNovaReceita.setOnClickListener(v -> {
            Intent intent = new Intent(CarteiraActivity.this, EntradaCarteiraActivity.class);
            startActivityForResult(intent, REQUEST_CODE_NOVA_RECEITA);
        });

        updateUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NOVA_RECEITA && resultCode == RESULT_OK && data != null) {
            float valor = data.getFloatExtra("valor", 0.0f);
            String descricao = data.getStringExtra("descricao");

            saldo += valor;
            historico.add(descricao + " - R$ " + valor);

            updateUI();
        }
    }

    private void updateUI() {
        textViewSaldo.setText(String.format("R$ %.2f", saldo));

        // Atualiza o histórico
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historico);
        listViewHistorico.setAdapter(adapter);

        // Atualiza o gráfico
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < historico.size(); i++) {
            String[] parts = historico.get(i).split(" - R\\$ ");
            float value = Float.parseFloat(parts[1]);
            entries.add(new BarEntry(i, value));
        }

        BarDataSet dataSet = new BarDataSet(entries, "Histórico");
        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }
}
