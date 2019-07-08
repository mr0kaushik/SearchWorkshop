package com.mr0kaushik.goworkshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mr0kaushik.goworkshop.R;
import com.mr0kaushik.goworkshop.models.Workshop;

import java.util.List;

public class WorkShopAdapter extends RecyclerView.Adapter<WorkShopAdapter.WorkshopViewHolder>{

    private Context context;
    private List<Workshop> workshopList;

    public WorkShopAdapter(Context context, List<Workshop> workshopList) {
        this.context = context;
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public WorkshopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.workshop_item_layout, null);
        return new WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopViewHolder holder, int position) {

        Workshop workshop = workshopList.get(position);

        holder.tvTitle.setText(workshop.getWorkshopTitle());
        holder.tvOrganisationName.setText(workshop.getWorkshopOrganiser());
        holder.tvDesc.setText(workshop.getWorkshopDescription());
        holder.tvLocation.setText(workshop.getCityName());
        holder.tvStartDate.setText(workshop.getStartDate());
        holder.tvDuration.setText(workshop.getWorkshopDuration());
        holder.tvApplyBy.setText(workshop.getApplyBy());

    }


    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    class WorkshopViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvOrganisationName, tvDesc;
        TextView tvLocation, tvStartDate, tvDuration, tvApplyBy;

        WorkshopViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOrganisationName = itemView.findViewById(R.id.tvOrganisation);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvStartDate = itemView.findViewById(R.id.tvStartDate);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvApplyBy = itemView.findViewById(R.id.tvApplyBy);

        }

    }

}
