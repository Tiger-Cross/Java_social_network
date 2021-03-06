package socialnetwork.domain.SetImplementations.Sequential;

// Taken from Antonio's gitlab

import socialnetwork.domain.SetImplementations.Node;

public class SequentialNode<E> implements Node<E> {

  private E item;
  private int key;
  private Node<E> next;

  SequentialNode(E item) {
    this(item, null);
  }

  private SequentialNode(E item, Node<E> next) {
    this(item, item.hashCode(), next);
  }

  SequentialNode(E item, int key, Node<E> next) {
    this.item = item;
    this.key = key;
    this.next = next;
  }

  @Override
  public E item() {
    return item;
  }

  @Override
  public int key() {
    return key;
  }

  @Override
  public Node<E> next() {
    return next;
  }

  @Override
  public void setItem(E item) {
    this.item = item;
  }

  @Override
  public void setKey(int key) {
    this.key = key;
  }

  @Override
  public void setNext(Node<E> next) {
    this.next = next;
  }
}
