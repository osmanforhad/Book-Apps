package com.osman.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* Declaring the variable **/
    private static final String TAG = "MainActivity";

    private Context mContext;

    ArrayList<String> titleArrayList;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initiate the Context **/
        mContext = MainActivity.this;

        /* initiate the titleArrayList **/
        titleArrayList = new ArrayList<String>();
        titleArrayList.add(Constants.WHAT_IS_JAVA);
        titleArrayList.add(Constants.HISTORY_OF_JAVA);
        titleArrayList.add(Constants.FEATURES_OF_JAVA);
        titleArrayList.add(Constants.C_VS_JAVA);
        titleArrayList.add(Constants.HELLO_JAVA_PROGRAM);
        titleArrayList.add(Constants.PROGRAM_INTERNAL);
        titleArrayList.add(Constants.HOW_TO_SET_PATH);
        titleArrayList.add(Constants.JDK_JRE_AND_JVM);
        titleArrayList.add(Constants.INTERNAL_DETAIL_OF_JVM);
        titleArrayList.add(Constants.JAVA_VARIABLES);
        titleArrayList.add(Constants.JAVA_DATA_TYPES);
        titleArrayList.add(Constants.UNICODE_SYSTEM);
        titleArrayList.add(Constants.OPERATORS);

        /* initiate the RecyclerView **/
        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        /* making variable of TitleAdapter and initial the context & titleArrayList**/
        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                /* Display popup message after clicking every item according to ArrayList **/
                Toast.makeText(mContext, "clicked "+titleArrayList.get(position), Toast.LENGTH_SHORT).show();


                /* for going to next activity after clicking every item according to ArrayList **/
                Intent desIntent = new Intent(mContext,DescriptionActivity.class);
                desIntent.putExtra("titles",titleArrayList.get(position)); //here titles is the key for DescriptionActivity activity
                startActivity(desIntent); //open the description

            }
        });//end of CustomItemClickListener

        /* set the adapter into RecyclerView **/
        mRecyclerView.setAdapter(adapter);

    }//end of the onCreate method

}//end of the class
