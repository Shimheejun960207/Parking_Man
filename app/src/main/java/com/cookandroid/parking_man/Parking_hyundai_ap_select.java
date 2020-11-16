package com.cookandroid.parking_man;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Parking_hyundai_ap_select extends AppCompatActivity {

    // 센서 변수 선언
    int sensor_01;
    int sensor_02;
    int sensor_03;
    int sensor_04;
    int sensor_05;
    int sensor_06;


    TextView parking_name;  // 주차장 이름

    // ArrayList -> Json으로 변환
    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";

    private  int park_rumber = 1; // 임시로 부여한 주차장변수
    private int p_sensor = 10; // 센서 id




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_hyundai_ap_select);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    // DB서버에서 값을 가져옵니다.
                    // 각각의 센서 변수에 값을 저장합니다.
                     sensor_01 = jsonResponse.getInt("sensor_01");
                     sensor_02 = jsonResponse.getInt("sensor_02");
                     sensor_03 = jsonResponse.getInt("sensor_03");
                     sensor_04 = jsonResponse.getInt("sensor_04");
                     sensor_05 = jsonResponse.getInt("sensor_05");
                     sensor_06 = jsonResponse.getInt("sensor_06");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        SensorRequest sensorRequest = new SensorRequest(p_sensor, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Parking_hyundai_ap_select.this);
        queue.add(sensorRequest);




        // 즐겨찾기 설정 여부를 저장하는 SharedPreferences인 "starValidate"파일
        final SharedPreferences starValidate = getSharedPreferences("starValidate", 0);
        final SharedPreferences.Editor editor = starValidate.edit();

        final Button btn_home,btn_back,btn_refresh;  // 상단바 변수
        final Button btn_B2_A1,btn_B2_A2,btn_B2_A3,btn_B2_B1,btn_B2_B2,btn_B2_B3; //지하2층 변수
        final Button btn_B3_A1,btn_B3_A2,btn_B3_A3,btn_B3_B1,btn_B3_B2,btn_B3_B3; //지하3층 변수
        final Button btn_star;
        btn_star = (Button)findViewById(R.id.btn_star);

        Spinner spn_parking_floor;
        final LinearLayout linear_floor_B2; //지하2층 레이아웃
        final LinearLayout linear_floor_B3; //지하3층 레이아웃

        linear_floor_B2 = (LinearLayout)findViewById(R.id.linear_floor_B2);
        linear_floor_B3 = (LinearLayout)findViewById(R.id.linear_floor_B3);
        spn_parking_floor = (Spinner)findViewById(R.id.spn_parking_floor);

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

        parking_name = (TextView)findViewById(R.id.parking_name);

        // 주차장 이름 변수에 저장
        final String parking = parking_name.getText().toString();

        // 즐겨찾기 설정 여부 검사
        if(starValidate.contains(parking)) { // hyundai_ap 주차장의 키값 존재할 경우
            if (favValidate(starValidate, parking)==1) // 1이면 즐겨찾기 되어있는 상태
                btn_star.setBackgroundResource(R.drawable.star_full);
            else
                btn_star.setBackgroundResource(R.drawable.star_void);
        }
        else { // hyundai_ap 주차장의 키값이 존재하지 않을 경우
            editor.putInt(parking, 0); // key 값: 주차장명, value 값: 즐겨찾기면 1 아니면 0
            editor.apply();
        }

        // 즐겨찾기 버튼 이벤트
        btn_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoritesAction favAction = (FavoritesAction)getApplication();  // 전역변수인 즐겨찾기 기능
                int validate = favValidate(starValidate, parking);

                if(favAction.starClick(parking, validate)) {
                    Toast.makeText(Parking_hyundai_ap_select.this, "즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    btn_star.setBackgroundResource(R.drawable.star_full);
                    editor.putInt(parking, 1);
                    editor.apply();

                    Log.d(TAG, "Put json");

                } else {
                    Toast.makeText(Parking_hyundai_ap_select.this, "즐겨찾기에 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    btn_star.setBackgroundResource(R.drawable.star_void);
                    editor.putInt(parking, 0);
                    editor.apply();

                    Log.d(TAG, "Put json");
                }
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

                            // oncreate 메소드의 코드를 한번더 실행한다.
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");
                                        // DB서버에서 값을 가져옵니다.
                                        // 각각의 센서 변수에 값을 저장합니다.
                                        sensor_01 = jsonResponse.getInt("sensor_01");
                                        sensor_02 = jsonResponse.getInt("sensor_02");
                                        sensor_03 = jsonResponse.getInt("sensor_03");
                                        sensor_04 = jsonResponse.getInt("sensor_04");
                                        sensor_05 = jsonResponse.getInt("sensor_05");
                                        sensor_06 = jsonResponse.getInt("sensor_06");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            SensorRequest sensorRequest = new SensorRequest(p_sensor, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(Parking_hyundai_ap_select.this);
                            queue.add(sensorRequest);

                            // 센서에 사물이 감지되면 주차장 자리가 빨간색으로 변경된다.
                            // 센서에 감지되지 않는다면 주차장 자리가 파란색으로 변경된다.

                            // A1의 센서 코드 값이 10이면 감지된 것 이다.
                            if (sensor_01 == 10)
                            {
                                btn_B2_A1.setBackgroundResource(R.drawable.parking_red);
                                btn_B3_A1.setBackgroundResource(R.drawable.parking_red);
                            }
                            else
                            {
                                btn_B2_A1.setBackgroundResource(R.drawable.parking_blue);
                                btn_B3_A1.setBackgroundResource(R.drawable.parking_blue);
                            }
                            // A2의 센서 코드 값이 20이면 감지된 것 이다.
                            if (sensor_02 == 20)
                            {
                                btn_B2_A2.setBackgroundResource(R.drawable.parking_red);
                                btn_B3_A2.setBackgroundResource(R.drawable.parking_red);
                            }
                            else
                            {
                                btn_B2_A2.setBackgroundResource(R.drawable.parking_blue);
                                btn_B3_A2.setBackgroundResource(R.drawable.parking_blue);
                            }
                            // A3의 센서 코드 값이 30이면 감지된 것 이다.
                            if (sensor_03 == 30)
                            {
                                btn_B2_A3.setBackgroundResource(R.drawable.parking_red);
                                btn_B3_A3.setBackgroundResource(R.drawable.parking_red);
                            }
                            else
                            {
                                btn_B2_A3.setBackgroundResource(R.drawable.parking_blue);
                                btn_B3_A3.setBackgroundResource(R.drawable.parking_blue);
                            }

                            // B1의 센서 코드 값이 40이면 감지된 것 이다.
                            if (sensor_04 == 40)
                            {
                                btn_B2_B1.setBackgroundResource(R.drawable.parking_red);
                                btn_B3_B1.setBackgroundResource(R.drawable.parking_red);
                            }
                            else
                            {
                                btn_B2_B1.setBackgroundResource(R.drawable.parking_blue);
                                btn_B3_B1.setBackgroundResource(R.drawable.parking_blue);
                            }

                            // B2의 센서 코드 값이 50이면 감지된 것 이다.
                            if (sensor_05 == 50)
                            {
                                btn_B2_B2.setBackgroundResource(R.drawable.parking_red);
                                btn_B3_B2.setBackgroundResource(R.drawable.parking_red);
                            }
                            else
                            {
                                btn_B2_B2.setBackgroundResource(R.drawable.parking_blue);
                                btn_B3_B2.setBackgroundResource(R.drawable.parking_blue);
                            }

                            // B3의 센서 코드 값이 60이면 감지된 것 이다.
                           if (sensor_06 == 60)
                            {
                                btn_B2_B3.setBackgroundResource(R.drawable.parking_red);
                                btn_B3_B3.setBackgroundResource(R.drawable.parking_red);
                            }
                            else
                            {
                                btn_B2_B3.setBackgroundResource(R.drawable.parking_blue);
                                btn_B3_B3.setBackgroundResource(R.drawable.parking_blue);
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

    // 취소버튼에 애니메이션 추가
    public void onBackPressed() {

        super.onBackPressed();
        //화면 전환 애니메이션
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

    }

    // 즐겨찾기 설정 여부 리턴하는 메소드
    public int favValidate(SharedPreferences starValidate, String parking) {
        int validate;
        validate = starValidate.getInt(parking, 0);
        return validate;
    }

}
