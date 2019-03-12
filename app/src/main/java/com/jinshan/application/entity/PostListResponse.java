package com.jinshan.application.entity;

import java.util.List;

public class PostListResponse {


    /**
     * page : {"totalPage":1,"totalCount":10,"resultlist":[{"id":23,"title":"曾经那个酷酷的少年也有了自己宠爱的小公主\u2014\u2014《前世情人》","content":null,"categoryId":4,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519491179042246.jpeg"},{"id":22,"title":"结婚4年，周杰伦聚会带昆凌：爱你的人，不愿意和你分开每一秒","content":null,"categoryId":3,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519489694802243.jpeg"},{"id":21,"title":"薛之谦发文否认捆绑周杰伦炒作，但用这两个字称呼杰伦粉丝不高兴","content":null,"categoryId":2,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519485358532240.jpeg"},{"id":20,"title":"最新民调：韩国瑜大幅超柯文哲 狂甩蔡英文近30%","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519441807142165.jpeg"},{"id":19,"title":"全年减税降费2万亿 财政部部长：世界上没有一个国家一年减这么多","content":null,"categoryId":2,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519481705112236.jpg"},{"id":13,"title":"如果符合燃放工会公会","content":null,"categoryId":2,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519457475172188.jpg"},{"id":11,"title":"头条新闻","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518845278802030.jpg"},{"id":10,"title":"测试图文结合帖子","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518843336932027.png"},{"id":9,"title":"测试","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518802281582009.jpg"},{"id":6,"title":"测试帖子3","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518796453331995.jpg"}]}
     */

    private PageBean page;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * totalPage : 1
         * totalCount : 10
         * resultlist : [{"id":23,"title":"曾经那个酷酷的少年也有了自己宠爱的小公主\u2014\u2014《前世情人》","content":null,"categoryId":4,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519491179042246.jpeg"},{"id":22,"title":"结婚4年，周杰伦聚会带昆凌：爱你的人，不愿意和你分开每一秒","content":null,"categoryId":3,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519489694802243.jpeg"},{"id":21,"title":"薛之谦发文否认捆绑周杰伦炒作，但用这两个字称呼杰伦粉丝不高兴","content":null,"categoryId":2,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519485358532240.jpeg"},{"id":20,"title":"最新民调：韩国瑜大幅超柯文哲 狂甩蔡英文近30%","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519441807142165.jpeg"},{"id":19,"title":"全年减税降费2万亿 财政部部长：世界上没有一个国家一年减这么多","content":null,"categoryId":2,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519481705112236.jpg"},{"id":13,"title":"如果符合燃放工会公会","content":null,"categoryId":2,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190307/15519457475172188.jpg"},{"id":11,"title":"头条新闻","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518845278802030.jpg"},{"id":10,"title":"测试图文结合帖子","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518843336932027.png"},{"id":9,"title":"测试","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518802281582009.jpg"},{"id":6,"title":"测试帖子3","content":null,"categoryId":1,"clickNum":0,"enjoyNum":0,"likeNum":0,"isRecommend":null,"orderIndex":null,"createTime":null,"operatorId":null,"status":null,"categoryName":null,"coverImage":"/upload/files/20190306/15518796453331995.jpg"}]
         */

        private int totalPage;
        private int totalCount;
        private List<ResultlistBean> resultlist;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ResultlistBean> getResultlist() {
            return resultlist;
        }

        public void setResultlist(List<ResultlistBean> resultlist) {
            this.resultlist = resultlist;
        }

        public static class ResultlistBean {
            /**
             * id : 23
             * title : 曾经那个酷酷的少年也有了自己宠爱的小公主——《前世情人》
             * content : null
             * categoryId : 4
             * clickNum : 0
             * enjoyNum : 0
             * likeNum : 0
             * isRecommend : null
             * orderIndex : null
             * createTime : null
             * operatorId : null
             * status : null
             * categoryName : null
             * coverImage : /upload/files/20190307/15519491179042246.jpeg
             */

            private int id;
            private String title;
            private Object content;
            private int categoryId;
            private int clickNum;
            private int enjoyNum;
            private int likeNum;
            private Object isRecommend;
            private Object orderIndex;
            private Object createTime;
            private Object operatorId;
            private Object status;
            private Object categoryName;
            private String coverImage;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getContent() {
                return content;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getClickNum() {
                return clickNum;
            }

            public void setClickNum(int clickNum) {
                this.clickNum = clickNum;
            }

            public int getEnjoyNum() {
                return enjoyNum;
            }

            public void setEnjoyNum(int enjoyNum) {
                this.enjoyNum = enjoyNum;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public Object getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(Object isRecommend) {
                this.isRecommend = isRecommend;
            }

            public Object getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(Object orderIndex) {
                this.orderIndex = orderIndex;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(Object operatorId) {
                this.operatorId = operatorId;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(Object categoryName) {
                this.categoryName = categoryName;
            }

            public String getCoverImage() {
                return coverImage;
            }

            public void setCoverImage(String coverImage) {
                this.coverImage = coverImage;
            }
        }
    }
}
