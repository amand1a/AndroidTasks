package Factory;

public class AirDelivery extends Delivery {

    private String lengthType;

    private String type;

    public AirDelivery(String nameCompany, double maxWeight, double maxDimensioned,String lengthType, String type ){
        this.nameCompany = nameCompany;
        this.maxWeight = maxWeight;
        this.maxDimensions = maxDimensioned;
        this.lengthType =lengthType;
        this.type = type;
    }

    @Override
    public void deliver() {
        System.out.println("Air delivery");
    }
}
