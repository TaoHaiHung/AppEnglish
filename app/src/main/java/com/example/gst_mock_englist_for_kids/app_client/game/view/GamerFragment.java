package com.example.gst_mock_englist_for_kids.app_client.game.view;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.network.NetworkConnection;

public class GamerFragment extends Fragment {

    private View view;

    private WebView wvGame;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.gamer_fragment, container, false);
        initView();
        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void actionWebview() {
        if (getContext() != null && NetworkConnection.isNetworkAvailable(getContext())) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                final String process = getProcessName(getContext());
                if (!"com.example.gst_mock_englist_for_kids.view.fragment".equals(process)) {

                    wvGame.getSettings().setJavaScriptEnabled(true);
                    wvGame.loadUrl(Constants.URL_WEB);
                    wvGame.setWebViewClient(new WebViewClient() {
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            WebView.setDataDirectorySuffix(url);
                            view.loadUrl(url);
                            return true;
                        }
                    });
                }
            }

        } else {
            showDialog();
        }
    }

    private String getProcessName(Context context) {
        if (context == null) {
            @SuppressLint("ServiceCast")
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
                if (processInfo.pid == android.os.Process.myPid()) {
                    return processInfo.processName;
                }
            }

        }
        return null;
    }

    private void initView() {
        wvGame = view.findViewById(R.id.wv_game);
        actionWebview();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        wvGame.destroy();
    }
}
