package com.example.tutorial5livedata_mvvm_room_recyclerview;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.tutorial5livedata_mvvm_room_recyclerview.databinding.ActivityMainBinding;
import com.example.tutorial5livedata_mvvm_room_recyclerview.view.AddMarkerActivity;
import com.example.tutorial5livedata_mvvm_room_recyclerview.view.MarkerAdapter;
import com.example.tutorial5livedata_mvvm_room_recyclerview.viewmodel.MarkerListViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MarkerListViewModel markerListViewModel = ViewModelProviders.of(this).get(MarkerListViewModel.class);

        MarkerAdapter adapter = new MarkerAdapter(markerListViewModel.getListLiveData().getValue());
        recyclerView.setAdapter(adapter);

        markerListViewModel.getListLiveData().observe(this, markerList -> adapter.setMarkerList(markerList));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add_location:
                Intent intent = new Intent(MainActivity.this, AddMarkerActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}
