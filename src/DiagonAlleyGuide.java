//Name: Carlos Avogadro
//UFL ID: c.avogadro
//Section:6909
//Project Number: 3
//Brief description of file documents: Program that helps Muggels transition into Hogwarts.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class DiagonAlleyGuide {
	//Checks if you have enough money to purchase desired item.
		public static boolean enoughMoney(int galleon, int sickle, int knut, int cost){
			double myBalanceUsd=exchangeMagicToUSD(galleon,sickle,knut);
			double costUsd= exchangeMagicToUSD(0,0,cost);
			if((myBalanceUsd-costUsd)>=0){
				return true;
			}
			else
				return false;
		}
		
		//Dollars left over after buying something
		public static double newBalanceUsd(int galleon, int sickle, int knut, int cost){
			double myBalanceUsd=exchangeMagicToUSD(galleon,sickle,knut);
			double costUsd= exchangeMagicToUSD(0,0,cost);
			double finalUsdBalance=myBalanceUsd-costUsd;
				return finalUsdBalance;
			}
		
		//Changes other magic money into knuts
		public static int othersToKnuts(int galleon,int sickles,int knuts){
			int galleonToKnuts=(galleon*17)*29;
			int sicklesToKnuts=(sickles*29);
			int totalKnuts=galleonToKnuts+sicklesToKnuts+knuts;
			
			return totalKnuts;
		}
		
		//Changes magic money to dollars
		public static double exchangeMagicToUSD(int galleon,int sickles,int knuts){
			 double UsdGalleon=((galleon*17.0)*29.0)*0.10;
			 double UsdSickles=(sickles*29.0)*0.10;
			 double UsdKnuts=(knuts*0.10);
			 double finalDollars=UsdKnuts+UsdSickles+UsdGalleon;
			 
			 return finalDollars;
			
		}
	//converts dollars to galleons 
	public static int exchangeGalleons(double USD){
		
		double galleonsDouble=(((USD/0.10)+0.10)/29.0)/17.0;
		
		int galleons=(int) galleonsDouble;
		
		return galleons;
 }
	//converts dollars to sickles 
	public static int exchangeSickles(double USD){
		double sticklesDouble=(((USD/0.10)+0.10)/29.0)%17;
		
		int sickles=(int) sticklesDouble;
		
		return sickles;
	}
	//exchanges dollars to knuts
	public static int exchangeKnuts(double USD){
		
		double knutsDouble=(((USD/0.10)+0.10)%29);
		
		int knuts=(int) knutsDouble;
		
		return knuts;
	}
	
	//Prints out your balance. Singularity is noted.
	public static void balance(int galleon, int sickle, int knut){
		System.out.println("\nYou have "+galleon+ ((galleon > 1||galleon==0) ? " Galleons" : " Galleon")+", "+sickle+
	((sickle > 1||sickle==0) ? " Sickles" : " Sickle")+", and "+knut+((knut > 1||knut==0) ? " Knuts." : " Knut."));
	}
	
	//Main menu
	public static void mainMenu(){
		System.out.println("Main Menu:\n1. Gringotts Bank\n2. List of Supplies\n3. Shoppes\n4. Leave\n");
		
	}
	
	//Bank menu 
	public static void gringottsMenu(){
		System.out.println("\nGringotts Bank\n1. Exchange Money\n2. Check Balance\n3. Exit");
	}
	
	//Displays the shop menu.
	public static void shoppes(){
		System.out.println("\nShoppes\n1. Broomstix\n2. Second-Hand Robes\n3. Olivanders\n4. Flourish and Blotts\n5. Potage's Cauldron Shop\n6. Exit");
		
		
	}
	
	//Removes items already bought from list
	public static void  haveBought(Collection<String> itemsNeeded,Collection<String> itemsHave){
		
		Iterator<String> iterator=itemsNeeded.iterator();
		
		while(iterator.hasNext()){
			if(itemsHave.contains(iterator.next())){
				iterator.remove();
			}
		}
		}

public static void main(String [] args){
	//Variables
	int optionsMenu=0;
	int optionsBank=0;
	int optionShoppes=0;
	int galleons=0;
	int sickles=0;
	int knuts=0;
	double dollarsToExchange=0;
	double newBalance=0;
	
	//Array with items needed
	String itemsNeeded []={"Broom","School robes","Wand","The Standard Book of Spells","A History of Magic","Magical Drafts and Potions"
			,"Cauldron"};
	
	//Create a list with array elements
	List<String> listItemsNeeded=new ArrayList<String>(Arrays.asList(itemsNeeded));
	
	//List of items already bought
	List<String> listItemsHave=new ArrayList<String>();
	
	Scanner input= new Scanner(System.in);
	
	System.out.println("Welcome to Diagon Alley!\n");
	while(optionsMenu!=4){
		mainMenu();
		optionsBank=0;
		optionShoppes=0;
		
		System.out.print("Selection: ");
		optionsMenu=input.nextInt();
		
		//bank menu
		if(optionsMenu==1){
			while(optionsBank!=3){
				
			gringottsMenu();
			
			System.out.print("\nSelection: ");
			
			optionsBank=input.nextInt();
			
			if (optionsBank==1){
				System.out.print("\nHow much would you like to exchange?\nUSD: ");
				
				dollarsToExchange=input.nextInt();
				if(dollarsToExchange<0){
					System.out.print("\nTransaction failed!\nInput cannot be negative!\n");
				}
				else{
				galleons+=exchangeGalleons(dollarsToExchange);
				
				sickles+=exchangeSickles(dollarsToExchange);
				
				knuts+=exchangeKnuts(dollarsToExchange);
				
				System.out.print("\nTransaction Complete!\n");
				}
				
			}
			
			if (optionsBank==2){
				balance(galleons,sickles,knuts);
				
			}
			if(optionsBank==3){
				System.out.print("\n");
			}
			else if(optionsBank>3||optionsBank<1){
				System.out.println("\nInvalid entry!\n");
			}
			
			}
			
		
		}
		//Inventory Menu
		if(optionsMenu==2){
			System.out.println("\nInventory:");
			for(String e:listItemsHave){
		    	System.out.println(e);
		    	
		    }
			
			System.out.println("\nNeed:");
			for(String e:listItemsNeeded){
		    	System.out.println(e);
		    	
		    }
			System.out.print("\n");
		}
		//Shoopees menu
		if(optionsMenu==3){
			while(optionShoppes!=6){
			shoppes();
			int optionShops=0;
			optionShops=0;
			
			System.out.print("\nSelection: ");
			
			optionShoppes=input.nextInt();
			//Broomstix menu	
			
			if(optionShoppes==1){
					while(optionShops!=2){
						System.out.println("\nBroomstix\n1. Buy Broom for 1 Galleon\n2. Exit");
						System.out.print("\nSelection: ");
						
						optionShops=input.nextInt();
						if (optionShops==1){
							//Prints error if item is already contained in list
							if(listItemsHave.contains("Broom")){
								System.out.println("\nTransaction failed!\nYou already have this!");
								
							}
							
							else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(1,0,0))==false)){
								System.out.println("\nTransaction failed!\nYou do not have enough money!");
										
							}							
							//Adds item to list of items bough and removes it from items needed
							
							else{
								listItemsHave.add("Broom");
								haveBought(listItemsNeeded,listItemsHave);
								
								newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(1,0,0));
								galleons=exchangeGalleons(newBalance);
								
								sickles=exchangeSickles(newBalance);
								
								knuts=exchangeKnuts(newBalance);
								
								System.out.println("\nTransaction successful!");
								
							}
						
						}
						else if(optionShops>2||optionShops<1){
							System.out.println("\nInvalid entry!");
						}
						
					}
					
				}
			else if(optionShoppes==2){
				while(optionShops!=2){
					System.out.println("\nSecond-Hand Robes\n1. Buy School robes for 12 Sickles\n2. Exit");
					System.out.print("\nSelection: ");
					
					optionShops=input.nextInt();
					if (optionShops==1){
						//Prints error if item is already contained in list
						if(listItemsHave.contains("School robes")){
							System.out.println("\nTransaction failed!\nYou already have this!");
							
						}
						else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(0,12,0))==false)){
							System.out.println("\nTransaction failed!\nYou do not have enough money!");
									
						}		
						//Adds item to list of items bough and removes it from items needed
						
						else{
							listItemsHave.add("School robes");
							haveBought(listItemsNeeded,listItemsHave);
							
							newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(0,12,0));
							galleons=exchangeGalleons(newBalance);
							
							sickles=exchangeSickles(newBalance);
							
							knuts=exchangeKnuts(newBalance);
							System.out.println("\nTransaction successful!");
							
						}
					}
					else if(optionShops>2||optionShops<1){
						System.out.println("\nInvalid entry!");
					}
				}
				
			}
			else if(optionShoppes==3){
				while(optionShops!=2){
					System.out.println("\nOlivanders\n1. Buy Wand for 7 Sickles\n2. Exit");
					System.out.print("\nSelection: ");
					
					optionShops=input.nextInt();
					if (optionShops==1){
						//Prints error if item is already contained in list
						if(listItemsHave.contains("Wand")){
							System.out.println("\nTransaction failed!\nYou already have this!");
							
						}
						else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(0,7,0))==false)){
							System.out.println("\nTransaction failed!\nYou do not have enough money!");
									
						}		
						//Adds item to list of items bough and removes it from items needed
						else{
							listItemsHave.add("Wand");
							haveBought(listItemsNeeded,listItemsHave);
							newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(0,7,0));
							galleons=exchangeGalleons(newBalance);
							
							sickles=exchangeSickles(newBalance);
							
							knuts=exchangeKnuts(newBalance);
							
							System.out.println("\nTransaction successful!");
							
						}
					}
					else if(optionShops>2||optionShops<1){
						System.out.println("\nInvalid entry!");
					}
				}
				
			}
			else if(optionShoppes==4){
				optionShoppes=0;
				while(optionShops!=4){
					System.out.println("\nFlourish and Blotts\n1. Buy The Standard Book of Spells for 5 Sickles" +
							"\n2. Buy A History of Magic for 3 Sickles and 12 Knuts\n3. Buy Magical Drafts and Potions for 27 Knuts" +
							"\n4. Exit");
					
					
					System.out.print("\nSelection: ");
					
					optionShops=input.nextInt();
					if (optionShops==1){
						//Prints error if item is already contained in list
						if(listItemsHave.contains("The Standard Book of Spells")){
							System.out.println("\nTransaction failed!\nYou already have this!");
							
						}
						else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(0,5,0))==false)){
							System.out.println("\nTransaction failed!\nYou do not have enough money!");
									
						}		
						//Adds item to list of items bough and removes it from items needed
						else{
							listItemsHave.add("The Standard Book of Spells");
							haveBought(listItemsNeeded,listItemsHave);
							newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(0,5,0));
							galleons=exchangeGalleons(newBalance);
							
							sickles=exchangeSickles(newBalance);
							
							knuts=exchangeKnuts(newBalance);
							System.out.println("\nTransaction successful!");
							
						}
					}
					else if (optionShops==2){
						//Prints error if item is already contained in list
						if(listItemsHave.contains("A History of Magic")){
							System.out.println("\nTransaction failed!\nYou already have this!");
							
						}
						else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(0,3,12))==false)){
							System.out.println("\nTransaction failed!\nYou do not have enough money!");
									
						}		
						//Adds item to list of items bough and removes it from items needed
						else{
							listItemsHave.add("A History of Magic");
							haveBought(listItemsNeeded,listItemsHave);
							newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(0,3,12));
							galleons=exchangeGalleons(newBalance);
							
							sickles=exchangeSickles(newBalance);
							
							knuts=exchangeKnuts(newBalance);
							System.out.println("\nTransaction successful!");
							
						}
					}
					else if (optionShops==3){
						//Prints error if item is already contained in list
						if(listItemsHave.contains("Magical Drafts and Potions")){
							System.out.println("\nTransaction failed!\nYou already have this!");
							
						}
						else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(0,0,27))==false)){
							System.out.println("\nTransaction failed!\nYou do not have enough money!");
									
						}		
						//Adds item to list of items bough and removes it from items needed
						else{
							listItemsHave.add("Magical Drafts and Potions");
							haveBought(listItemsNeeded,listItemsHave);
							newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(0,0,27));
							galleons=exchangeGalleons(newBalance);
							
							sickles=exchangeSickles(newBalance);
							
							knuts=exchangeKnuts(newBalance);
							System.out.println("\nTransaction successful!");
							
						}
					}
					else if(optionShops>4||optionShops<1){
						System.out.println("\nInvalid entry!");
					}
					
				}
				
			}
			else if(optionShoppes==5){
				while(optionShops!=2){
					System.out.println("\nPotage's Cauldron Shop\n1. Buy Cauldron for 10 Sickles\n2. Exit");
					System.out.print("\nSelection: ");
					
					optionShops=input.nextInt();
					if (optionShops==1){
						//Prints error if item is already contained in list
						if(listItemsHave.contains("Cauldron")){
							System.out.println("\nTransaction failed!\nYou already have this!");
							
						}
						else if((enoughMoney(galleons,sickles,knuts,othersToKnuts(0,10,0))==false)){
							System.out.println("\nTransaction failed!\nYou do not have enough money!");
									
						}		
						
						//Adds item to list of items bough and removes it from items needed
						else{
							listItemsHave.add("Cauldron");
							haveBought(listItemsNeeded,listItemsHave);
							newBalance=newBalanceUsd(galleons,sickles,knuts,othersToKnuts(0,10,0));
							galleons=exchangeGalleons(newBalance);
							
							sickles=exchangeSickles(newBalance);
							
							knuts=exchangeKnuts(newBalance);
							System.out.println("\nTransaction successful!");
							
						}
					}
					else if(optionShops>2||optionShops<1){
						System.out.println("\nInvalid entry!");
					}
				}
				
			}
			
			
			else if(optionShoppes==6){
			System.out.println("");
			}
			else if(optionShoppes>6 || optionShoppes<0){
				System.out.println("\nInvalid entry!");
			}
			
	
			}
			
		}
		if(optionsMenu==4 && listItemsNeeded.isEmpty()){
			System.out.println("\nHave a nice day!!");
		}
		else if(optionsMenu==4 && listItemsHave.isEmpty()){
			optionsMenu=0;
			System.out.println("\nYou have no supplies!\n");
		}
		else if(optionsMenu==4 && !(listItemsNeeded.isEmpty())){
			optionsMenu=0;
			System.out.println("\nYou are missing some items!\nMissing:");
			for(String e:listItemsNeeded){
				System.out.println(e);
			}
			System.out.print("\n");
		}
		else if(optionsMenu>4||optionsMenu<1){
			System.out.println("\nInvalid entry!\n");
		}
		
	}
}
}
















