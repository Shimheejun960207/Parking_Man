package com.cookandroid.parking_man;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

// 즐겨찾기 java 파일
public class Parking_favorites extends AppCompatActivity {

    Button btn_home, btn_back;
    ListView listView;

    ArrayAdapter<String> adapter;


    // ArrayList -> Json으로 변환
    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_favorites);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_home = (Button)findViewById(R.id.btn_home);
        listView = (ListView)findViewById(R.id.favorites_list);

        FavoritesAction favAction = (FavoritesAction) getApplication();  // 전역변수인 즐겨찾기 기능
        favAction.array = favAction.getStringArrayPref(getApplicationContext(), SETTINGS_PLAYER_JSON);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, favAction.array);
        listView.setAdapter(adapter);
        // ListView 클릭 시
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

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
