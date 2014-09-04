package com.example.android.model;

/**
 * Created by achercasky on 06/08/14.
 */
public class ItemData {

    private String title;
    private String imageUrl;

    public ItemData(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
