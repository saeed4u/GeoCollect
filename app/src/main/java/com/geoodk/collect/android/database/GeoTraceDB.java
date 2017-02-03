package com.geoodk.collect.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Saeed on 2/2/2017.
 */
public class GeoTraceDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public static final String GEOTRACE_ID = "polygon_id";
    public static final String GEOTRACE_DATA = "polygon_data";
    public static final String GEOTRACE_TABLE = "polygons";
    public static final String GEOTRACE_COLOR = "geotrace_color";

    public GeoTraceDB(Context context) {
        super(context, "polygons_db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + GEOTRACE_TABLE + "(" + GEOTRACE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GEOTRACE_DATA + " TEXT NOT NULL," + GEOTRACE_COLOR + " INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + GEOTRACE_TABLE);
        onCreate(db);
    }
}
