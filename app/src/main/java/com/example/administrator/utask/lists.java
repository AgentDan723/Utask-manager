package com.example.administrator.utask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class lists extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsadapter;
    private ListView listView;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        listView=findViewById(R.id.listview);
        button2=findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View view){
                additems(view);

        }
        });

        items=new ArrayList<>();
        itemsadapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsadapter);
        setUplistviewListener();


    }

    private void setUplistviewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterview, View view, int i, long l) {
                Context context= getApplicationContext();
                Toast.makeText(context, "Item Removed",Toast.LENGTH_LONG).show();
                items.remove(i);
                itemsadapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    private void additems(View view) {
        EditText input = findViewById(R.id.editText3);
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))) {
            itemsadapter.add(itemText);
            input.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Please Enter Text..", Toast.LENGTH_LONG).show();
        }
    }
}
