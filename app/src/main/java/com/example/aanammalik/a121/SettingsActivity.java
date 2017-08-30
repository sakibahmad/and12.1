package com.example.aanammalik.a121;

/**
 * Created by Aanam Malik on 7/16/2017.
 */

import android.widget.Toast;

        import android.annotation.TargetApi;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.preference.PreferenceActivity;
        import android.preference.PreferenceFragment;
        import android.preference.PreferenceManager;
        import android.util.Log;
        import android.widget.Toast;

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener{
    private static int prefs=R.xml.preferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        try {
            getClass().getMethod("getFragmentManager");
            AddResourceApi11AndGreater();
        } catch (NoSuchMethodException e) { //Api < 11
            AddResourceApiLessThan11();
        }

    }

    @SuppressWarnings("deprecation")
    protected void AddResourceApiLessThan11()
    {

        addPreferencesFromResource(prefs);
    }

    @TargetApi(11)
    protected void AddResourceApi11AndGreater()
    {
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PF()).commit();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    @TargetApi(11)
    public static class PF extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(SettingsActivity.prefs); //outer class
            // private members seem to be visible for inner class, and
            // making it static made things so much easier

        }
        @Override
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

        }
        @Override
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            Log.e("key= " , key);
            Toast.makeText(getActivity(), key+"  is changed. ", Toast.LENGTH_SHORT).show();
        }
    }
}
