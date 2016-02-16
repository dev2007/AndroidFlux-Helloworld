package com.awu.androidflux.activity;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.awu.androidflux.R;
import com.awu.androidflux.actions.ActionsCreator;
import com.awu.androidflux.dispatcher.Dispatcher;
import com.awu.androidflux.stores.MessageStore;
import com.awu.androidflux.stores.Store;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    private Dispatcher dispatcher;
    private ActionsCreator actionsCreator;
    private MessageStore store;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               actionsCreator.sendMessage("Click"+count++);
            }
        });

        dispatcher = Dispatcher.get();
        actionsCreator = ActionsCreator.get(dispatcher);
        store = new MessageStore();
        dispatcher.register(store);
    }

    @Override
    protected void onResume() {
        super.onResume();
        store.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        store.unRegister(this);
    }

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event) {
        Toast.makeText(this,store.getMessage(),Toast.LENGTH_SHORT).show();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
