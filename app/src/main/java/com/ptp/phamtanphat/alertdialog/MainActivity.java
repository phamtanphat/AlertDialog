package com.ptp.phamtanphat.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowAlertDialog,btnSingleChoice,btnMultipleChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMultipleChoice = findViewById(R.id.buttonMultipleChoice);
        btnShowAlertDialog = findViewById(R.id.buttonShowAlertDialog);
        btnSingleChoice = findViewById(R.id.buttonSingleChoice);

        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setTitle(R.string.title_alert_dialog);
                alertdialog.setMessage("Xac nhan ben duoi!!!");
                alertdialog.setIcon(android.R.drawable.stat_sys_warning);

                alertdialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                    }
                });

                alertdialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                alertdialog.setNeutralButton("Huy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Huy!!", Toast.LENGTH_SHORT).show();
                    }
                });
                alertdialog.show();
            }
        });

        btnSingleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder singlechoice = new AlertDialog.Builder(MainActivity.this);
                singlechoice.setTitle("Chon 1 con vat yeu thich");
                singlechoice.setCancelable(false);
                final String[] mangconvat = {"Con meo","Con heo","Con cho","Con ga"};
                singlechoice.setSingleChoiceItems(mangconvat, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, mangconvat[i], Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });

                singlechoice.show();
            }
        });

        btnMultipleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Chon nhung vat lieu xay dung");


                final String[] mangtenvatlieu = {"Sat","Thep","Gach","Go","Xi mang"};
                boolean[] mangchecked = {false,false,false,false,false,false};
                builder.setMultiChoiceItems(mangtenvatlieu,mangchecked,new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        if (b){
                            Toast.makeText(MainActivity.this, "Chon " + mangtenvatlieu[i], Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "Bo chon " + mangtenvatlieu[i], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.show();
            }
        });
    }
}
