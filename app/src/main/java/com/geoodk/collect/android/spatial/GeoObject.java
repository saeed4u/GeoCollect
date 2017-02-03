package com.geoodk.collect.android.spatial;

import org.osmdroid.views.overlay.PathOverlay;

import java.util.ArrayList;

/**
 * Created by jnordling on 9/15/15.
 */
public class GeoObject{
    public String type;
    public String nodeset;
    public ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
    public CustomMarkerHelper pointMarker;
    public PathOverlay pathOverlay;

    public PathOverlay getPathOverlay() {
        return pathOverlay;
    }

    public void setPathOverlay(PathOverlay pathOverlay) {
        this.pathOverlay = pathOverlay;
    }

    public CustomMarkerHelper getPointMarker() {
        return pointMarker;
    }

    public void setPointMarker(CustomMarkerHelper pointMarker) {
        this.pointMarker = pointMarker;
    }

    public String getGeotype() {
        return type;
    }

    public void setGeotype(String geotype) {
        this.type = geotype;
    }

    public String getNodeset() {
        return nodeset;
    }

    public void setNodeset(String nodeset) {
        this.nodeset = nodeset;
    }

    public ArrayList<ArrayList<String>> getGeovalues() {
        return values;
    }

    public void setGeovalues(ArrayList<ArrayList<String>> geovalues) {
        this.values = geovalues;
    }
}
