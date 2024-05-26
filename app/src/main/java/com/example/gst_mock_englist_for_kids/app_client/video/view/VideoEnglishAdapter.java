package com.example.gst_mock_englist_for_kids.app_client.video.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.video.model.VideoEnglish;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoEnglishAdapter extends RecyclerView.Adapter<VideoEnglishAdapter.ViewHolder> {

    private final Context mContext;

    private final List<VideoEnglish> mListVideo;

    private OnItemVideoClickListener mListener;

    public VideoEnglishAdapter(Context mContext, List<VideoEnglish> mListVideo) {
        this.mContext = mContext;
        this.mListVideo = mListVideo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_youtube, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VideoEnglish videoEnglish = mListVideo.get(position);
        Picasso.with(mContext).load(videoEnglish.getThumbnail()).placeholder(R.drawable.ic_place_holder).into(holder.mImgVideo);
        holder.mTxtNameVideo.setText(videoEnglish.getTitle());
        holder.mTxtDescription.setText(videoEnglish.getDescription());
    }

    @Override
    public int getItemCount() {
        return mListVideo.isEmpty() ? 0 : mListVideo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mImgVideo;

        private final TextView mTxtNameVideo;
        private final TextView mTxtDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgVideo = itemView.findViewById(R.id.img_thumbnail);
            mTxtNameVideo = itemView.findViewById(R.id.tv_titleVideo);
            mTxtDescription = itemView.findViewById(R.id.tv_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface OnItemVideoClickListener {
        void onItemClick(View view, int position);
    }

    public void onItemClickVideoListener(OnItemVideoClickListener listener) {
        mListener = listener;
    }


}
