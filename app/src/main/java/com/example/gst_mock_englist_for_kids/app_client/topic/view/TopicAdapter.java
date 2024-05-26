package com.example.gst_mock_englist_for_kids.app_client.topic.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.topic.model.Topic;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private static ClickListener mListener;

    private final Context mContext;

    private final List<Topic> mList;


    private final LayoutInflater mInflater;


    public TopicAdapter(Context context, List<Topic> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        final Topic topic = mList.get(position);
        holder.imgTopic.setImageBitmap(getBitmapFromAssets(topic.getImg()));
        holder.tvNameTopic.setText(topic.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private Bitmap getBitmapFromAssets(String fileName) {

        AssetManager am = mContext.getAssets();
        InputStream is = null;
        try {

            is = am.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BitmapFactory.decodeStream(is);
    }

    class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView imgTopic;

        private final TextView tvNameTopic;

        TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgTopic = itemView.findViewById(R.id.imgTopic);
            tvNameTopic = itemView.findViewById(R.id.tvNameTopic);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        mListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View view, int position);
    }
}
