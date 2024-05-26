package com.example.gst_mock_englist_for_kids.app_client.topic_detail.view;

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
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;




public class TopicDetailsAdapter extends RecyclerView.Adapter<TopicDetailsAdapter.TopicDetailsHolder> {

    private static ClickItemTopicDetails mClickItemTopicDetails;

    private final Context mContext;

    private final List<TopicDetails> mListDetails;

    private final LayoutInflater mLayoutInflater;

    public TopicDetailsAdapter(Context mContext, List<TopicDetails> listDetails) {
        this.mContext = mContext;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mListDetails = listDetails;
    }

    @NonNull
    @Override
    public TopicDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_topic_details, parent, false);
        return new TopicDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicDetailsHolder holder, int position) {
        final TopicDetails topicDetails = mListDetails.get(position);
        holder.imgTopicDetails.setImageBitmap(getBitmapFromAssets(topicDetails.getImg()));
        holder.tvNameTopicDetails.setText(topicDetails.getName());
    }

    @Override
    public int getItemCount() {
        if (mListDetails != null) {
            return mListDetails.size();
        }
        return 0;
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


    class TopicDetailsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView imgTopicDetails;
        private final TextView tvNameTopicDetails;

        TopicDetailsHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgTopicDetails = itemView.findViewById(R.id.imgTopicDetails);
            tvNameTopicDetails = itemView.findViewById(R.id.tvNameTopicDetails);
        }

        @Override
        public void onClick(View v) {
            mClickItemTopicDetails.onClickItem(v, getAdapterPosition());
        }
    }

    public void onItemClickListener(ClickItemTopicDetails clickItemTopicDetails) {
        mClickItemTopicDetails = clickItemTopicDetails;
    }

    public interface ClickItemTopicDetails {
        void onClickItem(View view, int position);
    }
}
