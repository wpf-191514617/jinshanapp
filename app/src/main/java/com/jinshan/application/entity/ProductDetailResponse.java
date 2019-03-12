package com.jinshan.application.entity;

public class ProductDetailResponse {


    /**
     * loanCrack : {"createTime":1551488554000,"operatorId":null,"imageUrl":"/upload/files/20190223/1550885948174252.png","dayrate":0.05,"orderIndex":0,"sparePath":null,"interfaceSeriesName":null,"id":266,"serverPhone":"0000","name":"讯到","applicationFlow":null,"applicationConditions4":"","accessPath":"http://papi.lrytech.com/h5/appDownloadOne.html?channelCode=BC6&tel=18708177363&modelType=1","applicationConditions1":"芝麻分580+","status":1,"updateTime":1551488555000,"royalty":0,"applicationConditions3":"","returnVisit":9,"categoryId":76,"applicationConditions2":"手机实名制","loanDeadline":7,"applicationConditions":"20-40","loanSpeed":24,"characteristicLabel":"极速放款","upperLimit":10000,"whetherCommission":1,"nextCommission":0}
     */

    private LoanCrackBean loanCrack;

    public LoanCrackBean getLoanCrack() {
        return loanCrack;
    }

    public void setLoanCrack(LoanCrackBean loanCrack) {
        this.loanCrack = loanCrack;
    }

    public static class LoanCrackBean {
        /**
         * createTime : 1551488554000
         * operatorId : null
         * imageUrl : /upload/files/20190223/1550885948174252.png
         * dayrate : 0.05
         * orderIndex : 0
         * sparePath : null
         * interfaceSeriesName : null
         * id : 266
         * serverPhone : 0000
         * name : 讯到
         * applicationFlow : null
         * applicationConditions4 :
         * accessPath : http://papi.lrytech.com/h5/appDownloadOne.html?channelCode=BC6&tel=18708177363&modelType=1
         * applicationConditions1 : 芝麻分580+
         * status : 1
         * updateTime : 1551488555000
         * royalty : 0
         * applicationConditions3 :
         * returnVisit : 9
         * categoryId : 76
         * applicationConditions2 : 手机实名制
         * loanDeadline : 7
         * applicationConditions : 20-40
         * loanSpeed : 24
         * characteristicLabel : 极速放款
         * upperLimit : 10000
         * whetherCommission : 1
         * nextCommission : 0
         */

        private long createTime;
        private Object operatorId;
        private String imageUrl;
        private double dayrate;
        private int orderIndex;
        private Object sparePath;
        private Object interfaceSeriesName;
        private int id;
        private String serverPhone;
        private String name;
        private Object applicationFlow;
        private String applicationConditions4;
        private String accessPath;
        private String applicationConditions1;
        private int status;
        private long updateTime;
        private int royalty;
        private String applicationConditions3;
        private int returnVisit;
        private int categoryId;
        private String applicationConditions2;
        private int loanDeadline;
        private String applicationConditions;
        private int loanSpeed;
        private String characteristicLabel;
        private int upperLimit;
        private int whetherCommission;
        private int nextCommission;

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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public double getDayrate() {
            return dayrate;
        }

        public void setDayrate(double dayrate) {
            this.dayrate = dayrate;
        }

        public int getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(int orderIndex) {
            this.orderIndex = orderIndex;
        }

        public Object getSparePath() {
            return sparePath;
        }

        public void setSparePath(Object sparePath) {
            this.sparePath = sparePath;
        }

        public Object getInterfaceSeriesName() {
            return interfaceSeriesName;
        }

        public void setInterfaceSeriesName(Object interfaceSeriesName) {
            this.interfaceSeriesName = interfaceSeriesName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getServerPhone() {
            return serverPhone;
        }

        public void setServerPhone(String serverPhone) {
            this.serverPhone = serverPhone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getApplicationFlow() {
            return applicationFlow;
        }

        public void setApplicationFlow(Object applicationFlow) {
            this.applicationFlow = applicationFlow;
        }

        public String getApplicationConditions4() {
            return applicationConditions4;
        }

        public void setApplicationConditions4(String applicationConditions4) {
            this.applicationConditions4 = applicationConditions4;
        }

        public String getAccessPath() {
            return accessPath;
        }

        public void setAccessPath(String accessPath) {
            this.accessPath = accessPath;
        }

        public String getApplicationConditions1() {
            return applicationConditions1;
        }

        public void setApplicationConditions1(String applicationConditions1) {
            this.applicationConditions1 = applicationConditions1;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getRoyalty() {
            return royalty;
        }

        public void setRoyalty(int royalty) {
            this.royalty = royalty;
        }

        public String getApplicationConditions3() {
            return applicationConditions3;
        }

        public void setApplicationConditions3(String applicationConditions3) {
            this.applicationConditions3 = applicationConditions3;
        }

        public int getReturnVisit() {
            return returnVisit;
        }

        public void setReturnVisit(int returnVisit) {
            this.returnVisit = returnVisit;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getApplicationConditions2() {
            return applicationConditions2;
        }

        public void setApplicationConditions2(String applicationConditions2) {
            this.applicationConditions2 = applicationConditions2;
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

        public int getLoanSpeed() {
            return loanSpeed;
        }

        public void setLoanSpeed(int loanSpeed) {
            this.loanSpeed = loanSpeed;
        }

        public String getCharacteristicLabel() {
            return characteristicLabel;
        }

        public void setCharacteristicLabel(String characteristicLabel) {
            this.characteristicLabel = characteristicLabel;
        }

        public int getUpperLimit() {
            return upperLimit;
        }

        public void setUpperLimit(int upperLimit) {
            this.upperLimit = upperLimit;
        }

        public int getWhetherCommission() {
            return whetherCommission;
        }

        public void setWhetherCommission(int whetherCommission) {
            this.whetherCommission = whetherCommission;
        }

        public int getNextCommission() {
            return nextCommission;
        }

        public void setNextCommission(int nextCommission) {
            this.nextCommission = nextCommission;
        }
    }
}
