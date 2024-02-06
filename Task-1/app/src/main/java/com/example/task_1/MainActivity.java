package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaration
    private Button btnOn, btnOff;

    private CameraManager camMan;
    private String CamID;
    private boolean isTorchOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);

        isTorchOn = false;

        /**
         * Check if device contains flashlight
         *
         * if not then exit from screen
         *
         */

        Boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (isFlashAvailable) {
            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
            alert.setTitle(getString(R.string.app_name));
            alert.setMessage(getString(R.string.msg_error));
            alert.setButton(
                    DialogInterface.BUTTON_POSITIVE,
                    getString(R.string.lbl_ok),
                    new DialogInterface.OnClickListener(){
                        public void onClick (DialogInterface dialog, int which ) {
                            finish();
                        }
                    });
            alert.show();
            return;
        }

        camMan = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try
        {
            CamID = camMan.getCameraIdList()[0];

        } catch (CameraAccessException e)
        {
            e.printStackTrace();
        }


        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    lightON();
                    isTorchOn = true;

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    lightOff();
                    isTorchOn = false;

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }

    public void lightON()
    {
        try
        {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                camMan.setTorchMode(CamID, true);
                Toast.makeText(MainActivity.this, "Torched Switched On.", Toast.LENGTH_LONG).show();
                btnOn.setVisibility(View.INVISIBLE);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public  void lightOff()
    {
        try
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                camMan.setTorchMode(CamID, false);
                Toast.makeText(MainActivity.this, "Torched Switched Off.", Toast.LENGTH_LONG).show();
                btnOn.setVisibility(View.INVISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isTorchOn) {
            lightOff();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isTorchOn) {
            lightOff();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isTorchOn) {
            lightON();
        }
    }
}