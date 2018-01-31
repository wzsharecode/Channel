package idoool.com.httplib.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import idoool.com.baselib.BaseApplication;
import idoool.com.baselib.utils.BarTextColorUtils;
import idoool.com.httplib.R;

/**
 * @author: wangdeshun
 * @date: 2018/1/21  22:46
 * @description: 创建 BaseFragment
 */

public abstract class BaseActivity<T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView<T> {

    protected T mPresenter;
    /**
     * 自定义dialog
     */
    public Dialog mProgressDialog;

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int layoutId();

    /**
     * 初始化视图控件
     */
    protected abstract void initView();

    /**
     * 页面重建时，重新设置Presenter
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (null == mPresenter) {
            mPresenter = setPresenter(mPresenter);
        }
    }

    private void initDialog() {
        mProgressDialog = new Dialog(this, R.style.progress_dialog);
        mProgressDialog.setContentView(R.layout.dialog);
        mProgressDialog.setCancelable(true);
        mProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = mProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText(getString(R.string.loading));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //状态栏背景透明,状态栏字体变为黑色
        BarTextColorUtils.transparencyBar(this);
        BarTextColorUtils.StatusBarLightMode(this, true);
        setContentView(layoutId());
        ButterKnife.inject(this);
        initDialog();
        mPresenter = setPresenter(mPresenter);
        initView();
    }

    @Override
    protected void onDestroy() {
        mPresenter = null;
        super.onDestroy();
    }

    /**
     * 无网络链接
     */
    @Override
    public void onNoConnect() {

        Toast.makeText(BaseApplication.getAppContext(), getString(R.string.no_network), Toast.LENGTH_SHORT).show();
    }

    /**
     * 开始请求
     *
     * @param isShow 是否显示加载对话框
     */
    @Override
    public void onRequestStart(boolean isShow) {
        //网络请求前显示对话框
        if (!isShow) {
            return;
        }
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 上传进度
     *
     * @param progress 进度
     */
    @Override
    public void uploadProgress(Object progress) {

    }

    /**
     * 下载进度
     *
     * @param progress 进度
     */
    @Override
    public void downloadProgress(Object progress) {

    }

    /**
     * 请求失败 status 0
     *
     * @param requestCode  请求区别码区分那个请求
     * @param errorMessage 失败原因
     */
    @Override
    public void onRequestFailed(Object requestCode, String errorMessage) {
        Toast.makeText(BaseApplication.getAppContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * 请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程
     *
     * @param requestCode 请求区别码区分那个请求
     * @param response    无响应原因
     */
    @Override
    public void onError(Object requestCode, Object response) {

    }

    /**
     * 请求结束
     */
    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        } else {
            mProgressDialog = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        onFinish();
    }
}
