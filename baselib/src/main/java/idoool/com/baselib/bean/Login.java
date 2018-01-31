package idoool.com.baselib.bean;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  08:04
 * @description: 创建 Login
 */

public class Login {

    /**
     * _id : 5a4d6b5ebe951a21314cbb07
     * createdAt : 2018-01-03T23:46:38.681Z
     * time : 1515023198681
     * phone : 13717846897
     * nickname : 小木
     * userGender : 1
     * userBirthday : 636652800000
     * userIcon : http://hzt.idoool.com/upload/large/ee18bb748852a01e4613586320d00ee7.large.jpeg
     * userType : 2
     * topicList : []
     * activityList : []
     * commentList : []
     * messageList : []
     * noticeList : []
     * level : 1
     * exp : 220
     * integral : 5
     * expLowerLimit : 200
     * expUpperLimit : 1500
     * isPassTest : false
     * tipPosts : []
     * onlineReportTime : 2018-01-19T06:54:10.092Z
     * onlineReportNumber : 4
     * onlineIsGotExp : true
     * propList : [{"propCode":"1001","icon":"http://hzt.idoool.com/upload/web/flowerIcon.png","name":"鲜花","number":6,"_id":"5a4d6b5ebe951a21314cbb08"}]
     * loggedinAt : 1516590115327
     * credit : 0
     * achievements : []
     * pushSettings : {"isPushNoticeOpen":true,"isPushCommentOpen":true,"isPushReplyOpen":true,"isPushTipOpen":true,"isPushUpvote":true,"isPushNewFans":true}
     * isGoodCodeNumber : false
     * gotAchievementsList : []
     * creditLowerLimit : 0
     * creditUpperLimit : 12
     * vipLevel : 0
     * todayExp : 210
     * tipNewPostsList : []
     * tipCommentsList : []
     * isClubVip : false
     * isAnchor : false
     * beFollowedNum : 0
     * followUserNum : 0
     * subscriptionChannelNum : 3
     * popularityValue : 0
     * resume :
     * usersig : eJxNjV1PgzAUhv8LtxrTU1oG3hEcihZlYTNyRQo9QKOyCmVqzP67hGzR2*d5P36crcivZF3vp96W9tugc*0Q53LBWmFvdaNxmCGXTHkVxwoDDpKCC6yuKrI6ZaUxWpXSlu6g-k2M6rVc1MyAEUIoY8G5g19GD1jKxi4PwDmnc*RkDziMet-PghLwgACQP2n1Oy4V8HhAKMD5T7czTtdFlGwitXuOiuRz528fpyJsrPaByFW8vkhvRJzXcN89jIX-phsTJl2Y3b5MQsQ2OfhqkxdBS3kgOvvx1AoUadTcGYZR67lZljjHX6baW1U_
     */

    private String _id;
    private String createdAt;
    private long time;
    private String phone;
    private String nickname;
    private int userGender;
    private long userBirthday;
    private String userIcon;
    private int userType;
    private int level;
    private int exp;
    private int integral;
    private int expLowerLimit;
    private int expUpperLimit;
    private boolean isPassTest;
    private String onlineReportTime;
    private int onlineReportNumber;
    private boolean onlineIsGotExp;
    private long loggedinAt;
    private int credit;
    private PushSettingsBean pushSettings;
    private boolean isGoodCodeNumber;
    private int creditLowerLimit;
    private int creditUpperLimit;
    private int vipLevel;
    private int todayExp;
    private boolean isClubVip;
    private boolean isAnchor;
    private int beFollowedNum;
    private int followUserNum;
    private int subscriptionChannelNum;
    private int popularityValue;
    private String resume;
    private String usersig;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public long getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(long userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getExpLowerLimit() {
        return expLowerLimit;
    }

    public void setExpLowerLimit(int expLowerLimit) {
        this.expLowerLimit = expLowerLimit;
    }

    public int getExpUpperLimit() {
        return expUpperLimit;
    }

    public void setExpUpperLimit(int expUpperLimit) {
        this.expUpperLimit = expUpperLimit;
    }

    public boolean isIsPassTest() {
        return isPassTest;
    }

    public void setIsPassTest(boolean isPassTest) {
        this.isPassTest = isPassTest;
    }

    public String getOnlineReportTime() {
        return onlineReportTime;
    }

    public void setOnlineReportTime(String onlineReportTime) {
        this.onlineReportTime = onlineReportTime;
    }

    public int getOnlineReportNumber() {
        return onlineReportNumber;
    }

    public void setOnlineReportNumber(int onlineReportNumber) {
        this.onlineReportNumber = onlineReportNumber;
    }

    public boolean isOnlineIsGotExp() {
        return onlineIsGotExp;
    }

    public void setOnlineIsGotExp(boolean onlineIsGotExp) {
        this.onlineIsGotExp = onlineIsGotExp;
    }

    public long getLoggedinAt() {
        return loggedinAt;
    }

    public void setLoggedinAt(long loggedinAt) {
        this.loggedinAt = loggedinAt;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public PushSettingsBean getPushSettings() {
        return pushSettings;
    }

    public void setPushSettings(PushSettingsBean pushSettings) {
        this.pushSettings = pushSettings;
    }

    public boolean isIsGoodCodeNumber() {
        return isGoodCodeNumber;
    }

    public void setIsGoodCodeNumber(boolean isGoodCodeNumber) {
        this.isGoodCodeNumber = isGoodCodeNumber;
    }

    public int getCreditLowerLimit() {
        return creditLowerLimit;
    }

    public void setCreditLowerLimit(int creditLowerLimit) {
        this.creditLowerLimit = creditLowerLimit;
    }

    public int getCreditUpperLimit() {
        return creditUpperLimit;
    }

    public void setCreditUpperLimit(int creditUpperLimit) {
        this.creditUpperLimit = creditUpperLimit;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public int getTodayExp() {
        return todayExp;
    }

    public void setTodayExp(int todayExp) {
        this.todayExp = todayExp;
    }

    public boolean isIsClubVip() {
        return isClubVip;
    }

    public void setIsClubVip(boolean isClubVip) {
        this.isClubVip = isClubVip;
    }

    public boolean isIsAnchor() {
        return isAnchor;
    }

    public void setIsAnchor(boolean isAnchor) {
        this.isAnchor = isAnchor;
    }

    public int getBeFollowedNum() {
        return beFollowedNum;
    }

    public void setBeFollowedNum(int beFollowedNum) {
        this.beFollowedNum = beFollowedNum;
    }

    public int getFollowUserNum() {
        return followUserNum;
    }

    public void setFollowUserNum(int followUserNum) {
        this.followUserNum = followUserNum;
    }

    public int getSubscriptionChannelNum() {
        return subscriptionChannelNum;
    }

    public void setSubscriptionChannelNum(int subscriptionChannelNum) {
        this.subscriptionChannelNum = subscriptionChannelNum;
    }

    public int getPopularityValue() {
        return popularityValue;
    }

    public void setPopularityValue(int popularityValue) {
        this.popularityValue = popularityValue;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getUsersig() {
        return usersig;
    }

    public void setUsersig(String usersig) {
        this.usersig = usersig;
    }

    public static class PushSettingsBean {
        /**
         * isPushNoticeOpen : true
         * isPushCommentOpen : true
         * isPushReplyOpen : true
         * isPushTipOpen : true
         * isPushUpvote : true
         * isPushNewFans : true
         */

        private boolean isPushNoticeOpen;
        private boolean isPushCommentOpen;
        private boolean isPushReplyOpen;
        private boolean isPushTipOpen;
        private boolean isPushUpvote;
        private boolean isPushNewFans;

        public boolean isIsPushNoticeOpen() {
            return isPushNoticeOpen;
        }

        public void setIsPushNoticeOpen(boolean isPushNoticeOpen) {
            this.isPushNoticeOpen = isPushNoticeOpen;
        }

        public boolean isIsPushCommentOpen() {
            return isPushCommentOpen;
        }

        public void setIsPushCommentOpen(boolean isPushCommentOpen) {
            this.isPushCommentOpen = isPushCommentOpen;
        }

        public boolean isIsPushReplyOpen() {
            return isPushReplyOpen;
        }

        public void setIsPushReplyOpen(boolean isPushReplyOpen) {
            this.isPushReplyOpen = isPushReplyOpen;
        }

        public boolean isIsPushTipOpen() {
            return isPushTipOpen;
        }

        public void setIsPushTipOpen(boolean isPushTipOpen) {
            this.isPushTipOpen = isPushTipOpen;
        }

        public boolean isIsPushUpvote() {
            return isPushUpvote;
        }

        public void setIsPushUpvote(boolean isPushUpvote) {
            this.isPushUpvote = isPushUpvote;
        }

        public boolean isIsPushNewFans() {
            return isPushNewFans;
        }

        public void setIsPushNewFans(boolean isPushNewFans) {
            this.isPushNewFans = isPushNewFans;
        }
    }

    public static class PropListBean {
        /**
         * propCode : 1001
         * icon : http://hzt.idoool.com/upload/web/flowerIcon.png
         * name : 鲜花
         * number : 6
         * _id : 5a4d6b5ebe951a21314cbb08
         */

        private String propCode;
        private String icon;
        private String name;
        private int number;
        private String _id;

        public String getPropCode() {
            return propCode;
        }

        public void setPropCode(String propCode) {
            this.propCode = propCode;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }
    }
}
