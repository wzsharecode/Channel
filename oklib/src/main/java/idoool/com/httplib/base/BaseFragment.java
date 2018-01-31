package idoool.com.httplib.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import butterknife.ButterKnife;
import idoool.com.httplib.R;
import idoool.com.baselib.BaseApplication;

/**
 * @author: wangdeshun
 * @date: 2018/1/21  22:46
 * @description: 创建 BaseFragment
 */

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView<T> {

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
    protected abstract int attachLayoutId();

    /**
     * 初始化视图控件
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据
     *
     * @throws NullPointerException
     */
    protected abstract void initData() throws NullPointerException;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDialog();
        mPresenter = setPresenter(mPresenter);
        initData();
    }

    private void initDialog() {
        mProgressDialog = new Dialog(getActivity(), R.style.progress_dialog);
        mProgressDialog.setContentView(R.layout.dialog);
        mProgressDialog.setCancelable(true);
        mProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = mProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText(getString(R.string.loading));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(attachLayoutId(), container, false);
        initView(view);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter = null;
        //Fragment销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this);
        ButterKnife.reset(this);
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
    public void uploadProgress(Progress progress) {

    }

    /**
     * 下载进度
     *
     * @param progress 进度
     */
    @Override
    public void downloadProgress(Progress progress) {

    }

    /**
     * 请求失败
     *
     * @param requestCode  请求区别码区分那个请求
     * @param errorMessage 失败原因
     */
    @Override
    public void onRequestFailed(Object requestCode, String errorMessage) {
        Toast.makeText(BaseApplication.getAppContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * 请求无响应
     *
     * @param requestCode  请求区别码区分那个请求
     * @param response     无响应原因
     */
    @Override
    public void onError(Object requestCode, Response response) {

    }

    /**
     * 请求结束
     */
    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }else {
            mProgressDialog = null;
        }
    }

}
