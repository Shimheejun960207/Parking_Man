package com.cookandroid.parking_man;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

// 즐겨찾기 기능에 관련된 메소드가 들어있는 java파일
public class FavoritesAction extends Application {
    ArrayAdapter<String> adapter;
    ArrayList<String> array = new ArrayList<>();

    // ArrayList -> Json으로 변환
    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";

    public boolean starClick(String parking, int star_number) {
        if (star_number == 0) { // 0이면 즐겨찾기 안되어있는 상태
            if(parking.length() != 0) {
                array.add(parking);  // 주차장 즐겨찾기 배열리스트에 추가
                setStringArrayPref(getApplicationContext(), SETTINGS_PLAYER_JSON, array);
            }
            return true;
        }
        else { // 1이면 즐겨찾기 되어있는 상태
            array.remove(parking);  // 배열리스트의 마지막 인덱스 데이터 삭제
            setStringArrayPref(getApplicationContext(), SETTINGS_PLAYER_JSON, array);

            return false;
        }
    }

    // ArrayList -> Json으로 변환하여 SharedPreferences인 "favorites"에 저장
    public void setStringArrayPref(Context context, String key, ArrayList<String> values) {
        SharedPreferences favorites = getSharedPreferences("favorites", MODE_PRIVATE);
        SharedPreferences.Editor editor = favorites.edit();
        JSONArray a = new JSONArray();

        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }

        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }

        editor.apply();
    }

    // Json -> ArrayList로 변환하여 반환
    public ArrayList getStringArrayPref(Context context, String key) {
        SharedPreferences favorites = getSharedPreferences("favorites", MODE_PRIVATE);
        String json = favorites.getString(key, null);
        ArrayList urls = new ArrayList();

        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);

                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}
