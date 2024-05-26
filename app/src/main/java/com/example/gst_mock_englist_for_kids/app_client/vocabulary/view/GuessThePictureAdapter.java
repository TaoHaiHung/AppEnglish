package com.example.gst_mock_englist_for_kids.app_client.vocabulary.view;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GuessThePictureAdapter extends RecyclerView.Adapter<GuessThePictureAdapter.GuessViewHolder> {

    private final Context mContext;

    private final List<TopicDetails> mList;

    private OnItemClickItemForGuessThePicture mOnItemClickItemForGuessThePicture;

    public GuessThePictureAdapter(Context mContext, List<TopicDetails> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GuessThePictureAdapter.GuessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_guess_picture, parent, false);
        return new GuessViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GuessThePictureAdapter.GuessViewHolder holder, final int position) {
        TopicDetails topicDetails = mList.get(position);
        holder.mImgGuessPicture.setImageBitmap(getBitmapFromAssets(topicDetails.getImg()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickItemForGuessThePicture.onClickItemImage(holder.mImgGuessPicture, holder.mImgTick, position);

            }
        });

    }

    private Bitmap getBitmapFromAssets(String img) {
        AssetManager am = mContext.getAssets();
        InputStream is = null;
        try {

            is = am.open(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BitmapFactory.decodeStream(is);
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    class GuessViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImgGuessPicture;
        private final ImageView mImgTick;

        GuessViewHolder(@NonNull View itemView) {
            super(itemView);

            mImgGuessPicture = itemView.findViewById(R.id.img_guess_picture);
            mImgTick = itemView.findViewById(R.id.img_tick);

        }

    }

    public interface OnItemClickItemForGuessThePicture {
        void onClickItemImage(ImageView imgItemPicture, ImageView imgTick, int position);
    }

    public void onItemCLickListener(OnItemClickItemForGuessThePicture listener) {
        mOnItemClickItemForGuessThePicture = listener;
    }
}
