/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop;

import java.util.ArrayList;

public class Store implements CropKeeper{
    private String name;
    private int ID ;
    private double maxCapacityArea;
    private double usedCapacityArea;
    private int KGperSquareMeter = 10;
    public ArrayList <Fruit> fruitList = new ArrayList <>();

    public Store (){
        
    }
    public Store( String name,double maxCapacityArea , int KGperSquareMeter ) {
        ID = (int)(Math.random()*5000)+1000;
        this.name = name;
        this.maxCapacityArea = maxCapacityArea;
        this.KGperSquareMeter = KGperSquareMeter;
        
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }
    
    public String getName(){
        return name;
    }
    public int getID() {
        return ID;
    }

    public double getMaxCapacityArea() {
        return maxCapacityArea;
    }

    public int getKGperSquareMeter() {
        return KGperSquareMeter;
    }

    
    public double avaliableCapacity(){
        return maxCapacityArea - usedCapacityArea;
    }
    public boolean canbeStored(Fruit f) throws CapacityNotEnoughException{
        boolean result = false;
        for (int i = 0; i < fruitList.size(); i++) {
            if(fruitList.get(i).compareTo(f) == 0){
                if(f.weight + fruitList.get(i).weight > KGperSquareMeter*avaliableCapacity()){
                    throw new CapacityNotEnoughException();
                    
                }else{
                    result = true;
                }
            }else{
                if(f.weight > KGperSquareMeter*avaliableCapacity()){
                    throw new CapacityNotEnoughException();
                }else{
                    result = true;
                }
            }
        }
        return result;
    }
    public void importCrop(Fruit f) throws CapacityNotEnoughException{
        if(canbeStored(f)){
            for (int i = 0; i < fruitList.size(); i++) {
                if(fruitList.get(i).compareTo(f) == 0){
                    fruitList.get(i).weight += f.weight;
                    usedCapacityArea = (usedCapacityArea + fruitList.get(i).weight * KGperSquareMeter);
                    break;
                }else{
                    fruitList.add(f);
                    usedCapacityArea = (usedCapacityArea + fruitList.get(i).weight * KGperSquareMeter);
                    break;
                }
            }
        }
    }
    public void exportCrop(Fruit f) throws FruitNotFoundException{
        for (int i = 0; i < fruitList.size(); i++) {
                if(fruitList.contains(f)){
                    fruitList.remove(f);
                    usedCapacityArea = usedCapacityArea - (fruitList.get(i).weight * this.KGperSquareMeter) ; 
                    break;
            }else{
                    throw new FruitNotFoundException();
                }
        }
    }
    @Override
    public void howToStore() {
        System.out.println("Fruits in large refrigerated cooler rooms ");
        System.out.println("Vegetables in sheds, not listed");
    }

    @Override
    public String toString() {
        return "Store{" + "name=" + name + ", ID=" + ID + ", maxCapacityArea=" + maxCapacityArea + ", KGperSquareMeter=" + KGperSquareMeter + '}';
    }

    

    
}