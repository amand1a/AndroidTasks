package Factory;

import Factory.Delivery;

public class RailWayDelivery extends Delivery {

    private  boolean withBallast;
    private  double railwayTrackWidth;

    public RailWayDelivery(String nameCompany, double maxWeight, double maxDimensioned,double railwayTrackWidth, boolean withBallast ){
        this.nameCompany = nameCompany;
        this.maxWeight = maxWeight;
        this.maxDimensions = maxDimensioned;
        this.withBallast = withBallast;
        this.railwayTrackWidth = railwayTrackWidth;
    }

    @Override
    public void deliver() {
        System.out.println("railway delivery");
    }
}
