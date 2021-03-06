package pers.xjh.note.ui.note;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import pers.xjh.note.R;
import pers.xjh.note.ui.base.BaseActivity;
import pers.xjh.note.ui.detail.android.ImageDetailActivity;
import pers.xjh.note.utils.Constant;

/**
 * Created by XJH on 2017/5/22.
 */

public class NoteTextActivity extends BaseActivity {

    private TextView mTvContent;
    //文字资源id
    private int mStringId;
    //文字
    private String mString;
    //图片资源
    private int[] mImageResourceId;

    @Override
    protected int initContentView() {
        return R.layout.activity_note_text;
    }

    @Override
    protected void getIntentData() {
        mStringId = getIntent().getIntExtra(Constant.KEY_STRING, 0);
        mString = getIntent().getStringExtra(Constant.KEY_STRING);
        mImageResourceId = getIntent().getIntArrayExtra(Constant.KEY_IMAGE_URL);
    }

    @Override
    protected void initTitle() {
        super.initTitle();
        if(mImageResourceId != null) {
            mTitleBar.setTitleRight("图片");
            mTitleBar.setRightTitleClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NoteTextActivity.this, ImageDetailActivity.class);
                    intent.putExtra(Constant.KEY_IMAGE_URL, mImageResourceId);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void initView() {
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }

    @Override
    protected void start() {
        if(mStringId != 0) {
            mTvContent.setText(getResources().getString(mStringId));
        } else if(!TextUtils.isEmpty(mString)) {
            mTvContent.setText(mString);
        }
    }
}
