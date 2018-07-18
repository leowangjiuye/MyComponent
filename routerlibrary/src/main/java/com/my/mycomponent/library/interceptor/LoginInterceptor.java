package com.my.mycomponent.library.interceptor;


import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.my.mycomponent.library.componentimpl.user.UserComponentImpl;
import com.my.mycomponent.library.data.ConstantCode;
import com.my.mycomponent.library.data.RouterMap;

/**
 * @author WangJY
 * create at 2018/7/14
 */

@Interceptor(priority = 1, name = "登录重定向")
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getExtra() == ConstantCode.INTERCEPTOR_CASHIER) {
            if (!UserComponentImpl.isLogin()) {
                ARouter.getInstance().build(RouterMap.LOGIN_ACTIVITY).navigation();
            } else {
//                postcard.withString()
                callback.onContinue(postcard);
            }
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
