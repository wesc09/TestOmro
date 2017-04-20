package com.example.adria.testomron;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.io.ObjectInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = MainActivity.class.getSimpleName() + ".java";
    private Button mButton, mButton2, mButton3;
    private EditText etData, etUri;
    static final int PICK_CONTACT_REQUEST = 0;
    static final int REQUEST_CODE = 10;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        etData = (EditText) findViewById(R.id.etData);
        etUri = (EditText) findViewById(R.id.etUri);
        mButton = (Button) findViewById(R.id.action_button);
        mButton2 = (Button) findViewById(R.id.action_button2);
        mButton3 = (Button) findViewById(R.id.action_button3);
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Log.d(TAG, "onCreate");
        Log.d(TAG, "intent: " + getIntent());

        Intent intent = getIntent();
        if (intent.getAction().equals(Intent.ACTION_VIEW)) {
            Uri responseUri = intent.getData();
            if(responseUri.getQueryParameter("displayName")!= null) {
                String serialId = responseUri.getQueryParameter("serialId").toString();


                //String[]id= response.split("serialId", "&");

                etUri.setText(serialId);
            }
            else{

                String data = responseUri.getQueryParameter("result").toString();
                etData.setText(data);

            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Log.d(TAG, "intent:" + getIntent());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }




    @Override
    public void onClick(View v) {


        if (v == mButton) {
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");
            String dss= Uri.parse("omronconnect://startup?returnUrl=testomron://MainActivity").toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://startup?returnUrl=testomron://MainActivity"));
            startActivity(intent);
            //%3A%2F%2F
        }
            if (v == mButton2) {

                // getPackageName() + getClass().getCanonicalName();
                Log.d(TAG, "onclick");
                String dss= Uri.parse("omronconnect://startup?returnUrl=testomron://MainActivity").toString();
                Intent intentData = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://transfer?returnUrl=testomron://MainActivity&serialId=000000940221100b1c7a0d02ffff"));
                startActivity(intentData);
            }


            if (v == mButton3) {
                // getPackageName() + getClass().getCanonicalName();
                Log.d(TAG, "onclick");


                // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://transfer?returnUrl=com.example.adria.testomron.MainActivity&serialId=1234567890qwert12345"));
                //startActivity(intent);
            }

        }

    }


