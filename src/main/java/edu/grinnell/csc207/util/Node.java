package edu.grinnell.csc207.util;


/**
 * A basic node class. Is both interior and exterior nodes. Has a right and left child if interior.
 *
 * @author Alex Pollock
 */
public class Node {
  /**
   * The depth of this node.
   */
  int depth = 0;
  /**
   * The value at this node. Should be null for interior nodes.
   */
  String value = null;
  /**
   * The left child node.
   */
  Node left = null;
  /**
   * The right child node.
   */
  Node right = null;

  /**
   * Create a node and assign some basic values.
   *
   * @param val the value to store.
   * @param dep the depth of this node in the tree.
   */
  public Node(String val, int dep) {
    this.depth = dep;
    this.value = val;
    this.left = null;
    this.right = null;
  } // Node(K)
} // Node
