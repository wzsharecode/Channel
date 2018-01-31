package idoool.com.httplib.view;

import idoool.com.baselib.bean.Login;
import idoool.com.httplib.base.IBasePresenter;
import idoool.com.httplib.base.IBaseView;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  10:04
 * @description: 创建 ILogin
 */

public interface ILogin {
    interface View extends IBaseView<Presenter> {

        /**
         * 登录成功
         * @param login
         */
        void loginSuccess(Login login);
    }

    interface Presenter extends IBasePresenter {

        /**
         * 登录
         * @param name
         * @param pwd
         */
        void login(String name, String pwd);

    }
}
