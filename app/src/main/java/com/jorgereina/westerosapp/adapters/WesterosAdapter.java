package com.jorgereina.westerosapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jorgereina.westerosapp.R;
import com.jorgereina.westerosapp.models.Westero;

import java.util.List;

public class WesterosAdapter extends RecyclerView.Adapter<WesterosAdapter.ViewHolder> {

    private Context context;
    private List<Westero> westeroList;

    public WesterosAdapter(Context context, List<Westero> westeroList) {
        this.context = context;
        this.westeroList = westeroList;
    }

    @Override
    public WesterosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WesterosAdapter.ViewHolder holder, int position) {

        Westero westero = westeroList.get(position);

        holder.nameTv.setText(westero.getName());
        holder.ratingTv.setText(westero.getAttackerCommander());
        holder.strengthTv.setText(westero.getName());
    }

    @Override
    public int getItemCount() {
        return westeroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        TextView ratingTv;
        TextView strengthTv;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.name_tv);
            ratingTv = (TextView) itemView.findViewById(R.id.rating_tv);
            strengthTv = (TextView) itemView.findViewById(R.id.strength_tv);
        }
    }
}
