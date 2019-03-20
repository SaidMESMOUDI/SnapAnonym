package com.saidus.snapanonym.presentation.presentation.adapter;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saidus.snapanonym.R;
import com.saidus.snapanonym.presentation.model.Snap;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SnapAdapter extends RecyclerView.Adapter <SnapAdapter.SnapItemViewHolder>{
    private List<Snap> nSnaps;
    private Context mContext;
    public SnapAdapter(List<Snap>nSnaps,Context mContext){
        this.nSnaps = nSnaps;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public SnapItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SnapItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.snap_item,viewGroup ,false));
    }
    

    @Override
    public void onBindViewHolder(@NonNull SnapItemViewHolder snapItemViewHolder, int position) {
        Snap currentSnap = nSnaps.get(position);
        snapItemViewHolder.snapDistance.setText(String.valueOf(currentSnap.getDistance()+" "+mContext.getString(R.string.snap_info_sample)));
        Glide.with(mContext).load(Base64.decode(currentSnap.getPicture().getContent(), Base64.DEFAULT)).into(snapItemViewHolder.snapImage);
    }

    @Override
    public int getItemCount() {
        return nSnaps.size();
    }

    public class SnapItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView snapImage;
        private TextView snapDistance;


        public  SnapItemViewHolder(@NonNull View itemView){
            super(itemView);
            snapImage = itemView.findViewById(R.id.snap_image);
            snapDistance = itemView.findViewById((R.id.snap_info));
        }
    }
}
