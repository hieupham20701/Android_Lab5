package com.example.lab5;

import android.widget.ImageView;

public class Donut {
    private int imgDonut;
    private String tvDonut;
    private String tvDescription;
    private String tvPrice;

    public Donut(int imgDonut, String tvDonut, String tvDescription, String tvPrice) {
        this.imgDonut = imgDonut;
        this.tvDonut = tvDonut;
        this.tvDescription = tvDescription;
        this.tvPrice = tvPrice;
    }

    public int getImgDonut() {
        return imgDonut;
    }

    public void setImgDonut(int imgDonut) {
        this.imgDonut = imgDonut;
    }

    public String getTvDonut() {
        return tvDonut;
    }

    public void setTvDonut(String tvDonut) {
        this.tvDonut = tvDonut;
    }

    public String getTvDescription() {
        return tvDescription;
    }

    public void setTvDescription(String tvDescription) {
        this.tvDescription = tvDescription;
    }

    public String getTvPrice() {
        return tvPrice;
    }

    public void setTvPrice(String tvPrice) {
        this.tvPrice = tvPrice;
    }
}
