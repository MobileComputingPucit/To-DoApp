package com.example.junaid.to_doapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Junaid on 26-Jan-18.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Notes_app";
    public static final String TABLE_USER = "user_details";
    public static final String TABLE_NOTES = "notes_details";
    public static final String USER_NAME = "user_name";
    public static final String USER_PASS = "user_pass";
    public static final String NOTES = "Notes";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_student_detail_table = "create table " + TABLE_USER + "("
                + USER_NAME + " text Primary key,"
                + USER_PASS + " Text)";
        System.out.println(create_student_detail_table);
        String create_note_table = "create table " + TABLE_NOTES + "("
                + USER_NAME + " text,"
                + NOTES + " Text, " +
                "foreign key (" + USER_NAME + " ) REFERENCES "+ TABLE_USER+ " (" + USER_NAME+ " ))";
        System.out.println(create_student_detail_table);
        db.execSQL(create_student_detail_table);
        db.execSQL(create_note_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
    public boolean insertUserData(User_table ut)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String name = "insert into " + TABLE_USER + " ("+USER_NAME+ "," +USER_PASS+ ") values ( '" + ut.get_user_name().toString() +"','" + ut.get_user_pass().toString() +"')";
        db.execSQL(name);
        return true;
    }
    public boolean insertNoteUser(String note_text, String user_name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String name = "insert into " + TABLE_NOTES + " ("+USER_NAME+ "," +NOTES+ ") values ( '" + user_name +"','" + note_text +"')";
        db.execSQL(name);
        return true;
    }

    public Cursor getUserData(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String read_query = "select * from "+TABLE_USER + " where " + USER_NAME + " = '" + name + "'";
        Cursor res = db.rawQuery(read_query,null);
        return res;
    }
    public Cursor getNotesData(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String read_query = "select * from "+TABLE_NOTES + " where " + USER_NAME + " = '" + name + "'";
        Cursor res = db.rawQuery(read_query,null);
        return res;
    }
}
