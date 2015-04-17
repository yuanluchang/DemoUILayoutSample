package com.uw.android250.homework1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity  implements TextWatcher {

    /** HW1: define the key for your intent's extra using a public constant */

    public final static String EXTRA_MESSAGE_Email = "com.uw.android250.homework1.MESSAGE_Email";
    public final static String EXTRA_MESSAGE_Password = "com.uw.android250.homework1.MESSAGE_Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** HW1: Add handler to validate input for user email and password */

        EditText editText = (EditText) findViewById(R.id.editUsername);
        editText.addTextChangedListener(this);

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

    /** HW1: Called when the user clicks the Send button */
    public void sendMessage(View view) {

        /** HW1: Create an Intent to start another activity (i.e. 2nd screen) to display user email and password */

        Intent intent = new Intent(this, DisplayMessageActivity.class);

        /** HW1: Retrieve input texts entered in main screen for user email and password.
         * Use findViewById() to get the EditText elements.
         * Use the putExtra() method to add its text value to the intent.
         * */

        EditText editText = (EditText) findViewById(R.id.editUsername);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_Email, message);

        editText = (EditText) findViewById(R.id.editPassword);
        message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_Password, message);

        startActivity(intent);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    /** HW1: Called after the user changes text entered */
    public void afterTextChanged(Editable s) {

    /** HW1: Validate if user input matches valid email format.
         *  Use regression provided by: http://www.regular-expressions.info/email.html
         */
        EditText emailInput = (EditText)findViewById(R.id.editUsername);
        if (!emailInput.getText().toString().matches("\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b"))
            emailInput.setError("Not in valid email format: [user]@[domain]");
    }

}
