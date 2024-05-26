package com.example.gst_mock_englist_for_kids.app_client.ebook.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.callback.OnClickItem;
import com.example.gst_mock_englist_for_kids.app_client.ebook.model.EBook;
import java.util.List;

public class EBookAdapter extends RecyclerView.Adapter<EBookAdapter.EBookViewHolder> {

    private final Context mContext;

    private final List<EBook> eBookList;

    private OnClickItem listener;

    public EBookAdapter(Context mContext, List<EBook> eBookList, OnClickItem listener) {
        this.mContext = mContext;
        this.eBookList = eBookList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_ebook_pdf, parent, false);
        return new EBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EBookViewHolder holder, final int position) {
        EBook eBook = eBookList.get(position);
        holder.txtNameBook.setText(eBook.getmNameBook());
        holder.imgBooks.setImageResource(eBook.getmBookImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(v, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return eBookList.isEmpty() ? 0 : eBookList.size();
    }

    class EBookViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNameBook, txtLink;

        private ImageView imgBooks;

        public EBookViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameBook = itemView.findViewById(R.id.tv_name_ebook);
            imgBooks = itemView.findViewById(R.id.img_ebook);
            txtLink = itemView.findViewById(R.id.tv_link);
        }
    }
}
