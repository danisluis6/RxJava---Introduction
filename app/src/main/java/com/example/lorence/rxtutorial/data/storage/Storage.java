package com.example.lorence.rxtutorial.data.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.lorence.rxtutorial.data.model.Cake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by lorence on 25/12/2017.
 * @version version7
 * @since 12/27/2017
 */

public class Storage extends SQLiteOpenHelper {

    private static final String TAG = Storage.class.getSimpleName();

    /**
     * When put @Inject annotation in here. That means other class, you can @Inject this constructor
     * and use this object to access some methods from this Class as onCreate or onUpgrade.
     * It is the same with CakeMapper [OK DONE]
     * @param context
     */
    @Inject
    public Storage(Context context) {
        super(context, "cakes_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch(SQLException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addCake(Cake cake) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, cake.getTitle());
        values.put(PREVIEW_DESCRIPTION, cake.getPreviewDescription());
        values.put(DETAIL_DESCRIPTION, cake.getDetailDescription());
        values.put(IMAGE_URL, cake.getImageUrl());

        try {
            db.insert(TABLE_NAME, null, values);
        } catch(SQLException e) {
            Log.d(TAG, e.getMessage());
        }

        db.close();
    }

    public List<Cake> getSavedCakes() {
        List<Cake> cakeList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

        try {
            Cursor cursor = db.rawQuery(SELECT_QUERY, null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    if (cursor.moveToFirst()) {
                        do {
                            Cake cake = new Cake();
                            cake.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
                            cake.setPreviewDescription(cursor.getString(cursor.getColumnIndex(PREVIEW_DESCRIPTION)));
                            cake.setDetailDescription(cursor.getString(cursor.getColumnIndex(DETAIL_DESCRIPTION)));
                            cake.setImageUrl(cursor.getString(cursor.getColumnIndex(IMAGE_URL)));

                            cakeList.add(cake);

                        } while (cursor.moveToNext());
                    }
                }
            }
        } catch (SQLException e) {
            Log.d(TAG, e.getMessage());
        }
        return cakeList;
    }

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String PREVIEW_DESCRIPTION = "previewDescription";
    private static final String DETAIL_DESCRIPTION = "detailDescription";
    private static final String IMAGE_URL = "imageUrl";
    private static final String TABLE_NAME = "cakes";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            ID + " integer primary key autoincrement not null," +
            TITLE + " text not null," +
            PREVIEW_DESCRIPTION + " text not null," +
            DETAIL_DESCRIPTION + " text not null," +
            IMAGE_URL + " text not null)";
}
