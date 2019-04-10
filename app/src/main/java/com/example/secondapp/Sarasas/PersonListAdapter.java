package com.example.secondapp.Sarasas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.secondapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class PersonListAdapter extends ArrayAdapter<Person> {

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    int mResource;

    static class ViewHolder {
        TextView name;
        TextView lastName;
    }

    public PersonListAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        String name = getItem(position).getName();
        String lastName = getItem(position).getLastName();

        Person person = new Person(name, lastName);

        //final View result;

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.TextView1);
            holder.lastName = (TextView) convertView.findViewById(R.id.TextView2);

            //result = convertView;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            //result = convertView;
        }



        //TextView tvName = (TextView) convertView.findViewById(R.id.TextView1);
        //TextView tvLastName = (TextView) convertView.findViewById(R.id.TextView2);

        //tvName.setText(name);
        //tvLastName.setText(lastName);


        holder.name.setText(name);
        holder.lastName.setText(lastName);

        return convertView;
    }
}
