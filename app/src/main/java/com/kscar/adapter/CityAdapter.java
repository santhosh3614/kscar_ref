package com.kscar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kscar.R;
import com.kscar.listeners.RvClickListeners;
import com.kscar.models.CityListModel;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CarHolder> {

    private Context context;
    private List<CityListModel.ResponseDatum> responseData;
    private RvClickListeners rvClickListeners;
    private LayoutInflater inflater;

    public CityAdapter(Context context, List<CityListModel.ResponseDatum> responseData, RvClickListeners rvClickListeners) {
        this.context = context;
        this.responseData = responseData;
        this.rvClickListeners = rvClickListeners;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarHolder(inflater.inflate(R.layout.item_state, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        CityListModel.ResponseDatum responseDatum = responseData.get(position);
        holder.txtState.setText(responseDatum.getVCityName());
        holder.txtState.setOnClickListener(v -> {
            rvClickListeners.onItemclick(holder.txtState, position);
        });

    }

    @Override
    public int getItemCount() {
        return responseData.size();
    }

    class CarHolder extends RecyclerView.ViewHolder {
        private TextView txtState;
        public CarHolder(View view) {
            super(view);
            txtState = view.findViewById(R.id.txtState);
        }
    }

}
