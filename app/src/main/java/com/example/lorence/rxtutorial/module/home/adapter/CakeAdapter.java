package com.example.lorence.rxtutorial.module.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lorence.rxtutorial.R;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.ViewHolder>{

    private LayoutInflater mLayoutInflater;

    public CakeAdapter(LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.list_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
