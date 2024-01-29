package com.sbit.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RowGridActivity extends AppCompatActivity {

    EditText rows,cols,alphabet;
    Button submit,add;
    TextView character,gridtext;
    GridView gridlist;

    ArrayList<String> alpabetlist=new ArrayList<>();
    int countlist;

    ArrayAdapter arrayAdapter;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row_grid);

        rows = findViewById(R.id.rows);
        cols = findViewById(R.id.cols);
        submit = findViewById(R.id.submitgrid);
        gridlist = findViewById(R.id.gridlist);
        alphabet = findViewById(R.id.alphabet);
        alphabet.setVisibility(View.GONE);
        character = findViewById(R.id.character);
        add = findViewById(R.id.add);

        alphabet.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence charSequence, int start, int end,
                                               Spanned dest, int etStart, int etEnd) {
                        if (charSequence.equals("")) {
                            return charSequence;
                        }
                        if (charSequence.toString().matches("[a-zA-Z ]+")) {
                            return charSequence;
                        }
                        return "";
                    }
                }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!cols.getText().toString().equals("") && !rows.getText().toString().equals("")) {

                    gridlist.setNumColumns(Integer.parseInt(cols.getText().toString()));

                    countlist = Integer.parseInt(rows.getText().toString()) * Integer.parseInt(cols.getText().toString());
                    Log.e("Count ::",""+countlist);
                    character.setText("Add "+countlist+" Alphabet one after another");
                }
                alphabet.setVisibility(View.VISIBLE);
            }
        });

        alpabetlist = new ArrayList<>();

//        for (i = 0; i < countlist; i++) {
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(alpabetlist.size()<countlist) {

                        if (!alphabet.getText().toString().isEmpty()) {

                            alphabet.setVisibility(View.VISIBLE);
                            Log.e("alphabet:", "" + alphabet.getText().toString());
                            Log.e("List :", "" + alpabetlist.size());
                            alphabet.setVisibility(View.VISIBLE);
                            alpabetlist.add(alphabet.getText().toString());
                            alphabet.setText("");
                        }
                    }else{

                        Log.e("List if else:", "" + alpabetlist.size());
                        if(alpabetlist.size()>0) {
                            arrayAdapter = new ArrayAdapter(RowGridActivity.this, android.R.layout.simple_list_item_1, alpabetlist);
                            gridlist.setAdapter(arrayAdapter);
                        }
                        Toast.makeText(RowGridActivity.this, "Enough alphabet", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        //}
    }
}