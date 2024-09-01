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
public class Fruit extends Crop implements Comparable  {
    private int cropKeeperID;
    Store s;
    Supplier sup;
    private String taste;
    private String color;
    private double price;
    
    
    Fruit(){
        
    }

    public Fruit(String name,double price,String taste, String cultivatedSeason, int weight,String type) {
        super(name, weight, cultivatedSeason ,type);
        this.price = price;
        this.taste = taste;
        cropKeeperID = s.getID();
    }

    @Override
    public String toString() {
        return name +","+ type +","+ weight+"," + cultivatedSeason+"," + taste +"," +price +"," + cropKeeperID  ;
    }

    @Override
    public void consumeIt() {
        System.out.println("Fruits are consumed raw");
    }

    @Override
    public void storeIt() throws CapacityNotEnoughException , CanNotBeStoredException{
            if(s.canbeStored(this)){
                s.fruitList.add(this);
            }else{
              throw new CanNotBeStoredException();
            }
        
    }
    public int getCropKeeperId(){
        return cropKeeperID;
        
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;
    if(o instanceof Fruit){
        if(((Fruit) o).color.equals(this.color) && ((Fruit) o).name.equals(this.name)){
            
        }else{
        result = abs(((Fruit) o).weight - this.weight);
    }
    }
    return result;
    }

    public String getColor() {
        return color;
    }
    
    public double getPrice() {
        return price;
    }
    
    
}
     

        

   
       
    



 

  
  

 

