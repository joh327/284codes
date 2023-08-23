public class Collections {
  public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
      this.data = data;
    }
  }
  
  public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    
    public void add(int data) {
      Node node = new Node(data);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
      size++;
    }

    public int get(int index) {
      Node node = head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      return node.data;
    }

    public void set(int index, int data) {
      Node node = head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      node.data = data;
    }

    public void remove() {
      Node node = head;
      for (int i = 0; i < size - 2; i++) {
        node = node.next;
      }
      node.next = null;
      tail = node;
      size--;
    }

    public int size() {
      return size;
    }
  }

  public class DoublyLinkedList {

    private Node head, tail;
    private int size = 0;

    public void add(int data) {
      Node node = new Node(data);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        node.prev = tail;
        tail = node;
      }
      size++;
    }

    public void remove() {
      tail = tail.prev;
      tail.next = null;
    }

  }

  public class DynamicArray {
    int size;
    int[] array;

    public DynamicArray() {
      size = 0;
      array = new int[1];
    }

    public void add(int data) {
      if (size == array.length) {
        int[] temp = new int[size * 2];
        for (int i = 0; i < size; i++) {
          temp[i] = array[i];
        }
        array = temp;
      }
      array[size] = data;
      size++;
    }
  }
}
