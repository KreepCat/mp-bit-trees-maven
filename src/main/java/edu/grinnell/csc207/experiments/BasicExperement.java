package edu.grinnell.csc207.experiments;

import edu.grinnell.csc207.util.BitTree;
import edu.grinnell.csc207.util.BrailleAsciiTables;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;

// Personal tests to see how individual methods work.
public class BasicExperement {
  public static void main(String[] args) {
    BitTree<Integer> Tree = new BitTree<>(6);
    System.err.println("Num Nodes: " + Tree.numNodes + " Size: " + Tree.size);
    Tree.set("100000", "A");
    Tree.set("100001", "B");
    System.err.println("Value: " + Tree.get("000000"));
    System.err.println("Value: " + Tree.get("100001"));
  }
}
