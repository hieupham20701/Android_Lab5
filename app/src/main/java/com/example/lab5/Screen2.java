package com.example.lab5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("imgDonut", 1);
        String title = bundle.getString("tvDonut", "test1");
        String desciption = bundle.getString("tvDescription", "test1");
        String price = bundle.getString("tvPrice", "test1");
        System.out.println(title);
        System.out.println(title);
        System.out.println(title);
        TextView tvTitle = (TextView) findViewById(R.id.txtNameDetal);
        TextView tvdesciption = (TextView) findViewById(R.id.txtDesDetail);
        TextView tvprice = (TextView) findViewById(R.id.txtPriceDetail);
        tvTitle.setText(title);
        tvdesciption.setText(desciption);
        tvprice.setText(price);
        ImageView imageView = (ImageView) findViewById(R.id.imgDonutDetail1);
        switch (id) {
            case 1:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.tasty_donut_1);
                break;
            case 3:
                imageView.setImageResource(R.drawable.green_donut_1);
                break;
            case 4:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 5:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 6:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 7:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 8:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            default:
                break;
        }
    }
}
