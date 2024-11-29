package edu.grinnell.csc207.util;

public class Node {
  int depth = 0;
  String value = null;
  Node left = null;
  Node right = null;

  public Node(String val, int dep) {
    this.depth = dep;
    this.value = val;
    this.left = null;
    this.right = null;
  } // Node(K)
}
