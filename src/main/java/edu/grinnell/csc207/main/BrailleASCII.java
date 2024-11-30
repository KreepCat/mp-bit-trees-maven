package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Convert one thing to another (ascii->braille,braille->ascii,braille->unicode).
   *
   * @param args inputs used to determaine what conversion to use
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      pen.println("Please try again");
      return;
    } // if
    if (args[0].equals("braille")) {
      for (int i = 0; i < args[1].length(); i++) {
        pen.print(BrailleAsciiTables.toBraille(args[1].charAt(i)));
      } // for
    } // if
    if (args[0].equals("ascii")) {
      if (args[1].length() % 6 == 0) {
        for (int i = 6; i <= args[1].length(); i += 6) {
          String letter = args[1].substring(i - 6, i);
          String converted = BrailleAsciiTables.toAscii(letter);
          if (converted != null) { // if the value exists
            pen.print(converted);
          } else { // if the value does not exist
            pen.println();
            pen.println("Invalid input");
            return;
          } // if/else
        } // for
      } else {
        pen.print("Invalid number of bits. Please try again.");
      } // if/else
    } // if
    if (args[0].equals("unicode")) {
      for (int i = 0; i < args[1].length(); i++) {
        String unicode =
            BrailleAsciiTables.toUnicode(BrailleAsciiTables.toBraille(args[1].charAt(i)));
        // STUB
      } // for
    } // if
    pen.println();
    pen.close();
  } // main(String[]

} // class BrailleASCII
