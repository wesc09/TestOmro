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
    private EditText etNombre,etUri;
    static final int PICK_CONTACT_REQUEST = 0;
    static final int REQUEST_CODE=10;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etUri= (EditText)findViewById(R.id.etUri);
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
        Log.d(TAG,"intent: " + getIntent());
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "intent:" + getIntent());
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Uri responseUri= data.getData();
                String response= responseUri.toString();
                String[]id= response.split("serialId", "&");
                etUri.setText(id(0));

                //diria que amb axo ens mostrarà tot el string al cuadre de texte "etUri", necesitem el dispositiu per comprovar-ho pero intenta averiguar com pillar el troç del string que volem
            }
        }
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);

                // Do something with the phone number... (FET)

                etNombre.setText(number);
            }

        }
    }


    @Override
    public void onClick(View v) {


        if (v == mButton) {
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://startup?returnUrl=com.example.adria.testomron.MainActivity"));
            startActivityForResult(intent, REQUEST_CODE );
        }
        if (v == mButton2) {
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");
            Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
            intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
            startActivityForResult(intent, PICK_CONTACT_REQUEST);

            }


        if (v == mButton3) {
            // getPackageName() + getClass().getCanonicalName();
            Log.d(TAG, "onclick");



            // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("omronconnect://transfer?returnUrl=com.example.adria.testomron.MainActivity&serialId=1234567890qwert12345"));
            //startActivity(intent);
        }

    }

}
