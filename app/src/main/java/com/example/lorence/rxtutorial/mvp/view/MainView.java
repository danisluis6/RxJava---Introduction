package com.example.lorence.rxtutorial.mvp.view;

import com.example.lorence.rxtutorial.data.model.Cake;

import java.util.List;

/**
 * Created by lorence on 25/12/2017.
 *
 * @version version7
 * @since 12/25/2017
 */

public interface MainView extends BaseView {

    void onCakeLoaded(List<Cake> cakes);
}

