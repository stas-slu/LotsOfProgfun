package javastuff.linkedlists;

/**
 * Adding Node in middle of list without creating new List
 */
public class AddingNodeInMiddleOfList {

    public static void main(String[] argc) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        System.out.println("List before adding: " + linkedList.toString());
        linkedList.addInMiddleWithoutCreatingNewList(666);
        System.out.println("List after adding: " + linkedList.toString());
    }
}

