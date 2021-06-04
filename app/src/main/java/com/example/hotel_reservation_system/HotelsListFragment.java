package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelsListFragment extends Fragment {

    View view;
    TextView headingTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //heading text view
        headingTextView = view.findViewById(R.id.heading_text_view);

        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuests = getArguments().getString("number of guests");

        //Set up the header
        headingTextView.setText("Welcome user, displaying hotel for " + numberOfGuests + " guests staying from " + checkInDate +
                " to " + checkOutDate);


        // Set up the RecyclerView
        ArrayList<HotelListData> hotelListData = initHotelListData();
        RecyclerView recyclerView = view.findViewById(R.id.hotel_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelListAdapter hotelListAdapter= new HotelListAdapter(getActivity(), hotelListData);
        recyclerView.setAdapter(hotelListAdapter);
    }

    public ArrayList<HotelListData> initHotelListData() {
        ArrayList<HotelListData> list = new ArrayList<>();

        list.add(new HotelListData("Halifax Regional Hotel", "2000$", "true"));
        list.add(new HotelListData("Hotel Pearl", "500$", "false"));
        list.add(new HotelListData("Hotel Amano", "800$", "true"));
        list.add(new HotelListData("San Jones", "250$", "false"));
        list.add(new HotelListData("Halifax Regional Hotel", "2000$", "true"));
        list.add(new HotelListData("Hotel Pearl", "500$", "false"));
        list.add(new HotelListData("Hotel Amano", "800$", "true"));
        list.add(new HotelListData("San Jones", "250$", "false"));

        return list;
    }
}
