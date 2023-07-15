package com.example.sd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList grade_id, grade_semester, grade_result;

    Animation translate_anim;

    int position;

    CustomAdapter(Activity activity, Context context, ArrayList grade_id, ArrayList grade_semester, ArrayList grade_result){
        this.activity = activity;
        this.context = context;
        this.grade_id = grade_id;
        this.grade_semester = grade_semester;
        this.grade_result = grade_result;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.grade_id_txt.setText(String.valueOf(grade_id.get(holder.getAdapterPosition())));
        holder.grade_semester_txt.setText(String.valueOf(grade_semester.get(holder.getAdapterPosition())));
        holder.grade_result_txt.setText(String.valueOf(grade_result.get(holder.getAdapterPosition())));



        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update_activity.class);
                intent.putExtra("id", String.valueOf(grade_id.get(holder.getAdapterPosition())));
                intent.putExtra("semester", String.valueOf(grade_semester.get(holder.getAdapterPosition())));
                intent.putExtra("result", String.valueOf(grade_result.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return grade_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView grade_id_txt,itemsemester, itemgrade,grade_semester_txt, grade_result_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            grade_id_txt = itemView.findViewById(R.id.grade_id_txt);
            itemsemester = itemView.findViewById(R.id.itemsemester);
            itemgrade = itemView.findViewById(R.id.itemgrade);

            grade_semester_txt = itemView.findViewById(R.id.grade_semester_txt);
            grade_result_txt = itemView.findViewById(R.id.grade_result_txt);
            mainLayout = itemView.findViewById(R.id. mainLayout);

            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
