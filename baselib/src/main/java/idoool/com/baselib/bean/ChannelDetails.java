package idoool.com.baselib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  15:12
 * @description: 创建 ChannelDetails
 */

public class ChannelDetails {

    private ChannelBean channel;

    public ChannelBean getChannel() {
        return channel;
    }

    public void setChannel(ChannelBean channel) {
        this.channel = channel;
    }

    public static class ChannelBean {
        /**
         * _id : 5a57571f16fb146b5ca51880
         * category : 5a5756e27bab986b4d232c3d
         * icon : http://hzt.idoool.com/upload/large/2416f972f8d25daf87de749db9130a94.large.png
         * title : #海浪日记
         * intro : 记录每天你与桃子的点点滴滴，一天一篇对桃的小情书
         * owner : {"_id":"56fa73cd46bb32396f33efba","level":2,"nickname":"吃桃群众小代表","phone":"11000000026","userIcon":"http://hzt.idoool.com/upload/large/773d042df44a28e72819759f16628914.large.jpeg","creditUpperLimit":12}
         * channelType : 1
         * recommendResUrlList : ["http://hzt.idoool.com/upload/medium/8be15afc77a347a2fb21e0f4b0d28adf.medium.jpeg","http://hzt.idoool.com/upload/medium/df4df09aec41fff1fec5163a677c15ac.medium.jpeg","http://hzt.idoool.com/upload/medium/60e638a10c9152b6a56c0de6f0118f01.medium.jpeg","http://hzt.idoool.com/upload/medium/1f6a748f04edf511b4f735f76474f23a.medium.jpeg","http://hzt.idoool.com/upload/medium/9fd34a97d2a3e70d27c55b01b332c0d7.medium.jpeg","http://hzt.idoool.com/upload/medium/d0ea380b0352f0250a76bcabfe763576.medium.jpeg","http://hzt.idoool.com/upload/medium/517d682223d2616c125f02b7f0921963.medium.jpeg","http://hzt.idoool.com/upload/medium/d25cc40ddaf821f6b02e80a08f7c1bd0.medium.jpeg","http://hzt.idoool.com/upload/medium/44bc9a8090b293ed6580370ac1866ead.medium.jpeg","http://hzt.idoool.com/upload/medium/438e1fde5892ad61becf285dc64ebb01.medium.jpeg"]
         * dailyRecordShare : {"value":0,"date":"2018-01-29T16:09:24.171Z"}
         * heat : 136.5
         * tags : []
         * isActiving : false
         * postCount : 0
         * subscriptionNum : 165
         * createdAt : 2018-01-11T12:22:55.728Z
         * __v : 0
         * coverImageUrl : http://hzt.idoool.com/upload/large/835942c3ca19e40bfa5d0195c91cbfb9.large.png
         * shareInfo : []
         * isSubscribe : true
         */

        private String _id;
        private String category;
        private String icon;
        private String title;
        private String intro;
        private OwnerBean owner;
        private int channelType;
        private DailyRecordShareBean dailyRecordShare;
        private double heat;
        private boolean isActiving;
        private int postCount;
        private int subscriptionNum;
        private String createdAt;
        private int __v;
        @SerializedName("coverImageUrl")
        private String coverImageUrl;
        private boolean isSubscribe;
        private List<String> recommendResUrlList;
        private List<?> tags;
        private List<?> shareInfo;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public int getChannelType() {
            return channelType;
        }

        public void setChannelType(int channelType) {
            this.channelType = channelType;
        }

        public DailyRecordShareBean getDailyRecordShare() {
            return dailyRecordShare;
        }

        public void setDailyRecordShare(DailyRecordShareBean dailyRecordShare) {
            this.dailyRecordShare = dailyRecordShare;
        }

        public double getHeat() {
            return heat;
        }

        public void setHeat(double heat) {
            this.heat = heat;
        }

        public boolean isIsActiving() {
            return isActiving;
        }

        public void setIsActiving(boolean isActiving) {
            this.isActiving = isActiving;
        }

        public int getPostCount() {
            return postCount;
        }

        public void setPostCount(int postCount) {
            this.postCount = postCount;
        }

        public int getSubscriptionNum() {
            return subscriptionNum;
        }

        public void setSubscriptionNum(int subscriptionNum) {
            this.subscriptionNum = subscriptionNum;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getCoverImageUrl() {
            return coverImageUrl;
        }

        public void setCoverImageUrl(String coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
        }

        public boolean isIsSubscribe() {
            return isSubscribe;
        }

        public void setIsSubscribe(boolean isSubscribe) {
            this.isSubscribe = isSubscribe;
        }

        public List<String> getRecommendResUrlList() {
            return recommendResUrlList;
        }

        public void setRecommendResUrlList(List<String> recommendResUrlList) {
            this.recommendResUrlList = recommendResUrlList;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<?> getShareInfo() {
            return shareInfo;
        }

        public void setShareInfo(List<?> shareInfo) {
            this.shareInfo = shareInfo;
        }

        public static class OwnerBean {
            /**
             * _id : 56fa73cd46bb32396f33efba
             * level : 2
             * nickname : 吃桃群众小代表
             * phone : 11000000026
             * userIcon : http://hzt.idoool.com/upload/large/773d042df44a28e72819759f16628914.large.jpeg
             * creditUpperLimit : 12
             */

            private String _id;
            private int level;
            private String nickname;
            private String phone;
            private String userIcon;
            private int creditUpperLimit;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }

            public int getCreditUpperLimit() {
                return creditUpperLimit;
            }

            public void setCreditUpperLimit(int creditUpperLimit) {
                this.creditUpperLimit = creditUpperLimit;
            }
        }

        public static class DailyRecordShareBean {
            /**
             * value : 0
             * date : 2018-01-29T16:09:24.171Z
             */

            private int value;
            private String date;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
