package com.example.secondapp.Sarasas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.secondapp.ObjectSerializer;
import com.example.secondapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.DialogTitle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;


public class SarasasFragment extends Fragment implements SarasasView{

    @Nullable
    @BindView(R.id.btnNew)
    Button btnNaujas;

    public TextView mName;
    public TextView mLastName;

    private static SharedPreferences.Editor mEditor;
    private static SharedPreferences mPreferences;

    private SarasasPresenter presenter;

    private static final String TAG = "SarasasFragment";
    ArrayList<Person> peopleList = new ArrayList<>();

    public static SarasasFragment newInstance(Bundle args){
        SarasasFragment f = new SarasasFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        presenter = new SarasasPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, rootView);

        ListView list = (ListView) rootView.findViewById(R.id.theList);
        Log.d(TAG, "onCreateView: Started.");


        PersonListAdapter adapter = new PersonListAdapter(getContext(), R.layout.custom_list_layout, peopleList);
        list.setAdapter(adapter);


//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Log.d(TAG, "name: " + peopleList.get(position).getName()+ " lastname: " + peopleList.get(position).getLastName());
//
//            }
//        });



        btnNaujas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Intent intent = new Intent(v.getContext(), PersonNew.class);
                //startActivity(intent);


                PersonNew nextFrag= new PersonNew();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

                //mName = (TextView) rootView.findViewById(R.id.ovardas);
                //mLastName = (TextView) rootView.findViewById(R.id.opassword);
//                mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//                mEditor = mPreferences.edit();
//                String newName = mPreferences.getString(getString(R.string.name), "");
//                String newLastName = mPreferences.getString(getString(R.string.lastName),"");
//
//                Person newPerson = new Person(newName, newLastName);
//                peopleList.add(newPerson);
//                adapter.notifyDataSetChanged();
//                mEditor.apply();

            }
        });







        return rootView;
    }


    public void save(){

        mPreferences = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        try {
            mEditor.putString("UserList", ObjectSerializer.serialize(peopleList));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mEditor.apply();
    }


    public void load(){


        mPreferences = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
        try {
            peopleList = (ArrayList) ObjectSerializer.deserialize(mPreferences.getString("UserList", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mEditor.apply();
    }

    public void openDialog(){
        PersonEditDialog editDialog = new PersonEditDialog();
        editDialog.show(getFragmentManager(), "example dialog");


    }

}

