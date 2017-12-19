package com.example.lorence.piggycoin.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lorence.piggycoin.R;
import com.example.lorence.piggycoin.adapters.TickerAdapter.ViewHolder;
import com.example.lorence.piggycoin.data.retrofit.response.Ticker;
import com.example.lorence.piggycoin.preferences.OverrideFonts;
import com.example.lorence.piggycoin.preferences.OverrideFonts.TYPE_FONT_NAME;
import com.example.lorence.piggycoin.preferences.OverrideFonts.TYPE_STYLE;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lorence on 19/12/2017.
 */

@SuppressWarnings("ALL")
public class TickerAdapter extends Adapter<ViewHolder> {

    private Context mContext;
    private List<Ticker> mGroupTickers;

    public TickerAdapter(Context context, List<Ticker> groupReminders) {
        mContext = context;
        mGroupTickers = groupReminders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item_currency, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final Ticker ticker = mGroupTickers.get(position);
        viewHolder.tvItemCurrency.setText(ticker.getId());
    }

    @Override
    public int getItemCount() {
        return mGroupTickers.size();
    }

    public void setTickers(List<Ticker> tickers) {
        mGroupTickers = tickers;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvItemCurrency)
        TextView tvItemCurrency;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            initAttributes();
        }

        void initAttributes() {
            tvItemCurrency.setTypeface(OverrideFonts.getTypeFace(mContext, TYPE_FONT_NAME.HELVETICANEUE, TYPE_STYLE.LIGHT));
        }
    }
}
