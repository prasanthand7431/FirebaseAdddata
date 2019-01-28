package com.example.prasanth.realtimedatabase;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    Spinner spinner;
    Button button;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference("artist");

        editText1=findViewById(R.id.edit);
        spinner=findViewById(R.id.spins);
        button=findViewById(R.id.buttons);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addArtist();

            }
        });
    }

    private void addArtist(){

        String name=editText1.getText().toString().trim();
        String genere=spinner.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name)){

            String id=databaseReference.push().getKey();

            Artist artist=new Artist(id,name,genere);

            databaseReference.child(id).setValue(artist);

            Toast.makeText(this, "Artist Added", Toast.LENGTH_SHORT).show();


        }else {

            Toast.makeText(this, "You should add name", Toast.LENGTH_SHORT).show();
        }
    }
}
