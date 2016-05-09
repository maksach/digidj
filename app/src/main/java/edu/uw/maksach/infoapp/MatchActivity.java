package edu.uw.maksach.infoapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MatchActivity extends AppCompatActivity {
    private Spinner spinner;
    private static final String[]paths = {"item 1", "item 2", "item 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //GENRE SPINNER
        Spinner staticSpinner1 = (Spinner)findViewById(R.id.genre_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.genres_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter1
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner1.setAdapter(staticAdapter1);

        //TEMPO SPINNER
        Spinner staticSpinner2 = (Spinner)findViewById(R.id.tempo_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.tempos_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter2
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner2.setAdapter(staticAdapter2);


        //KEY SPINNER
        Spinner staticSpinner3 = (Spinner)findViewById(R.id.key_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter3 = ArrayAdapter
                .createFromResource(this, R.array.keys_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter3
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner3.setAdapter(staticAdapter3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_match, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (item.getItemId()) {
            //sorts the list by date created
            case R.id.match_songs:
                Toast.makeText(this, "Match Songs", Toast.LENGTH_SHORT).show();
                Intent matchIntent = new Intent(this, MatchActivity.class);
                startActivity(matchIntent);
                return true;
            //adds a new task
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                /*
                AddFragment addFragment = new AddFragment();
                transaction.replace(R.id.side_panel, addFragment, addFragment.toString());
                transaction.commit();
                */
                return true;
            //shows the list of tasks that are completed with a check mark
            case R.id.your_music:
                Toast.makeText(this, "Your Music", Toast.LENGTH_SHORT).show();
                MasterFragment songsFragment = MasterFragment.newInstance();
                //completedFragment.setOnTaskSelectedListener((MasterFragment.OnTaskSelectedListener) this);
                transaction.replace(R.id.list, songsFragment, songsFragment.toString());
                transaction.commit();
                return true;
            //shows the list of tasks that are incomplete without a check mark
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void findMatch(View v) {
        ImageView image = new ImageView(this);
        image.setImageResource(R.mipmap.ic_launcher);
        AlertDialog.Builder builder = new AlertDialog.Builder(
                MatchActivity.this);

        // Setting Dialog Title
        builder.setTitle("Match Found!");
        builder.setView(image);
        // Setting Dialog Message
        builder.setMessage("All We Do - Trey Songz \n AND \n Cabaret - Justin Timberlake ft. Drake");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.show();
        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);
        dialog.show();

    }
}
