package socialnetwork.domain.sequential;

import java.util.ArrayList;
import java.util.List;

public class SequentialSet<E> {

  // This code was taken from Anto's gitlab he uses for lectures

  int size = 0;
  private Node<E> head, tail;

  public SequentialSet() {
    head = SequentialNode.head;
    tail = SequentialNode.tail;
    head.setNext(tail);
  }

  public Node<E> getFirst(){
    return head.next();
  }

  public List<E> toArrayList(){
    List<E> list = new ArrayList<>();
    Node<E> node = head.next();
    while (node != tail) {
      list.add(0, node.item());
      node = node.next();
    }
    return list;
  }

  private Position<E> find(Node<E> start, int key) {
    Node<E> pred, curr;
    curr = start;
    do {
      pred = curr;
      curr = curr.next();
    } while (curr.key() < key);  // until curr.key >= key
    return new Position<E>(pred, curr);
  }

  public boolean contains(E item) {
    Node<E> node = new SequentialNode<>(item);
    Position<E> expectedPosition = find(head, node.key());

    return expectedPosition.curr.key() == node.key();
  }

  public boolean add(E item) {
    Node<E> node = new SequentialNode<>(item);
    Position<E> where = find(head, node.key());
    if (where.curr.key() == node.key()) {
      return false;
    } else {
      node.setNext(where.curr);
      where.pred.setNext(node);
      size += 1;
      return true;
    }
  }

  public boolean remove(E item) {
    Node<E> node = new SequentialNode<>(item);
    Position<E> where = find(head, node.key());
    if (where.curr.key() > node.key()) {
      return false;
    } else {
      where.pred.setNext(where.curr.next());
      size -= 1;
      return true;
    }
  }

  public int size() {
    return size;
  }


  private static class Position<T> {

    public final Node<T> pred, curr;

    public Position(Node<T> pred, Node<T> curr) {
      this.pred = pred;
      this.curr = curr;
    }
  }
}