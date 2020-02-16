

public class Process {
	
	public static String[] createLot(Integer number) throws Exception {
		String[] result = new String[number];
		
		try {
			for (int i = 0; i < number; i++) {
				result[i] = "" + (i+1);
			}
			
			System.out.println("Create parking lot with " + result.length + " slot(s)");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public static String[] parkLot(String[] array, String data) throws Exception {
		String[] result = array;
		String info = "";
		
		for (int i = 0; i < array.length; i++) {
			String[] temp = array[i].split(" ");
			
			if (temp.length < 2) {
				String tempData = temp[0] + " " + data;
				array[i] = tempData;
				info = "Allocated slot number: " + (i + 1);
				break;
			}
		}
		
		if (info.equalsIgnoreCase("")) {
			info = "Sorry, parking lot is full";
		}
		
		System.out.println(info);
		
		return result;
	}
	
	public static String[] leaveLot(String[] array, Integer parkNumber) throws Exception {
		String result[] = array;
		
		try {
			String temp = result[parkNumber - 1];
			temp = "" + parkNumber;
			array[parkNumber - 1] = temp;
			System.out.println("Leave " + parkNumber);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("There are only " + array.length + " parking lot");
		}
				
		return result;
	}
	
	public static void checkLotStatus(String[] array) throws Exception {
		String dataOut = "";
		for (String data : array) {
			String[] temp = data.split(" ");
			
			if (temp.length > 1) {
				dataOut += data + "\r\n";
			}
		}
		System.out.println("SlotNo. RegistrationNo. Color");
		System.out.println(dataOut);
	}
	
	public static void listRegByColor(String[] array, String color) throws Exception {
		String dataOut = "";
		
		for (int i = 0; i < array.length; i++) {
			String[] temp = array[i].split(" ");
			
			if (temp.length > 1) {
				if (temp[2].equalsIgnoreCase(color)) {
					dataOut += (temp[1] + ", ");
				}
			}
		}
		
		if (dataOut.equalsIgnoreCase("")) {
			dataOut = "Not Found";
		}
		
		System.out.println(dataOut);
	}
	
	public static void listSlotByColor(String[] array, String color) throws Exception {
		String dataOut = "";
		
		for (int i = 0; i < array.length; i++) {
			String[] temp = array[i].split(" ");
			
			if (temp.length > 1) {
				if (temp[2].equalsIgnoreCase(color)) {
					dataOut += (temp[0] + ", ");
				}
			}
		}
		
		if (dataOut.equalsIgnoreCase("")) {
			dataOut = "Not Found";
		}
		
		System.out.println(dataOut);
	}
	
	public static void listRegPosition (String[] array, String regNumber) throws Exception {

		String dataOut = "";
		
		for (int i = 0; i < array.length; i++) {
			String[] temp = array[i].split(" ");
			
			if (temp.length > 1) {
				if (temp[1].equalsIgnoreCase(regNumber)) {
					dataOut += (temp[0] + ", ");
				}
			}
		}
		
		if (dataOut.equalsIgnoreCase("")) {
			dataOut = "Not Found";
		}
		
		System.out.println(dataOut);
	
	}
	

}
