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
public class Supplier implements CropKeeper{
    private Store s;
    private String name;
    private int ID ;
    private double budget;
    private ArrayList <Crop> cropList = new ArrayList <>();
    
    public Supplier(String name, double budget) {
        this.name = name;
        this.budget = budget;
        ID = (int) (Math.random()*1000)+1000;
    }
    public void buyCrop(Crop c) throws FruitNotFoundException, SupplierHasNotEnoughMoneyException{
        for (int i = 0; i < s.fruitList.size(); i++) {
            if(s.fruitList.contains((Fruit)c)){
                if(s.fruitList.get(i).getPrice() * s.fruitList.get(i).weight<=this.budget ){
                    if(!cropList.contains(c)){
                    s.exportCrop((Fruit)c);
                    budget -= (s.fruitList.get(i).getPrice() * s.fruitList.get(i).weight);
                    cropList.add(c);
                    break;
                    }
                }else{
                    throw new SupplierHasNotEnoughMoneyException();
                }
            }
        }
    }
    public void sellCrop(Crop c) throws CapacityNotEnoughException, FruitNotFoundException{
        for (int i = 0; i < cropList.size(); i++) {
            if(cropList.contains(c)){
                cropList.remove(c);
                if(c instanceof Fruit){
                budget +=cropList.get(i).weight*cropList.get(i).fruit.getPrice();
                s.importCrop((Fruit)c);
                break;
                }else{
                    
                }
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
    public String getName(){
        return name;
    }
    public int getID() {
        return ID;
    }
   
    
    public double getBudget(){
        return budget;
    }
    public ArrayList<Crop> getCropList() {
        return cropList;
    }
    
    
    @Override
    public String toString() {
        return "Supplier{" + "name=" + name + ", ID=" + ID + ", budget=" + budget + '}';
    }
    
}
    
    


 

