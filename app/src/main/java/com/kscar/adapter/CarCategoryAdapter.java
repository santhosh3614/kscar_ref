package com.kscar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kscar.R;
import com.kscar.listeners.RvClickListeners;
import com.kscar.models.CarCategoryModel;

import java.util.List;

public class CarCategoryAdapter extends RecyclerView.Adapter<CarCategoryAdapter.CarHolder> {


    private Context context;
    private List<CarCategoryModel.ResponseDatum> responseData;
    private RvClickListeners rvClickListeners;
    private LayoutInflater inflater;

    public CarCategoryAdapter(Context context, List<CarCategoryModel.ResponseDatum> responseData, RvClickListeners rvClickListeners) {
        this.context = context;
        this.responseData = responseData;
        this.rvClickListeners = rvClickListeners;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarHolder(inflater.inflate(R.layout.item_car_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        CarCategoryModel.ResponseDatum responseDatum = responseData.get(position);
        Glide.with(context).load(responseDatum.getVCarImage())
                .placeholder(R.drawable.car)
                .into(holder.imgCar);
        holder.txtCar.setText(responseDatum.getVCar());
        holder.rlItemCar.setOnClickListener(v -> {
            rvClickListeners.onItemclick(holder.rlItemCar, position);
        });
    }

    @Override
    public int getItemCount() {
        return responseData.size();
    }

    class CarHolder extends RecyclerView.ViewHolder {
        private RelativeLayout rlItemCar;
        private ImageView imgCar;
        private TextView txtCar;

        public CarHolder(View view) {
            super(view);
            rlItemCar = view.findViewById(R.id.rlItemCar);
            imgCar = view.findViewById(R.id.imgCar);
            txtCar = view.findViewById(R.id.txtCar);
        }


    }

}
