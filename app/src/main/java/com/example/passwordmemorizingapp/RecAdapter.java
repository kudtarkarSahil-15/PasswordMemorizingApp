package com.example.passwordmemorizingapp;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyView> {

//    fields
    Context context;
//    private ArrayList<Model> dataModel;
    ArrayList recordId, userId, password, domain;
//    Activity activity;
    String Domain;

    Database2 db2;

//    consructor
    public RecAdapter(Context context, ArrayList recordId, ArrayList userId, ArrayList password, ArrayList domain) {
        this.context = context;
        this.recordId = recordId;
        this.userId = userId;
        this.password = password;
        this.domain = domain;
    }

//    constructor
//    public RecAdapter(Context context, ArrayList<Model> dataModel) {
//        this.context = context;
//        this.dataModel = dataModel;
//    }

    @NonNull
    @Override
    public RecAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.data_container, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.MyView holder, @SuppressLint("RecyclerView") int position) {

//        here getting all the data from arrays
//        holder.recordIdTxt.setText(String.valueOf(recordId.get(position)));
        holder.domainTxt.setText(String.valueOf(domain.get(position)));
//        Model model = dataModel.get(position);
//        holder.domainTxt.setText(model.getDomain());

//        holder.imageView.setImageResource(String.valueOf(domain.get(position)).equals("Amazon") ? R.drawable.amazon : R.drawable.google);

        String domainName = String.valueOf(domain.get(position));
        if(domainName.equalsIgnoreCase("Amazon")) {
            holder.imageView.setImageResource(R.drawable.amazon);
        }
        else if(domainName.equalsIgnoreCase("Google")) {
            holder.imageView.setImageResource(R.drawable.google);
        }
        else if(domainName.equalsIgnoreCase("Myntra")) {
            holder.imageView.setImageResource(R.drawable.myntra);
        }
        else if(domainName.equalsIgnoreCase("Instagram")) {
            holder.imageView.setImageResource(R.drawable.instagram);
        }
        else if(domainName.equalsIgnoreCase("Twitter")) {
            holder.imageView.setImageResource(R.drawable.twitter);
        }
        else if(domainName.equalsIgnoreCase("LinkedIn")) {
            holder.imageView.setImageResource(R.drawable.linkedln);
        }
        else if(domainName.equalsIgnoreCase("Flipkart")) {
            holder.imageView.setImageResource(R.drawable.flipkart);
        }
        else if(domainName.equalsIgnoreCase("Zoom")) {
            holder.imageView.setImageResource(R.drawable.zoom);
        }
        else if(domainName.equalsIgnoreCase("Work Gmail")) {
            holder.imageView.setImageResource(R.drawable.workid);
        }
        else if(domainName.equalsIgnoreCase("School Gmail")) {
            holder.imageView.setImageResource(R.drawable.student_id);
        }
        else if(domainName.equalsIgnoreCase("StudentId")) {
            holder.imageView.setImageResource(R.drawable.student_id);
        }
        else if(domainName.equalsIgnoreCase("Netflix")) {
            holder.imageView.setImageResource(R.drawable.netflix);
        }
        else if(domainName.equalsIgnoreCase("Prime")) {
            holder.imageView.setImageResource(R.drawable.amazonprime);
        }
        else if(domainName.equalsIgnoreCase("Leetcode")) {
            holder.imageView.setImageResource(R.drawable.leetcode);
        }
        else if(domainName.equalsIgnoreCase("Github")) {
            holder.imageView.setImageResource(R.drawable.github);
        }
        else if(domainName.equalsIgnoreCase("Repl_it")) {
            holder.imageView.setImageResource(R.drawable.replit);
        }
        else if(domainName.equalsIgnoreCase("Udemy")) {
            holder.imageView.setImageResource(R.drawable.udemy);
        }
        else if(domainName.equalsIgnoreCase("Facebook")) {
            holder.imageView.setImageResource(R.drawable.facebook);
        }
        else if(domainName.equalsIgnoreCase("SnapChat")) {
            holder.imageView.setImageResource(R.drawable.snapchat);
        }
        else if(domainName.equalsIgnoreCase("Microsoft")) {
            holder.imageView.setImageResource(R.drawable.microsoft);
        }
        else if(domainName.equalsIgnoreCase("Edge")) {
            holder.imageView.setImageResource(R.drawable.edge);
        }
        else if(domainName.equalsIgnoreCase("CodeChef")) {
            holder.imageView.setImageResource(R.drawable.codechef);
        }
        else if(domainName.equalsIgnoreCase("Hackerrank")) {
            holder.imageView.setImageResource(R.drawable.hackerrank);
        }
        else if(domainName.equalsIgnoreCase("Figma")) {
            holder.imageView.setImageResource(R.drawable.figma);
        }
        else if(domainName.equalsIgnoreCase("Office")) {
            holder.imageView.setImageResource(R.drawable.office);
        }
        else if(domainName.equalsIgnoreCase("Zomato")) {
            holder.imageView.setImageResource(R.drawable.zomato);
        }
        else if(domainName.equalsIgnoreCase("Swiggy")) {
            holder.imageView.setImageResource(R.drawable.swiggy);
        }
        else if(domainName.equalsIgnoreCase("Gmail")) {
            holder.imageView.setImageResource(R.drawable.gmail);
        }
        else {
            holder.imageView.setImageResource(R.drawable.icon_default);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(context, MainActivity5.class);
                in.putExtra("myId",String.valueOf(recordId.get(position)));
                in.putExtra("myUserId",String.valueOf(userId.get(position)));
                in.putExtra("myPassword",String.valueOf(password.get(position)));
                in.putExtra("myDomain",String.valueOf(domain.get(position)));
//                  in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                  in.putExtra("myUserId", model.getUserId());
//                  in.putExtra("myPassword", model.getPassword());
//                  in.putExtra("myDomain", model.getDomain());
//                activity.startActivityForResult(in, 1);
                context.startActivity(in);
            }
        });


//        holder.imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                db2 = new Database2(context);
//                db2.deleteData(Database2.COLUMN_ID);
//                db2.close();
//
//                Intent in = new Intent(context, MainActivity3.class);
//                context.startActivity(in);
//            }
//        });
    }

    @Override
    public int getItemCount() {
//        we can use any obj over here all will give same result
        return recordId.size();
    }

    public static class MyView extends RecyclerView.ViewHolder {

//        fields
        TextView domainTxt;
        LinearLayout linearLayout;
//        ImageButton imageButton;
        ImageView imageView;

        public MyView(@NonNull View itemView) {
            super(itemView);

            domainTxt = itemView.findViewById(R.id.domainTxt);
//            imageButton = itemView.findViewById(R.id.imgButtonDelete);
            imageView = itemView.findViewById(R.id.imageViewI);

            linearLayout = itemView.findViewById(R.id.containerLayout);
        }
    }
}


