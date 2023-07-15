package com.example.sd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Grade_list2.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "grade_list1";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SEMESTER = "grade_semester";
    private static final String COLUMN_RESULT = "grade_result";


    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SEMESTER + " TEXT," +
                COLUMN_RESULT + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addGrade(String semester, String result){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SEMESTER, semester);
        cv.put(COLUMN_RESULT, result);


            long result_t = db.insert(TABLE_NAME,null, cv);
            if(result_t == -1){
                Toast.makeText(context, "다시 시도해주세요.", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "추가 되었습니다.", Toast.LENGTH_SHORT).show();
            }

        }


    Cursor readALLData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    void updateData(String row_id, String semester, String result){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SEMESTER, semester);
        cv.put(COLUMN_RESULT, result);
        long result_t = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result_t == -1){
            Toast.makeText(context, "다시 시도해주세요.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "수정 되었습니다.",Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result_t = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result_t == -1){
            Toast.makeText(context, "다시 시도해주세요.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "삭제 되었습니다.",Toast.LENGTH_SHORT).show();
        }
    }

    void deleteALLData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }


}








