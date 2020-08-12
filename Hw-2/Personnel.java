
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Personnel {
	public int currentYear=2016;
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

	public void ReadandSplit(String args, String args2) {
		
		String[] personnel = readFile(args);//Read personnel data file and store in a string array named personnel
		String[] monitoring = readFile(args2);//Read monitoring data file and store in a string array named monitoring
		for (int i = 0; i < personnel.length; i++) {
			
			String p_splitted[] = personnel[i].split("\\t");
			
			for (int j = 0; j < monitoring.length; j++) {
								
				String m_splitted[] = monitoring[j].split("\\t");
				
				RemoveBomChar r=new RemoveBomChar();
				m_splitted[0]=r.removeUTF8BOM(m_splitted[0]);
				
				RemoveBomChar f=new RemoveBomChar();
				p_splitted[0]=f.removeUTF8BOMm(p_splitted[0]);


				

				if (p_splitted[1].equals(m_splitted[0])) {//Check the equality of Registration number
					String a = p_splitted[2];
					switch (a) {
					case "MANAGER":
						Manager m = new Manager();
						double salaryofManager = m.calculateSalary(m_splitted[1],m_splitted[2],m_splitted[3],m_splitted[4],p_splitted[3]);
						//Calls calculateSalary method as override from the subclass named Manager
						WritetoFile z= new WritetoFile();
						z.writetofile(p_splitted[0],p_splitted[1],p_splitted[2],p_splitted[3],salaryofManager);
						//Calls writetofile method to create a new file and print personnel and salary information.
						break;
					case "SECURITY":
						Security s = new Security();
						double salaryofSecurity = s.calculateSalary(m_splitted[1],m_splitted[2],m_splitted[3],m_splitted[4],p_splitted[3]);
						//Calls calculateSalary method as override from the subclass named Security
						WritetoFile y= new WritetoFile();
						y.writetofile(p_splitted[0],p_splitted[1],p_splitted[2],p_splitted[3],salaryofSecurity);
						//Calls writetofile method to create a new file and print personnel and salary information.
						break;
					case "OFFICER":
						Officer o = new Officer();
						double salaryofOfficer = o.calculateSalary(m_splitted[1],m_splitted[2],m_splitted[3],m_splitted[4],p_splitted[3]);
						//Calls calculateSalary method as override from the subclass named Officer
						WritetoFile x= new WritetoFile();
						x.writetofile(p_splitted[0],p_splitted[1],p_splitted[2],p_splitted[3],salaryofOfficer);
						//Calls writetofile method to create a new file and print personnel and salary information.
						break;
					case "WORKER":
						Worker w = new Worker();
						double salaryofWorker = w.calculateSalary(m_splitted[1],m_splitted[2],m_splitted[3],m_splitted[4],p_splitted[3]);
						//Calls calculateSalary method as override from the subclass named Worker
						WritetoFile u= new WritetoFile();
						u.writetofile(p_splitted[0],p_splitted[1],p_splitted[2],p_splitted[3],salaryofWorker);
						//Calls writetofile method to create a new file and print personnel and salary information.
						break;
					case "CHIEF":
						Chief c = new Chief();
						double salaryofChief = c.calculateSalary(m_splitted[1],m_splitted[2],m_splitted[3],m_splitted[4],p_splitted[3]);
						//Calls calculateSalary method as override from the subclass named Chief
						WritetoFile q= new WritetoFile();
						q.writetofile(p_splitted[0],p_splitted[1],p_splitted[2],p_splitted[3],salaryofChief);
						//Calls writetofile method to create a new file and print personnel and salary information.
						break;
					case "PARTTIME_EMPLOYEE":
						PartTimeEmployee p = new PartTimeEmployee();
						double salaryofPTEmployee = p.calculateSalary(m_splitted[1],m_splitted[2],m_splitted[3],m_splitted[4],p_splitted[3]);
						//Calls calculateSalary method as override from the subclass named PartTimeEmployee
						WritetoFile e= new WritetoFile();
						e.writetofile(p_splitted[0],p_splitted[1],p_splitted[2],p_splitted[3],salaryofPTEmployee);
						//Calls writetofile method to create a new file and print personnel and salary information.
						break;
					}
				}
			}
		}
	}


	double calculateSalary(String m_splitted, String m_splitted2, String m_splitted3,String m_splitted4,String yearofStart) {
		
		return 0;
	}

}
