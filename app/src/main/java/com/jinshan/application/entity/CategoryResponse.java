package com.jinshan.application.entity;

import java.util.List;

public class CategoryResponse {


    private List<CategoryPostlistBean> CategoryPostlist;

    public List<CategoryPostlistBean> getCategoryPostlist() {
        return CategoryPostlist;
    }

    public void setCategoryPostlist(List<CategoryPostlistBean> CategoryPostlist) {
        this.CategoryPostlist = CategoryPostlist;
    }

    public static class CategoryPostlistBean {
        /**
         * id : 1
         * name : 最新帖子
         * description : 最新帖子
         * createTime : 1551871161000
         * updateTime : 1551871161000
         * operatorId : 1
         * orderIndex : 0
         * status : null
         */

        private int id;
        private String name;
        private String description;
        private long createTime;
        private long updateTime;
        private int operatorId;
        private int orderIndex;
        private Object status;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public int getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(int orderIndex) {
            this.orderIndex = orderIndex;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }
    }
}
