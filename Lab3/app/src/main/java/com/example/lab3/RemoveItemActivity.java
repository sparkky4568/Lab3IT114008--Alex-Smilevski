package com.example.lab3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@AndroidEntryPoint
public class RemoveItemActivity extends AppCompatActivity {

    @Inject
    StringList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_remove_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void removeItem(View view)
    {
        EditText et;
        int pos;
        String removed_item;

        et = (EditText) findViewById(R.id.edit_remove_position);
        pos = Integer.parseInt(et.getText().toString());

        try
        {
            removed_item = the_list.remove(pos);

            hideKeyboard();
            Snackbar.make(findViewById(R.id.myRemoveCoordinatorLayout),
                    removed_item + " removed from the list",
                    Snackbar.LENGTH_SHORT).show();
        }
        catch(IndexOutOfBoundsException e)
        {
            hideKeyboard();
            Snackbar.make(findViewById(R.id.myRemoveCoordinatorLayout),
                    "Failed to remove item from the list",
                    Snackbar.LENGTH_SHORT).show();
        }
    }

    private void hideKeyboard()
    {
        Context context = getCurrentFocus().getContext();

        InputMethodManager inputMethodManager =
                (InputMethodManager)
                        context.getSystemService(Activity.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null)
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
}