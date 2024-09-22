
public class Practice {

	
	
	private int rollnum;
	private String name;

	
	

	public static void sum(Practice s) {
		System.out.println("student details: "+ s.name + "roll number " +s.rollnum);	
	}	

public Practice() {
		
		System.out.println("the default constructor");
		
	}
	

	public Practice(int rollnum, String name) {
		this();
		
		this.rollnum = rollnum;
		
		this.name = name;
	}

public static void main(String[] args)
	
	{
	System.out.println("the default constructor new");
	Practice p= new Practice();
	System.out.println("the default constructor old");
	p.rollnum=23;
	p.name="heena";
	System.out.println("the default constructor demo");
	Practice p1= new Practice();
	p1.rollnum=26;
	p1.name="heenaeee";
	
	
	sum(p);
	sum(p1);
	//System.out.println("Student p details name "+p.name+ "rollnum" + p.rollnum);
	
	//System.out.println("Student p1 details name "+p1.name+ "rollnum" + p1.rollnum);
	}

}
