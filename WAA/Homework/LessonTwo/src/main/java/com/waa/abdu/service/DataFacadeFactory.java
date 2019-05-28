package com.waa.abdu.service;

import com.waa.abdu.com.waa.abdu.iservice.DataFacade;

/**
 * Returns an implementation of a DataFacade.
 * Could be TestDataImpl or ProdDataImpl, depending on
 * input argument.
 *
 * Input argument can be "dev" or "prod"
 */

public class DataFacadeFactory {

    public DataFacade getDataFacadeInstance(String type) {
        if(type.equals("dev")) {
            return  TestDataImpl.INSTANCE;
        }
//		if(type.equals("prod")){
//			return ProdDataImpl.INSTANCE
//		}
        return null;
    }

}
