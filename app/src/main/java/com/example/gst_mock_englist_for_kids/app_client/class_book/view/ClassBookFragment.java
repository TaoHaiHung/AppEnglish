package com.example.gst_mock_englist_for_kids.app_client.class_book.view;

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

public class ClassBookFragment extends Fragment {

    private View view;

    private RecyclerView rvEbook;

    private EBookAdapter mEBookAdapter;

    private List<EBook> mListEBooks;


    public static ClassBookFragment newInstance() {

        Bundle args = new Bundle();
        ClassBookFragment fragment = new ClassBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_class_ebook, container, false);
        initView();
        return view;
    }

    private void initView() {
        rvEbook = view.findViewById(R.id.rv_ebooks);
        mListEBooks = new ArrayList<>();

        mListEBooks.add(new EBook("Family and Friend 1", R.drawable.img_ebook_one));
        mListEBooks.add(new EBook("Family and Friend 2", R.drawable.img_family_and_friend_two));
        mListEBooks.add(new EBook("Family and Friend 3", R.drawable.img_ebook_three));
        mListEBooks.add(new EBook("Family and Friend 4", R.drawable.img_ebook_four));
        mListEBooks.add(new EBook("Family and Friend 5", R.drawable.img_ebook_five));
        mListEBooks.add(new EBook("Family and Friend 6", R.drawable.img_ebook_six));
        mEBookAdapter = new EBookAdapter(getActivity(), mListEBooks, new OnClickItem() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(getActivity(), ClassBookDetailActivity.class);
                intent.putExtra("pdf", mListEBooks.get(position).getmNameBook());
                startActivity(intent);
            }
        });
        rvEbook.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvEbook.setHasFixedSize(true);
        rvEbook.setAdapter(mEBookAdapter);
    }


//    private void changeFragment(Fragment fragment) {
//        FragmentTransaction transaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
//        transaction.replace(R.id.frame_ebook, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
