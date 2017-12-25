
package com.example.lorence.rxtutorial.mvp.module;

import javax.annotation.Generated;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CakesResponse {

    private String product;
    private CakesResponseStaffContacts[] staffContacts;
    private String releaseDate;
    private CakesResponseCakes[] cakes;
    private int version;

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public CakesResponseStaffContacts[] getStaffContacts() {
        return this.staffContacts;
    }

    public void setStaffContacts(CakesResponseStaffContacts[] staffContacts) {
        this.staffContacts = staffContacts;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public CakesResponseCakes[] getCakes() {
        return this.cakes;
    }

    public void setCakes(CakesResponseCakes[] cakes) {
        this.cakes = cakes;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
