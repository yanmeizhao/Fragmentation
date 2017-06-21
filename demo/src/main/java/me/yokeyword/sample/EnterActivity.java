package me.yokeyword.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.sample.demo_flow.MainActivity;

/**
 * Created by YoKeyword on 16/6/5.
 */
public class EnterActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;

//    private TextView mTvBtnFlow, mTvBtnWechat, mTvBtnZhihu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
//        initView();
        setSupportActionBar(mToolBar);
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
//        mTvBtnFlow = (TextView) findViewById(R.id.tv_btn_flow);
//        mTvBtnWechat = (TextView) findViewById(R.id.tv_btn_wechat);
//        mTvBtnZhihu = (TextView) findViewById(R.id.tv_btn_zhihu);


//        mTvBtnFlow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        mTvBtnWechat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        mTvBtnZhihu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

    }

    @OnClick(R.id.tv_btn_flow)
    void enterFlow() {
        startActivity(new Intent(EnterActivity.this, MainActivity.class));
    }

    @OnClick(R.id.tv_btn_wechat)
    void enterWeChat() {
        startActivity(new Intent(EnterActivity.this, me.yokeyword.sample.demo_wechat.MainActivity.class));
    }

    @OnClick(R.id.tv_btn_zhihu)
    void enterZhihu() {
        startActivity(new Intent(EnterActivity.this, me.yokeyword.sample.demo_zhihu.MainActivity.class));
    }

    @OnClick(R.id.tv_btn_enter_sign_mode)
    void enterDesignMode() {
        startActivity(new Intent(EnterActivity.this, me.yokeyword.sample.demo_multiple_function.MainActivity.class));
    }
}
