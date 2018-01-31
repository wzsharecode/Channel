package idoool.com.baselib.bean;

import java.util.List;

/**
 * @author: wangdeshun
 * @date: 2018/1/23  14:26
 * @description: 创建 ChannelListType 最新、最热、精选 数据列表bean
 */

public class ChannelListType {

        private int nextOffset;
        private int total;
        private boolean isLastPage;
        private List<ListBean> list;

        public int getNextOffset() {
            return nextOffset;
        }

        public void setNextOffset(int nextOffset) {
            this.nextOffset = nextOffset;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {

            private int contentType;
            private PostBean post;

            public int getContentType() {
                return contentType;
            }

            public void setContentType(int contentType) {
                this.contentType = contentType;
            }

            public PostBean getPost() {
                return post;
            }

            public void setPost(PostBean post) {
                this.post = post;
            }

            public static class PostBean {

                private long time;
                private long createTime;

                public long getTime() {
                    return time;
                }

                public void setTime(long time) {
                    this.time = time;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }
            }
        }
}
