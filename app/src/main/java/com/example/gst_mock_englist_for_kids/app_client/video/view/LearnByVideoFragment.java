package com.example.gst_mock_englist_for_kids.app_client.video.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.video.model.VideoEnglish;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.network.NetworkConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LearnByVideoFragment extends Fragment {

    private View view;

    private RecyclerView mRvVideo;

    private final List<VideoEnglish> mListVideo = new ArrayList<>();

    private VideoEnglishAdapter mVideoEnglishAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learn_by_video, container, false);
        initView();
        checkInternet();
        return view;
    }

    private void checkInternet() {
        if (getContext() != null) {
            if (NetworkConnection.isNetworkAvailable(getContext())) {
                new LoadingVideo().execute();

            } else {
                showDialog();

            }
        }
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.check_internet);
        builder.setMessage(R.string.check_your_internet);
        builder.setCancelable(false);
        builder.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack(Constants.BACK_STACK_HOME_FRAGMENT, Constants.FLAG_HOME_FRAGMENT);
                    dialog.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    private void initView() {

        mRvVideo = view.findViewById(R.id.rv_video_english);
    }

    private List<VideoEnglish> GetJsonYoutube() {
        assert getContext() != null;
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, Constants.URL_GET_JSON, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    String title;
                    String link;
                    String idVideo;
                    String description;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObjectItem = jsonArray.getJSONObject(i);
                        JSONObject jsonObjectSnippet = jsonObjectItem.getJSONObject("snippet");
                        title = jsonObjectSnippet.getString("title");
                        description = jsonObjectSnippet.getString("description");
                        JSONObject jsonObjectThumbnail = jsonObjectSnippet.getJSONObject("thumbnails");
                        JSONObject jsonObjectMedium = jsonObjectThumbnail.getJSONObject("medium");
                        link = jsonObjectMedium.getString("url");
                        JSONObject jsonResourceID = jsonObjectSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceID.getString("videoId");
                        mListVideo.add(new VideoEnglish(title, description, idVideo, link));
                    }
                    mVideoEnglishAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Toast.makeText(getContext(), R.string.check_your_internet, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), R.string.check_your_internet, Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
        return mListVideo;
    }

    @SuppressLint("StaticFieldLeak")
    private class LoadingVideo extends AsyncTask<Void, Void, List<VideoEnglish>> {

        private ProgressDialog mPrLoading;

        @Override
        protected List<VideoEnglish> doInBackground(Void... voids) {
            if (getContext() != null) {
                if (NetworkConnection.isNetworkAvailable(getContext())) {
                    return GetJsonYoutube();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<VideoEnglish> videoEnglishes) {
            super.onPostExecute(videoEnglishes);
            mPrLoading.dismiss();
            mVideoEnglishAdapter = new VideoEnglishAdapter(getContext(), mListVideo);
            mRvVideo.setAdapter(mVideoEnglishAdapter);
            mRvVideo.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
            mRvVideo.setHasFixedSize(true);
            mVideoEnglishAdapter.onItemClickVideoListener(new VideoEnglishAdapter.OnItemVideoClickListener() {
                @Override
                public void onItemClick(final View view, int position) {
                    final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1.0f);
                    value.setDuration(300);
                    value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float progress = (float) value.getAnimatedValue();
                            view.setScaleX(progress);
                            view.setScaleY(progress);
                        }
                    });
                    value.start();
                    Intent intent = new Intent(getContext(), LearnForVideoActivity.class);
                    intent.putExtra(Constants.DATA_FOR_VIDEO, mListVideo.get(position).getIdVideo());
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mPrLoading = new ProgressDialog(getContext());
            mPrLoading.setMessage("Loading wait...");
            mPrLoading.show();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();


    }
}

