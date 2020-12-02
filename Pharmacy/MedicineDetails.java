package Pharmacy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MedicineDetails {
	ArrayList<medicine> set = new ArrayList<medicine>();
	ArrayList<Cart> c = new ArrayList<Cart>();

	public void get_medicine_info() throws Exception {
		File file = new File("C:\\Users\\pnisc\\f1.txt");
		FileReader fr = new FileReader(file); // reads the file
		BufferedReader buffer = new BufferedReader(fr); // creates a buffering character input stream
		String line;
		while ((line = buffer.readLine()) != null) {
			String str = line;
			String[] arrstr = str.split(" ", 8);
			medicine m1 = new medicine(Integer.parseInt(arrstr[0]), arrstr[1], arrstr[2], Integer.parseInt(arrstr[3]),
					Integer.parseInt(arrstr[4]), Integer.parseInt(arrstr[5]), Float.parseFloat(arrstr[6]),
					Integer.parseInt(arrstr[7]));
			String date = arrstr[5] + " " + arrstr[4] + " " + arrstr[3];
			if (expiry(date) > 0) {
				set.add(m1);
			}
		}
		fr.close();
	}

	public void view_cart() {
		System.out.println("Medicines in the cart are: ");
		for (Cart c12 : c) {
			System.out.println("Name: " + c12.tablet + " Quantity: " + c12.quantity + " Cost: " + c12.cost);
		}
	}

	private int expiry(String date1) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
		LocalDateTime now = LocalDateTime.now();
		String date2 = dtf.format(now);

		return date1.compareTo(date2);

	}
}