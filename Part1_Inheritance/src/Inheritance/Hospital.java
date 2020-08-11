package Inheritance;
	//********************************************************************
//  Hospital.java       Authors: Lewis/Loftus
//
//  Solution to Programming Project 9.2 
//********************************************************************

class HospitalEmployee {
		
		protected String name;
		protected int number;
		
		//constructor for HospitalEmployee
		 HospitalEmployee(String name, int number) {
			setname(name);
			setnumber(number);
		}
		
		public void setname(String name) {
			this.name = name;
		}
		
		public void setnumber(int number) {
			this.number = number;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getNumber() {
			return this.number;
		}

		public String toString() 
	    { 
	        return name + " " + number ; 
	    }
		//work method
		public void work()
		{
		System.out.println (name + " works for the hospital.");
		}
   }      
   
    class Doctor extends HospitalEmployee {
		
		String speciality;
		
		//constructor for Doctor class
		public Doctor (String name, int number, String speciality) {
			super(name,number);
			this.speciality = speciality;
		}

		//To override toString() method
		public String toString() 
	    { 
	        return name + " " + number + " " + speciality; 
	    }
	}
    
    class Nurse extends HospitalEmployee {
		
		int  numOfPatients;
		
		//constructor for Nurse class
		public Nurse (String name,int number, int numOfPatients) {
			super(name,number);
			this.numOfPatients =  numOfPatients;
		}
		
		//To override toString() method
		public String toString() 
	    { 
	        return name + " " + number + " has " + numOfPatients + " patients."; 
	    }

	}
   
    class Surgeon extends Doctor{

    		boolean operating;
    		
    		//constructor for Surgeon class
    		public Surgeon(String name, int number, String speciality, boolean operating) {
    			super(name,number,speciality);
    			this.operating = operating;
    		}
    		
    		//To override toString() method
    		public String toString() 
    	    { 
    	        return name + " " + number + " " + speciality + " Operating: " + operating ; 
    	    }

    	}
      
  public class Hospital{

   public static void main (String[] args)
   {
      HospitalEmployee vito = new HospitalEmployee ("Vito", 123);
      Doctor michael = new Doctor ("Michael", 234, "Heart");
      Surgeon vincent = new Surgeon ("Vincent", 645, "Brain", true);
      Nurse sonny = new Nurse ("Sonny", 789, 6);
      

      // print the employees
      System.out.println (vito);
      System.out.println (michael);
      System.out.println (vincent);
      System.out.println (sonny);
      

      // invoke the specific methods of the objects
      vito.work();
      michael.work();
      vincent.work();
      sonny.work();
   }
  
}
