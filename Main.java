
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws NumberFormatException, Exception {
		Queue<String> arguments = new LinkedList<>(Arrays.asList(args));
		
		try {
			if (arguments.isEmpty()) {
				String[] arrayData = null;
				try {
					while (true) {
						String argument = "";
						Scanner keyboardInput = new Scanner(System.in);
						argument += keyboardInput.nextLine();
						String[] temp = argument.split(" ");
						processData(temp, arrayData);
					}
				} catch (Exception e) {
					System.out.println("Wrong command");
				}
			} else {
				String command = arguments.remove();
				System.out.println(command);
				try {
					File file = new File(command); 
					FileReader fr = new FileReader(file); 
					BufferedReader br = new BufferedReader(fr);
					String line;
					String[] arrayData = null;
					while ((line = br.readLine()) != null) {
						String[] temp = line.split(" ");
						processData(temp, arrayData);
					}
					fr.close();
				} catch (IOException e) {
					System.out.println("File Not Found!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void processData(String[] temp, String[] arrayData) throws Exception {
		try {
			if (temp[0].equalsIgnoreCase("create_parking_lot")) {
				arrayData = Process.createLot(Integer.parseInt(temp[1]));
			} else if (temp[0].equalsIgnoreCase("park")) {
				arrayData = Process.parkLot(arrayData, temp[1] + " " + temp[2]);
			} else if (temp[0].equalsIgnoreCase("leave")) {
				arrayData = Process.leaveLot(arrayData, Integer.parseInt(temp[1]));
			} else if (temp[0].equalsIgnoreCase("status")) {
				Process.checkLotStatus(arrayData);
			} else if (temp[0].equalsIgnoreCase("registration_numbers_for_cars_with_colour")) {
				Process.listRegByColor(arrayData, temp[1]);
			} else if (temp[0].equalsIgnoreCase("slot_numbers_for_cars_with_colour")) {
				Process.listSlotByColor(arrayData, temp[1]);
			} else if (temp[0].equalsIgnoreCase("slot_number_for_registration_number")) {
				Process.listRegPosition(arrayData, temp[1]);
			} else {
				System.out.println("Wrong command");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Wrong command");
		}
	}

}
