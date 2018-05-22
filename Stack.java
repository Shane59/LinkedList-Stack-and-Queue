/*
 * Shinya Aoi
 * 05/21/2018
 * LinkedList Data Structure HW
 */

/**
 * This class is acting like stack by using LinkedList.
 * this class extends List class.
 */
public class Stack extends List {

    /**
     * This method adds an object at the beginning?
     * @param o which is an object that you want to add.
     */
    public void push(Object o){
        super.insert(o,0);
    }

    /**
     * This method removes an object from the beginning?
     * @return the object that has been removed.
     */
    public Object pop(){
        return super.remove(0);
    }

    /**
     * Override the insert method from the list class
     * that does not take index number.
     * @param o which is an object that you want to add.
     */
    public void insert(Object o){
        push(o);
    }

    /**
     * Overriding the remove method from the list class
     * that does not take index number.
     * @return the object that has been removed.
     */
    public Object remove() {
        return pop();
    }

    /**
     * Main method to test all the methods.
     * @param args
     */
    public static void main(String[] args) {
        Stack s = new Stack();
        Stack empty = new Stack();
        try {
            s.push("S");
            s.push("H");
            s.push("I");
            s.push("N");
            s.insert("Y");
            System.out.println(s.toString());

            System.out.println(s.pop());
            System.out.println(s.toString());
            System.out.println(s.remove());
            System.out.println(s.toString());
            System.out.println(s.indexOf("H"));
            System.out.println(s.isEmpty());
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try{
            empty.pop();
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try{
            empty.remove();
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try {
            System.out.println(empty.isEmpty());
        }catch (LinkedListException e){}
    }
}
