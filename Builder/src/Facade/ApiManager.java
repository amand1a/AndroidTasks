package Facade;

import Facade.Person;

public class ApiManager {


    public  Person getData(){
        return  new Person("Anton", 100);
    }
}
