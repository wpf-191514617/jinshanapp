package com.jinshan.application.entity;

import java.util.List;

public class ProductResponse {

    private List<ProductEntity> resultlist;

    public List<ProductEntity> getResultlist() {
        return resultlist;
    }

    public void setResultlist(List<ProductEntity> resultlist) {
        this.resultlist = resultlist;
    }
}
