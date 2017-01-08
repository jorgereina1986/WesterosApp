package com.jorgereina.westerosapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgereina.westerosapp.R;
import com.jorgereina.westerosapp.activities.DetailsActivity;
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

        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WesterosAdapter.ViewHolder holder, final int position) {

        Westero westero = westeroList.get(position);

        holder.nameTv.setText(westero.getAttackerKing());
        holder.ratingTv.setText(westero.getAttackerCommander());
        holder.strengthTv.setText(westero.getName());
        //click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                view.getContext().startActivity(intent);
            }
        });
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
