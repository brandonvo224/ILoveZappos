package com.example.brand.ilovezappos;

import com.squareup.otto.Bus;

/**
 * Created by brand on 2/8/2017.
 */

public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}

}
