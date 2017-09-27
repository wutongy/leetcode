class Node<T extends Comparable<T>>(
  private T value;
  private Node<T> left;
  private Node<T> right;

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }
)

class BinarySearchTree<T extends Comparable<T>> {
  private Node<T> root;
  public BinarySearchTree(T value) {
    root = new Node<T>(value);
  }
  public void insert(T value) {
    Node<T> node = new Node<T>(value);
  }
}
