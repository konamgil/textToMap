package com.letscombin.getimagefrommanager.parsingjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button btnSumit;
    private EditText etKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        btnSumit = (Button)findViewById(R.id.btnSumit);
        etKey = (EditText)findViewById(R.id.etKey);
        initData();
    }

    private String[] mKeyName = {"이름", "번호", "주소"};
    private String[] uName = {"고남길","고은별","고한주","고가영"};
    private String[] uNumber = {"01072553466","01037793466","01073532116","01012435116"};
    private String[] mAddr = {"서울시 송파구 마천동","서울시 송파구 거여동","서울시 송파구 오금동","서울시 송파구 문정동"};

    private void initData(){
        final ArrayList<HashMap<String,String>> mArray = new ArrayList<>();
        for (int idx = 0 ; idx < uName.length ; idx++){
            HashMap<String , String> map = new HashMap<String , String>();
            map.put(mKeyName[0], uName[idx]);
            map.put(mKeyName[1], uNumber[idx]);
            map.put(mKeyName[2], mAddr[idx]);
            mArray.add(map);
        }

        Log.e(getClass().getSimpleName(), "map ? : "  + mArray.size());

        btnSumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etKey.getText().toString();
                String resultMsg = "";

                for (int count =0 ; count < mArray.size() ; count++){
                   HashMap<String, String> getMap = mArray.get(count);
                    if (getMap.get("이름").equalsIgnoreCase(msg)){
                        resultMsg =
//                                getMap.get(mKeyName[0]) +
                                getMap.get(mKeyName[1]) + " \n" +
                                getMap.get(mKeyName[2]) ;
                    }
                }
                text.setText(resultMsg);
            }
        });
    }
}
