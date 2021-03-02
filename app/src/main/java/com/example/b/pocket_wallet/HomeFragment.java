package com.example.b.pocket_wallet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;



public class HomeFragment extends Fragment implements View.OnClickListener{
    GridView grid;
    String[] name = {
            "Payments",
            "Insurance",
            "Bill Payments",
            "Money Transfer",
    } ;
    int[] imageId = {
            R.drawable.payment_icon,
            R.drawable.insurance_icon,
            R.drawable.billpayment_icon,
            R.drawable.moneytranser_icon,
    };

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView movieticket = (ImageView) view.findViewById(R.id.movieticket);
        ImageView eventticket = (ImageView) view.findViewById(R.id.eventticket);
        ImageView busticket = (ImageView) view.findViewById(R.id.busticket);
        ImageView discount = (ImageView) view.findViewById(R.id.discount);

        movieticket.setOnClickListener(this);
        eventticket.setOnClickListener(this);
        busticket.setOnClickListener(this);
        discount.setOnClickListener(this);


        CustomGrid adapter = new CustomGrid(getActivity(), name, imageId);
        grid=(GridView) view.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (name[+ position])
                {
                    case "Payments":
                        startActivity(new Intent(getActivity(),Payments.class));
                        break;
                    case "Insurance":
                        startActivity(new Intent(getActivity(),Insurance.class));
                        break;
                    case "Bill Payments":
                        startActivity(new Intent(getActivity(),BillPayments.class));
                        break;
                    case "Money Transfer":
                        startActivity(new Intent(getActivity(),MoneyTransfer.class));
                        break;
                }

            }
        });



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.movieticket:
                startActivity(new Intent(getActivity(),MoviesList.class));
                break;
            case R.id.eventticket:
                startActivity(new Intent(getActivity(),EventList.class));
                break;
            case R.id.busticket:
                startActivity(new Intent(getActivity(),BusList.class));
                break;
            case R.id.discount:
                startActivity(new Intent(getActivity(),DiscountList.class));
                break;
            default:
                break;
        }

    }
}
