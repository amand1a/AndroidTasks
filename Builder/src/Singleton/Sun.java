package Singleton;

public  class Sun {
    private static Sun  instance ;
    private boolean light = false;

    private Sun(boolean light){
        this.light = light;
    }

    static public Sun getInstance(boolean light) {

        if(instance == null){
            instance = new Sun(light);
        }
        return instance;
    }
}
