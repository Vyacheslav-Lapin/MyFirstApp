package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import static com.example.myfirstapp.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity implements OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        String message = getIntent().getStringExtra(EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        if (textView == null)
            textView = findViewById(R.id.textView);

        textView.setText(message);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent()
                .putExtra("name", textView.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
