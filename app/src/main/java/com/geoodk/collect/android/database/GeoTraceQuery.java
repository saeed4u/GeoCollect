package com.geoodk.collect.android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.geoodk.collect.android.database.model.GeoTrace;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;

/**
 * Created by blanka on 2/2/2017.
 */
public class GeoTraceQuery {

    private SQLiteDatabase mDatabase;
    private ContentValues mContentValues;

    public GeoTraceQuery(Context mContext) {
        GeoTraceDB geoTraceDB = new GeoTraceDB(mContext);
        mDatabase = geoTraceDB.getWritableDatabase();
    }

    public boolean addGeoTrace(String geoTrace, int color) {

        Log.v("geoTrace",geoTrace);

        mContentValues = new ContentValues();
        mContentValues.put(GeoTraceDB.GEOTRACE_DATA, geoTrace);
        mContentValues.put(GeoTraceDB.GEOTRACE_COLOR, color);
        return mDatabase.insert(GeoTraceDB.GEOTRACE_TABLE, null, mContentValues) > 0;
    }

    public void closeDB(){
        mDatabase.close();
    }

    public ArrayList<GeoTrace> getGeoTraces() {
        ArrayList<GeoTrace> geoTraces = new ArrayList<>();
        Cursor query = mDatabase.query(GeoTraceDB.GEOTRACE_TABLE, new String[]{GeoTraceDB.GEOTRACE_DATA, GeoTraceDB.GEOTRACE_COLOR}, null, null, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                String geoTrace = query.getString(0);
                int color = query.getInt(1);
                String[] geoPoints = geoTrace.split(";");
                ArrayList<GeoPoint> geoPointsList = new ArrayList<>();
                for (String geoPoint : geoPoints) {
                    String[] geoTraceValues = geoPoint.split(" ");
                    if (geoTraceValues.length >= 4) {
                        double latitude = Double.parseDouble(geoTraceValues[0].trim());
                        double longitude = Double.parseDouble(geoTraceValues[1].trim());
                        double altitude = Double.parseDouble(geoTraceValues[2].trim());

                        Log.v("Latitude",""+latitude);
                        Log.v("longitude",""+longitude);
                        Log.v("altitude",""+altitude);

                        geoPointsList.add(new GeoPoint(latitude, longitude, altitude));
                    }
                }
                geoTraces.add(new GeoTrace(geoPointsList, color));
            }
            query.close();
            mDatabase.close();
        }
        return geoTraces;
    }

}
