package com.example.user.joe102703;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int tmp, ch=-1;
    boolean chks[] = new boolean[4];
    boolean tmps[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是標題");
        builder.setMessage("內文");
        //確定
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"按了確定",Toast.LENGTH_SHORT).show();
            }
        });
        //取消
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"按了取消",Toast.LENGTH_SHORT).show();
            }
        });
        //略過
        builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"按了略過",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("這是標題");
        builder.setMessage("內文");
        //new 一個EditText
        final EditText ed = new EditText(MainActivity.this);
        //將EditText set進 dialog
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"輸入為"+ed.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

    }
    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選一");
        //tmp = ch;
        //singlechoice
        builder.setSingleChoiceItems(R.array.drinks, tmp, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = which;
            }
        });


        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(tmp >= 0 )
                {
                String[] str = getResources().getStringArray(R.array.drinks);
                TextView tv = (TextView) findViewById(R.id.textView);
                ch = tmp;
                tv.setText(str[ch]);
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();



    }
    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選一");
        //setItem
        builder.setItems(R.array.drinks, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] str = getResources().getStringArray(R.array.drinks);
                TextView tv2 = (TextView) findViewById(R.id.textView2);
                tv2.setText(str[which]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();

    }
    public void click5(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選多");
        tmps = chks.clone();
        builder.setMultiChoiceItems(R.array.drinks, tmps, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chks = tmps.clone();
                String[] str = getResources().getStringArray(R.array.drinks);
                TextView tv3 = (TextView) findViewById(R.id.textView3);
                StringBuilder sb = new StringBuilder();
                for (int i=0;i<=3;i++)
                {
                    if (chks[i])
                    {
                        sb.append(str[i] + ",");
                    }
                }

                tv3.setText(sb);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmps = chks.clone();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自定");

        builder.setView(R.layout.layout1);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按略過", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void click7(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自定");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View myview = inflater.inflate(R.layout.layout1, null);
        Button btn = (Button) myview.findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(myview);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按略過", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
