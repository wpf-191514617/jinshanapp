package com.jinshan.application.entity;

import java.util.List;

public class PostResponse {


    /**
     * page : {"totalPage":2,"totalCount":7,"resultlist":[{"id":9,"title":"测试","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":0,"createTime":1551880233000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190306/15518802281582009.jpg"},{"id":10,"title":"测试图文结合帖子","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":10,"createTime":1551884337000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190306/15518843336932027.png"},{"id":11,"title":"头条新闻","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":20,"createTime":1551884530000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190306/15518845278802030.jpg"},{"id":13,"title":"如果符合燃放工会公会","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":0,"createTime":1551945752000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190307/15519457475172188.jpg"},{"id":19,"title":"全年减税降费2万亿 财政部部长：世界上没有一个国家一年减这么多","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":0,"createTime":1551948176000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190307/15519481705112236.jpg"}]}
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
         * totalPage : 2
         * totalCount : 7
         * resultlist : [{"id":9,"title":"测试","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":0,"createTime":1551880233000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190306/15518802281582009.jpg"},{"id":10,"title":"测试图文结合帖子","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":10,"createTime":1551884337000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190306/15518843336932027.png"},{"id":11,"title":"头条新闻","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":20,"createTime":1551884530000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190306/15518845278802030.jpg"},{"id":13,"title":"如果符合燃放工会公会","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":0,"createTime":1551945752000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190307/15519457475172188.jpg"},{"id":19,"title":"全年减税降费2万亿 财政部部长：世界上没有一个国家一年减这么多","content":null,"categoryId":5,"clickNum":null,"enjoyNum":null,"likeNum":null,"isRecommend":0,"orderIndex":0,"createTime":1551948176000,"operatorId":null,"status":0,"categoryName":"精选帖子","coverImage":"/upload/files/20190307/15519481705112236.jpg"}]
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
             * id : 9
             * title : 测试
             * content : null
             * categoryId : 5
             * clickNum : null
             * enjoyNum : null
             * likeNum : null
             * isRecommend : 0
             * orderIndex : 0
             * createTime : 1551880233000
             * operatorId : null
             * status : 0
             * categoryName : 精选帖子
             * coverImage : /upload/files/20190306/15518802281582009.jpg
             */

            private int id;
            private String title;
            private Object content;
            private int categoryId;
            private Object clickNum;
            private Object enjoyNum;
            private Object likeNum;
            private int isRecommend;
            private int orderIndex;
            private long createTime;
            private Object operatorId;
            private int status;
            private String categoryName;
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

            public Object getClickNum() {
                return clickNum;
            }

            public void setClickNum(Object clickNum) {
                this.clickNum = clickNum;
            }

            public Object getEnjoyNum() {
                return enjoyNum;
            }

            public void setEnjoyNum(Object enjoyNum) {
                this.enjoyNum = enjoyNum;
            }

            public Object getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(Object likeNum) {
                this.likeNum = likeNum;
            }

            public int getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(int isRecommend) {
                this.isRecommend = isRecommend;
            }

            public int getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(int orderIndex) {
                this.orderIndex = orderIndex;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(Object operatorId) {
                this.operatorId = operatorId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
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
