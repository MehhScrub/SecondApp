package com.example.secondapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends Fragment implements MainView{
    private MainPresenter presenter;
    private MainFragmentCallBack callBack;
    public static boolean IS_FIRST_TIME = true;


    @BindView(R.id.button2)
    Button tmygtukas;

    public static MainFragment newInstance(Bundle args) {
        MainFragment f = new MainFragment();
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainPresenter(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            try {
                callBack = (MainFragmentCallBack) context;
            } catch (ClassCastException e) {}
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {// Buttons of settings
        View rootView = inflater.inflate(R.layout.editmain, container, false);
        ButterKnife.bind(this, rootView);


        tmygtukas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.SarasasButtonClicked();

            }

        });



        presenter.viewCreated();

        return rootView;
    }
    @Override
    public void setMainTitle(String title) {
    }

    @Override
    public void goNextWindow(int tag,String params) {

        goNextWindow(tag,params);
         }

    @Override
    public void goNextWindow(int tag) {
        try {
            if (callBack != null) {
                callBack.goNextFragment(tag,"");
            }
        }catch (Exception e){
        }
    }




}
