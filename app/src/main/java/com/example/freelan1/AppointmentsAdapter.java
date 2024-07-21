package com.example.freelan1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class AppointmentsAdapter extends BaseAdapter {

    private Context context;
    private List<String> appointments;

    public AppointmentsAdapter(Context context, List<String> appointments) {
        this.context = context;
        this.appointments = appointments;
    }

    @Override
    public int getCount() {
        return appointments.size();
    }

    @Override
    public Object getItem(int position) {
        return appointments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.drawable.appointment_item, parent, false);
        }
        TextView appointmentText = convertView.findViewById(R.id.appointmentText);
        appointmentText.setText(appointments.get(position));
        return convertView;
    }
}
