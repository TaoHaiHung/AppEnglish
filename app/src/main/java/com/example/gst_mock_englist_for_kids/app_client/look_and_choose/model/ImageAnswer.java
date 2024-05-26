package com.example.gst_mock_englist_for_kids.app_client.look_and_choose.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ImageAnswer")
public class ImageAnswer {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "image")
    private final String img;

    @ColumnInfo(name = "a")
    private final String a;

    @ColumnInfo(name = "b")
    private final String b;

    @ColumnInfo(name = "c")
    private final String c;

    @ColumnInfo(name = "d")
    private final String d;

    @ColumnInfo(name = "correct")
    private final String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }


    public String getA() {
        return a;
    }


    public String getB() {
        return b;
    }


    public String getC() {
        return c;
    }


    public String getD() {
        return d;
    }


    public String getAnswer() {
        return answer;
    }


    public ImageAnswer(int id, String img, String a, String b, String c, String d, String answer) {
        this.id = id;
        this.img = img;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }
}
