
public class Security extends Personnel {
	
	@Override
    double calculateSalary(String m_splitted, String m_splitted2, String m_splitted3,String m_splitted4,String yearofStart){
	int maxhourforwork=54;
	Integer yearofstart = Integer.valueOf(yearofStart);//convert String to Integer
	Integer week1 = Integer.valueOf(m_splitted);//convert String to Integer
	Integer week2 = Integer.valueOf(m_splitted2);//convert String to Integer
	Integer week3 = Integer.valueOf(m_splitted3);//convert String to Integer
	Integer week4 = Integer.valueOf(m_splitted4);//convert String to Integer
	double severancePay=(currentYear-yearofstart)*20*8/10;// Severance pay changes according to experience of Personnel
	double transMoney=24*4;//they are paid 4 TL for transportation per day.
	double foodMoney=24*5;//they are paid 5 TL for food per day.
	

	if(week1>maxhourforwork){//If they work more than 54 hours per week they are paid for 54 hours only.
		week1=54;
	}
	if(week2>maxhourforwork){
		week2=54;
	}
	if(week3>maxhourforwork){
		week3=54;
	}
	if(week4>maxhourforwork){
		week4=54;
	}
	double sSalary=(week1+week2+week3+week4)*6.5;//they paid 6.5 tl per hour
	sSalary+=severancePay+foodMoney+transMoney;
	return sSalary;

	
}
}
