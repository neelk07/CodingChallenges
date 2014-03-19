package LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: neel
 * Date: 11/27/13
 * Time: 8:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedList{

    Node head;

    public LinkedList(int d){
        this.head = new Node(d);
    }

    //add a node to the linked list
    void appendToTail(int d){
        Node end = new Node(d);
        Node begin = this.head;

        while(begin.next != null)
        {
            begin = begin.next;
        }

        begin.next = end;
    }


    //print the linked list
    void printList(){
        Node iter = this.head;

        while(iter != null)
        {
            System.out.print(iter.data+"->");
            iter = iter.next;
        }
        System.out.print("null\n");
    }

    /*
    to delete a node with the target data in a singly linked list
    runtime should be O(n)
    */
    void deleteNode(int target){
        //reference to iterate list starting at beginning of list
        Node iter_front = this.head.next;
        Node iter = this.head;

        //check for if the first node has the target
        if(iter.data == target)
        {
            this.head = null;
            return;
        }

        while(iter_front != null)
        {
            //check if we found the correct node
            if(iter_front.data == target)
            {
                //get reference to node in front
                Node next = iter_front.next;
                //set node behind it to the next node after target node
                iter.next = next;
                System.out.print("Deleted LinkedList.Node:"+target+"\n");
                return;
            }

            //iterate
            iter_front = iter_front.next;
            iter = iter.next;

        }

        System.out.print("Target LinkedList.Node Not Found!");
    }

    /*
        reverse a singly linked list in O(n)
     */
    void reverseList(){

        Node prev = null;
        Node next = null;
        Node iter = this.head;

        while(iter != null)
        {
            next = iter.next;
            iter.next = prev;
            prev = iter;
            iter = next;

        }

        //prev is the link to the head of the new list
        this.head = prev;

    }

    /*
        merge two sorted linked list into one sorted singly linked list in O(n)
     */


}
