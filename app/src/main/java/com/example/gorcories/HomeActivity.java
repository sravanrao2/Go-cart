package com.example.gorcories;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * This Activity is used for loading the main fragment into the view.
 */
public class HomeActivity extends AppCompatActivity {
    /**
     *
     @param cartview instantiates a layout xml into its corresponding view objects by cart id.
     */
    Button cartview;
    /**
     *This method takes the xml elements ,process them and returns the view.
     @Param savedInstanceState it is used to pass data between the activities.
     @return returns the specified fragments on click of the button.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        cartview = findViewById(R.id.cartview);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        cartview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replacefragment(new Cart());
            }
        });
        replacefragment(new FlyerFragment());
    }
    /**
     *This method takes the onclick elements , process them and returns the fragment accordingly.
     @Param navigationItemSelectedListener it is used to pass data between the activities.
     @param menuItem is used to get the item id on click in the menu for bottom navigation.

     @return returns the specified fragments on click of the button.
     */
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.home:
                    selectedFragment = new FlyerFragment();
                    break;
                case R.id.items:
                    selectedFragment = new ItemsView();
                    break;
                case R.id.profile:
                    selectedFragment = new Profile();

            }
            replacefragment(selectedFragment);
//            getFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
    /**
     *This method takes the Selected fragment from the onNavigationItemSelected method , process them and returns the fragment accordingly.
     @Param fragmenttransaction it is used to pass data to begin the according activity.

     */
    public void replacefragment(Fragment fragment) {
        FragmentManager fg = getFragmentManager();
        FragmentTransaction fragmenttransaction = fg.beginTransaction();
        fragmenttransaction.replace(R.id.fragment_container, fragment).addToBackStack("tag");
        fragmenttransaction.commit();
    }
}
