package com.geoodk.collect.android.database.model;


import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;

/**
 * Created by blanka on 2/2/2017.
 */
public class GeoTrace {

   private ArrayList<GeoPoint> mGeoPoints;
    private int mColor;

    public GeoTrace(ArrayList<GeoPoint> mGeoPoints, int mColor) {
        this.mGeoPoints = mGeoPoints;
        this.mColor = mColor;
    }

    public ArrayList<GeoPoint> getmGeoPoints() {
        return mGeoPoints;
    }

    public int getmColor() {
        return mColor;
    }
}
