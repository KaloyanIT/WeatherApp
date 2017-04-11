package com.example.kaloyan.weatherapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kaloyan.weatherapp.data.WeatherData;
import com.example.kaloyan.weatherapp.models.Weather;
import com.example.kaloyan.weatherapp.utils.Constants;
import com.example.kaloyan.weatherapp.views.daily.DailyContracts;
import com.example.kaloyan.weatherapp.views.daily.DailyPresenter;
import com.example.kaloyan.weatherapp.views.drawer.FragmentDrawer;
import com.example.kaloyan.weatherapp.views.daily.DailyView;
import com.example.kaloyan.weatherapp.views.weekly.WeeklyContracts;
import com.example.kaloyan.weatherapp.views.weekly.WeeklyPresenter;
import com.example.kaloyan.weatherapp.views.weekly.WeeklyView;
import com.example.kaloyan.weatherapp.views.home.HomeView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private DailyContracts.Presenter dailyPresenter;
    public Weather weather;
    private WeeklyContracts.Presenter weeklyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = Constants.BASE_URL;

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        displayView(0);


        WeatherData data = new WeatherData(url);
        data.getAllInfoWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<Weather, String>() {
                    @Override
                    public String apply(Weather weather) throws Exception {
                        weather = weather;
                        //TextView tv_title = (TextView) findViewById(R.id.my_textview) ;
                        //tv_title.setText(weather.daily.summary);
                        return weather.daily.summary;
                    }
                })
                .subscribe();
    }

    public Weather getData() {
        if(this.weather != null) {
            return this.weather;
        }
        return null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeView();
                title = getString(R.string.title_home);
                break;
            case 1:
                DailyView dailyView = new DailyView();
                this.dailyPresenter = new DailyPresenter(dailyView);
                fragment = (Fragment) this.dailyPresenter.getView();
                title = getString(R.string.title_daily);
                break;
            case 2:
                WeeklyView weeklyView = new WeeklyView();
                this.weeklyPresenter = new WeeklyPresenter(weeklyView);
                fragment = (Fragment) this.weeklyPresenter.getView();
                title = getString(R.string.title_weekly);
            default:
                break;
        }

        if(fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
