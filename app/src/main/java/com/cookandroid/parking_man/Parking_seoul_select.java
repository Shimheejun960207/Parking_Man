package com.cookandroid.parking_man;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Parking_seoul_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_seoul_select);

        Button btn_back,btn_home;

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);

        // 지역 버튼 설정

        Button btn_Gangnam,btn_Gangdong,btn_Gangbuk,btn_Gangseo,btn_Gwanag,btn_Gwangjin,btn_Guro,
                btn_Geumcheon,btn_Nowon,btn_Dobong,btn_Dongdeamun,btn_Dongjak,btn_Mapo,btn_Seodaemun,
                btn_Seocho,btn_Seongdong,btn_Seongbuk,btn_Songpa,btn_Yangcheon,btn_Yeongdeungpo,
                btn_Yongsan,btn_Eunpyeong,btn_Jongno,btn_Jung,btn_Jungnang;

        btn_Gangnam = (Button) findViewById(R.id.btn_Gangnam);
        btn_Dobong = (Button)findViewById(R.id.btn_Dobong);
        btn_Dongdeamun  = (Button)findViewById(R.id.btn_Dongdeamun);
        btn_Dongjak  = (Button)findViewById(R.id.btn_Dongjak);
        btn_Eunpyeong  = (Button)findViewById(R.id.btn_Eunpyeong);
        btn_Gangbuk  = (Button)findViewById(R.id.btn_Gangbuk);
        btn_Gangdong  = (Button)findViewById(R.id.btn_Gangdong);
        btn_Gangseo  = (Button)findViewById(R.id.btn_Gangseo);
        btn_Geumcheon  = (Button)findViewById(R.id.btn_Geumcheon);
        btn_Guro  = (Button)findViewById(R.id.btn_Guro);
        btn_Gwanag  = (Button)findViewById(R.id.btn_Gwanag);
        btn_Gwangjin  = (Button)findViewById(R.id.btn_Gwangjin);
        btn_Jongno  = (Button)findViewById(R.id.btn_Jongno);
        btn_Jung  = (Button)findViewById(R.id.btn_Jung);
        btn_Jungnang  = (Button)findViewById(R.id.btn_Jungnang);
        btn_Mapo  = (Button)findViewById(R.id.btn_Mapo);
        btn_Nowon = (Button)findViewById(R.id.btn_Nowon);
        btn_Seocho = (Button)findViewById(R.id.btn_Seocho);
        btn_Seodaemun = (Button)findViewById(R.id.btn_Seodaemun);
        btn_Seongbuk = (Button)findViewById(R.id.btn_Seongbuk);
        btn_Seongdong = (Button)findViewById(R.id.btn_Seongdong);
        btn_Songpa = (Button)findViewById(R.id.btn_Songpa);
        btn_Yangcheon  = (Button)findViewById(R.id.btn_Yangcheon);
        btn_Yeongdeungpo = (Button)findViewById(R.id.btn_Yeongdeungpo);
        btn_Yongsan = (Button)findViewById(R.id.btn_Yongsan);




        //강남구 선택 이벤트
        btn_Gangnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(getApplicationContext(),Parking_gangnam_select.class);
                startActivity(Intent);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });

        // 도봉구
        btn_Dobong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 동대문구
        btn_Dongdeamun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 동작구
        btn_Dongjak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 은평구
        btn_Eunpyeong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 강북구
        btn_Gangbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 강동구
        btn_Gangdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 강서구
        btn_Gangseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 금촌구
        btn_Geumcheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 구로구
        btn_Guro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 관악구
        btn_Gwanag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 광진구
        btn_Gwangjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 종로구
        btn_Jongno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 중구
        btn_Jung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 중량구
        btn_Jungnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 마포구
        btn_Mapo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 노원구
        btn_Nowon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 서초구
        btn_Seocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 서대문구
        btn_Seodaemun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 성북구
        btn_Seongbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 성동구
        btn_Seongdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 송파구
        btn_Songpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 양천구
        btn_Yangcheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 영등포구
        btn_Yeongdeungpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
                dlg.setTitle("서비스 준비중 입니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        // 용산구
        btn_Yongsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Parking_seoul_select.this);
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
