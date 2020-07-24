package com.cookandroid.parking_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Parking_gangnam_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_gangnam_select);

        Button btn_back,btn_home;
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);
        final Button btn_next;
        btn_next = (Button) findViewById(R.id.btn_next);

        final LinearLayout linear_hyundai_mu,linear_hyundai_ap;
        linear_hyundai_mu = (LinearLayout) findViewById(R.id.linear_hyundai_mu);
        linear_hyundai_ap = (LinearLayout) findViewById(R.id.linear_hyundai_ap);

        Spinner spn_parking_name;
        spn_parking_name = (Spinner)findViewById(R.id.spn_parking_name);



        // 스피너 선택하는 이벤트
        spn_parking_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) // 선택하세요 클릭시 이벤트
                {
                    linear_hyundai_mu.setVisibility(View.INVISIBLE);
                    linear_hyundai_ap.setVisibility(View.INVISIBLE);
                    btn_next.setVisibility(View.INVISIBLE);

                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });

                }
                else if(position == 1) // 임시 A
                {
                    linear_hyundai_mu.setVisibility(View.VISIBLE);
                    linear_hyundai_ap.setVisibility(View.INVISIBLE);
                    btn_next.setVisibility(View.VISIBLE);

                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent Intent = new Intent(getApplicationContext(),Parking_hyundai_mu_select.class);
                            startActivity(Intent);
                            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                        }
                    });

                }
                    else if(position == 2) // 임시 B
                {
                    linear_hyundai_mu.setVisibility(View.INVISIBLE);
                    linear_hyundai_ap.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.VISIBLE);

                    btn_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent Intent = new Intent(getApplicationContext(),Parking_hyundai_ap_select.class);
                            startActivity(Intent);
                            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                        }
                    });

                }
                else{}
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
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
