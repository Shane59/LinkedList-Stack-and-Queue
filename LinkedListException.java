/*
 * Shinya Aoi
 * 05/21/2018
 * LinkedList Data Structure HW
 */

/**
 * This class is extends RuntimeException that throws error
 * from the List, Stack and Queue classes.
 */
public class LinkedListException extends RuntimeException{

    /**
     * Non-argument constructor
     */
    public LinkedListException(){
        super();
    }

    /**
     * Constructor with a String message
     * @param message that is passed from where it is called.
     */
    public LinkedListException(String message){
        super(message);
    }
}
