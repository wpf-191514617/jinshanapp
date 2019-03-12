package com.jinshan.application.entity;

import java.util.List;

public class SetResponse {


    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * classificationName : 机审系列
         * resultList : [{"id":35,"createTime":1551489299000,"characteristicLabel":"不看征信","operatorId":null,"imageUrl":"/upload/files/20190302/15514892854001370.png","status":0,"updateTime":1551489299000,"orderIndex":20,"classification":1,"name":"黑马","remarks":"无回访","jurisdiction":1,"recommend":9},{"id":81,"createTime":1551321912000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551262354474421.png","status":0,"updateTime":1551321912000,"orderIndex":18,"classification":1,"name":"一号钱庄系列","remarks":"放款快，不上征信","jurisdiction":1,"recommend":0},{"id":82,"createTime":1551322461000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551262336146420.png","status":0,"updateTime":1551322461000,"orderIndex":8,"classification":1,"name":"由你花系列","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":88,"createTime":1551322608000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551262259339414.png","status":0,"updateTime":1551322609000,"orderIndex":5,"classification":1,"name":"星期贷系列","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":101,"createTime":1551488957000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551261902704401.png","status":0,"updateTime":1551488958000,"orderIndex":21,"classification":1,"name":"战神系","remarks":"放款快，不上征信","jurisdiction":1,"recommend":0},{"id":121,"createTime":1551321880000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551261525065381.png","status":0,"updateTime":1551321880000,"orderIndex":19,"classification":1,"name":"现金侠系","remarks":"无回访，下款快","jurisdiction":1,"recommend":0},{"id":124,"createTime":1551322739000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551261490746378.png","status":0,"updateTime":1551322740000,"orderIndex":1,"classification":1,"name":"吉祥钱袋系","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":143,"createTime":1551322672000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551261138424358.png","status":0,"updateTime":1551322672000,"orderIndex":3,"classification":1,"name":"河马应急系","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":163,"createTime":1551322710000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190227/1551263672056442.png","status":0,"updateTime":1551322711000,"orderIndex":2,"classification":1,"name":"秒有钱","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":167,"createTime":1551321816000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551321812820452.png","status":0,"updateTime":1551321817000,"orderIndex":20,"classification":1,"name":"超级金卡","remarks":"无回访，下款快","jurisdiction":1,"recommend":0},{"id":168,"createTime":1551321968000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551321965375453.png","status":0,"updateTime":1551321969000,"orderIndex":17,"classification":1,"name":"壹玖贷","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":169,"createTime":1551322008000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322006341454.png","status":0,"updateTime":1551322009000,"orderIndex":16,"classification":1,"name":"小牛金卡","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":170,"createTime":1551322134000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322099755455.png","status":0,"updateTime":1551322135000,"orderIndex":14,"classification":1,"name":"猪八借","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":171,"createTime":1551322289000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322287675456.png","status":0,"updateTime":1551322290000,"orderIndex":12,"classification":1,"name":"小虎钱包","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":172,"createTime":1551322364000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322321956457.png","status":0,"updateTime":1551322365000,"orderIndex":10,"classification":1,"name":"英雄元宝","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":173,"createTime":1551322402000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322398962458.png","status":0,"updateTime":1551322403000,"orderIndex":9,"classification":1,"name":"速米袋","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":174,"createTime":1551499029000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190228/1551322503884459.png","status":0,"updateTime":1551499029000,"orderIndex":0,"classification":1,"name":"现金ATM","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":175,"createTime":1551322564000,"characteristicLabel":"机审，不人工电话","operatorId":null,"imageUrl":"/upload/files/20190228/1551322541026460.png","status":0,"updateTime":1551322565000,"orderIndex":6,"classification":1,"name":"米诺钱包","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":176,"createTime":1551322639000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322637249461.png","status":0,"updateTime":1551322639000,"orderIndex":4,"classification":1,"name":"王佬吉","remarks":"机审核，不人工","jurisdiction":1,"recommend":0},{"id":178,"createTime":1551322808000,"characteristicLabel":"机审，不人工电话","operatorId":1,"imageUrl":"/upload/files/20190228/1551322806651463.png","status":0,"updateTime":1551322809000,"orderIndex":10,"classification":1,"name":"桔子钱包","remarks":"无回访，下款快","jurisdiction":1,"recommend":0}]
         */

        private String classificationName;
        private List<ResultListBean> resultList;

        public String getClassificationName() {
            return classificationName;
        }

        public void setClassificationName(String classificationName) {
            this.classificationName = classificationName;
        }

        public List<ResultListBean> getResultList() {
            return resultList;
        }

        public void setResultList(List<ResultListBean> resultList) {
            this.resultList = resultList;
        }

        public static class ResultListBean {
            /**
             * id : 35
             * createTime : 1551489299000
             * characteristicLabel : 不看征信
             * operatorId : null
             * imageUrl : /upload/files/20190302/15514892854001370.png
             * status : 0
             * updateTime : 1551489299000
             * orderIndex : 20
             * classification : 1
             * name : 黑马
             * remarks : 无回访
             * jurisdiction : 1
             * recommend : 9
             */

            private int id;
            private long createTime;
            private String characteristicLabel;
            private Object operatorId;
            private String imageUrl;
            private int status;
            private long updateTime;
            private int orderIndex;
            private int classification;
            private String name;
            private String remarks;
            private int jurisdiction;
            private int recommend;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getCharacteristicLabel() {
                return characteristicLabel;
            }

            public void setCharacteristicLabel(String characteristicLabel) {
                this.characteristicLabel = characteristicLabel;
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

            public int getOrderIndex() {
                return orderIndex;
            }

            public void setOrderIndex(int orderIndex) {
                this.orderIndex = orderIndex;
            }

            public int getClassification() {
                return classification;
            }

            public void setClassification(int classification) {
                this.classification = classification;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public int getJurisdiction() {
                return jurisdiction;
            }

            public void setJurisdiction(int jurisdiction) {
                this.jurisdiction = jurisdiction;
            }

            public int getRecommend() {
                return recommend;
            }

            public void setRecommend(int recommend) {
                this.recommend = recommend;
            }
        }
    }
}
