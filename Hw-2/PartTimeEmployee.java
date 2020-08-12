
public class PartTimeEmployee extends Employee {

	@Override
    double calculateSalary(String m_splitted, String m_splitted2, String m_splitted3,String m_splitted4,String yearofStart){

		Integer week1 = Integer.valueOf(m_splitted);//convert String to Integer
		Integer week2 = Integer.valueOf(m_splitted2);//convert String to Integer
		Integer week3 = Integer.valueOf(m_splitted3);//convert String to Integer
		Integer week4 = Integer.valueOf(m_splitted4);//convert String to Integer
		if(week1<10){		//If they work less than 10 hours no money paid.
			week1=0;
		}
		else if(week1>20){//If they work more than 20 hours they are paid for 20 hours only.
			week1=20;
		}
		if(week2<10){
			week2=0;
		}
		else if(week2>20){
			week2=20;
		}
		if(week3<10){
			week3=0;
		}
		else if(week3>20){
			week3=20;
		}
		if(week4<10){
			week4=0;
		}
		else if(week4>20){
			week4=20;
		}
	
	double salary=(week1+week2+week3+week4)*12;//they paid 12 tl per hour
	return salary;
	}
}
