import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)
    private static Scanner scnr = new Scanner(System.in);
    private static String userInput = "-1";
    private static boolean needInput = true;

    public static void main(String[] args) 
    {


        initializeDogList();
        initializeMonkeyList();

        // Loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        do
        {
        	displayMenu();
        	userInput = scnr.nextLine();
        	switch (userInput)
        	{
        		case "1": intakeNewDog(scnr);
        			break;
        		case "2": intakeNewMonkey(scnr);
        			break;
        		case "3": reserveAnimal(scnr);
        			break;
        		case "4": printAnimals("dogs");
        			break;
        		case "5": printAnimals("monkeys");
        			break;
        		case "6": printAnimals("available");
        			break;
        		case "Q":
        		case "q": needInput = false;
        			break;
        		default: 
        			System.out.println("\nInvalid Input. Please enter 1, 2, 3, 4, 5, 6, or q.");
        			break;
        	}
        } while (needInput);
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    }

    // This method prints the menu options
    public static void displayMenu() 
    {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() 
    {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() 
    {
    	Monkey monkey1 = new Monkey("Jack", "Capuchin", "male", "5", "23.2", "36.1", "20.1", "23.0", "03-03-2006", "Barbados", "in service", false, "The Bahamas");
    	Monkey monkey2 = new Monkey("Sky", "Squirrel Monkey", "female", "2", "30.9", "18.0", "23.1", "22.5", "01-20-2015", "New Zealand", "Phase II", false, "United States");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    }


    // Intakes new dogs into Dog ArrayList
    public static void intakeNewDog(Scanner scanner) 
    {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is " + name + "'s breed?");
        String breed = scanner.nextLine();
        
        System.out.println("What is " + name + "'s gender?");
        String gender = scanner.nextLine();
        
        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine();
        
        System.out.println("What is " + name + "'s weight?");
        String weight = scanner.nextLine();
        
        System.out.println("What is " + name + "'s acquisition date?");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("What is " + name + "'s acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("What is " + name + "'s training status?");
        String trainingStatus = scanner.nextLine();
        
        //Input validation loop for reserve status
        boolean needInput = true;
        boolean reserved = false;
        do 
        {
	        System.out.println("Is " + name + " reserved?");
	        String userInput = scanner.nextLine().toLowerCase();
	        switch (userInput)
	        {
	        	case "yes":
	        		reserved = true;
	        		needInput = false;
	        		break;
	        	case "no":
	        		reserved = false;
	        		needInput = false;
	        		break;
	        	default:
	        		System.out.println("\nInvalid input. Please enter \"Yes\" or \"No\".\n");
	        		break;
	        }
        } while (needInput);
        
        System.out.println("What is " + name + "'s service country?");
        String inServiceCountry = scanner.nextLine();
        
        // Instantiates a new dog and adds it to the Dog ArrayList
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        
        System.out.println("\n" + name + " has been added.");
    }


    	// Intakes new monkeys into Monkey ArrayList
        public static void intakeNewMonkey(Scanner scanner) 
        {
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            // Input validation for allowed monkey species
            boolean needInput = true;
            String species = "-1";
            do
            {
	            System.out.println("What is " + name + "'s species?");
	            species = scanner.nextLine();
	            switch (species.toLowerCase())
	            {
	            	case "capuchin":
	            	case "guenon":
	            	case "macaque":
	            	case "marmoset":
	            	case "squirrel monkey":
	            	case "tamarin":
	            		needInput = false;
	            		break;
	            	default:
	            		System.out.println("\nInvalid input. Please enter a valid species.\n");
	            		break;
	            }
            } while (needInput);
            
            System.out.println("What is " + name + "'s gender?");
            String gender = scanner.nextLine();
            
            System.out.println("What is " + name + "'s age?");
            String age = scanner.nextLine();
            
            System.out.println("What is " + name + "'s weight?");
            String weight = scanner.nextLine();
            
            System.out.println("What is " + name + "'s height?");
            String height = scanner.nextLine();
            
            System.out.println("What is " + name + "'s body length?");
            String bodyLength = scanner.nextLine();
            
            System.out.println("What is " + name + "'s tail length?");
            String tailLength = scanner.nextLine();
            
            System.out.println("What is " + name + "'s acquisition date?");
            String acquisitionDate = scanner.nextLine();
            
            System.out.println("What is " + name + "'s acquisition country?");
            String acquisitionCountry = scanner.nextLine();
            
            System.out.println("What is " + name + "'s training status?");
            String trainingStatus = scanner.nextLine();
            
            //Input validation loop for reserve status
            needInput = true;
            boolean reserved = false;
            do 
            {
    	        System.out.println("Is " + name + " reserved?");
    	        String userInput = scanner.nextLine().toLowerCase();
    	        switch (userInput)
    	        {
    	        	case "yes":
    	        		reserved = true;
    	        		needInput = false;
    	        		break;
    	        	case "no":
    	        		reserved = false;
    	        		needInput = false;
    	        		break;
    	        	default:
    	        		System.out.println("\nInvalid input. Please enter \"Yes\" or \"No\".\n");
    	        		break;
    	        }
            } while (needInput);
            
            System.out.println("What is " + name + "'s service country?");
            String inServiceCountry = scanner.nextLine();
            
            // Instantiates a new monkey and adds it to the Monkey ArrayList
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
            monkeyList.add(newMonkey);
            
            System.out.println("\n" + name + " has been added.");
        }

        // Reserves animals by via animal type and service country
        public static void reserveAnimal(Scanner scanner) 
        {
        	boolean needInput = true;
        	boolean animalFound = false;
        	
        	System.out.println("In what country is the animal being reserved?");
        	String inServiceCountry = scanner.nextLine();
        	
        	do
        	{
	            System.out.println("Are you reserving a dog or a monkey?");
	            String userInput = scanner.nextLine();
	            switch (userInput.toLowerCase())
	            {
	            	// Reserves a dog in input country
	            	case "dog":
	            		for (Dog dog: dogList)
	            		{
	            			if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry))
	            			{
	            				dog.setReserved(true);
	            				animalFound = true;
	            				System.out.println("\n" + dog.getName() + " is reserved for " + inServiceCountry + ".");
	            				break;
	            			}
	            		}
	            		if (!animalFound)
	            		{
	            			System.out.println("\nThere are no available dogs in " + inServiceCountry + ".");
	            		}
	            		needInput = false;
	            		break;
	            	// Reserves a monkey in input country
	            	case "monkey":
	            		for (Monkey monkey: monkeyList)
	            		{
	            			if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry))
	            			{
	            				monkey.setReserved(true);
	            				animalFound = true;
	            				System.out.println("\n" + monkey.getName() + " is reserved for " + inServiceCountry + ".");
	            				break;
	            			}
	            		}
	            		if (!animalFound)
	            		{
	            			System.out.println("\nThere are no available monkeys in " + inServiceCountry + ".");
	            		}
	            		needInput = false;
	            		break;
	            	// Input validation error message
	            	default:
	            		System.out.println("\nInvalid Input. Please enter \"Dog\" or \"Monkey\".\n");
	            		break;
	            }
        	} while (needInput);
        }

        // Prints list of either all dogs, all monkeys, or all available rescue animals.
        public static void printAnimals(String listType) 
        {
        	// FIXME List of all dogs
        	if (listType.equals("dogs"))
        	{
        		System.out.println("This option needs to be implemeted");
        	}
        	// FIXME List of all monkeys
        	if (listType.equals("monkeys"))
        	{
        		System.out.println("This option needs to be implemeted");
        	}
        	// List of in service and unreserved animals
        	if (listType.equals("available"))
	        {
	        	System.out.println("In-service and available rescue animals: ");
	        	System.out.println("------------------------------------------------\n");
	        		for (Dog dog: dogList)
	        		{
	        			if ((dog.getReserved() == false) && (dog.getTrainingStatus().equalsIgnoreCase("in service")))
	        			{
	        				System.out.println("Dog: " + dog.getName() + ": ");
	        				System.out.println(" | Training status: " + dog.getTrainingStatus());
	        				System.out.println(" | Acquisition country: " + dog.getAcquisitionLocation());
	        				System.out.println(" | Reservation status: " + dog.getReserved());
	        				System.out.println();
	        			}
	        		}
	        		for (Monkey monkey: monkeyList)
	        		{
	        			if ((monkey.getReserved() == false) && (monkey.getTrainingStatus().equalsIgnoreCase("in service")))
	        			{
	        				System.out.println("Monkey: " + monkey.getName() + ": ");
	        				System.out.println(" | Training status: " + monkey.getTrainingStatus());
	        				System.out.println(" | Acquisition country: " + monkey.getAcquisitionLocation());
	        				System.out.println(" | Reservation status: " + monkey.getReserved());
	        				System.out.println();
	        			}
	        		}
        	}

        }
}

