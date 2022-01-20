package com.example.uv_cbot;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CompletionActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String> list1;
    SearchView sv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completion);
        getSupportActionBar().hide();
            lv=findViewById(R.id.list);
            sv=findViewById(R.id.search_icon);
            sv.setQueryHint("Search here for completed tasks.");
            list1=new ArrayList<String>();
            list1.add("Task 1");
            list1.add("Task 2");
            list1.add("Task 3");
            list1.add("Task 4");
            list1.add("Task 5");
            list1.add("Task 6");
            list1.add("Task 7");
            list1.add("Task 8");
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list1);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
