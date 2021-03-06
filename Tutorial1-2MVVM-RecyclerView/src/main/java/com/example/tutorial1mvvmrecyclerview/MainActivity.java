package com.example.tutorial1mvvmrecyclerview;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.tutorial1mvvmrecyclerview.databinding.ActivityMainBinding;
import com.example.tutorial1mvvmrecyclerview.viewmodel.MarkerViewModel;

public class MainActivity extends AppCompatActivity {

    /*
     RecyclerView is updated when data is changed
     fields of Marker are ObservableField<> of immutable String and Integers
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       final MarkerViewModel markerListViewModel = ViewModelProviders.of(this).get(MarkerViewModel.class);
        binding.setViewModel(markerListViewModel);

        MarkerAdapter adapter = new MarkerAdapter(markerListViewModel.getMarkerList());
        recyclerView.setAdapter(adapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                markerListViewModel.add();

                Toast.makeText(MainActivity.this, "ViewModel list size: " + binding.getViewModel().getMarkerList().size(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
