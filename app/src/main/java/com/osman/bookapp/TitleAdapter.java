package com.osman.bookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<String> titleList;
    private CustomItemClickListener clickListener;

    /* constructor method for title adapter class **/
    public TitleAdapter(Context mContext, ArrayList<String> titleList, CustomItemClickListener clickListener) {
        this.mContext = mContext;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }//end of the constructor method

    /* Start all implemented method **/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /* Create view holder through layout **/
        final View view = LayoutInflater.from(mContext).inflate(R.layout.title_layout, parent, false);

        final MyViewHolder viewHolder = new MyViewHolder(view);

        /* Writing code for making clickable event **/
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(view, viewHolder.getPosition());
            }
        });
        /* end code for clickable event **/

        return viewHolder; /* display the view which is click by user **/
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /* Bind the view after opening **/
        holder.titleText.setText(titleList.get(position).replace("_"," "));

    }

    @Override
    public int getItemCount() {
        return titleList.size(); /* display total data **/
    }
    /* end of all implemented method **/

    /* Writing a Sub class or inner class **/
    public class MyViewHolder extends RecyclerView.ViewHolder {

        /* Defining the view **/
        TextView titleText;

        /* constructor method **/
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /* initialize the view **/
            titleText = (TextView) itemView.findViewById(R.id.title_text);

        }//end of the constructor method

    }//end of the MyViewHolder class

}//end of the class
