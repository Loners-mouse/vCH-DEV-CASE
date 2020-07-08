package com.ch.dev.async.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class HbCache {

    private static Map<String,Boolean> hbCache = new ConcurrentHashMap<String, Boolean>(){{
        put("id1",true);
        put("id2",false);
    }};

    public static boolean getHb(String id){
        if(hbCache.containsKey(id)){
            return hbCache.get(id);
        }
        return false;
    }

    public static void putHb(String id,Boolean value){
        hbCache.put(id, value);
    }

    public static void removeHb(String id){
        hbCache.remove(id);
    }
}
