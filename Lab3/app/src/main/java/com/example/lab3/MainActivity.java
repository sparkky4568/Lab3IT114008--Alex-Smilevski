package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    StringList the_list;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        tv = (TextView) findViewById(R.id.text_main);

        if(the_list.isEmpty())
        {
            the_list.add(the_list.size(), "pizza");
            the_list.add(the_list.size(), "crackers");
            the_list.add(the_list.size(), "peanut butter");
            the_list.add(the_list.size(), "jelly");
            the_list.add(the_list.size(), "bread");
            the_list.add(the_list.size(), "spaghetti");
        }
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

    public void onOption1(MenuItem i)
    {
        int j;

        tv.setText("");

        for(j = 0; j < the_list.size(); j++)
            tv.append(the_list.get(j) + '\n');
    }

    public void onOption2(MenuItem i)
    {
        int j;

        tv.setText("");

        for(j = the_list.size() - 1; j >= 0; j--)
            tv.append(the_list.get(j) + '\n');
    }

    public void onOption3(MenuItem i)
    {
        tv.setText("The list contains " + the_list.size() + " item(s).");
    }

    public void onOption4(MenuItem i)
    {
        startActivity(new Intent(this, AddItemActivity.class));
    }

    public void onOption5(MenuItem i)
    {
        startActivity(new Intent(this, RemoveItemActivity.class));
    }

    public void onOption6(MenuItem i)
    {
        the_list.clear();
        tv.setText("All items have been removed from the list.");
    }
}