package com.example.myfirstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.val;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    static Log log = new Log("MainActivity");

    @NonFinal
    RetainedFragment dataFragment;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        log.i("configuration was changed (onConfigurationChanged called)." +
                " Config - " + newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log.i("onCreate called!");

        val fm = getFragmentManager(); // find the retained fragment on activity restarts
        dataFragment = (RetainedFragment) fm.findFragmentByTag("data");

        if (dataFragment == null) { // create the fragment and data the first tim
            dataFragment = new RetainedFragment(); // add the fragment
            fm.beginTransaction().add(dataFragment, "data").commit();
            dataFragment.setData(loadMyData()); // load the data from the web
        }

        // the data is available in dataFragment.getData()
    }

    private MyDataObject loadMyData() {
        return null; // TODO: 25/04/2018
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        val intent = new Intent(
                this,
                DisplayMessageActivity.class);

        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString().trim().intern();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)
            return;
        String message = data.getStringExtra(EXTRA_MESSAGE);
        log.i("Your message is " + message);
    }
}
