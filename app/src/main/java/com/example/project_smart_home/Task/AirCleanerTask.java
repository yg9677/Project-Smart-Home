package com.example.project_smart_home.Task;

import static com.example.project_smart_home.utils.Constants.PATH_CODE_ACL_MODE;
import static com.example.project_smart_home.utils.Constants.SEND_CMD;
import static com.example.project_smart_home.utils.Constants.SEND_MODEL;

public class AirCleanerTask extends CommunicateTask {

    @Override
    protected String doInBackground(String... strings) {
        super.selectTask(SEND_MODEL);
        super.selectPath(PATH_CODE_ACL_MODE);
        super.selectCmd(SEND_CMD);
        return super.doInBackground(strings);
    }
}

