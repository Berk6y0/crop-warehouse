/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    /**
     *
     * @author Berkay BADANOZ
     */
public class OOProject2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FruitNotFoundException, SupplierHasNotEnoughMoneyException, CapacityNotEnoughException, FileNotFoundException {
        ArrayList <Supplier> supplierList = new ArrayList <>();
        ArrayList <Store> storeList = new ArrayList<>();
        ArrayList <Fruit> fruitList = new ArrayList<>();
        ArrayList <Crop> cropList = new ArrayList<>();
        for (int i = 0; i < storeList.size(); i++) {
            for (int j = 0; j < storeList.get(j).fruitList.size(); j++) {
                fruitList.add(storeList.get(i).fruitList.get(j));
            } 
          }
        FileInputStream Sup1 = new FileInputStream("C:\\Users\\tokta\\Desktop\\Suppliers.txt");
           Scanner b=new Scanner(Sup1);
           while(b.hasNextLine()){
           String input=b.nextLine().replaceAll("s", "");
           String[]arr=input.split(" ");
           supplierList.add(new Supplier(arr[0],Double.parseDouble(arr[2])));
      }
          FileInputStream Stor1 = new FileInputStream("C:\\Users\\Berkay BADANOZ\\Desktop\\Stores.txt");
            Scanner b1 = new Scanner(Stor1);
            while (b1.hasNextLine()) {
                String input = b1.nextLine().replaceAll("s", "");
                String[] arr = input.split(",");
                storeList.add(new Store(arr[0], Double.parseDouble(arr[1]), Integer.parseInt(arr[2])));
            }
            
            FileInputStream Crop1 = new FileInputStream("C:\\Users\\Berkay BADANOZ\\Desktop\\Crops.txt");
            Scanner b2 = new Scanner(Crop1);

            while (b2.hasNextLine()) {

                String input = b2.nextLine().replaceAll("s", "");
                String[] arr = input.split(",");
                if (arr[1].equals("fruit")) {
                    int CropKeeperId = Integer.parseInt(arr[6]);
                    if (CropKeeperId / 1000 == 1) {
                        for (Supplier i : supplierList) {
                            if (i.getID() == CropKeeperId) {
                                Crop fruit = new Fruit(arr[0] ,Double.parseDouble(arr[2]), arr[3],arr[4], Integer.parseInt(arr[5]) ,arr[6] );
                                i.getCropList().add(fruit);
                                cropList.add(fruit);
                            }
                        }

                    } else if (CropKeeperId / 1000 == 5) {
                        for (Store i : storeList) {
                            if (i.getID() == CropKeeperId) {
                                Fruit fruit = new Fruit(arr[0], Double.parseDouble(arr[2]), arr[3], arr[4], Integer.parseInt(arr[5]) , arr[6]);
                                i.getFruitList().add(fruit);
                               cropList.add(fruit);
                            }
                        }
                    }

                } else if (arr[1].equals("vegetable")) {
                    int cropKeeperId = Integer.parseInt(arr[5]);
                    if (cropKeeperId / 1000 == 1) {
                        for (Supplier i : supplierList) {
                            if (i.getID() == cropKeeperId) {
                                Vegetable v1 = new Vegetable(arr[0],Double.parseDouble(arr[2]), arr[3], arr[4]);
                                cropList.add(v1);
                                i.getCropList().add(v1);
                                cropList.add(v1);
                            }
                        }

                    }
                }
            }
        

        
       boolean choice = false;
        
        
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose one option");
            int num = scanner.nextInt();
            if(num>0 && num<=9){
                choice = true;
            }
           while(choice){
               switch(num){
                   case 1:
                       displayAllSuppliers(supplierList);
                       break;
                   case 2:
                       displayAllStores(storeList);
                       break;
                   case 3:
                       
                       System.out.println("Please enter supplier's name");
                       String namesup = scanner.next();
                       System.out.println("Please enter ID");
                       int IDsup = scanner.nextInt();
                       System.out.println("Which fruit do you want to buy");
                       System.out.println("Please enter name of fruit");
                       String name = scanner.next();
                       System.out.println("Please enter ID");
                       int ID = scanner.nextInt();
                       buyAFruitCrop(findFruitWitGivenID(name, ID, fruitList), findSuppWithGivenID(namesup, IDsup, supplierList));
                       break;
                   case 4:
                       System.out.println("Please enter supplier's name");
                       String namesup2 = scanner.next();
                       System.out.println("Please enter ID");
                       int IDsup2 = scanner.nextInt();
                       System.out.println("Which fruit do you want to buy");
                       System.out.println("Please enter name of fruit");
                       String name2 = scanner.next();
                       System.out.println("Please enter ID");
                       int ID2 = scanner.nextInt();
                       sellAFruitCrop(findFruitWitGivenID(name2, ID2, fruitList), findSuppWithGivenID(namesup2, IDsup2, supplierList));
                       break;
                   case 5:
                       System.out.println("Please enter store's name");
                       String s = scanner.next();
                       System.out.println("Please enter ID of store");
                       int IDstore = scanner.nextInt();
                       System.out.println("Which fruit do you want to remove");
                       System.out.println("Please enter name of fruit");
                       String name3 = scanner.next();
                       System.out.println("Please enter color of fruit");
                       String color = scanner.next();
                       removeFruitFromAStore(findStoreWithGivenID(s, IDstore, storeList), name3, color);
                       break;
                   case 6:
                       System.out.println("Please enter supplier's name");
                       String namesup3 = scanner.next();
                       System.out.println("Please enter ID of supplier");
                       int IDsup3 = scanner.nextInt();
                       System.out.println("Please enter ID of fruit");
                       int ID3 = scanner.nextInt();
                       removeCropfromSupplier(findSuppWithGivenID(namesup3, IDsup3, supplierList), ID3);
                       break;
                   case 7:
                       System.out.println("IS Crop vegetable or fruit");
                       String type = scanner.next();
                       if(type.equals("Fruit")){
                           System.out.println("enter necessary values");
                           System.out.println("Price");
                           double price = scanner.nextInt();
                           System.out.println("name");
                           String namenew = scanner.next();
                           System.out.println("weight");
                           int weight = scanner.nextInt();
                           System.out.println("season");
                           String season = scanner.next();
                           Crop crop= new Fruit(price, type, namenew, weight, season, type);
                           System.out.println("For store or supplier");
                           String stored = scanner.next();
                           if(stored.equals("Store")){
                               System.out.println("ID of Store");
                               int IDnew = scanner.nextInt();
                               System.out.println("name of Store");
                               String namenew2 = scanner.next();
                               findStoreWithGivenID(namenew2, IDnew, storeList).fruitList.add((Fruit)cropnew);
                           }else{
                               System.out.println("ID of Supplier");
                               int IDnew = scanner.nextInt();
                               System.out.println("name of Supplier");
                               String namenew2 = scanner.next();
                               findSuppWithGivenID(namenew2, IDnew, supplierList).getCropList().add(cropnew);
                           }
                           
                           
                       }else{
                           System.out.println("region");
                           String region = scanner.next();
                           System.out.println("name");
                           String namenew = scanner.next();
                           System.out.println("weight");
                           int weight = scanner.nextInt();
                           System.out.println("season");
                           String season = scanner.next();
                           Crop Crop = new Vegetable(region, namenew, weight, season, type);
                                                      System.out.println("For store or supplier");
                           String stored = scanner.next();
                           if(stored.equals("Store")){
                               System.out.println("ID of Store");
                               int IDnew = scanner.nextInt();
                               System.out.println("name of Store");
                               String namenew2 = scanner.next();
                               findStoreWithGivenID(namenew2, IDnew, storeList).fruitList.add((Fruit)Crop);
                           }else{
                               System.out.println("ID of Supplier");
                               int IDnew = scanner.nextInt();
                               System.out.println("name of Supplier");
                               String namenew2 = scanner.next();
                               findSuppWithGivenID(namenew2, IDnew, supplierList).getCropList().add(Crop);
                           }
                       }
                       break;
                   case 8:
                            System.out.println("ID of Supplier");
                            int IDnew = scanner.nextInt();
                            System.out.println("name of Supplier");
                            String namenew2 = scanner.next();
                            System.out.println(findSuppWithGivenID(namenew2,IDnew, supplierList).getBudget());
                            break;
                   case 9:
                            System.out.println("ID of Store");
                            int storeId = scanner.nextInt();
                            System.out.println("name of Store");
                            String StoreName = scanner.next();
                            System.out.println(findStoreWithGivenID(StoreName, storeId, storeList).avaliableCapacity());
                            break;
                            default:
               }
                
               System.out.println("See you later");
               
           }
        
    
    }
    
    public static void displayAllSuppliers(ArrayList <Supplier> s){
        for (Supplier item : s) {
            System.out.println(item.toString());
            System.out.println(item.getCropList().toString());
        }
    }
    
    public static void displayAllStores(ArrayList <Store> s){
        for(Store item :s){
            System.out.println(item.toString());
            System.out.print(item.fruitList.toString());
            item.howToStore();
        }
    }
    
    public static void buyAFruitCrop(Fruit f , Supplier s) throws FruitNotFoundException, SupplierHasNotEnoughMoneyException{
        
        s.buyCrop(f);
    }
    
    public static void sellAFruitCrop(Fruit f , Supplier s) throws CapacityNotEnoughException, FruitNotFoundException{
        s.sellCrop(f);
    }
    
    public static void removeFruitFromAStore(Store s , String name , String color){
        for (int i = 0; i < s.fruitList.size(); i++) {
            if(s.fruitList.get(i).name.equals(name) && s.fruitList.get(i).getColor().equals(color)){
                s.fruitList.remove(i);
            }
        }
    }
     public static void removeCropfromSupplier(Supplier s , int ID){
         for (int i = 0; i < s.getCropList().size(); i++) {
             if(s.getCropList().get(i).fruit.getCropKeeperId() == ID){
                 s.getCropList().remove(i);
                 break;
             }
         }
     }
     
     
     public static void showRemainingBudget(int ID ,ArrayList<Supplier> supplierList ){
         for (int i = 0; i < supplierList.size(); i++) {
            if(supplierList.get(i).getID() == ID){
                System.out.println(supplierList.get(i).getBudget());
         }else{
                System.out.println("Wrong given informations");
            }
         }
     }
     
     public static void showRemainingCapacity(Store s){
         System.out.print("Remaining capacity is : ");
         System.out.println(s.avaliableCapacity());
     }
     
     public static void quitApp(){
         System.out.println("See you later");
     }
     public static Supplier findSuppWithGivenID(String name ,int ID ,ArrayList<Supplier> supplierList ){
         Supplier res = null;
         for (int i = 0; i < supplierList.size(); i++) {
             Supplier b = supplierList.get(i);
             if(b != null){
                 if(b.getID() == ID && b.getName().equals(name)){
                     res = b;
                 }
             }
         }
         return res;
     }
     
     public static Fruit findFruitWitGivenID(String name,int ID ,ArrayList<Fruit> fruitList ){
         Fruit res = null;
         for (int i = 0; i < fruitList.size(); i++) {
             Fruit b = fruitList.get(i);
             if(b != null){
                 if(b.getCropKeeperId()== ID && b.name.equals(name)){
                     res = b;
                 }
             }
         }
         return res;
     }
     public static Store findStoreWithGivenID(String name ,int ID ,ArrayList<Store> storeList ){
         Store res = null;
         for (int i = 0; i < storeList.size(); i++) {
             Store b = storeList.get(i);
             if(b != null){
                 if(b.getID() == ID && b.getName().equals(name)){
                     res = b;
                 }
             }
         }
         return res;
     }
     String menu="• (Press 1) Display all suppliers and their crop list, how they are stored and how they are consumed.\n" +
"• (Press 2) Display all stores and their fruit list, how they are stored and how they are consumed.\n" +
"• (Press 3) Buy a fruit crop for a Supplier and add it to the a stores’s fruitList, removing it from the \n" +
"related store. Ask the value of required fields from the user.\n" +
"• (Press 4) Sell a fruit crop of a Supplier and remove it from the supplier’s cropList, adding it to the \n" +
"related store’s fruitList. Ask the value of required fields from the user.\n" +
"• (Press 5) Remove a fruit from a store. Ask the required fields from the user.\n" +
"• (Press 6) Remove a crop from a supplier. Ask the required fields from the user.\n" +
"• (Press 7) Add crop. Ask the required fields from the user and add the new crop to a store or a \n" +
"supplier.\n" +
"• (Press 8) Show remaining budget. Print remaining budget of a given supplier.";
}
   