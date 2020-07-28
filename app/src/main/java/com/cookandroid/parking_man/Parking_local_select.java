package com.cookandroid.parking_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Parking_local_select extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_local_select);

        Button btn_back,btn_home;

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);


        // 지역 선택하는 버튼 변수 설정
        Button btn_Seoul,btn_Gyeong_gi,btn_Gangwon,btn_Chungcheong_north,btn_Gyeongsang_north
                ,btn_Chungcheong_south,btn_Gyeongsang_south,btn_Jeolla_north,btn_Jeolla_south;
        btn_Seoul = (Button) findViewById(R.id.btn_Seoul);
        btn_Chungcheong_north = (Button) findViewById(R.id.btn_Chungcheong_north);
        btn_Chungcheong_south = (Button) findViewById(R.id.Chungcheong_south);
        btn_Gyeong_gi = (Button) findViewById(R.id.btn_Gyeong_gi);
        btn_Gangwon = (Button) findViewById(R.id.btn_Gangwon);
        btn_Gyeongsang_north = (Button) findViewById(R.id.Gyeongsang_north);
        btn_Gyeongsang_south = (Button) findViewById(R.id.Gyeongsang_south);
        btn_Jeolla_north = (Button) findViewById(R.id.Jeolla_north);
        btn_Jeolla_south = (Button) findViewById(R.id.Jeolla_south);


        //서울 클릭 이벤트
        btn_Seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(),Parking_seoul_select.class);
                startActivity(Intent);
                // 화면 전환 애니메이션입니다.
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });

        //경기도 클릭 이벤트
        btn_Gyeong_gi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //강원도 클릭 이벤트
        btn_Gangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //충북 클릭 이벤트
        btn_Chungcheong_north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //충남 클릭 이벤트
        btn_Chungcheong_south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //경북 클릭 이벤트
        btn_Gyeongsang_north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //경남 클릭 이벤트
        btn_Gyeongsang_south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //전북 클릭 이벤트
        btn_Jeolla_north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        //전남 클릭 이벤트
        btn_Jeolla_south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_local_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
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
