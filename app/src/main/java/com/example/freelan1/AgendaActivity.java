package com.example.freelan1;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AgendaActivity extends AppCompatActivity {

    private TextView tvMonthYear;
    private GridView calendarGridView;
    private ListView appointmentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        tvMonthYear = findViewById(R.id.tvMonthYear);
        calendarGridView = findViewById(R.id.calendarGridView);
        appointmentsListView = findViewById(R.id.appointmentsListView);

        // Configurar o calendário
        List<String> days = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            days.add(String.valueOf(i));
        }

        CalendarAdapter calendarAdapter = new CalendarAdapter(this, days);
        calendarGridView.setAdapter(calendarAdapter);

        // Configurar a lista de agendamentos
        List<String> appointments = new ArrayList<>();
        appointments.add("Joana - 10:00 AM");
        appointments.add("Pedro - 11:00 AM");
        appointments.add("Maria - 02:00 PM");
        AppointmentsAdapter appointmentsAdapter = new AppointmentsAdapter(this, appointments);
        appointmentsListView.setAdapter(appointmentsAdapter);
    }
}
