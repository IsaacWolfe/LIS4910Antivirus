package com.antivirus.lis4910.iwolfe.lis4910antivirus;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button websiteBtn = findViewById(R.id.scanPhoneBtn);
        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String webpage = "http://isaacwolfe.net"; // Could be webpage showing how to toggle settings off in security risk apps
                Uri webaddress = Uri.parse(webpage);

                Intent gotoWebpage = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoWebpage.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoWebpage);
                }
            }
        });*/

        Button settingsBtnActivity = findViewById(R.id.settingsBtn);
        settingsBtnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(getApplicationContext(), settingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        Button viewListBtnActivity = findViewById(R.id.viewListBtn);
        viewListBtnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(getApplicationContext(), listActivity.class);
                startActivity(listIntent);
            }
        });
    }

    public void checkApplication (View v){
        EditText inputApp = findViewById(R.id.appNameEditText);
        String input = inputApp.getText().toString().toLowerCase();
        if (input == "test") {
            TextView status = findViewById(R.id.statusTextView);
            status.setText("Infected");
            status.setTextColor(Color.RED);
        }
        else {
            TextView status = findViewById(R.id.statusTextView);
            status.setText("Clean");
            status.setTextColor(Color.GREEN);
        }
    }


    public void readStorage(View v){
        if (checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == (getPackageManager().PERMISSION_GRANTED)) {
            Toast myToast = Toast.makeText(getApplicationContext(), "Access granted!", Toast.LENGTH_LONG);
            myToast.show();
        }
        else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "Storage is wanted to scan applications, not needed.", Toast.LENGTH_LONG).show();
            }
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
    }

    private int checkPermission(String readExternalStorage) {
        return 0;
    }
    //public void onButtonTouch (View v) {
        //Toast myToast = Toast.makeText(getApplicationContext(), "Clean", Toast.LENGTH_LONG);
        //myToast.show();
    //}
}
