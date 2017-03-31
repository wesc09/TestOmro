package com.example.adria.testomron;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
// palomo y tontopolla
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = MainActivity.class.getSimpleName() + ".java";
    private Button mButton, mButton2, mButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mButton = (Button) findViewById(R.id.action_button);
        mButton2 = (Button) findViewById(R.id.action_button2);
        mButton3 = (Button) findViewById(R.id.action_button3);
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == mButton){
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://startup?returnUrl=com.example.adria.testomron.MainActivity"));
            startActivity(intent);
        }
        if (v == mButton2){
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://startup?returnUrl=com.example.adria.testomron.MainActivity"));
            startActivity(intent);
        }
        if (v == mButton3){
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://startup?returnUrl=com.example.adria.testomron.MainActivity"));
            startActivity(intent);
        }

    }
}
