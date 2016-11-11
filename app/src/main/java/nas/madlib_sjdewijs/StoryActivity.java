package nas.madlib_sjdewijs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Sander de Wijs on 11-11-2016
 * Minor Programmeren
 * Native App Studio
 * Studentnummer: 10582134
 *
 * Shows the incorporated user input in a completed story.
 */


public class StoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // show the third activity
        setContentView(R.layout.third_layout);

        // create and perform intent to show completed story
        Intent receiveStory = getIntent();
        String completeStory = receiveStory.getExtras().getString("completeStory");
        TextView completeStoryTV = (TextView) findViewById(R.id.tv_story);
        completeStoryTV.setText(completeStory);
    }

    // switch from current activity to second activity
    public void BackToSecondScreen(View view){
        Intent second_layout_intent = new Intent(this, SecondScreen.class);
        startActivity(second_layout_intent);
    }
}