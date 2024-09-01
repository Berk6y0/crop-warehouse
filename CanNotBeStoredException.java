/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop;

/**
 *
 * @author Berkay BADANOZ
 */
class CanNotBeStoredException extends Exception {
    public CanNotBeStoredException (String  msg){
      super(msg);
    }

    CanNotBeStoredException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
class SupplierHasNotEnougMoneyException extends Exception{
public SupplierHasNotEnougMoneyException(String msg){
super(msg);}

}
class FruitNotAvailableException extends Exception{
public FruitNotAvailableException (String msg){
super(msg);
}

}
