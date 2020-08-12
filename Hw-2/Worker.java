
public class Worker extends FullTimeEmployee{

	@Override
    double calculateSalary(String m_splitted, String m_splitted2, String m_splitted3,String m_splitted4,String yearofStart){
		Integer yearofstart = Integer.valueOf(yearofStart);//convert String to Integer
		Integer week1 = Integer.valueOf(m_splitted);//convert String to Integer
		Integer week2 = Integer.valueOf(m_splitted2);//convert String to Integer
		Integer week3 = Integer.valueOf(m_splitted3);//convert String to Integer
		Integer week4 = Integer.valueOf(m_splitted4);//convert String to Integer
	double severancePay=(currentYear-yearofstart)*20*8/10;// Severance pay changes according to experience of Personnel
	double dayOfWork=20*73;	// Full-time Employees do not work at weekends.(20 days per mounth)
							//Workers are paid 73 TL per day
	int overwork1=week1-40;	//  Workers work for 40 standard hours per week.
	int overwork2=week2-40;
	int overwork3=week3-40;
	int overwork4=week4-40;
	if(overwork1>10){		//Workers can work maximum 10 hours a week to gain overwork salary.
		overwork1=10;
	}
	if(overwork2>10){
		overwork2=10;
	}
	if(overwork3>10){
		overwork3=10;
	}
	if(overwork4>10){
		overwork4=10;
	}
	double overWorkSalary=(overwork1+overwork2+overwork3+overwork4)*4;//Workers are paid 4 TL per hour for overwork salary.
	double salary=overWorkSalary+dayOfWork+severancePay;
	return salary;
	}
}
