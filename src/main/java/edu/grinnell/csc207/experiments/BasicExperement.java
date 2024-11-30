package edu.grinnell.csc207.experiments;

import edu.grinnell.csc207.util.BitTree;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    InputStream b2aStream = new ByteArrayInputStream(b2a.getBytes());
    tree.load(b2aStream);
    tree.dump(pen);
  } // main

  static final String b2a =
      "100000,A\n"
      + "110000,B\n"
      + "100100,C\n"
      + "100110,D\n"
      + "100010,E\n"
      + "110100,F\n"
      + "110110,G\n"
      + "110010,H\n"
      + "010100,I\n"
      + "010110,J\n"
      + "101000,K\n"
      + "111000,L\n"
      + "101100,M\n"
      + "101110,N\n"
      + "101010,O\n"
      + "111100,P\n"
      + "111110,Q\n"
      + "111010,R\n"
      + "011100,S\n"
      + "011110,T\n"
      + "101001,U\n"
      + "111001,V\n"
      + "101101,X\n"
      + "101111,Y\n"
      + "101011,Z\n"
      + "010111,W\n"
      + "000000, \n";
} // BasicExperement
