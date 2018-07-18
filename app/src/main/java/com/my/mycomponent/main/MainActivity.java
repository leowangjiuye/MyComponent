package com.my.mycomponent.main;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.my.mycomponent.library.componentimpl.user.UserComponentImpl;
import com.my.mycomponent.library.data.ConstantCode;
import com.my.mycomponent.library.data.ConstantString;
import com.my.mycomponent.library.data.RouterMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserComponentImpl.setLogin(false);

                ARouter.getInstance()
                        .build(RouterMap.LOGIN_ACTIVITY)
                        .withString(ConstantString.KEY_LOGIN_NAME, "123456")
                        .withString(ConstantString.KEY_LOGIN_PASSWORD, "123456")
                        .navigation();
            }
        });
        findViewById(R.id.btn_cashier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(RouterMap.CASHIER_ACTIVITY)
                        .navigation(MainActivity.this, ConstantCode.REQUEST_CODE_CASHIER);
            }
        });

        addFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "///  onActivityResult() | requestCode = "+requestCode+" | resultCode = "+resultCode);
        switch (requestCode) {
            case ConstantCode.REQUEST_CODE_CASHIER:
                break;
                default:
                    break;
        }
    }

    private void addFragment() {

        Fragment homeFragment = getHomeFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fl_container, homeFragment)
                .commitAllowingStateLoss();
    }

    private Fragment getHomeFragment() {
        return (Fragment) ARouter.getInstance().build(RouterMap.USER_INFO_FRAGMENT).navigation();
    }

}
