package com.kscar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kscar.R;
import com.kscar.listeners.RvClickListeners;

import java.util.ArrayList;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.PaymentHolder> {

    private Context context;
    private ArrayList<String> listOfPayement;
    private RvClickListeners rvClickListeners;
    private LayoutInflater inflater;
    private LinearLayout llCatainer;
    public PaymentHistoryAdapter(Context context, ArrayList<String> listOfPayement, RvClickListeners rvClickListeners) {
        this.context = context;
        this.listOfPayement = listOfPayement;
        this.rvClickListeners = rvClickListeners;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @NonNull
    @Override
    public PaymentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentHolder(inflater.inflate(R.layout.item_payment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentHolder holder, int position) {
        holder.llCatainer.setOnClickListener(v -> {
            rvClickListeners.onItemclick(holder.llCatainer, position);
        });
    }

    @Override
    public int getItemCount() {
        return listOfPayement.size();
    }

    class PaymentHolder extends RecyclerView.ViewHolder {
        private LinearLayout llCatainer;
        public PaymentHolder(View view) {
            super(view);
            llCatainer = view.findViewById(R.id.llCatainer);
        }
    }
}
