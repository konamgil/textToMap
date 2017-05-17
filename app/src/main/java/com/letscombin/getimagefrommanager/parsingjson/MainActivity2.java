package com.letscombin.getimagefrommanager.parsingjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity2 extends AppCompatActivity {

    private TextView text;
    private Button btnSumit;
    private EditText etKey;
//    private HashMap name;
//    private LinkedHashMap name;
    private ArrayMap name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        name = new HashMap<String,item>();
//        name = new LinkedHashMap<String,item>();
        name = new ArrayMap<String,item>();

        ArrayList<String> mArrayList = new ArrayList<String>();

        String raw_data = "이름:장동건," +
                          "전화:01012343466," +
                          "주소:서울시 송파구 거여동," +

                          "이름:김원빈," +
                          "전화:01037795678," +
                          "주소:서울시 송파구 오금동," +

                          "이름:권상우," +
                          "전화:01097232116," +
                          "주소:서울시 송파구 방이동,"

                ;

        String[] mdata = raw_data.split(",");
        //컬럼 뽑아내기
        String uName="";
        String uAddr="";
        String uNum="";

        for(int i=0; i<mdata.length; i++){
            mArrayList.add(mdata[i]);
            String[] keyValue = mArrayList.get(i).split(":");
//            if (keyValue[0].equals("이름")) {
//                uName = keyValue[1];
//                name.put(uName,"");
//            }
//            if (keyValue[0].equals("전화")){
//                uAddr = keyValue[1];
//            } else if (keyValue[0].equals("주소")){
//                uNum = keyValue[1];
//            }
            switch (keyValue[0]){
                case "이름":
                    uName = keyValue[1];
                    name.put(uName,"");
                    break;
                case "전화":
                    uNum = keyValue[1];
                    break;
                case "주소":
                    uAddr = keyValue[1];
                    break;
                default:
                    break;
            }
            name.put(uName,new item(uNum,uAddr));
        }

        text = (TextView)findViewById(R.id.text);
        btnSumit = (Button)findViewById(R.id.btnSumit);
        etKey = (EditText)findViewById(R.id.etKey);

        btnSumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = etKey.getText().toString();
                if(key!=null) {
                    try {
                        item info = (item)name.get(key);
                        text.setText(info.getNum().toString() + "\n" + info.getAddr().toString());
                    }catch (NullPointerException e){
                        Toast.makeText(getApplicationContext(),"없는 이름 입니다.",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"입력해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
