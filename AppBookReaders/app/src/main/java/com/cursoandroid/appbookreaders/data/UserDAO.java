package com.cursoandroid.appbookreaders.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.cursoandroid.appbookreaders.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserDAO implements IUserDAO{

    private SQLiteDatabase  write;
    private SQLiteDatabase  read;
    private List<User>      userList = new ArrayList<>();

    public UserDAO(Context context) {
        Data db   = new Data(context);
        write     = db.getWritableDatabase();
        read      = db.getReadableDatabase();
    }


    @Override
    public boolean save(User user) {

        ContentValues cv = new ContentValues();
        cv.put("username",user.getUsername());
        cv.put("email",user.getEmail());
        cv.put("password",user.getPassword());

        try {
            write.insert(Data.TABEL_USER,null,cv);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> listUser() {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM " + Data.TABEL_USER + ";";

        Cursor cursor = read.rawQuery(sql,null);

        while(cursor.moveToNext()){
            Long id         = cursor.getLong(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor.getColumnIndex("username"));
            String email    = cursor.getString(cursor.getColumnIndex("email"));
            String password = cursor.getString(cursor.getColumnIndex("password"));

            User user = new User(id,username,email,password);
            userList.add(user);
        }
        return  userList;
    }


    public User search(String username){

        List<User> userList = listUser();

        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getUsername().equals(username)){
                return userList.get(i);
                break;
            }else return null;
        }
    
    }
}
