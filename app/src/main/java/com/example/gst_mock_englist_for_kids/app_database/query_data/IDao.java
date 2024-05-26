package com.example.gst_mock_englist_for_kids.app_database.query_data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gst_mock_englist_for_kids.app_client.look_and_choose.model.ImageAnswer;
import com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.model.ListenAnswer;
import com.example.gst_mock_englist_for_kids.app_client.topic.model.Topic;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;

import java.util.List;


@Dao
public interface IDao {
    //get topic
    @Query("SELECT * FROM Topic ORDER BY id ASC")
    List<Topic> getTopicList();

    //Insert topic table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopic(List<Topic> topics);

    // Insert topicDetails table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopicDetails(List<TopicDetails> topicDetails);

    //get topic details follow by topic
    @Query("SELECT * FROM TopicDetails WHERE idTopic=:idTopic")
    List<TopicDetails> getListTopicDetails(final int idTopic);


    //insert ImageAnswer
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImageAnswer(List<ImageAnswer> list);


    //getImageQuestion
    @Query("SELECT * FROM ImageAnswer ORDER BY RANDOM() LIMIT 20")
    List<ImageAnswer> getListImageAnswer();

    //insert ListenAnswer
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListenAnswer(List<ListenAnswer> list);

    //getListenImageAnswer
    @Query("SELECT * FROM ListenAnswer ORDER BY RANDOM() LIMIT 20")
    List<ListenAnswer> getListListenAnswer();

    //getRandom CheckTopicDetails
    @Query("SELECT * FROM TopicDetails ORDER BY RANDOM() LIMIT 30")
    List<TopicDetails> getListGuessThePicture();

}
