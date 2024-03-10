package Builder;

public class Coffee {
    private boolean coffee;

    private boolean doubleCoffee;

    private double milk;

    private double cream;

    private int sugar;

    private double cinnamon;

    private String syrup;


    public Coffee(boolean coffee, boolean doubleCoffee, double milk, double cream, int sugar, double cinnamon , String syrup){
        this.coffee = coffee;
        this.doubleCoffee = doubleCoffee;
        this.milk = milk;
        this.cream = cream;
        this.sugar  = sugar;
        this.cinnamon = cinnamon;
        this.syrup  = syrup;
    }


    public static CoffeeBuilder builder(){
        return  new CoffeeBuilder();
    }

    public static class  CoffeeBuilder{

        private boolean coffee= false;

        private boolean doubleCoffee = false;

        private double milk = 0;

        private double cream = 0;

        private int sugar  = 0;

        private double cinnamon = 0.0;

        private String syrup = null;

        public CoffeeBuilder coffee(boolean coffee){
            this.coffee = coffee;
            return this;
        }
        public CoffeeBuilder doubleCoffee(boolean doubleCoffee){
            this.doubleCoffee = doubleCoffee;
            return this;
        }
        public CoffeeBuilder milk(double milk){
            this.milk = milk;
            return this;
        }
        public CoffeeBuilder cream(double cream){
            this.cream = cream;
            return this;
        }
        public CoffeeBuilder sugar(int sugar){
            this.sugar = sugar;
            return this;
        }

        public CoffeeBuilder cinnamon(int cinnamon){
            this.cinnamon = cinnamon;
            return this;
        }

        public CoffeeBuilder syrup(String syrup){
            this.syrup = syrup;
            return this;
        }

        public Coffee build(){
            return new Coffee(coffee, doubleCoffee, milk, cream, sugar,cinnamon, syrup);
        }
    }

}
