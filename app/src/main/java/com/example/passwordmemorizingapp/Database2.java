package com.example.passwordmemorizingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database2 extends SQLiteOpenHelper {

    Context context;

    public static final String DB_NAME = "records.db";
    public static final String RECORD_TABLE = "RecordTable";
    public static final String COLUMN_ID = "idRec";
    public static final String COLUMN_EMAIL_REC = "emailIdRec";
    public static final String COLUMN_PASSWORD = "passwordRec";
    public static final String COLUMN_DOMAIN = "domainRec";

    //db constructor
    public Database2(@Nullable Context context) {

        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        create a table rec
        sqLiteDatabase.execSQL("CREATE TABLE " + RECORD_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL_REC + " TEXT," +
                COLUMN_PASSWORD + " TEXT," +
                COLUMN_DOMAIN + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " +RECORD_TABLE);
        onCreate(db);
    }

    public void addRecords(String userId, String password, String domain) {

        SQLiteDatabase dbAdd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL_REC, userId);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_DOMAIN, domain);

        long result = dbAdd.insert(RECORD_TABLE, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed to Insert a Data..!!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Data has been Added Successfully..", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor scanData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery("SELECT *FROM " +RECORD_TABLE, null);
        }
        return cursor;
    }

    public void updateData(String recordUPID, String userId, String password, String domain) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL_REC, userId);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_DOMAIN, domain);

        db.update(RECORD_TABLE, cv,"domainRec=?", new String[]{recordUPID});
        db.close();

//        if(result == -1) {
//            Toast.makeText(context, "Failed To Update", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(context, "Added successfully",Toast.LENGTH_SHORT).show();
//        }
//        return result;
    }

    public void deleteData(String domain) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RECORD_TABLE,"domainRec=?",new String[]{domain});
        db.close();
//        if(result == -1) {
//            Toast.makeText(context, "Failed To Delete", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(context, "Added successfully",Toast.LENGTH_SHORT).show();
//        }
//        return result;
    }

}























/*
* public class Database2 extends SQLiteOpenHelper {
    private final Context context;
    private static final String DataBaseName = "Records.db";
    private static final int DataBaseVersion = 1;
    private static final String TableName = "my_records";
    private static final String RecordId = "ID";
    private static final String ColumnId = "UserId";
    private static final String ColumnPassword = "Password";
    private static final String ColumnDomainType = "Domain";

    public Database2(@Nullable Context context)  {
        super(context, DataBaseName, null, DataBaseVersion);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)  {
        String query =
                "CREATE TABLE " +TableName + " (" + RecordId + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ColumnId + " TEXT, " + ColumnPassword + " TEXT, " + ColumnDomainType + " TEXT ); ";
        db.execSQL(query); }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +TableName);
        onCreate(db);
    }

    public void addRecords(String UserId, String Password, String Domain) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ColumnId, UserId);
        cv.put(ColumnPassword, Password);
        cv.put(ColumnDomainType, Domain);
        long result = db.insert(TableName, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed to insert a data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully stored your data", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor scanData()  {
        String query = "SELECT *FROM " +TableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    int updateData(String userId,String password,String domain) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ColumnId,userId);
        cv.put(ColumnPassword,password);
        cv.put(ColumnDomainType,domain);
        int result =  db.update(TableName,cv,"Domain=?", new String[]{domain});
//        if(result == -1) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(context, "Added successfully",Toast.LENGTH_SHORT).show();
//        }
        return result;
    }

    public int deleteData(String userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result =  db.delete(TableName,"userId=?",new String[]{userId});
//        if(result == -1) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(context, "Added successfully",Toast.LENGTH_SHORT).show();
//        }
        return result;
    }
}
*/