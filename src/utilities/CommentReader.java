package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CommentReader {
	ArrayList<String> keep;
	ArrayList<Integer> number;
	ArrayList<String> filenames;

	public static void main(String[] args) {
		// TODO
		CommentReader a = new CommentReader();
		a.activate();
	}
	// TODO
	// TODO

	// TODO
	void activate() {
		filenames = new ArrayList<String>();
		String tot = "";
		int frt = 0;
		keep = new ArrayList<String>();
		number = new ArrayList<Integer>();
		scan();

		System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" + keep.size());
		tot = tot + filenames.get(frt) + "\n";
		frt++;
		for (int i = 0; i < keep.size(); i++) {
			tot = tot + keep.get(i) + " " + number.get(i) + "\n";
			if (i > 0) {
				if (number.get(i) < number.get(i - 1)) {
					tot = tot + filenames.get(frt) + "\n";
					frt++;
				}
			}

		}
		System.out.println(tot);
		try {
			FileWriter fw = new FileWriter("src/CommentReader/Comment", false);

			fw.write(tot);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void scan() {

		File TakoEngine = new File("src/CommentReader");
		File[] directoryListing = TakoEngine.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				if (child.getAbsolutePath()
						.substring(child.getAbsolutePath().length() - 4, child.getAbsolutePath().length())
						.equals("java")) {
					filenames.add(child.getAbsolutePath());
					try {
						int i = 0;
						BufferedReader br = new BufferedReader(new FileReader(child));
						String line = br.readLine();
						while (line != null) {

							i++;

							line = line.trim();
							if (line.length() > 3) {

								// TODO make sure it scans words right
								if (line.substring(0, 4).equals("// T")) {
									keep.add(line);
									number.add(i);

								}

							}
							line = br.readLine();

						}
						br.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
	}
}
