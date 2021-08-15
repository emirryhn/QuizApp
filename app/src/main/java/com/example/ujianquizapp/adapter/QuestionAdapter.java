package com.example.ujianquizapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ujianquizapp.QuestionDetail;
import com.example.ujianquizapp.R;
import com.example.ujianquizapp.entity.Questions;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private ArrayList<Questions> dataList;
    private Context context;

    public QuestionAdapter(Context context, ArrayList<Questions> dataList){
        this.dataList = dataList;
        this.context = context;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        TextView textName, textLevel;
        Button btnSolve;
        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
            textLevel = itemView.findViewById(R.id.text_level);
            btnSolve = itemView.findViewById(R.id.btn_solve);
        }
    }

    @NonNull
    @Override
    public QuestionAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.question_layout, parent, false);
            return new QuestionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.QuestionViewHolder holder, int position) {
        holder.textName.setText(dataList.get(position).getName());
        holder.textLevel.setText(dataList.get(position).getLevel());
        holder.btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, QuestionDetail.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
//        return dataList.size();
        return (dataList != null) ? dataList.size() : 0;
    }

}
