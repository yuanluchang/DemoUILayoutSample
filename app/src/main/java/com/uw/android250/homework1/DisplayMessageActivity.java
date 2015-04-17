package com.uw.android250.homework1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** HW1: Display 2nd screen for user email and password */

        Intent intent = getIntent();

        LinearLayout displayText = new LinearLayout(this);
        displayText.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams displayTextParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        displayTextParams.setMargins(100, 100, 100, 100);
        displayText.setPadding(16, 10, 16, 10);

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_Email);
        TextView textView = new TextView(this);
        textView.setText("Email: " + message);
        textView.setTextSize(20);
        displayText.addView(textView, displayTextParams);

        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_Password);
        TextView textView1 = new TextView(this);
        textView1.setText("Password: " + message);
        textView1.setTextSize(20);
        displayText.addView(textView1, displayTextParams);

        setContentView(displayText);

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

}
