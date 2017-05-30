package com.example.emperormoose.habitapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.interpolator.linear;
import static com.example.emperormoose.habitapp.R.id.text;
import static com.example.emperormoose.habitapp.R.layout.activity_main;
import static com.example.emperormoose.habitapp.R.layout.activity_habit;

public class MainActivity extends AppCompatActivity {

    //Variables for this class
    private ListView mListView;
    private EditText mEditText;
    private Button mButton;
    ArrayList<String> habitList = new ArrayList<String>();
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Standard start of android stuff
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        //Variables for views and the button listener
        mListView = (ListView) findViewById(R.id.mainListView);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(onClick());

        //Sets the default text for the textview
        TextView textView = new TextView(this);
        textView.setText("New text");
        //The adapter handles the listview
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, habitList);
        mListView.setAdapter(listAdapter);

        //TODO fix the errors in this block. activity.class is unknown, despite being defined. Figure out how intent works,
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(view.getContext(), activity_habit.class);
                mIntent.putExtra(text);
                startActivity(mIntent);
            }
        });
    }

    //listener for the button
    private View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the text from the edit text
                String text =  mEditText.getText().toString();
                //add the text to the adapter
                listAdapter.add(text);
                //place the adapter in the view
            }
        };
    }
}