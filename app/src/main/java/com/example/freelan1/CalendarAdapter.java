package com.example.freelan1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CalendarAdapter extends BaseAdapter {

    private Context context;
    private List<String> days;

    public CalendarAdapter(Context context, List<String> days) {
        this.context = context;
        this.days = days;
    }

    @Override
    public int getCount() {
        return days.size();
    }

    @Override
    public Object getItem(int position) {
        return days.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.drawable.calendar_day, parent, false);
        }
        TextView dayText = convertView.findViewById(R.id.dayText);
        dayText.setText(days.get(position));
        return convertView;
    }
}
