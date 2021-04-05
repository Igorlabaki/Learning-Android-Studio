package com.cursoandroid.appbookreaders.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Data  extends SQLiteOpenHelper {

    public static int VERSION               =   4;
    public static String NOME_DB            =   "DB_BOOKREADERS";
    public static String TABEL_USER         =   "user";

    public Data(Context context) {
        super(context,NOME_DB,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABEL_USER +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username VARCHAR(50) NOT NULL UNIQUE," +
                "email VARCHAR(50) NOT NULL," +
                "password VARCHAR(9) NOT NULL);";
        try {
            db.execSQL(sql);
            Log.i("Info db", "Data create");
        }catch (Exception e){
            Log.i("Info db", "PORRAAAAAAAAAA");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE "+ TABEL_USER;
        try{
            db.execSQL(sql);
            onCreate(db);
            Log.i("Info db", "App atualizado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
