package com.example.myapp6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
//      어댑터객체 생성 후데이터 어댑터에 입력
        adapter adapter = new adapter();
        adapter.addItem(new lating("jmw93","내용이 참 재미있었고 유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));
        adapter.addItem(new lating("jmw931012","내용이 참  유익했어요"));

        recyclerView.setAdapter(adapter);
    }
}
