package com.pikachu.record.activity.countdown;

import android.content.Context;
import com.pikachu.record.R;
import com.pikachu.record.activity.task.TaskAddDialogAdapter;
import com.pikachu.record.monitor.DataSynEvent;
import com.pikachu.record.sql.table.CountDown;
import com.pikachu.record.sql.table.Task;
import com.pikachu.record.tool.ToolOther;
import com.pikachu.record.tool.ToolPublic;
import com.pikachu.record.tool.ToolTime;
import org.greenrobot.eventbus.EventBus;

/**
 * @author calvinche
 *         date 2022/4/14
 */
public class CountDownDialogAdapter extends TaskAddDialogAdapter{

    public CountDownDialogAdapter(Context context) {
        super(context);
        addStr = "添加倒计时";
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.countdown_add_data_ui;
    }

    @Override
    protected void addAndUpData(boolean isUpData, Task task) {
        String title = titleEditView.getText().toString();
        String msg = msgEditView.getText().toString();
        String stopTime = stopTimeTV.getText().toString();

        if (title.equals(""))
            title = initStr;
        if (msg.equals(""))
            msg = initStr;
        if (stopTime.equals(""))
            stopTime = ToolTime.getItem(ToolPublic.TIME_DATA);


        if (isUpData) {
            task.setTitle(title);
            task.setText(msg);
            task.setStopTime(stopTime);
//            initialSql.updateCountDown(task);
        } else {
            initialSql.setOneCountDownData(new CountDown(null, "", title, msg, stopTime, false, ToolTime.getItem(ToolPublic.TIME_DATA)));
            addAlarm(stopTime, task);
        }


        ToolOther.tw(activity, finishStr, R.drawable.toast_true_icon);
        cancelDialog();
        //发布事件
        EventBus.getDefault().post(new DataSynEvent());
        endAdd.endAdd();
    }
}
