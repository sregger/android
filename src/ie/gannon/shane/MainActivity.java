package ie.gannon.shane;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import android.widget.EditText;
import android.util.Log;

public class MainActivity extends Activity
{
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /** Called when the user clicks the Send button */
	public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		Log.w("debugme", message);
		try
		{
			startActivity(intent);
		}
		catch(Exception e)
		{
			Log.w("debugme", e);
		}
		Log.w("debugme", "Started the activity");
	}
}
