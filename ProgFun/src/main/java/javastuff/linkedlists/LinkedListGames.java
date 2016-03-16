package javastuff.linkedlists;


public class LinkedListGames {

    public static void main(String[] argc) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        /**
         * Find the middle of a linked list.
         * The list is not cyclic
         */
        System.out.println("The middle is: " + linkedList.findMiddle());

        /**
         * Find the K element from the end of the list
         */
        int kNodeA = 1;
        int kNodeB = 2;
        int kNodeC = 4;
        //should return 50
        System.out.println("The " + kNodeA + "-th element from end is: " + linkedList.findKelementFromTheEnd(0));
        //should return 30
        System.out.println("The " + kNodeB + "-th element from end is: " + linkedList.findKelementFromTheEnd(2));
        //should return 10
        System.out.println("The " + kNodeC + "-th element from end is: " + linkedList.findKelementFromTheEnd(4));
    }
}

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    int numberOfNodes;

    public void add(int data) {
        Node node = new Node(data);

        if(head == null) {
            head = node;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        numberOfNodes++;
    }

    public void add1(int data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
        }

        Node crunchifyTemp = new Node(data);
        Node crunchifyCurrent = head;

        // Let's check for NPE before iterate over crunchifyCurrent
        if (crunchifyCurrent != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (crunchifyCurrent.next != null) {
                crunchifyCurrent = crunchifyCurrent.next;
            }

            // the last node's "next" reference set to our new node
            crunchifyCurrent.next = crunchifyTemp;
        }

        // increment the number of elements variable
        numberOfNodes++;
    }

    public int findMiddle() {
        if(head == null) {
            return -1; //return -1 for empty list
        }

        Node oneHop, twoHop;
        oneHop = twoHop = head;

        while(twoHop != null && twoHop.next != null && twoHop.next.next != null) {
            oneHop = oneHop.next;
            twoHop = twoHop.next.next;
        }

        return oneHop.data;
    }

    /**
     * The trick here is to move the first pointer K elements from the START, then, start moving the second pointer,
     * and when the first reach the end, it is exactly the K point from the end for the second pointer
     */
    public int findKelementFromTheEnd(int indexK) {
        Node kNodeFromStart = head;
        Node kNodeFromEnd = head;
        for (int i = 0; i < indexK; i++) {
            kNodeFromStart = kNodeFromStart.next;
        }

        while(kNodeFromStart.next != null) {
            kNodeFromStart = kNodeFromStart.next;
            kNodeFromEnd = kNodeFromEnd.next;
        }
        return kNodeFromEnd.data;
    }
}