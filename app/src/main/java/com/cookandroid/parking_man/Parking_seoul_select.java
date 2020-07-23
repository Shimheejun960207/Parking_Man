package com.cookandroid.parking_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Parking_seoul_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_seoul_select);

        Button btn_gangnam,btn_back,btn_home;
        btn_gangnam = (Button) findViewById(R.id.btn_gangnam);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);



        //강남구 선택 이벤트
        btn_gangnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(),Parking_gangnam_select.class);
                startActivity(Intent);
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
