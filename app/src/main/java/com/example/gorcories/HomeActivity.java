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

public class HomeActivity extends AppCompatActivity {

    Button cartview;

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
    }
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

    public void replacefragment(Fragment fragment) {
        FragmentManager fg = getFragmentManager();
        FragmentTransaction fragmenttransaction = fg.beginTransaction();
        fragmenttransaction.replace(R.id.fragment_container, fragment).addToBackStack("tag");
        fragmenttransaction.commit();
    }
}
