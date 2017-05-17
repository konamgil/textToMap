package com.letscombin.getimagefrommanager.parsingjson;

/**
 * Created by konamgil on 2017-05-17.
 */

public class item {
    String addr;
    String num;

    public item(String addr, String num){
        this.addr = addr;
        this.num = num;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
