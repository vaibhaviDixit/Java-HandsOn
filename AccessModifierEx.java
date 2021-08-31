package modify; //modify package
import defaultAcc.Default; // import Default class
import protectedAcc.Protected; // import Protected class
import privateAcc.Private; //import Private class
import publicAcc.Public;//import Public class

/*
 * Author :vaibhavi 
 * code to demonstrate access modifiers in package
 */
public class AccessModifierEx extends Protected{
	
	void callSuperMethods() {
		
		//protected access modifier of protected class is accessible only by inheritance outside the package
	    super.proMethod(4, 6); //super keyword is used to call Protected class fields
	    int a=super.proVar;
	    
	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create default class object
	    Default df=new Default();
	    
	   //int a= df.defaultVar;//error: default not accessible outside the package
	    
		Protected pro=new Protected();// protected is accessible outside package
        int a=pro.pub;//public variable of Protected class is accessible only
        // # public is accessible anywhere
        
        //create object of Public class which have all public fields and methods
        Public pb=new Public();
        int b=pb.pubVar;
        pb.pubMethod(23, 12);
        
        //create object of Private class which have all private fields and methods
        Private prv=new Private();
      //not accessible outside package
        //int pv=prv.privateVar; error
        //prv.privMethod;    error
        
		
        /*
         * public is accessible anywhere
         * private is accessible only inside that class
         * default is accessible inside same class and same package
         * protected is accessible  inside same class , same package and subclass of outside the package
         * 
         */
		
		

	}

}
