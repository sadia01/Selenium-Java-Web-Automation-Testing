package data;

import org.testng.annotations.DataProvider;

public class DataSet {
	

	
	@DataProvider(name = "combinedAccountCheckoutData")
	public static Object[][] combinedDataSet1() {
	    return new Object[][]{
	        {
	            // CreateAccount Data
	            "Cobie", "Rico", "cobiericog@gmail.com", "01612336528", "cobi1234", "cobi1234",
	            // CheckoutProduct Data
	            "Cobie", "Rico", "cobiericog@hotmail.com", "Dhaka", "Rayerbazar, Dhanmondi", "01612336528"
	        },
	        {
	            // CreateAccount Data
	            "Samantha", "Saiko", "samanthasaiko@gmail.com", "01712556443", "saiko1234", "saiko1234",
	            // CheckoutProduct Data
	            "Samantha", "Saiko", "samanthasaiko@gmail.com", "Bagerhat", "Bagerhat Sadar", "01712556443"
	        }
	    };
	}

    @DataProvider(name = "combinedLoginCheckoutData")
    public static Object[][] combinedDataSet2() {
        return new Object[][] {
            { 
            	//Login Data
            	"plengorm@gmail.com", "pleng1234", 
               //Checkout Login Data
            	"01630189022", "plengorm@gmail.com"   
            },
            
               
            { 
            	//Checkout Login Data
            	"wanwiwa@gmail.com", "wan1234", 
            	"01987666789", "wanwiwa@gmail.com"
            }
        };
    }
    

}
