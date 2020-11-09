package com.example.project_smart_home.object;

import com.example.project_smart_home.MainActivity;
import com.example.project_smart_home.Task.AirCleanerTask;

import static com.example.project_smart_home.utils.Constants.APP_TEST;

public class AirCleaner extends Device {

    public AirCleaner(String name, String deviceKind, String model, int state, String room) {
        super(name, deviceKind, model, state, room);
    }

    public AirCleaner() {
    }

    @Override
    public void onoffDevice() {
        switch (state){                 // 디바이스 상태
            case 1:                     // 켜져있을 경우
                setState(3);            // 인공지능모드로 변경
                if(!APP_TEST) commandDevice(MainActivity.myCode, getModel(),"auto");
                break;
            case 2:                     // 꺼져있을 경우
                setState(1);            // 켜짐으로 변경
                if(!APP_TEST) commandDevice(MainActivity.myCode, getModel(),"on");
                break;
            case 3:                     // 인공지능 모드일 경우
                setState(2);            // 꺼짐으로 변경
                if(!APP_TEST) commandDevice(MainActivity.myCode, getModel(),"off");
                break;
        }
    }

    public void commandDevice(String... cmd) {
        super.communicateTask = new AirCleanerTask();
        super.communicateTask.execute(cmd);
    }

    public void setByState(){
        super.setByState();
        switch (state){
            case 3:
                mode = "인공지능모드";
                onoff = true;
                break;
        }
    }

    @Override
    public void setState(int state) {
        super.setState(state);
        setByState();
    }
}
