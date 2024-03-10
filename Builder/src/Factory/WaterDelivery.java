package Factory;

import Factory.Delivery;

public class WaterDelivery extends Delivery {
    private String type;

    public WaterDelivery(String nameCompany, double maxWeight, double maxDimensioned, String type){
        this.nameCompany = nameCompany;
        this.maxWeight = maxWeight;
        this.maxDimensions = maxDimensioned;
        this.type = type;
    }
    @Override
   public void deliver() {
        System.out.println("water deliver");
    }
}
