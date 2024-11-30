package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Alex Pollock
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * The size of the bit tree. Its depth.
   */
  int size = 0;
  /**
   * The root node of the tree.
   */
  Node root = null;
  /**
   * The total number of nodes in the tree.
   */
  int numNodes = 0;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a bit tree of depth n.
   * @param n the depth of the tree created
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
   * Creates the skeleton of a tree based on its size.
   *
   * @param root the node that we are creating the children of. This is initially the root.
   * @param depth the current depth of the tree
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
      } // if/else
    } // for
    return currNode;
  } // traverse(String)


  private void dumpHelper(String bits, PrintWriter pen) {
    if (bits.length() == size) {
      if (get(bits) != null) {
        pen.println(bits + "," + get(bits));
      } // if
    } else {
      dumpHelper((new StringBuilder(bits).append('0')).toString(), pen);
      dumpHelper((new StringBuilder(bits).append('1')).toString(), pen);
    } // if/else
  } // dumpHelper(String,PrintWriter)
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
   * Traverses the tree using bits to find a value to return.
   *
   * @param bits the bits used to traverse the tree.
   * @throws IndexOutOfBoundsException if the length of bits or its values are incorrect.
   * @return the value found in the tree at bits.
   */
  public String get(String bits) throws IndexOutOfBoundsException {
    if (bits.length() != size) {
      throw new IndexOutOfBoundsException();
    } // if
    Node foundNode = traverse(bits);
    return foundNode.value;
  } // get(String, String)

  /**
   * Prints out the combination of bits that correspond to the values in the tree.
   *
   * @param pen the pen used to print output
   */
  public void dump(PrintWriter pen) {
    this.dumpHelper("", pen);
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(source));
    try {
      String read = buffer.readLine();
      while (read!=null) {
        String[] vals = read.split(",");
        set(vals[0], vals[1]);
        read = buffer.readLine();
      }
    } catch (IOException e) {
    }
  } // load(InputStream)

} // class BitTree
