package idoool.com.baselib.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author: wangdeshun
 * @date: 2018/1/22  10:57
 * @description: 创建 ChannelList 频道列表
 */

public class ChannelList {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * _id : 5a38f0446d2c3948b5f63f47
         * index : 2
         * name : 频道分类
         * icon : http://192.168.2.29:8091/upload/large/d3029812a77d8b5896d4a90c6c80364b.png
         * channelList : [{"_id":"5a0bdf2502cd3668044aa313","icon":"http://192.168.2.29:8091/upload/small/4d8ed7ca77f5b11aa07459f01232b65d.small.jpeg","title":"#测试频道推荐","channelType":1,"topNewPosts":[],"heat":61.5,"intro":"1","isActiving":false,"tags":[],"owner":{"_id":"56f0b5af825275606fe391e1","userIcon":"http://hzt.idoool.com/upload/small/e1ed1dbdb5f5e5993ffc6e112437bbc1.small.png","nickname":"黄子韬","phone":"12345678999","level":2,"wearAchievement":{"isCompleted":true,"type":1,"__v":0,"reward":"奖励称号1枚","completeCondition":"日签到排名第一","name":"The First","icon":"http://hzt.idoool.com/upload/web/firstsignin_wear.png","_id":"57d91d153a58d43e24931ff3"},"creditLowerLimit":12,"creditUpperLimit":100,"vipLevel":1,"resume":""},"postCount":0,"coverImageUrl":"http://192.168.2.29:8091/upload/large/4d8ed7ca77f5b11aa07459f01232b65d.jpeg","subscriptionNum":41,"createdAt":"2017-11-15T06:31:01.095Z","__v":0,"category":"5a38f0446d2c3948b5f63f47","dailyRecordShare":{"date":"2018-01-24T07:51:18.060Z","value":0},"recommendResUrlList":["http://192.168.2.29:8091/upload/medium/7cf4ab03dbea2fc2d66fc8f925852914.medium.jpeg","http://192.168.2.29:8091/upload/large/b5df192ad2bb87b674b882cc0742cc2e.gif","http://192.168.2.29:8091/upload/medium/94dbc04a9c5207c50d7bbf4115b4f998.medium.jpeg","http://192.168.2.29:8091/upload/medium/9d2527e2094525d559a737eff47b250c.medium.jpeg","http://192.168.2.29:8091/upload/medium/52f2b2a053257c7422744ba73240f221.medium.jpeg"],"shareInfo":[],"isSubscribe":true},{"_id":"5a0bdfab02cd3668044aa317","icon":"http://192.168.2.29:8091/upload/small/4d8ed7ca77f5b11aa07459f01232b65d.small.jpeg","title":"#测试频道推荐名称超长的情况，测试频道推荐名称超长的情况，测试频道推荐名称超长的情况111111111111111111111111111111","channelType":1,"topNewPosts":[],"heat":37,"intro":"奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风奥斯市反馈藕断丝连家乐福数据雷锋精神龙卷风","isActiving":false,"tags":[],"postCount":0,"owner":{"_id":"58d4f9d63f67a771d299e122","phone":"12000000001","creditLowerLimit":5000,"creditUpperLimit":10000,"vipLevel":5,"isGoodCodeNumber":false,"level":3,"nickname":"yuuuuuututuuutuuutuuuuiidijdjd","userIcon":"http://192.168.2.29:8091/upload/large/92a277198e223e993f7a6051f616e011.jpeg","resume":"最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称最长的昵称","wearAchievement":{"_id":"57c400024e72365d729d6904","icon":"http://192.168.2.29:8091/upload/web/starvisit_wear.png","name":"拯救银河系","completeCondition":"被黄子韬翻牌","reward":"奖励称号1枚","__v":0,"type":1,"isCompleted":true,"createdAt":"2017-12-08T07:33:26.562Z"}},"subscriptionNum":39,"coverImageUrl":"http://192.168.2.29:8091/upload/large/522a05b3db086ecb8b345739ab616abd.jpeg","createdAt":"2017-11-15T06:33:15.183Z","subtitleColor":"#FEBF18","titleColor":"#A2D742","__v":0,"category":"5a38f0446d2c3948b5f63f47","dailyRecordShare":{"date":"2018-01-18T03:49:12.825Z","value":0},"recommendResUrlList":[],"shareInfo":[],"isSubscribe":true},{"_id":"5a0bdfce02cd3668044aa318","icon":"http://192.168.2.29:8091/upload/small/4d8ed7ca77f5b11aa07459f01232b650.small.jpeg","title":"#测试频道在活动时频道名称超长的情况，测试频道在活动时频道名称超长的情况","channelType":2,"featureType":3,"topNewPosts":[],"heat":5.5,"intro":"1","isActiving":false,"tags":[],"postCount":0,"owner":{"_id":"56f0b5af825275606fe391e1","userIcon":"http://hzt.idoool.com/upload/small/e1ed1dbdb5f5e5993ffc6e112437bbc1.small.png","nickname":"黄子韬","phone":"12345678999","level":2,"wearAchievement":{"isCompleted":true,"type":1,"__v":0,"reward":"奖励称号1枚","completeCondition":"日签到排名第一","name":"The First","icon":"http://hzt.idoool.com/upload/web/firstsignin_wear.png","_id":"57d91d153a58d43e24931ff3"},"creditLowerLimit":12,"creditUpperLimit":100,"vipLevel":1,"resume":""},"subscriptionNum":10,"coverImageUrl":"http://192.168.2.29:8091/upload/small/4d8ed7ca77f5b11aa07459f01232b651.small.jpeg","createdAt":"2017-11-15T06:33:50.395Z","__v":0,"category":"5a38f0136d2c3948b5f63f45","dailyRecordShare":{"date":"2018-01-18T11:56:12.346Z","value":0},"recommendResUrlList":["http://192.168.2.29:8091/upload/large/ff0286d896b49740c715d1cc2e92b5e2.gif"],"shareInfo":[],"isSubscribe":false}]
         * createdAt : 2017-12-19T10:56:04.165Z
         * __v : 0
         */

        @SerializedName("_id")
        private String _id;
        private int index;
        private String name;
        private String icon;
        private String createdAt;
        @SerializedName("__v")
        private int __v;
        private List<ChannelListBean> channelList;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
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

        public List<ChannelListBean> getChannelList() {
            return channelList;
        }

        public void setChannelList(List<ChannelListBean> channelList) {
            this.channelList = channelList;
        }

        public static class ChannelListBean {
            /**
             * _id : 5a0bdf2502cd3668044aa313
             * icon : http://192.168.2.29:8091/upload/small/4d8ed7ca77f5b11aa07459f01232b65d.small.jpeg
             * title : #测试频道推荐
             * channelType : 1
             * topNewPosts : []
             * heat : 61.5
             * intro : 1
             * isActiving : false
             * tags : []
             * owner : {"_id":"56f0b5af825275606fe391e1","userIcon":"http://hzt.idoool.com/upload/small/e1ed1dbdb5f5e5993ffc6e112437bbc1.small.png","nickname":"黄子韬","phone":"12345678999","level":2,"wearAchievement":{"isCompleted":true,"type":1,"__v":0,"reward":"奖励称号1枚","completeCondition":"日签到排名第一","name":"The First","icon":"http://hzt.idoool.com/upload/web/firstsignin_wear.png","_id":"57d91d153a58d43e24931ff3"},"creditLowerLimit":12,"creditUpperLimit":100,"vipLevel":1,"resume":""}
             * postCount : 0
             * coverImageUrl : http://192.168.2.29:8091/upload/large/4d8ed7ca77f5b11aa07459f01232b65d.jpeg
             * subscriptionNum : 41
             * createdAt : 2017-11-15T06:31:01.095Z
             * __v : 0
             * category : 5a38f0446d2c3948b5f63f47
             * dailyRecordShare : {"date":"2018-01-24T07:51:18.060Z","value":0}
             * recommendResUrlList : ["http://192.168.2.29:8091/upload/medium/7cf4ab03dbea2fc2d66fc8f925852914.medium.jpeg","http://192.168.2.29:8091/upload/large/b5df192ad2bb87b674b882cc0742cc2e.gif","http://192.168.2.29:8091/upload/medium/94dbc04a9c5207c50d7bbf4115b4f998.medium.jpeg","http://192.168.2.29:8091/upload/medium/9d2527e2094525d559a737eff47b250c.medium.jpeg","http://192.168.2.29:8091/upload/medium/52f2b2a053257c7422744ba73240f221.medium.jpeg"]
             * shareInfo : []
             * isSubscribe : true
             * subtitleColor : #FEBF18
             * titleColor : #A2D742
             * featureType : 3
             */

            private String _id;
            private String icon;
            private String title;
            private int channelType;
            private double heat;
            private String intro;
            private boolean isActiving;
            private OwnerBean owner;
            private int postCount;
            private String coverImageUrl;
            private int subscriptionNum;
            private String createdAt;
            @SerializedName("__v")
            private int __v;
            private String category;
            private DailyRecordShareBean dailyRecordShare;
            private boolean isSubscribe;
            private String subtitleColor;
            private String titleColor;
            private int featureType;
            private List<String> recommendResUrlList;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
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

            public int getChannelType() {
                return channelType;
            }

            public void setChannelType(int channelType) {
                this.channelType = channelType;
            }

            public double getHeat() {
                return heat;
            }

            public void setHeat(double heat) {
                this.heat = heat;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public boolean isIsActiving() {
                return isActiving;
            }

            public void setIsActiving(boolean isActiving) {
                this.isActiving = isActiving;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public int getPostCount() {
                return postCount;
            }

            public void setPostCount(int postCount) {
                this.postCount = postCount;
            }

            public String getCoverImageUrl() {
                return coverImageUrl;
            }

            public void setCoverImageUrl(String coverImageUrl) {
                this.coverImageUrl = coverImageUrl;
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

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public DailyRecordShareBean getDailyRecordShare() {
                return dailyRecordShare;
            }

            public void setDailyRecordShare(DailyRecordShareBean dailyRecordShare) {
                this.dailyRecordShare = dailyRecordShare;
            }

            public boolean isIsSubscribe() {
                return isSubscribe;
            }

            public void setIsSubscribe(boolean isSubscribe) {
                this.isSubscribe = isSubscribe;
            }

            public String getSubtitleColor() {
                return subtitleColor;
            }

            public void setSubtitleColor(String subtitleColor) {
                this.subtitleColor = subtitleColor;
            }

            public String getTitleColor() {
                return titleColor;
            }

            public void setTitleColor(String titleColor) {
                this.titleColor = titleColor;
            }

            public int getFeatureType() {
                return featureType;
            }

            public void setFeatureType(int featureType) {
                this.featureType = featureType;
            }

            public List<String> getRecommendResUrlList() {
                return recommendResUrlList;
            }

            public void setRecommendResUrlList(List<String> recommendResUrlList) {
                this.recommendResUrlList = recommendResUrlList;
            }

            public static class OwnerBean {
                /**
                 * _id : 56f0b5af825275606fe391e1
                 * userIcon : http://hzt.idoool.com/upload/small/e1ed1dbdb5f5e5993ffc6e112437bbc1.small.png
                 * nickname : 黄子韬
                 * phone : 12345678999
                 * level : 2
                 * wearAchievement : {"isCompleted":true,"type":1,"__v":0,"reward":"奖励称号1枚","completeCondition":"日签到排名第一","name":"The First","icon":"http://hzt.idoool.com/upload/web/firstsignin_wear.png","_id":"57d91d153a58d43e24931ff3"}
                 * creditLowerLimit : 12
                 * creditUpperLimit : 100
                 * vipLevel : 1
                 * resume :
                 */

                @SerializedName("_id")
                private String _id;
                private String userIcon;
                private String nickname;
                private String phone;
                private int level;
                private WearAchievementBean wearAchievement;
                private int creditLowerLimit;
                private int creditUpperLimit;
                private int vipLevel;
                private String resume;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getUserIcon() {
                    return userIcon;
                }

                public void setUserIcon(String userIcon) {
                    this.userIcon = userIcon;
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

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public WearAchievementBean getWearAchievement() {
                    return wearAchievement;
                }

                public void setWearAchievement(WearAchievementBean wearAchievement) {
                    this.wearAchievement = wearAchievement;
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

                public String getResume() {
                    return resume;
                }

                public void setResume(String resume) {
                    this.resume = resume;
                }

                public static class WearAchievementBean {
                    /**
                     * isCompleted : true
                     * type : 1
                     * __v : 0
                     * reward : 奖励称号1枚
                     * completeCondition : 日签到排名第一
                     * name : The First
                     * icon : http://hzt.idoool.com/upload/web/firstsignin_wear.png
                     * _id : 57d91d153a58d43e24931ff3
                     */

                    private boolean isCompleted;
                    private int type;
                    @SerializedName("__V")
                    private int __v;
                    private String reward;
                    private String completeCondition;
                    private String name;
                    private String icon;
                    @SerializedName("_id")
                    private String _id;

                    public boolean isIsCompleted() {
                        return isCompleted;
                    }

                    public void setIsCompleted(boolean isCompleted) {
                        this.isCompleted = isCompleted;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int get__v() {
                        return __v;
                    }

                    public void set__v(int __v) {
                        this.__v = __v;
                    }

                    public String getReward() {
                        return reward;
                    }

                    public void setReward(String reward) {
                        this.reward = reward;
                    }

                    public String getCompleteCondition() {
                        return completeCondition;
                    }

                    public void setCompleteCondition(String completeCondition) {
                        this.completeCondition = completeCondition;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public String get_id() {
                        return _id;
                    }

                    public void set_id(String _id) {
                        this._id = _id;
                    }
                }
            }

            public static class DailyRecordShareBean {
                /**
                 * date : 2018-01-24T07:51:18.060Z
                 * value : 0
                 */

                private String date;
                private int value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }
        }
    }
}
