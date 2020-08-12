 


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static String[] readFile(String path) {
		try {
			int i = 0;
			int lenght = Files.readAllLines(Paths.get(path)).size();
			String[] results = new String[lenght];
			for (String line : Files.readAllLines(Paths.get(path))) {
				results[i++] = line;
			}

			return results;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws ParseException {
		
		String[] prescription = readFile(args[0]);					//Read prescription data file and store in a string array named prescription

		String[] medicaments = readFile(args[1]);					//Read medicaments data file and store in a string array named medicaments
		
		String splitted[] = prescription[0].split("\\t");	 		
																	
		String patient = splitted[0];	
		String ssa = splitted[1]; 									// ssa : social security administration
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		Date date = df.parse(splitted[2]); 							// date : prescription date
		double total_amount = 0.0;

		for (int i = 1; i < prescription.length; i++) {
			splitted = prescription[i].split("\\t");
			String drug_name = splitted[0];
			int drug_qty = Integer.parseInt(splitted[1]);

			double min_price = 1.7*Math.pow(10, 308);				//max double number for initial comparison for minimum price 	

			for (int j = 0; j < medicaments.length; j++) {
				splitted = medicaments[j].split("\\t");
				String med_name = splitted[0];						//med_name : name of medicaments
				String med_ssa = splitted[1];						//med_ssa : social security administration of medicaments
				Date med_date1 = df.parse(splitted[2]);				//med_date1 : validity date of medicaments
				Date med_date2 = df.parse(splitted[3]);				//med_date2 : expiry date of medicaments
				double med_price = Double.parseDouble(splitted[4]);	//med_price : price of medicaments

				if (drug_name.equals(med_name) & ssa.equals(med_ssa)
						&& ((date.after(med_date1) && date.before(med_date2)) || date.equals(med_date1)
								|| date.equals(med_date2))
						&& med_price < min_price) {

					min_price = med_price;

				}
			}
			total_amount += min_price * drug_qty;
			System.out.print(drug_name);
			System.out.print("\t");
			System.out.print(min_price);
			System.out.print("\t");
			System.out.print(drug_qty);
			System.out.print("\t");
			System.out.printf("%.2f", min_price * drug_qty);
			System.out.println(" ");
			
		}

		System.out.print("Total\t");
		System.out.printf("%.2f", total_amount);
		
	}
}
