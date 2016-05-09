package edu.uw.maksach.infoapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add initall fragments to each pane
        MasterFragment songsFragment = MasterFragment.newInstance();
        //songsFragment.setOnTaskSelectedListener((MasterFragment.OnTaskSelectedListener) this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.list, songsFragment, "MasterFragment");
        ft.commit();
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
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (item.getItemId()) {
            //sorts the list by date created
            case R.id.match_songs:
                Toast.makeText(this, "Match Songs", Toast.LENGTH_SHORT).show();
                Intent matchIntent = new Intent(MainActivity.this, MatchActivity.class);
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
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
