package com.cookandroid.parking_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Parking_hyundai_mu_select extends AppCompatActivity {

    private  int park_rumber = 1; // 임시로 부여한 주차장변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_hyundai_mu_select);

        final Button btn_home,btn_back,btn_refresh;  // 상단바 변수
        final Button btn_B2_A1,btn_B2_A2,btn_B2_A3,btn_B2_B1,btn_B2_B2,btn_B2_B3; //지하2층 변수
        Button btn_B3_A1,btn_B3_A2,btn_B3_A3,btn_B3_B1,btn_B3_B2,btn_B3_B3; //지하3층 변수

        Spinner spn_parking_floor;
        final LinearLayout linear_floor_B2; //지하2층 레이아웃
        final LinearLayout linear_floor_B3; //지하3층 레이아웃

        linear_floor_B2 = (LinearLayout)findViewById(R.id.linear_floor_B2);
        linear_floor_B3 = (LinearLayout)findViewById(R.id.linear_floor_B3);
        spn_parking_floor = (Spinner)findViewById(R.id.spn_parking_floor);

        RatingBar btn_star;
        btn_star = (RatingBar) findViewById(R.id.btn_star);

        btn_B2_A1 = (Button) findViewById(R.id.btn_B2_A1);
        btn_B2_A2 = (Button) findViewById(R.id.btn_B2_A2);
        btn_B2_A3 = (Button) findViewById(R.id.btn_B2_A3);
        btn_B2_B1 = (Button) findViewById(R.id.btn_B2_B1);
        btn_B2_B2 = (Button) findViewById(R.id.btn_B2_B2);
        btn_B2_B3 = (Button) findViewById(R.id.btn_B2_B3);

        btn_B3_A1 = (Button) findViewById(R.id.btn_B3_A1);
        btn_B3_A2 = (Button) findViewById(R.id.btn_B3_A2);
        btn_B3_A3 = (Button) findViewById(R.id.btn_B3_A3);
        btn_B3_B1 = (Button) findViewById(R.id.btn_B3_B1);
        btn_B3_B2 = (Button) findViewById(R.id.btn_B3_B2);
        btn_B3_B3 = (Button) findViewById(R.id.btn_B3_B3);

        btn_refresh = (Button) findViewById(R.id.btn_refresh) ;
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);


        /*
        주차장 빈칸 을 변경하는 방법 (어디까지나 나의 생각)

        예) 사물이 감지되면  int senser_B2_A1(지하2층 A1자리의 센서값) = 1
            사물이 감지되지 않으면 i = 0
            주차장 총칸을 알려주는 변수 int x = 6; //  6칸이다
            주차장 빈칸을 알려주는 변수 int y = 6; // 처음빈칸은 6칸이다

            if (senser_B1_A1 == 1) // 센서감지
            {    btn_B2_A1.setBackgroundResource(R.drawable.parking_red);

            // 그 자리의 위젯 배경화면을 빨간색으로 변경시킴

             y--; // 빈칸의 값이 줄어들음

            }

            else // 감지되지않음
            {   btn_B2_A1.setBackgroundResource(R.drawable.parking_blue);    }
            //  배경화면을 파란색으로 변경시킴

         */


    btn_star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            Toast toast = Toast.makeText(Parking_hyundai_mu_select.this,"즐겨찾기에 추가되었습니다.",Toast.LENGTH_SHORT);
            toast.show();
        }
    });


        // 스피너 선택하는 이벤트
        spn_parking_floor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if(position == 0)
                {
                    linear_floor_B2.setVisibility(View.VISIBLE);
                    linear_floor_B3.setVisibility(View.INVISIBLE);

                    //새로고침 버튼 이벤트
                    // 일단은 값이 변하는 걸 주기위해 임시적으로 주차장 값이 변하게 설정
                    btn_refresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (park_rumber == 1)
                            {
                                btn_B2_A1.setBackgroundResource(R.drawable.parking_red);
                                btn_B2_B2.setBackgroundResource(R.drawable.parking_red);
                                btn_B2_B1.setBackgroundResource(R.drawable.parking_blue);
                                btn_B2_B3.setBackgroundResource(R.drawable.parking_blue);
                                park_rumber--;
                            }
                            else
                            {
                                btn_B2_A1.setBackgroundResource(R.drawable.parking_blue);
                                btn_B2_B2.setBackgroundResource(R.drawable.parking_blue);
                                btn_B2_B1.setBackgroundResource(R.drawable.parking_red);
                                btn_B2_B3.setBackgroundResource(R.drawable.parking_red);
                                park_rumber++;
                            }

                        }
                    });

                }
                else if(position == 1)
                {
                    linear_floor_B2.setVisibility(View.INVISIBLE);
                    linear_floor_B3.setVisibility(View.VISIBLE);
                }
                else {}
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

}
