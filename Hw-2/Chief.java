
public class Chief extends FullTimeEmployee {

	@Override
	double calculateSalary(String m_splitted, String m_splitted2, String m_splitted3,String m_splitted4,String yearofStart) {
		Integer yearofstart = Integer.valueOf(yearofStart);// convert String to Integer
		Integer week1 = Integer.valueOf(m_splitted);// convert String to Integer
		Integer week2 = Integer.valueOf(m_splitted2);// convert String to Integer
		Integer week3 = Integer.valueOf(m_splitted3);// convert String to Integer
		Integer week4 = Integer.valueOf(m_splitted4);// convert String to Integer
		double severancePay=(currentYear-yearofstart)*20*8/10;// Severance pay changes according to experience of Personnel
		double dayOfWork=20*84;	// Full-time Employees do not work at weekends.(20 days per mounth)
								//Chiefs are paid 84 TL per day
		int overwork1=week1-40;	//  Chiefs work for 40 standard hours per week.
		int overwork2=week2-40;
		int overwork3=week3-40;
		int overwork4=week4-40;
		if(overwork1>8){		//Chiefs can work maximum 8 hours a week to gain overwork salary.
			overwork1=8;
		}
		if(overwork2>8){
			overwork2=8;
		}
		if(overwork3>8){
			overwork3=8;
		}
		if(overwork4>8){
			overwork4=8;
		}
		double overworksalary=(overwork1+overwork2+overwork3+overwork4)*5;//Chiefs are paid 5 TL per hour for overwork salary.
		double salary=overworksalary+dayOfWork+severancePay;
		return salary;
	}
}
