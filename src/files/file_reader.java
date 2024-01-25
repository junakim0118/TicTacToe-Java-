package files;

import java.io.*;
import java.util.*;

public class file_reader {
	public static void main(String args[]) {
		System.out.print("Enter a filename to read: ");
		Scanner in = new Scanner(System.in);
		File inFile = new File(in.next());
		try {
			Scanner freader = new Scanner(inFile);
			String line;
			while (freader.hasNextLine()) {
				line = freader.nextLine();

// Probably place here some code to actually do something with the
// line of text that was read in...

				
				
			}
			freader.close();
		} catch (IOException e) {

			System.err.println(e);
			System.exit(1);
		}
	}
}