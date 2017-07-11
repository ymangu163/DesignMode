package com.design.mode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.common.adapter.DividerItemDecoration;
import com.common.adapter.HomeAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new HomeAdapter(MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        initData();
        mAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                handleClick(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
                mAdapter.removeData(position);
            }
        });

    }

    private void handleClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
//                intent = new Intent(this, UIActivity.class);
                break;
            case 1:
//                intent = new Intent(this, EncloseActivity.class);
                break;
            case 2:
//                intent = new Intent(this, CustomActivity.class);
                break;
            case 3:
//                intent = new Intent(this, FrameActivity.class);
                break;



        }
//        startActivity(intent);

    }

    private void initData() {
        String[] array = getResources().getStringArray(R.array.main);
        mDatas = Arrays.asList(array);
        mAdapter.setDatas(mDatas);
    }




}
