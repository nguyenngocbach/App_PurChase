package com.bachnn.myapplication.fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bachnn.myapplication.R;

public class DialogOneFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog= new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_one);
        dialog.show();
        return dialog;
    }
}
