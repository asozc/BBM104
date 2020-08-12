
public class RemoveBomChar {

	private final String UTF8_BOM = "\uFEFF";

	 String removeUTF8BOM(String reg_number)
	    {
	        		 	
		 	if (reg_number.startsWith(UTF8_BOM))
	        {
	        	reg_number=reg_number.replace(UTF8_BOM, "");
	        }
	        return reg_number;
	        
	    }
	 String removeUTF8BOMm(String personnelname)
	    {
	        
		 	
		 	if (personnelname.startsWith(UTF8_BOM))
	        {
		 		personnelname=personnelname.replace(UTF8_BOM, "");
	        }
	        return personnelname;
	        
	    }

	   
}
