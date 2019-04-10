package com.example.secondapp.Sarasas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.secondapp.R;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonNew extends SarasasFragment {

    public SharedPreferences mPreferences;
    public SharedPreferences.Editor mEditor;
    public EditText mName;
    public EditText mLastName;

    @BindView(R.id.btnAdd)
    Button btnAdd;



    private static final String TAG = "PersonNew";

    public static PersonNew newInstance(Bundle args){
        PersonNew f = new PersonNew();
        f.setArguments(args);
        return f;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.new_person, container, false);
        ButterKnife.bind(this, rootView);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName = (EditText)rootView.findViewById(R.id.addName);
                mLastName = (EditText) rootView.findViewById(R.id.addLastName);
//                mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//                mEditor = mPreferences.edit();
                String name = mName.getText().toString();
                String lastName = mLastName.getText().toString();
//                mEditor.putString(getString(R.string.name), name);
//                mEditor.putString(getString(R.string.lastName), lastName);
//                mEditor.commit();
//
//                mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//                mEditor = mPreferences.edit();
                //String newName = mPreferences.getString(getString(R.string.name), "");
                //String newLastName = mPreferences.getString(getString(R.string.lastName),"");



                Person newPerson = new Person(name, lastName);
                peopleList.add(newPerson);
                //SarasasFragment.adapter.notifyDataSetChanged();

                //mEditor.apply();

            }
        });





        return rootView;
    }

























}
