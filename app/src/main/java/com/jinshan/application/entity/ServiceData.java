package com.jinshan.application.entity;

import java.util.List;

public class ServiceData {


    private List<CustomerServiceListBean> customerServiceList;

    public List<CustomerServiceListBean> getCustomerServiceList() {
        return customerServiceList;
    }

    public void setCustomerServiceList(List<CustomerServiceListBean> customerServiceList) {
        this.customerServiceList = customerServiceList;
    }

    public static class CustomerServiceListBean {
        /**
         * id : 1
         * name : 12345
         * imageUrl : /upload/files/20190306/15518723828721960.jpg
         * workingHours : 早8:00——晚18:00
         * createTime : 1551878671000
         * updateTime : 1551878671000
         * operatorId : 1
         * status : 1
         * orderIndex : 0
         */

        private int id;
        private String name;
        private String imageUrl;
        private String workingHours;
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

        public String getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
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
