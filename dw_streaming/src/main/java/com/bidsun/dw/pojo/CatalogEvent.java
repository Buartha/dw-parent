package com.bidsun.dw.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Niuxy
 * @className CatalogEvent
 * @description TODO
 * @date 2021/6/1 17:06
 */
public class CatalogEvent implements Serializable {
    private static final long serialVersionUID = -6637354161064511025L;
    private Map eventMap;


    public Map getEventMap() {
        return eventMap;
    }

    public void setEventMap(Map eventMap) {
        this.eventMap = eventMap;
    }


}
