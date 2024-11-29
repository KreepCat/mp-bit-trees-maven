package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Alex Pollock
 */
public class BitTree<K> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  public int size = 0;
  PrintWriter pen = new PrintWriter(System.out);
  Node root = null;
  public int numNodes = 0;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    size = n;
    root = new Node(null, 0);
    numNodes = 1;
    createNodes(root, 0);
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+
  /**
   * Creates the skeleton of a tree based on its size
   */
  private void createNodes(Node root, int depth) {
    if (depth != this.size) {
      root.left = new Node(null, depth + 1);
      root.right = new Node(null, depth + 1);
      this.numNodes += 2;
      createNodes(root.left, depth + 1);
      createNodes(root.right, depth + 1);
    } // if
  } // createNodes(Node,int)

  /**
   * Traverse the bit tree using a string and return the node found at the end.
   * 
   * @param bits the string being used to traverse.
   * @return the node found at the end of the bits.
   * @throws IndexOutOfBoundsException error thrown if the string is not made of 1s and 0s
   */
  private Node traverse(String bits) throws IndexOutOfBoundsException {
    Node currNode = root;
    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i) == '0') { // go left
        currNode = currNode.left;
      } else if (bits.charAt(i) == '1') { // go right
        currNode = currNode.right;
      } else { // incorrect input
        throw new IndexOutOfBoundsException();
      } // if else
    } // for
    return currNode;
  } // traverse(String)
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Traverse the tree using the bits and set the end node to value.
   * 
   * @param bits the bits that tell how to traverse the tree
   * @param value the value to set the node to
   * @throws IndexOutOfBoundsException if bits is an inappropriate size or contains elements other
   *         then 0 and 1
   */
  public void set(String bits, String value) throws IndexOutOfBoundsException {
    if (bits.length() != size) {
      throw new IndexOutOfBoundsException();
    } // if
    Node foundNode = traverse(bits);
    foundNode.value = value;
  } // set(String, String)

  /**
   *
   */
  public String get(String bits) throws IndexOutOfBoundsException {
    if (bits.length() != size) {
      throw new IndexOutOfBoundsException();
    } // if
    Node foundNode = traverse(bits);
    return foundNode.value;
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    // STUB
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)

} // class BitTree
