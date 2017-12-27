package com.example.lorence.rxtutorial.mapper;

import android.util.Log;

import com.example.lorence.rxtutorial.data.model.Cake;
import com.example.lorence.rxtutorial.data.api.response.CakesResponse;
import com.example.lorence.rxtutorial.data.api.response.CakesResponseCakes;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by lorence on 26/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

public class CakeMapper {

    @Inject
    public CakeMapper() {
        Log.i("TAG", "CakeMapper -> CakeMapper(Constructor)");
    }

    public List<Cake> mapCakes(CakesResponse response) {
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakesResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImageUrl(cake.getImage());
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }

}
