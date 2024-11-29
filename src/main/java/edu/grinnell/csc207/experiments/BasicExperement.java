package edu.grinnell.csc207.experiments;

import edu.grinnell.csc207.util.BitTree;


import java.io.PrintWriter;

//
/**
 * Personal tests to see how individual methods work.
 *
 * @author Alex Pollock
 */
public class BasicExperement {

  /**
   * Some basic experiments in a class spelled incorrectly.
   * @param args ignore.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BitTree tree = new BitTree(6);
    tree.set("100000", "A");
    tree.set("100001", "B");
    System.err.println("Value: " + tree.get("100000"));
    System.err.println("Value: " + tree.get("100001"));
    tree.dump(pen);
  } // main
} // BasicExperement
