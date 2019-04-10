package com.example.secondapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.view.Window;

import com.example.secondapp.Sarasas.SarasasFragment;


public class MainActivity extends FragmentActivity implements SettingsView, MainFragmentCallBack {
    private SettingsPresenter presenter;
    // fragment tag numbers pages declaration
    public static final int MAIN_TAG = 1;
    public static final int SARASAS_TAG = 4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_activity_layout);
       // ButterKnife.bind(this);


        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            Fragment firstFragment = MainFragment.newInstance(new Bundle());

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }



    }
    public void goNextFragment(int tag_id, String params) {
        Fragment nextFragment = null;

        switch (tag_id){
            case MAIN_TAG:
                nextFragment = MainFragment.newInstance(getIntent().getExtras());
                break;
            case SARASAS_TAG:
                nextFragment = SarasasFragment.newInstance(getIntent().getExtras());
                break;

        }
        if (nextFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    //.replace(R.id.fragment_container, nextFragment)
                    .setCustomAnimations(R.anim.from_right_to_left, R.anim.fragment_static_fade_out, R.anim.fragment_static_fade_in, R.anim.from_left_to_right)
                    //.setCustomAnimations(R.anim.fragment_static_fade_in, R.anim.from_left_to_right, android.R.anim.fade_in, R.anim.from_left_to_right)
                    //.setCustomAnimations(R.anim.from_right_to_left, R.anim.from_left_to_right)
                    .replace(R.id.fragment_container, nextFragment)
                    .commit();
        }
    }


}
