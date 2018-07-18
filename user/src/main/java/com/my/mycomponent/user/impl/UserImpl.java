package com.my.mycomponent.user.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.my.mycomponent.library.data.ConstantString;
import com.my.mycomponent.library.data.RouterMap;
import com.my.mycomponent.library.interfaces.user.IUser;


/**
 * @author WangJY
 * create at 2018/7/14
 */
@Route(path = RouterMap.USER_IMPL)
public class UserImpl implements IUser {
    private static final String FILENAME = "parameter";
    private Context context;

    @Override
    public boolean isLogin() {
        return context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE).getBoolean(ConstantString.KEY_LOGIN_STATE, false);
    }

    @Override
    public void setLogin(boolean isLogin) {
        context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE).edit().putBoolean(ConstantString.KEY_LOGIN_STATE, isLogin).apply();
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
