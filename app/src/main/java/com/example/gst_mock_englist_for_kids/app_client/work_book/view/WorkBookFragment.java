package com.example.gst_mock_englist_for_kids.app_client.work_book.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.ebook.view.EBookAdapter;
import com.example.gst_mock_englist_for_kids.app_client.callback.OnClickItem;
import com.example.gst_mock_englist_for_kids.app_client.ebook.model.EBook;

import java.util.ArrayList;
import java.util.List;

public class WorkBookFragment extends Fragment {

    private View view;

    private RecyclerView rvWorkBook;

    private EBookAdapter mEBookAdapter;

    private List<EBook> mListEBooks;

    public static WorkBookFragment newInstance() {

        Bundle args = new Bundle();

        WorkBookFragment fragment = new WorkBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_work_book, container, false);
        initview();
        return view;
    }

    private void initview() {
        rvWorkBook = view.findViewById(R.id.rv_work_book);
        mListEBooks = new ArrayList<>();
        mListEBooks.add(new EBook("Family and Friend 1", R.drawable.img_wb_english_one));
        mListEBooks.add(new EBook("Family and Friend 2", R.drawable.img_wb_english_two));
        mListEBooks.add(new EBook("Family and Friend 3", R.drawable.img_wb_english_three));
        mListEBooks.add(new EBook("Family and Friend 4", R.drawable.img_wb_english_four));
        mListEBooks.add(new EBook("Family and Friend 5", R.drawable.img_wb_english_five));
        mListEBooks.add(new EBook("Family and Friend 6", R.drawable.img_wb_english_six));
        mEBookAdapter = new EBookAdapter(getActivity(), mListEBooks, new OnClickItem() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WorkBookDetailActivity.class);
                intent.putExtra("work book", mListEBooks.get(position).getmNameBook());
                startActivity(intent);
            }
        });
        rvWorkBook.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvWorkBook.setHasFixedSize(true);
        rvWorkBook.setAdapter(mEBookAdapter);
    }
}
