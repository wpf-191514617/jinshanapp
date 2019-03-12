package com.jinshan.application.entity;

import java.util.List;

public class HomeLoanBean {


    private List<ProductEntity> recommendLoanCrackList;

    public List<ProductEntity> getRecommendLoanCrackList() {
        return recommendLoanCrackList;
    }

    public void setRecommendLoanCrackList(List<ProductEntity> recommendLoanCrackList) {
        this.recommendLoanCrackList = recommendLoanCrackList;
    }

    public static class RecommendLoanCrackListBean {
        /**
         * id : 659
         * name : 苹果钱包
         * upperLimit : 10000
         * dayrate : 0.05
         * loanSpeed : 24
         * loanDeadline : 7
         * applicationConditions : 20-40
         * applicationConditions1 : 芝麻分580+
         * applicationConditions2 : 手机实名制
         * applicationConditions3 :
         * applicationConditions4 :
         * applicationFlow : null
         * serverPhone : 0000
         * characteristicLabel : 1161354
         * categoryId : 74
         * operatorId : 1
         * createTime : 1550907426000
         * updateTime : 1547618921000
         * status : 1
         * accessPath : https://www.y4d.cn/0aE3
         * imageUrl : /upload/files/20190116/1547618889991154.png
         * royalty : 0
         * orderIndex : 22222
         * interfaceSeriesName : null
         * nextCommission : null
         * whetherCommission : null
         * returnVisit : null
         * sparePath : null
         * manualTime : null
         * manualDate : null
         */

        private int id;
        private String name;
        private int upperLimit;
        private double dayrate;
        private int loanSpeed;
        private int loanDeadline;
        private String applicationConditions;
        private String applicationConditions1;
        private String applicationConditions2;
        private String applicationConditions3;
        private String applicationConditions4;
        private Object applicationFlow;
        private String serverPhone;
        private String characteristicLabel;
        private int categoryId;
        private int operatorId;
        private long createTime;
        private long updateTime;
        private int status;
        private String accessPath;
        private String imageUrl;
        private int royalty;
        private int orderIndex;
        private Object interfaceSeriesName;
        private Object nextCommission;
        private Object whetherCommission;
        private Object returnVisit;
        private Object sparePath;
        private Object manualTime;
        private Object manualDate;

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

        public int getUpperLimit() {
            return upperLimit;
        }

        public void setUpperLimit(int upperLimit) {
            this.upperLimit = upperLimit;
        }

        public double getDayrate() {
            return dayrate;
        }

        public void setDayrate(double dayrate) {
            this.dayrate = dayrate;
        }

        public int getLoanSpeed() {
            return loanSpeed;
        }

        public void setLoanSpeed(int loanSpeed) {
            this.loanSpeed = loanSpeed;
        }

        public int getLoanDeadline() {
            return loanDeadline;
        }

        public void setLoanDeadline(int loanDeadline) {
            this.loanDeadline = loanDeadline;
        }

        public String getApplicationConditions() {
            return applicationConditions;
        }

        public void setApplicationConditions(String applicationConditions) {
            this.applicationConditions = applicationConditions;
        }

        public String getApplicationConditions1() {
            return applicationConditions1;
        }

        public void setApplicationConditions1(String applicationConditions1) {
            this.applicationConditions1 = applicationConditions1;
        }

        public String getApplicationConditions2() {
            return applicationConditions2;
        }

        public void setApplicationConditions2(String applicationConditions2) {
            this.applicationConditions2 = applicationConditions2;
        }

        public String getApplicationConditions3() {
            return applicationConditions3;
        }

        public void setApplicationConditions3(String applicationConditions3) {
            this.applicationConditions3 = applicationConditions3;
        }

        public String getApplicationConditions4() {
            return applicationConditions4;
        }

        public void setApplicationConditions4(String applicationConditions4) {
            this.applicationConditions4 = applicationConditions4;
        }

        public Object getApplicationFlow() {
            return applicationFlow;
        }

        public void setApplicationFlow(Object applicationFlow) {
            this.applicationFlow = applicationFlow;
        }

        public String getServerPhone() {
            return serverPhone;
        }

        public void setServerPhone(String serverPhone) {
            this.serverPhone = serverPhone;
        }

        public String getCharacteristicLabel() {
            return characteristicLabel;
        }

        public void setCharacteristicLabel(String characteristicLabel) {
            this.characteristicLabel = characteristicLabel;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getOperatorId() {
            return operatorId;
        }

        public void setOperatorId(int operatorId) {
            this.operatorId = operatorId;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAccessPath() {
            return accessPath;
        }

        public void setAccessPath(String accessPath) {
            this.accessPath = accessPath;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getRoyalty() {
            return royalty;
        }

        public void setRoyalty(int royalty) {
            this.royalty = royalty;
        }

        public int getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(int orderIndex) {
            this.orderIndex = orderIndex;
        }

        public Object getInterfaceSeriesName() {
            return interfaceSeriesName;
        }

        public void setInterfaceSeriesName(Object interfaceSeriesName) {
            this.interfaceSeriesName = interfaceSeriesName;
        }

        public Object getNextCommission() {
            return nextCommission;
        }

        public void setNextCommission(Object nextCommission) {
            this.nextCommission = nextCommission;
        }

        public Object getWhetherCommission() {
            return whetherCommission;
        }

        public void setWhetherCommission(Object whetherCommission) {
            this.whetherCommission = whetherCommission;
        }

        public Object getReturnVisit() {
            return returnVisit;
        }

        public void setReturnVisit(Object returnVisit) {
            this.returnVisit = returnVisit;
        }

        public Object getSparePath() {
            return sparePath;
        }

        public void setSparePath(Object sparePath) {
            this.sparePath = sparePath;
        }

        public Object getManualTime() {
            return manualTime;
        }

        public void setManualTime(Object manualTime) {
            this.manualTime = manualTime;
        }

        public Object getManualDate() {
            return manualDate;
        }

        public void setManualDate(Object manualDate) {
            this.manualDate = manualDate;
        }
    }
}
