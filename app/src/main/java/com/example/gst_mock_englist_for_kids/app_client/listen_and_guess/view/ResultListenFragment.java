package com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;


import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.callback.MyDialogListener;

public class ResultListenFragment extends DialogFragment {

    private final MyDialogListener mDialogListener;

    @SuppressWarnings("FieldCanBeLocal")
    private Button mBtnTryAgain, mBtnExit;

    private final View.OnClickListener mBtnTryAgainClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
            if (mDialogListener != null) {
                mDialogListener.onCloseDialog();
            }
        }
    };
    private final View.OnClickListener mBtnExitClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack(Constants.BACK_STACK_HOME_FRAGMENT, Constants.FLAG_HOME_FRAGMENT);
                dismiss();
            }
        }
    };

    public ResultListenFragment(MyDialogListener listener) {
        mDialogListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.dialog_fragment_result_listen, container, false);

        initViews(mView);
        return mView;
    }

    private void initViews(View view) {
        mBtnTryAgain = view.findViewById(R.id.btnTryAgain);
        mBtnTryAgain.setOnClickListener(mBtnTryAgainClick);

        mBtnExit = view.findViewById(R.id.btnExit);
        mBtnExit.setOnClickListener(mBtnExitClick);
    }
}
