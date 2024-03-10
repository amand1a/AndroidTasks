package Facade;

public class PersonDataCacheFacade {


    public  static Person getPersonData(){

        CacheManager cacheManager =  CacheManager.getInstance();
        Person person = cacheManager.getCache();

        if(person == null){
            ApiManager apiManager = new ApiManager();
            person = apiManager.getData();
            cacheManager.setCache(person);

        }

        return person;
    }
}
