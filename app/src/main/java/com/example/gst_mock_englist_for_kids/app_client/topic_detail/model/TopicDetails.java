package com.example.gst_mock_englist_for_kids.app_client.topic_detail.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.gst_mock_englist_for_kids.app_client.topic.model.Topic;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "TopicDetails",
        foreignKeys = @ForeignKey(entity = Topic.class,
                parentColumns = "id",
                childColumns = "idTopic",
                onDelete = CASCADE))
public class TopicDetails implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "idTopicDt")
    private int id;

    @ColumnInfo(name = "imageTopicDt")
    private String img;

    @ColumnInfo(name = "nameTopicDt")
    private String name;

    @ColumnInfo(name = "idTopic",index = true)
    private int idTopic;

    public TopicDetails() {
    }

    @Ignore
    public TopicDetails(int id, String img, String name, int idTopic) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.idTopic = idTopic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }
}