package com.my.mycomponent.library.componentimpl.user;

import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.my.mycomponent.library.data.RouterMap;
import com.my.mycomponent.library.interfaces.user.IUser;

/**
 * @author WangJY
 * create at 2018/7/14
 */
public class UserComponentImpl {
    public static boolean isLogin(){
        IUser user = (IUser) ARouter.getInstance().build(RouterMap.USER_IMPL).navigation();
        if (user == null) {
            return false;
        }
        return user.isLogin();
    }

    public static void setLogin(boolean isLogin) {
        IUser user = (IUser) ARouter.getInstance().build(RouterMap.USER_IMPL).navigation();
        if (user == null) {
            return;
        }
        user.setLogin(isLogin);
    }
}
