package com.example.hotel_reservation_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private ArrayList<HotelListData> hotelListData;
    private LayoutInflater layoutInflater;

    //Data gets passed in the constructor
    HotelListAdapter(Context context, ArrayList<HotelListData> hotelListData){
      this.layoutInflater = LayoutInflater.from(context);
      this.hotelListData = hotelListData;
    }

    @NonNull
    @Override
    public HotelListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelListAdapter.ViewHolder holder, int position) {
        String hotelName = hotelListData.get(position).getHotelName();
        String hotelPrice = hotelListData.get(position).getPrice();
        String hotelAvailability = hotelListData.get(position).getAvailability();

        // set up the text
        holder.hotelName.setText(hotelName);
        holder.hotelAvailability.setText(hotelAvailability);
        holder.hotelPrice.setText(hotelPrice);
    }

    @Override
    public int getItemCount() {
        if (hotelListData != null) {
            return hotelListData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hotelName, hotelPrice, hotelAvailability;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
            hotelPrice = itemView.findViewById(R.id.price_text_view);
            hotelAvailability = itemView.findViewById(R.id.availability_text_view);

        }
    }
}

