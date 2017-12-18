package com.example.lorence.piggycoin.data.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lorence on 18/12/2017.
 *
 */

@SuppressWarnings("ALL")
public class Ticket {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("rank")
    @Expose
    private Integer rank;

    @SerializedName("price_usd")
    @Expose
    private Double price_usd;

    @SerializedName("price_btc")
    @Expose
    private Double price_btc;

    @SerializedName("24h_volume_usd")
    @Expose
    private Double volume_usd;

    @SerializedName("market_cap_usd")
    @Expose
    private Long market_cap_usd;

    @SerializedName("available_supply")
    @Expose
    private Double available_supply;

    @SerializedName("total_supply")
    @Expose
    private Double total_supply;

    @SerializedName("max_supply")
    @Expose
    private Double max_supply;

    @SerializedName("percent_change_1h")
    @Expose
    private Double percent_change_1h;

    @SerializedName("percent_change_24h")
    @Expose
    private Double percent_change_24h;

    @SerializedName("percent_change_7d")
    @Expose
    private Double percent_change_7d;

    @SerializedName("last_updated")
    @Expose
    private Long last_updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getPriceUsd() {
        return price_usd;
    }

    public void setPriceUsd(Double price_usd) {
        this.price_usd = price_usd;
    }

    public Double getpriceBtc() {
        return price_btc;
    }

    public void setPriceBtc(Double price_btc) {
        this.price_btc = price_btc;
    }

    public Double getvolumeUsd() {
        return volume_usd;
    }

    public void setVolumeUsd(Double volume_usd) {
        this.volume_usd = volume_usd;
    }

    public Long getMarketCapUsd() {
        return market_cap_usd;
    }

    public void setMarketCapUsd(Long market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public Double getAvailableSupply() {
        return available_supply;
    }

    public void setAvailableSupply(Double available_supply) {
        this.available_supply = available_supply;
    }

    public Double getTotalSupply() {
        return total_supply;
    }

    public void setTotalSupply(Double total_supply) {
        this.total_supply = total_supply;
    }

    public Double getMaxSupply() {
        return max_supply;
    }

    public void setMaxSupply(Double max_supply) {
        this.max_supply = max_supply;
    }

    public Double getPercentChange1H() {
        return percent_change_1h;
    }

    public void setPercentChange1H(Double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public Double getPercentChange24H() {
        return percent_change_24h;
    }

    public void setPercentChange24H(Double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public Double getPercentChange7D() {
        return percent_change_7d;
    }

    public void setPercentChange7D(Double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public Long getLastUpdated() {
        return last_updated;
    }

    public void setLastUpdated(Long last_updated) {
        this.last_updated = last_updated;
    }
}
