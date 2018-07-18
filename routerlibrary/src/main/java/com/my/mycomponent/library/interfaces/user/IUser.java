package com.my.mycomponent.library.interfaces.user;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author WangJY
 * create at 2018/7/14
 */
public interface IUser extends IProvider {
    /**
     * 获取登录状态
     * @return 是否登录
     */
    boolean isLogin();

    /**
     * 设置登录状态
     * @param isLogin 是否登录
     */
    void setLogin(boolean isLogin);
}
