package com.prototype.pathmyeducation.navigation;

import android.graphics.Bitmap;


/**
 * Created by Chris on 28/01/2017.
 */

public class Point {

    // Node information
    private String location;
    private String desc;
    private Bitmap picture;

    public Point() {
        this.location = "";
        this.desc = "";
        this.picture = null;
        //this.nearby = null;
    }

    public Point(String location, String desc, Bitmap picture, PointNode[] nearby) {
        this();
        this.location = location;
        this.desc = desc;
        this.picture = picture;
        //this.nearby = nearby;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public Bitmap getPicture() {
        return picture;
    }
}
