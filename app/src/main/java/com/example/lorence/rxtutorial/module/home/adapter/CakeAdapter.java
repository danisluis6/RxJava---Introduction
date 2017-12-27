package com.example.lorence.rxtutorial.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lorence.rxtutorial.R;
import com.example.lorence.rxtutorial.data.model.Cake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.ViewHolder>{

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<Cake> mCakeList = new ArrayList<>();

    public CakeAdapter(Context context, LayoutInflater inflater) {
        mContext = context;
        mLayoutInflater = inflater;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /** Get it from Module/Component */
        // private Context mContext;

        @Bind(R.id.cake_icon)
        ImageView imvCakeIcon;

        @Bind(R.id.textview_title)
        TextView tvTitle;

        @Bind(R.id.textview_preview_description)
        TextView tvDescription;

        ViewHolder(View itemView) {
            super(itemView);
            // mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        void bindView(Cake cake) {
            tvTitle.setText(cake.getTitle());
            tvDescription.setText(cake.getPreviewDescription());
            Glide.with(mContext).load(cake.getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imvCakeIcon);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.list_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(mCakeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCakeList.size();
    }

    public void addCakes(List<Cake> cakes) {
        mCakeList.addAll(cakes);
        notifyDataSetChanged();
    }

}
