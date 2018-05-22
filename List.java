/*
 * Shinya Aoi
 * 05/21/2018
 * LinkedList Data Structure HW
 */

/**
 * This class is a LinkedList class.
 */
public class List {
    Node head = null;

    /**
     * Inner class that defines Node
     */
    private class Node{
        Object data;
        Node next;

        /**
         * Constructor that takes an object
         * @param o which is object
         */
        public Node(Object o){
            data = o;
        }

    }

    /**
     * This method inserts an object into a specific index.
     * @param next which is an object that will be added.
     * @param index where you want to put the object.
     */
    public void insert(Object next, int index) {
        //When the index is negative value
        if(index<0 || index>size()) {
            throw new LinkedListException("Index is invalid!");
        }
        Node adding = new Node(next);
        Node current = head;
        int count = 0;

        //When the list is empty
        if(current == null){
            if(index==0) {
                head = adding;
            }
            else throw new LinkedListException();
        }
        //When the list has a single element -- adding the element to the beginning.
        else if(current.next==null){
            if(index==0) {
                Node temp = head;
                head = adding;
                head.next = temp;
            }
            else if(index==1){
                head.next = adding;
            }
        }
        //When the list has more than two elements
        else{
            //When the index is 0 which means you add the element to the start.
            if(index==0){
                Node temp =  current;
                head = adding;
                head.next = temp;
            }

            while(current.next!=null){
                if(count+1 == index){
                    Node temp = current.next;
                    current.next = adding;
                    current.next.next = temp;
                    break;
                }
                count++;
                current = current.next;
                //When the index is the end of the list.
                if(current.next==null&&count+1==index) {
                    current.next = adding;
                    break;
                }
            }
        }
    }

    /**
     * This method is to remove an object in the specific index.
     * @param index where you want to remove the object.
     * @return the object that has been removed.
     */
    public Object remove(int index) {
        if(index<0 || index>=size()) {
            throw new LinkedListException("The list is empty or index is invalid!");
        }
        //When the list is empty
        if(head==null) {
            System.out.println("The list is empty!");
            throw new LinkedListException();
        }
        //when the list has only one element
        else if(head.next==null){
            if(index==0){
                Node removeElement = head;
                head = null;
                return removeElement.data;
            }
            else throw new LinkedListException();
        }
        //when there are more than two elements in the list
        else{
            Node current = head;
            int count = 0;
            //When the index is 0 which deleting the head.
            if(index==0){
                Node removeElement = head;
                head = head.next;
                return removeElement.data;
            }
            while(current!=null){
                //in the body
                if(count+1==index){
                    Node removeElement = current.next;
                    current.next = current.next.next;
                    return removeElement.data;
                }
                current = current.next;
                count++;
                //if the index is the end of the list.
                if(current.next==null && count+1==index){
                    Node removeElement = current;
                    current.data = null;
                    return removeElement.data;
                }
            }
        }
        throw new LinkedListException();
    }

    /**
     * Override toString method to print out the objects in the list.
     * @return the String of the list.
     */
    @Override
    public String toString() {
        String retValue = "";
        Node current = head;

        while(current != null) {
            retValue += current.data.toString() + " ";
            current = current.next;
        }
        return retValue;
    }

    /**
     * This method returns the size of the list.
     * @return the size of the list.
     */
    public int size(){
        int size = 0;
        Node current = head;
        if (current==null){
            return size;
        }
        while(current.next!=null){
            size++;
            current = current.next;
        }
        size++;
        return size;
    }

    /**
     * This method checks if the list is empty.
     * @return true if the list is empty.
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * This method finds the index of the target that you look for.
     * @param target that you are looking for.
     * @return the index of the target. If the target does not exist,
     * return -1 instead.
     */
    public int indexOf(Object target){
        Node current = head;
        int count = 0;
        while (current.next!=null){
            if(current.data.equals(target)){
                return count;
            }
            count++;
            current = current.next;
        }
        if(current.data.equals(target)) return count;
        return -1;
    }

    /**
     * This method is to add to the end.
     * @param o which is an object that you want to add at the end.
     */
    public void append(Object o){
        insert(o,size());
    }

    /**
     * Main method to check all the methods.
     * @param args
     * @throws LinkedListException
     */
    public static void main(String[] args) throws LinkedListException {
        List s = new List();
        List empty = new List();
        List one = new List();
        s.insert("A", 0);
        s.insert("O", 1);
        s.insert("I", 2);
        s.insert("S", 3);

        one.insert("X", 0);
        try {
            System.out.println(s.toString());
            System.out.println("Size is : " + s.size());

            System.out.println(s.indexOf("S"));
            System.out.println(s.indexOf("J"));
            s.append("H");
            System.out.println(s.toString());
            System.out.println(s.remove(3));
            System.out.println("New size is : " + s.size());
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try {
            empty.remove(0);
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try {
            System.out.println(empty.isEmpty());
        }catch (LinkedListException e){}
        try{
            s.insert("K",5);
        }catch (LinkedListException e){
            System.out.println(e);
        }
        try{
            s.insert("L",4);
        }catch (LinkedListException e){
            System.out.println(e);
        }
    }
}
