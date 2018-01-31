package idoool.com.baselib.bean;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  08:04
 * @description: 创建 Login
 */

public class Login3 {

    /**
     * status : 1
     * msg : post/uploads/space/2017/0104/170828_rPsL_1456141.gif
     * data : {"memPhoto":"","nickName":"13651125236","mobile":"13651125236","realName":"","gender":2,"genderMsg":"","memEmail":""}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * memPhoto :
         * nickName : 13651125236
         * mobile : 13651125236
         * realName :
         * gender : 2
         * genderMsg :
         * memEmail :
         */

        private String memPhoto;
        private String nickName;
        private String mobile;
        private String realName;
        private int gender;
        private String genderMsg;
        private String memEmail;

        public String getMemPhoto() {
            return memPhoto;
        }

        public void setMemPhoto(String memPhoto) {
            this.memPhoto = memPhoto;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getGenderMsg() {
            return genderMsg;
        }

        public void setGenderMsg(String genderMsg) {
            this.genderMsg = genderMsg;
        }

        public String getMemEmail() {
            return memEmail;
        }

        public void setMemEmail(String memEmail) {
            this.memEmail = memEmail;
        }
    }
}
