/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author Berkay BADANOZ
 */
public class Vegetable extends Crop implements Comparable {
    CropKeeper cropKeeper;
    private int cropKeeperID;
    Supplier sup;
    Store s;
    private String cultivatedRegion;
    
    public Vegetable(String cultivatedRegion, String name, int weight, String cultivatedSeason,String type) {
        super(name, weight, cultivatedSeason ,type);
        this.cultivatedRegion = cultivatedRegion;
        cropKeeperID = sup.getID();
    }

    @Override
    public String toString() {
        return name +","+type+ ","+weight+","+cultivatedRegion +","+cropKeeperID;
    }
    @Override
    public void consumeIt() {
        System.out.println("Vegetables are cooked.");
    }

    @Override
    public void storeIt() throws CapacityNotEnoughException , CanNotBeStoredException{
            System.out.println("Vegetables can not store");
        
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;
    if(o instanceof Fruit){
        if(((Vegetable) o).name.equals(this.name)){
            
        }else{
        result = abs(((Fruit) o).weight - this.weight);
    }
    }
    return result;
    }

    

    

    

    
    
}
    
    
    



