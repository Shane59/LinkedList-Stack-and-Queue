/*
 * Shinya Aoi
 * 05/21/2018
 * LinkedList Data Structure HW
 */

/**
 * This class acts like Queue by using LinkedList.
 * This class extends the List class.
 */
public class Queue extends List {

    /**
     * This method adds an object to the beginning of the list.
     * @param o which is an object.
     */
    public void enqueue(Object o){
        super.insert(o, 0);
    }

    /**
     * This method removes an object from the end of the list.
     * @return the object that has been removed.
     */
    public Object dequeue(){
        return super.remove(super.size()-1);
    }

    /**
     * Override the insert method from the list class
     * that does not take index number.
     * @param o which is an object that you want to add.
     */
    public void insert(Object o){
        enqueue(o);
    }

    /**
     * Overriding the remove method from the list class
     * that does not take index number.
     * @return the object that has been removed.
     */
    public Object remove(){
        return dequeue();
    }

    /**
     * Main method to test all the methods.
     * @param args
     */
    public static void main(String[] args) {
        Queue q = new Queue();
        Queue empty = new Queue();
        try {
            q.enqueue("A");
            q.enqueue("O");
            q.enqueue("I");
            q.enqueue("S");
            q.enqueue("H");
            q.enqueue("I");
            q.enqueue("N");
            q.enqueue("Y");
            q.enqueue("A");
            q.insert("!");
            System.out.println(q.toString());
            System.out.println(q.dequeue());
            System.out.println(q.toString());
            System.out.println(q.remove());
            System.out.println(q.toString());

        }catch (LinkedListException e){
            System.out.println(e);
        }
        try {
            empty.dequeue();
            empty.remove();
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try {
            System.out.println(empty.isEmpty());
        }catch (LinkedListException e){}
    }
}
