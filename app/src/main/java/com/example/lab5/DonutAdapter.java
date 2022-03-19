package com.example.lab5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DonutAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Donut> donutList;
    private List<Donut>donutListFilter;
    private int positionSelect = -1;

    public DonutAdapter(Context context, int idLayout, List<Donut> donutList) {
        this.context = context;
        this.idLayout = idLayout;
        this.donutList = donutList;
        this.donutListFilter = donutList;
    }

    @Override
    public int getCount() {
        if (donutListFilter.size() != 0 && !donutListFilter.isEmpty()) {
            return donutListFilter.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);

        }
        TextView txtTitle = (TextView) view.findViewById(R.id.txtName);
        TextView txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        TextView txtPrice = (TextView) view.findViewById(R.id.txtPrice);

        ImageView imgDonut = (ImageView) view.findViewById(R.id.logo);

        final ConstraintLayout linerLayout = view.findViewById(R.id.idContraint);

        final  com.example.lab5.Donut donut = donutListFilter.get(i);

        if(donutListFilter != null && !donutListFilter.isEmpty()){
            txtTitle.setText(donut.getTvDonut());
            txtDescription.setText(donut.getTvDescription());
            txtPrice.setText(donut.getTvPrice()+"$");

            int idDonut = donut.getImgDonut();
            switch(idDonut) {
                case 1:
                    imgDonut.setImageResource(R.drawable.donut_red_1);
                    break;
                case 2:
                    imgDonut.setImageResource(R.drawable.donut_yellow_1);
                    break;
                case 3:
                    imgDonut.setImageResource(R.drawable.green_donut_1);
                    break;
                case 4:
                    imgDonut.setImageResource(R.drawable.pink_donut_1);
                    break;
                case 5:
                    imgDonut.setImageResource(R.drawable.tasty_donut_1);
                    break;
                case 6:
                    imgDonut.setImageResource(R.drawable.donut_red_1);
                    break;
                case 7:
                    imgDonut.setImageResource(R.drawable.donut_red_1);
                    break;
                default:
                    break;
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Screen2.class);
                Bundle bundle = new Bundle();
                bundle.putInt("imgDonut", donut.getImgDonut());
                bundle.putString("tvDonut", donut.getTvDonut());
                bundle.putString("tvDescription", donut.getTvDescription());
                bundle.putString("tvPrice", donut.getTvPrice()+"$");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        if(positionSelect == i){
            linerLayout.setBackgroundColor(Color.GRAY);
        }else{
            linerLayout.setBackgroundColor(Color.WHITE);
        }
        return view;
    }

    public void filterDonut(String filter){
        donutListFilter = new ArrayList<>();
        for(Donut donut : donutList){
            if(donut.getTvDonut().toLowerCase().indexOf(filter) != -1){
                donutListFilter.add(donut);
            }
        }
        notifyDataSetChanged();
    }

    public void filterPinkDonut () {
        filterDonut("pink");
    }

    public void filterFloating() {
        filterDonut("floating");
    }
    public void allDonut() {
        donutListFilter = donutList;
        notifyDataSetChanged();
    }

    public void filterByText(Editable text) {
        donutListFilter = new ArrayList<>();
        for(Donut donut: donutList) {
            if(donut.getTvDonut().toLowerCase().indexOf(text.toString()) != -1) {
                donutListFilter.add(donut);
            }
        }
        notifyDataSetChanged();
    }
}
