package idoool.com.channel.moudel.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.InjectView;
import idoool.com.channel.R;
import idoool.com.channel.moudel.channel.list.ChannelListActivity;
import idoool.com.channel.utils.ToastUtils;
import idoool.com.httplib.base.BaseActivity;
import idoool.com.baselib.bean.Login;
import idoool.com.httplib.presenter.LoginPresenter;
import idoool.com.httplib.view.ILogin;

/**
 * @author: wangdeshun
 * @date: 2018/1/18  10:14
 * @description: 创建 LoginActivity
 */

public class LoginActivity extends BaseActivity<ILogin.Presenter> implements ILogin.View {
    @InjectView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login("13717846897", "e10adc3949ba59abbe56e057f20f883e");
            }
        });
    }

    /**
     * 重写 无网络更新UI
     */
    @Override
    public void onNoConnect() {
        super.onNoConnect();
//        toActivity();
    }

    /**
     * 登录成功 进入首页
     */
    private void toActivity() {
        startActivity(new Intent(this, ChannelListActivity.class));
        finish();
    }

    /**
     * 登录成功
     */
    @Override
    public void loginSuccess(Login login) {
        ToastUtils.showShort(login.getNickname());
        toActivity();
    }


    @Override
    public ILogin.Presenter setPresenter(ILogin.Presenter presenter) {

        if (null == presenter) {
            this.mPresenter = new LoginPresenter(this, this);
        }
        return mPresenter;
    }

}
