package com.example.passwordmemorizingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database1 extends SQLiteOpenHelper {

    //create a db constants
    public static final String DB_NAME= "loginCred.db";
    public static final String LOGIN_TABLE= "LoginCredential";
    public static final String COLUMN_ID= "_id";
    public static final String COLUMN_EMAIL= "emailId";
    public static final String COLUMN_PASSWORD= "password";

    //db constructor
    public Database1(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//      String q1 = "CREATE TABLE LoginCred(id integer primary key autoincrement,email text,password text)";

        sqLiteDatabase.execSQL("CREATE TABLE " + LOGIN_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " text, " +
                COLUMN_PASSWORD + " text " +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LOGIN_TABLE);
//        onCreate(sqLiteDatabase);

    }

    //method SignIN UP
    public boolean signUp(String emailS, String passwordS) {

        SQLiteDatabase dbSignUP = this.getWritableDatabase();
//        String q2= "INSERT INTO VALUES('email', 'password');

//      ContentValues are like a insert in sql  -->
//      dbSignUP.execSQL("INSERT INTO " + LOGIN_TABLE + " VALUES('" + email + "', '" + password + "')");

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, emailS);
        cv.put(COLUMN_PASSWORD, passwordS);

        dbSignUP.insert(LOGIN_TABLE, null, cv);
        return true;

    }

    //method Login
    public boolean loginIn(String email, String password) {
        SQLiteDatabase dbLoginIn = this.getReadableDatabase();

        Cursor cursor = dbLoginIn.rawQuery("SELECT *FROM " + LOGIN_TABLE + " WHERE " + COLUMN_EMAIL + "=? and " + COLUMN_PASSWORD + "=?",new String[]{email,password});

        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }


}
