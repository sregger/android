package ie.gannon.shane;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.support.v4.app.NavUtils;
import android.util.Log;

public class DisplayMessageActivity extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("debugme", "Create called");
        super.onCreate(savedInstanceState);
        Log.w("debugme", "Super called");
        setContentView(R.layout.activity_display_message);
        Log.w("debugme", "Set Content called");

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            Log.w("debugme", "Setting action bar");
            getActionBar().setDisplayHomeAsUpEnabled(true);
            Log.w("debugme", "Set action bar");
        }

        Log.w("debugme", "Getting intent");
        Intent intent = getIntent();
        Log.w("debugme", "Got intent");
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.w("debugme", "Message is " + message);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        Log.w("debugme", "Created text view");

        // Set the text view as the activity layout
        setContentView(textView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}