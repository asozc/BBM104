
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WritetoFile {

	void writetofile(String nameandSurname, String regNumber, String position, String yearofStart, double salary) {

		String[] namesplitted = nameandSurname.split(" ");//Split nameandSurname to check whether the personnel has more than one name  
		int i = namesplitted.length;
		String Name = null,Surname=null;
		if(i==3){		//two names
			Name = namesplitted[0]+" "+namesplitted[1];
			Surname = namesplitted[2];
		}
		if(i==2){		//one name 
			Name = namesplitted[0];
			Surname = namesplitted[1];
		}
		
		
		
		

		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(regNumber + ".txt");
			printWriter.println("Name : "+ Name);
			printWriter.println();
			printWriter.println("Surname : " + Surname);
			printWriter.println();
			printWriter.println("Registration Number : " + regNumber);
			printWriter.println();
			printWriter.println("Position : " + position);
			printWriter.println();
			printWriter.println("Year of Start : " + yearofStart);
			printWriter.println();
			printWriter.printf("Total Salary : ");
			printWriter.printf("%.2f" , salary);
			printWriter.printf(" TL");
			
			printWriter.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
}
