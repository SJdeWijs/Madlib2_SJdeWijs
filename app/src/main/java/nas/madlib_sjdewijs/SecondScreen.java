package nas.madlib_sjdewijs;

import android.app.Activity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by P on 11-11-2016.
 */

public class SecondScreen extends Activity {
    Story myStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream is;
        try{
            is = getAssets().open("madlib0_simple.txt");
        } catch (IOException e) {
            e.printStackTrace();
            is = null;
        }
        if (is != null){
            myStory = new Story(is);
            int placeholderCount = myStory.getPlaceholderCount();
            setContentView(R.layout.second_layout);


        }

        // get data from second layout
        // Intent activityThatCalled = getIntent();
        // String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
    }
}
