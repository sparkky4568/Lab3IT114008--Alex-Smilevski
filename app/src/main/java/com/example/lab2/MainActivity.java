package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editFile;
    private TextView textMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        editFile = (EditText) findViewById(R.id.edit_file);
        textMain = (TextView) findViewById(R.id.text_main);
    }

    public void displayBoats(View view) {
        try {
            String urlStr = editFile.getText().toString();
            URL url = new URL(urlStr);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            Boat boat1 = new Boat();
            Boat boat2 = new Boat();
            Boat boat3 = new Boat();

            boat1.setMake(reader.readLine());
            boat1.setModel(reader.readLine());
            boat1.setYear(Integer.parseInt(reader.readLine()));
            boat1.setLength(Double.parseDouble(reader.readLine()));
            boat1.setEngineType(reader.readLine());
            boat1.setPrice(Double.parseDouble(reader.readLine()));

            boat2.setMake(reader.readLine());
            boat2.setModel(reader.readLine());
            boat2.setYear(Integer.parseInt(reader.readLine()));
            boat2.setLength(Double.parseDouble(reader.readLine()));
            boat2.setEngineType(reader.readLine());
            boat2.setPrice(Double.parseDouble(reader.readLine()));

            boat3.setMake(reader.readLine());
            boat3.setModel(reader.readLine());
            boat3.setYear(Integer.parseInt(reader.readLine()));
            boat3.setLength(Double.parseDouble(reader.readLine()));
            boat3.setEngineType(reader.readLine());
            boat3.setPrice(Double.parseDouble(reader.readLine()));

            reader.close();

            double avgLength = (boat1.getLength() + boat2.getLength() + boat3.getLength()) / 3.0;
            double avgPrice = (boat1.getPrice() + boat2.getPrice() + boat3.getPrice()) / 3.0;

            DecimalFormat lengthFormat = new DecimalFormat("0.0");
            DecimalFormat priceFormat = new DecimalFormat("$#,##0.00");

            StringBuilder result = new StringBuilder();
            result.append("Boat 1:\n").append(boat1.toString()).append("\n");
            result.append("Boat 2:\n").append(boat2.toString()).append("\n");
            result.append("Boat 3:\n").append(boat3.toString()).append("\n");
            result.append("Average Length: ").append(lengthFormat.format(avgLength)).append(" feet\n");
            result.append("Average Price: ").append(priceFormat.format(avgPrice));

            textMain.setText(result.toString());

        } catch (Exception e) {
            textMain.setText("Error: " + e.getMessage());
        }
    }
}