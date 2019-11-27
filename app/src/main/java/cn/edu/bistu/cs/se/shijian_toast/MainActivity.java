package cn.edu.bistu.cs.se.shijian_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button tishi;
    private Button denglu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tishi=findViewById(R.id.tishi);
        tishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"tishiduihuakuang",Toast.LENGTH_SHORT).show();
            }
        });
        denglu=findViewById(R.id.denglu);
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                final View view_custom = inflater.inflate(R.layout.denglu, null,false);
                final EditText zhanghao =view_custom.findViewById(R.id.zhanghao);
                final EditText mima=view_custom.findViewById(R.id.mima);
                builder.setView(view_custom);
                builder.setCancelable(true);
                builder.setTitle("登录");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String use=zhanghao.getText().toString();
                        String password=mima.getText().toString();
                        if(use.equals("abc") && password.equals("123"))
                             Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG)
                                .show();
                        else
                            Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_LONG)
                                    .show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                AlertDialog alert=builder.create();


            }
        });
    }
}
