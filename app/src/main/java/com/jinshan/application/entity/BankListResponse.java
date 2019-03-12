package com.jinshan.application.entity;

import java.util.List;

public class BankListResponse {


    /**
     * resultList : {"totalPage":1,"totalCount":4,"resultlist":[{"id":1,"name":"测试1","imageUrl":"/upload/files/20190306/15518725022941963.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872503000,"updateTime":1551872503000,"operatorId":1,"status":1,"orderIndex":0},{"id":2,"name":"efw","imageUrl":"/upload/files/20190306/15518725212561964.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872522000,"updateTime":1551872522000,"operatorId":1,"status":1,"orderIndex":0},{"id":3,"name":"scdsdvsfb","imageUrl":"/upload/files/20190306/15518725399321965.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872541000,"updateTime":1551872541000,"operatorId":1,"status":1,"orderIndex":0},{"id":4,"name":"scdsdvs","imageUrl":"/upload/files/20190306/15518725763151966.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872578000,"updateTime":1551872578000,"operatorId":1,"status":1,"orderIndex":0}]}
     */

    private ResultListBean resultList;

    public ResultListBean getResultList() {
        return resultList;
    }

    public void setResultList(ResultListBean resultList) {
        this.resultList = resultList;
    }

    public static class ResultListBean {
        /**
         * totalPage : 1
         * totalCount : 4
         * resultlist : [{"id":1,"name":"测试1","imageUrl":"/upload/files/20190306/15518725022941963.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872503000,"updateTime":1551872503000,"operatorId":1,"status":1,"orderIndex":0},{"id":2,"name":"efw","imageUrl":"/upload/files/20190306/15518725212561964.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872522000,"updateTime":1551872522000,"operatorId":1,"status":1,"orderIndex":0},{"id":3,"name":"scdsdvsfb","imageUrl":"/upload/files/20190306/15518725399321965.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872541000,"updateTime":1551872541000,"operatorId":1,"status":1,"orderIndex":0},{"id":4,"name":"scdsdvs","imageUrl":"/upload/files/20190306/15518725763151966.jpg","accessPath":"https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282","createTime":1551872578000,"updateTime":1551872578000,"operatorId":1,"status":1,"orderIndex":0}]
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
             * id : 1
             * name : 测试1
             * imageUrl : /upload/files/20190306/15518725022941963.jpg
             * accessPath : https://www.rongkezhijia.cn/app/index.php?i=2&c=entry&m=ewei_shopv2&do=mobile&r=member.bdother.bdother&id=1906&mid=36282
             * createTime : 1551872503000
             * updateTime : 1551872503000
             * operatorId : 1
             * status : 1
             * orderIndex : 0
             */

            private int id;
            private String name;
            private String imageUrl;
            private String accessPath;
            private long createTime;
            private long updateTime;
            private int operatorId;
            private int status;
            private int orderIndex;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getAccessPath() {
                return accessPath;
            }

            public void setAccessPath(String accessPath) {
                this.accessPath = accessPath;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(int operatorId) {
                this.operatorId = operatorId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(int orderIndex) {
                this.orderIndex = orderIndex;
            }
        }
    }
}
