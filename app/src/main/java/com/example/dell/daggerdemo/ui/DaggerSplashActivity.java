package com.example.dell.daggerdemo.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.dell.daggerdemo.R;
import com.example.dell.daggerdemo.databinding.ActivitySplashBinding;

public class DaggerSplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding = null;

    private String[] dataList = new String[]{"dagger中Component跟Component的依赖", "dagger中Component跟SubComponent的结合方式"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        //绑定xml对应的model
        binding.setVm(this);

        binding.listView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dataList
        ));
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(DaggerSplashActivity.this,MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DaggerSplashActivity.this,SubComponentActivity.class));
                        break;
                }
            }
        });
    }
}
