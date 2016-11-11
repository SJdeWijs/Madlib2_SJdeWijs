package nas.madlib_sjdewijs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by Sander de Wijs on 11-11-2016
 * Minor Programmeren
 * Native App Studio
 * Studentnummer: 10582134
 *
 * This screen asks for user input, which then gets passed to the final screen.
 */

public class SecondScreen extends Activity {
    // create a Story beforehand
    Story myStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream is;
        // generate a random integer from 0 to 4
        Random rand = new Random();
        int random = rand.nextInt(5);
        // choose a text based on the random integer
        try{
            if (random == 0) {
                is = getAssets().open("madlib0_simple.txt");
            }
            else if (random == 1) {
                is = getAssets().open("madlib1_tarzan.txt");
            }
            else if (random == 2){
                is = getAssets().open("madlib2_university.txt");
            }
            else if (random == 3){
                is = getAssets().open("madlib3_clothes.txt");
            }
            else if (random == 4){
                is = getAssets().open("madlib4_dance.txt");
            }
            else {
                is = null;
            }
        }
         catch (IOException e) {
            e.printStackTrace();
            is = null;
        }
        if (is != null) {
            // create a story variable
            myStory = new Story(is);

            // show second layout
            setContentView(R.layout.second_layout);

            // create a TextView variable
            TextView inputTextView = (TextView) findViewById(R.id.tv_words_left);

            // set text to the amount of placeholders present in the entire story
            inputTextView.setText("There are " + myStory.getPlaceholderCount() + " word(s) left.");

            // replace entered word with nothing, so textbox is emptied
            EditText wordEditText = (EditText) findViewById(R.id.et_entered_words);
            wordEditText.setHint(myStory.getNextPlaceholder());
            wordEditText.setText("");
        }
    }

    // switch from current activity to final activity, which shows the completed story
    public void SwitchStoryScreen(View view) {
        Intent third_layout_intent = new Intent(this, StoryScreen.class);
        startActivity(third_layout_intent);
    }

    public void enteredWord(View view) {
        // create variable of edittext with id et_entered_words
        EditText wordEditText = (EditText) findViewById(R.id.et_entered_words);

        if (wordEditText.length() != 0) {
            // convert entered words to seperate strings
            String word = wordEditText.getText().toString();

            // fills in the entered word in the chosen story
            myStory.fillInPlaceholder(word);

            // create textview variable of textview which shows number of words left
            TextView wordsLeft = (TextView) findViewById(R.id.tv_words_left);

            // update count of placeholders left, to be filled in
            wordsLeft.setText("There are " + myStory.getPlaceholderRemainingCount() + " word(s) left");

            //  create an EditText variable, then print the next placeholder to be filled in
            if (wordEditText.length() != 0) {
                wordEditText.setHint(myStory.getNextPlaceholder());
            }

            if (myStory.getPlaceholderRemainingCount() == 0){
                // create intend to pass entered data to final activity
                Intent storyScreenIntent = new Intent(this, StoryScreen.class);
                storyScreenIntent.putExtra("completeStory", myStory.toString());
                startActivity(storyScreenIntent);
                finish();
            }
        }
        // show error message when no character is entered
        else {
            wordEditText.setError("Please enter a word");
        }
        // replace entered word with nothing, so textbox is emptied
        wordEditText.setText("");
    }

}
