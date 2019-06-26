package com.example.bohproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = (RecyclerView) findViewById(R.id.characters);

    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    //mAdapter = new MyAdapter(myDataset);
    recyclerView.setAdapter(mAdapter);
  }

  protected void onPress(View view) {
    Intent intent = new Intent(this, ViewActivity.class );
    startActivity(intent);
  }
}
