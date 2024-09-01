/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop;

import java.util.ArrayList;

/**
 *
 * @author Berkay BADANOZ
 */
public abstract class Crop  {

    Fruit fruit;
    protected String name;
    protected String type;
    protected int weight;
    protected String cultivatedSeason;
    Crop(){
        
    }
    Crop(String name ,int weight ,String cultivatedSeason ,String type){
        this.name = name;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
        this.type = type;
    }
    @Override
    public abstract String toString();
    public abstract void consumeIt();
    public abstract void storeIt() throws CanNotBeStoredException , CapacityNotEnoughException;
    
}
