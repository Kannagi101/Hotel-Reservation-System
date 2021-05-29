package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HotelsListFragment extends Fragment {

    View view;
    TextView headingTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.hotel_list_fragment, container, false);

        //heading text view
        headingTextView = view.findViewById(R.id.heading_text_view);

        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuests = getArguments().getString("number of guests");

        headingTextView.setText("Welcome user, displaying hotel for " +numberOfGuests+ " guests staying from " +checkInDate+ " to " +checkOutDate);
        return view;
    }
}
