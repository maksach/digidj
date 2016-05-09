package edu.uw.maksach.infoapp;

//author: Sachin Makaram

import android.database.Cursor;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.LoaderManager;
import java.util.Date;
import android.widget.SimpleCursorAdapter.ViewBinder;

//author: Sachin Makaram

//class that creates the list of tasks in the left hand side panel
public class MasterFragment extends Fragment {

    OnTaskSelectedListener onTaskSelectedListener;
    //implements ontaskselectedlistener interface to show the details of a selected task
    public interface OnTaskSelectedListener {
        void onTaskSelected(int id, String title, String description, int deadline, int completed, int created);
    }
    public void setOnTaskSelectedListener(OnTaskSelectedListener listener) {
        onTaskSelectedListener = listener;
    }
    //private fields
    private static final String TAG = "MasterFragment";

    public MasterFragment() {
        //empty constructor
    }

    //new instance of a list if the user clicks the show completed option from the menu
    //method is passed a boolean of whether or not each task in the master fragment list view
    //is checked or not
    public static MasterFragment newInstance() {
        MasterFragment fragment = new MasterFragment();
        Bundle bundle = new Bundle();
        //specify any arguments we want to give to the fragment. These can also come from the method params
        fragment.setArguments(bundle);
        return fragment;
    }

    //once the master fragment first shows
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    //set the simple cursor adapter of the list view
    //sets the adapter equal to the input given by the user (recipient address and body)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        //String[] some_array = getResources().getStringArray(R.array.songs_array);

        View rootView = inflater.inflate(R.layout.fragment_master, parent, false);
        return rootView;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}
