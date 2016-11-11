package nas.madlib_sjdewijs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.CheckBox;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



/*    public void onGetWordClick(){


        // send data from this activity to next one
        //second_layout_intent.putExtra("callingActivity", "MainActivity"); // key , value (we want to retrieve)
        // retrieve information from first screen
        //startActivityForResult(second_layout_intent, result);

    }*/

    public void SwitchSecondLayout(View view){
        Intent second_layout_intent = new Intent(this, SecondScreen.class);
        startActivity(second_layout_intent);


    }
}
