package pers.xjh.note.ui.detail.android.activityLifeCycle;

import android.os.Bundle;
import android.view.View;

import pers.xjh.note.R;
import pers.xjh.note.runtime.RtEnv;
import pers.xjh.note.widget.dialog.AlertDialog;

/**
 * Created by XJH on 2017/4/28.
 */

public class AActivity extends LifeCycleActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_a);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                RtEnv.startActivity(BActivity.class);
                break;
            case R.id.btn_2:
                RtEnv.startActivity(CActivity.class);
                break;
            case R.id.btn_3:
                RtEnv.startActivity(DActivity.class);
                break;
            case R.id.btn_4:
                RtEnv.startActivity(EActivity.class);
                break;
            case R.id.btn_5:
                RtEnv.startActivity(FActivity.class);
                break;
            case R.id.btn_6:
                RtEnv.startActivity(TransparentActivity.class);
                break;
            case R.id.btn_7:
                RtEnv.startActivity(NotFullActivity.class);
                break;
            case R.id.btn_8:
                new AlertDialog.Builder(this).setInAnimation(R.anim.soft_in).build().show();
                break;
        }
    }
}