package Facade;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private  Person cache;

    private static CacheManager instance;

    private  CacheManager(){
    }
    public Person getCache() {
        return cache;
    }

    public void setCache(Person cache) {
        this.cache = cache;
    }

    public static CacheManager getInstance() {
        if(instance == null){
            instance = new CacheManager();
        }
        return instance;
    }
}
