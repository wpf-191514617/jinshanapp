package com.jinshan.application.entity;

import java.util.List;

public class RecommandResponse {

    private List<RecommandEntity> recommendList;

    public List<RecommandEntity> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<RecommandEntity> recommendList) {
        this.recommendList = recommendList;
    }
}
