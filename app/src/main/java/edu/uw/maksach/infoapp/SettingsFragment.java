package edu.uw.maksach.infoapp;

import android.os.Bundle;
import android.preference.PreferenceFragment;
/**
 * Created by sachinmakaram on 4/23/16.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
