package mainPackage;

import java.io.Serializable;

public class Bat implements Fly, Serializable {

    @Override
    public void ascend(){
        System.out.println("ascend-emelkedés");
    }

    @Override
    public void descend(){
        System.out.println("descend-ereszkedés");
    }
}
