package com.example.secondapp.Sarasas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.secondapp.R;

import androidx.appcompat.app.AppCompatDialogFragment;

public class PersonEditDialog extends AppCompatDialogFragment {

    private TextView editName;
    private TextView editLastName;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.list_edit_dialog, null);


        editName = (TextView) view.findViewById(R.id.editName);
        editLastName = (TextView) view.findViewById(R.id.editLastName);




        builder.setView(view)
                .setTitle("Edit")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });




        return builder.create();
    }
}
