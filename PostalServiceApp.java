package postal.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostalServiceApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		FileInputStream input = null;
		FileOutputStream output = null;
		List<String> distanceList = new ArrayList<String>();
		List<Integer> theTotalDistance = new ArrayList<Integer>();
		int distance = 0;
		List<String> newDistanceList = new ArrayList<String>();
		List<String> curlyBraceList = new ArrayList<String>();
		List<String> arrayContentList = null;

		try {
			input = new FileInputStream(
					"C:/DistanceFileInput.txt");
			output = new FileOutputStream(
					"C:/DistanceTravelled.txt");
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(input));
			String inFile;

			while ((inFile = bufferedReader.readLine()) != null) {
				distanceList.add(inFile);
			}
			bufferedReader.close();

		} catch (IOException exception) {
			exception.printStackTrace();
		}

		// compare the elements
		for (int i = 0; i < distanceList.size(); i++) {
			removeDuplicateElements(distanceList, newDistanceList, i);
		}
		// Set individual values from the new distance list
		DataContents contents = new DataContents();
		for (String curlyRemove : newDistanceList) {
			curlyBraceList = Arrays.asList(curlyRemove.split("[{}]"));
			for (String arrayContent : curlyBraceList) {
				if (!arrayContent.isEmpty() && arrayContent != null) {
					arrayContentList = Arrays.asList(arrayContent.split(","));
					System.out.println(arrayContentList);
					populateTheDestinationAndDistance(arrayContentList,
							contents);
					theTotalDistance.add(contents.getDistance());
				}
			}
		}
		for (Integer finalDistance : theTotalDistance) {
			distance = distance + finalDistance.intValue();
		}
		System.out.println("The total distance travelled is: " + distance);
		// Print everything in DistanceTravelled.txt
		for (String temp : newDistanceList) {

			output.write(temp.getBytes());
			output.write(System.getProperty("line.separator").getBytes());
			output.flush();

		}
		String message = "The total distance travelled is: " + distance;
		byte[] outFileMessage = message.getBytes();
		output.write(outFileMessage);
		output.flush();

	}

	/**
	 * Populate the destination and distance.
	 * 
	 * @param arrayContentList
	 *            the array content list
	 * @param contents
	 *            the contents
	 */
	private static void populateTheDestinationAndDistance(
			List<String> arrayContentList, DataContents contents) {

		contents.setFirstDestination(arrayContentList.get(0).trim());
		contents.setSecondDestination(arrayContentList.get(1).trim());
		contents.setDistance(Integer.parseInt(arrayContentList.get(2).trim()));

	}

	/**
	 * Removes the duplicate elements.
	 * 
	 * @param distanceList
	 *            the distance list
	 * @param newDistanceList
	 *            the new distance list
	 * @param i
	 *            the i
	 */
	private static void removeDuplicateElements(List<String> distanceList,
			List<String> newDistanceList, int i) {
		for (int j = i + 1; j < distanceList.size(); j++) {
			if (distanceList.get(i).equals(distanceList.get(j))) {
				distanceList.remove(i);
				continue;
			}

		}
		newDistanceList.add(distanceList.get(i));
	}
}
