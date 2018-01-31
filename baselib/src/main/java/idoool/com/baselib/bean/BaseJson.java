package idoool.com.baselib.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import idoool.com.baselib.Api;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  11:14
 * @description: 创建 BaseJson 如果你服务器返回的数据格式固定为这种方式(这里只提供思想,服务器返回的数据格式可能不一致,可根据自家服务器返回的格式作更改)
 * 替换范型即可重用 {@link BaseJson}
 */


public class BaseJson<T> implements Serializable {

    @SerializedName("status")
    public String status;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public T data;

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (status.equals(Api.REQUEST_SUCCESS)) {
            return true;
        } else {
            return false;
        }
    }
}

