package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import test.ValidatingIP;

public class IPAddressValidatorTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		FileInputStream input = null;
		FileOutputStream outputOne = null;
		FileOutputStream outputTwo = null;
		ArrayList<String> iPList = new ArrayList<String>();

		// Create new Regex Ip address validator object.
		new ValidatingIP();

		try {
			input = new FileInputStream("C:/IpAddresses.txt");
			outputOne = new FileOutputStream("C:/ValidIP.txt"); // The location
																// of the output
																// files can be
																// altered
																// accordingly
			outputTwo = new FileOutputStream("C:/InvalidIP.txt");
			Scanner inFile = new Scanner(input);

			while (inFile.hasNextLine()) {
				iPList.add(inFile.nextLine());
			}
			// Sorting the String of IP Addresses in descending order.
			Collections.sort(iPList, Collections.reverseOrder());
			inFile.close();

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		if (iPList != null || !iPList.isEmpty()) {
			ipAddressValidator(outputOne, outputTwo, iPList);
		}

	}

	/**
	 * IP address Validator.
	 *
	 * @param outputOne the output one
	 * @param outputTwo the output two
	 * @param iPList the IP address list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void ipAddressValidator(FileOutputStream outputOne,
			FileOutputStream outputTwo, ArrayList<String> iPList)
			throws IOException {
		String values;
		for (String temp : iPList) { // Iterate through the list of IP
										// Addresses.
			values = temp;
			//validate the list of IP address using Regex
			boolean inFileIPValid = ValidatingIP.validate(values);
			byte[] result = values.getBytes();

			if (inFileIPValid == true) {
				outputOne.write(result);
				outputOne
						.write(System.getProperty("line.separator").getBytes());
				outputOne.flush();
			} else {
				outputTwo.write(result);
				outputTwo
						.write(System.getProperty("line.separator").getBytes());
				outputTwo.flush();
			}
		}
	}

}
