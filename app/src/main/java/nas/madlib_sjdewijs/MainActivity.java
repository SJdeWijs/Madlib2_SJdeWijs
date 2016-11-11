package nas.madlib_sjdewijs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // show main activity
        setContentView(R.layout.activity_main);
    }

    // switch from current activity to second activity
    public void SwitchSecondLayout(View view){
        Intent second_layout_intent = new Intent(this, SecondScreen.class);
        startActivity(second_layout_intent);
        finish();
    }
}
