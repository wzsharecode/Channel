package idoool.com.httplib.presenter;

import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;

import idoool.com.baselib.Api;
import idoool.com.baselib.bean.Login;
import idoool.com.httplib.convert.JsonCallback;
import idoool.com.httplib.view.ILogin;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  12:00
 * @description: 创建 ChannelPresenter
 */

public class LoginPresenter extends BasePresenter implements ILogin.Presenter {

    private ILogin.View mView;

    public LoginPresenter(ILogin.View view, Object tag) {
        super(view, tag);
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
        HttpParams params = new HttpParams();
        params.put("phone", name);
        params.put("password", pwd);
        PostRequest postRequest = okGoPost(Api.LOGIN);
        postRequest.params(params).cacheMode(CacheMode.NO_CACHE);
        postRequest.execute(new JsonCallback<Login>(true, mView, "login") {
            @Override
            public void onSuccess(Response<Login> response) {
                Login login = response.body();
                if (null == login) {
                    return;
                }
                // 更新UI
                mView.loginSuccess(login);
            }
        });
    }

}
