import Builder.Coffee;
import Facade.Person;
import Facade.PersonDataCacheFacade;
import Factory.Delivery;
import Factory.RailWayDelivery;
import Singleton.Sun;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Coffee firstCoffee = Coffee.builder()
                .coffee(true)
                .doubleCoffee(false)
                .syrup("crimson")
                .build();



        Sun sun1 = Sun.getInstance(false);
        Sun sun2 = Sun.getInstance(true);

        System.out.println(sun1);
        System.out.println(sun2);


        Delivery delivery = new RailWayDelivery("DHl",1000,1000,2,false);
        delivery.deliver();

        Person person1 =  PersonDataCacheFacade.getPersonData();
        System.out.println(person1);

        Person person2 =  PersonDataCacheFacade.getPersonData();
        System.out.println(person2);
    }

}