package com.my.mycomponent.cashier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.my.mycomponent.library.componentimpl.user.UserComponentImpl;
import com.my.mycomponent.library.data.ConstantCode;
import com.my.mycomponent.library.data.RouterMap;
import com.my.mycomponent.library.interfaces.user.IUser;

@Route(path = RouterMap.CASHIER_ACTIVITY, extras = ConstantCode.INTERCEPTOR_CASHIER)
public class CashierActivity extends AppCompatActivity {
    @Autowired(name = RouterMap.USER_IMPL)
    IUser iuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.fix_cashier_activity_main);
//        boolean isLogin = UserComponentImpl.isLogin();
        boolean isLogin = iuser.isLogin();
        ((TextView)findViewById(R.id.txt_msg)).setText(isLogin? "has logined": "please login");
    }
}
