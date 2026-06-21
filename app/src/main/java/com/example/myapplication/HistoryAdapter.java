package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Holder> {

    Context context;
    ArrayList<AnalysisModel> list;

    public HistoryAdapter(Context context, ArrayList<AnalysisModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_2, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        AnalysisModel model = list.get(position);

        holder.text1.setText(model.text);

        holder.text2.setText(
                "احساس غالب : " + model.emotion +
                        " | موضوع متن : " + model.topic +
                        " | کلمات کلیدی متن : " + model.keywords
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView text1, text2;

        public Holder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(android.R.id.text1);
            text2 = itemView.findViewById(android.R.id.text2);
        }
    }
}