package com.cookandroid.parking_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Parking_local_select extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_local_select);

        Button btn_seoul,btn_back,btn_home;
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);
        btn_seoul = (Button) findViewById(R.id.btn_seoul);
        //서울 클릭 이벤트
        btn_seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(),Parking_seoul_select.class);
                startActivity(Intent);
                // 화면 전환 애니메이션입니다.
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });

        // 좌측 상단 뒤로가기 버튼 이벤트
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });

        //우측 홈버튼 이벤트
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(),Parking_main.class);
                startActivity(Intent);
            }
        });

    }
    // 취소버튼에 애니메이션 추가
    public void onBackPressed() {

         super.onBackPressed();
         //화면 전환 애니메이션
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

    }
}
