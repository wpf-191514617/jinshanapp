package com.jinshan.application.entity;

import com.jinshan.application.Constant;
import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

public class BannerResponse {


    private List<AdvertisementListBean> advertisementList;

    public List<AdvertisementListBean> getAdvertisementList() {
        return advertisementList;
    }

    public void setAdvertisementList(List<AdvertisementListBean> advertisementList) {
        this.advertisementList = advertisementList;
    }

    public static class AdvertisementListBean extends SimpleBannerInfo {
        /**
         * coverImageUrl : /upload/files/20190306/15518758447551979.jpg
         * id : 1
         * title : 11
         * operateSrc : 22
         */

        private String coverImageUrl;
        private int id;
        private String title;
        private String operateSrc;

        public String getCoverImageUrl() {
            return coverImageUrl;
        }

        public void setCoverImageUrl(String coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
        }

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

        public String getOperateSrc() {
            return operateSrc;
        }

        public void setOperateSrc(String operateSrc) {
            this.operateSrc = operateSrc;
        }

        @Override
        public Object getXBannerUrl() {
            return Constant.BASEURL + getCoverImageUrl();
        }
    }
}
