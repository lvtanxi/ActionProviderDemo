package com.example.tmnt.bargemenu;

import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private BargeActionProvider mActionProvider;
    private Button btn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWindowFocusChanged(true);
            }
        });
    }


    //在此方法中进行设置文字数字等
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mActionProvider.setBadge(count++);
        mActionProvider.setIcon(android.R.drawable.ic_input_add);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_image);
        mActionProvider = (BargeActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mActionProvider.setOnClickMeniListener(new BargeActionProvider.OnClickMeniListener() {
            @Override
            public void clickMenu(int what) {
                mActionProvider.setBadge(0);
            }
        }, 0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_image) {
            mActionProvider.setBadge(0);
        }
        return true;
    }
}
