package Factory;

public class AutoDelivery extends Delivery {

    public AutoDelivery(String nameCompany, double maxWeight, double maxDimensioned ){
        this.nameCompany = nameCompany;
        this.maxWeight = maxWeight;
        this.maxDimensions = maxDimensioned;

    }

    @Override
    public void deliver() {
        System.out.println("Auto delivery");
    }
}
