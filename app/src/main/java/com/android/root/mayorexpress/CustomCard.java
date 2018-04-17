package com.android.root.mayorexpress;

public class CustomCard {

    private int image;
    private String w;//work
    private String d1;//description1
    private String d2;//description2

    public CustomCard(int image, String w, String d1, String d2) {
        this.image = image;
        this.w = w;
        this.d1 = d1;
        this.d2 = d2;
    }

    public int getImage() {
        return image;
    }

    public String getW() {
        return w;
    }

    public String getD1() {
        return d1;
    }

    public String getD2() {
        return d2;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setW(String w) {
        this.w = w;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }
}
