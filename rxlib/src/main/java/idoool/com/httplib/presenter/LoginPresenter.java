package idoool.com.httplib.presenter;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import idoool.com.baselib.bean.BaseJson;
import idoool.com.baselib.bean.Login;
import idoool.com.httplib.base.BaseObserver;
import idoool.com.httplib.net.RetrofitFactory;
import idoool.com.httplib.view.ILogin;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  12:00
 * @description: 创建 ChannelPresenter
 */

public class LoginPresenter extends BasePresenter implements ILogin.Presenter {

    private ILogin.View mView;

    public LoginPresenter(ILogin.View view, LifecycleProvider<ActivityEvent> provider) {
        super(view, provider);
        this.mView = view;
    }

    /**
     * 登录
     *
     * @param name 用户名
     * @param pwd  密码
     */
    @Override
    public void login(final String name, final String pwd) {
        RetrofitFactory.getInstance().login(name, pwd).compose(switchSchedulers(mView)).subscribe(new BaseObserver<Login>(true,mView,"login") {
                    @Override
                    protected void onHandleSuccess(Login user) {
                        mView.loginSuccess(user);
                    }
                });
    }
}
