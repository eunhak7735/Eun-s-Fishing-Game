import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fishing_Game_Main {
    
    private static Fish biggestFish = new Fish();
    private static ArrayList<Fish> t = new ArrayList<Fish>();
    private static FishTank fishTank = new FishTank(t);
    public static void main(String[] args)throws IOException, InterruptedException{
        /**
         * pond fishing doesn't run by methods
         * river fishing I'll try to make it run by methods(creating methods within this class)
         * 
         * MILESTONES:
         * add longest and heaviest fish to the report
         * if have time, add a method so that depending on their weight(% of chance), they would break the line and run away
         * 
         * DONE!
         */
        
        Scanner scan = new Scanner(System.in);
        
        //fishtank capacity
        int storage = 15;
        System.out.println("\n\nWelcome to the Fishing Game!\n");
        System.out.println("Enter \"continue\" to continue or \"exit\" to exit:");
        String answer = scan.nextLine();
        while (!(answer.toLowerCase().equals("continue")) && !(answer.toLowerCase().equals("exit"))) {
            System.out.println("\nEnter the valid word(\"continue\" to continue or \"exit\" to exit): ");
            answer = scan.nextLine();
        }
        //loops back here, start(or menu) of the game
        while ((answer.toLowerCase().equals("continue"))) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("MENU: Enter \"view\" to view your aquarium, \"exit\" to exit, and \"start\" to start fishing");
            String menu = scan.nextLine();
            //just to make sure the user enters the correct value.
            while (!(menu.toLowerCase().equals("exit"))  && !(menu.toLowerCase().equals("view")) && !(menu.toLowerCase().equals("start"))) {
                System.out.println("\nEnter the valid word(\"view\" to view your aquarium, \"exit\" to exit, and \"start\" to start fishing): ");
                menu = scan.nextLine();
            }
            //make remove or release here
            if (menu.toLowerCase().equals("view")) {
                System.out.println(fishTank.toString()); 
                if (fishTank.size() > 0){
                    //methods in aquarium
                    System.out.println("What would you like to do?");
                    System.out.println("Enter \"release\" to release fish, \"sort\" to sort your aquarium(least to greatest, or by species), else to go back to the menu:");
                    String decOnFt = scan.nextLine();
                    while (decOnFt.toLowerCase().equals("release") || decOnFt.toLowerCase().equals("sort")) {
                        if (fishTank.size() == 0) {
                            System.out.println("\nYou have no fish in your aquarium!");
                            System.out.println("Going back to the menu...");
                            break;
                        }
                        if (decOnFt.toLowerCase().equals("sort")) {
                            System.out.println("\nEnter \"weight\" to sort by weight, \"length\" to sort by length, \"species\" to sort by species(alphabetical order):");
                            String viewDec = scan.nextLine();
                            while (!(viewDec.toLowerCase().equals("species")) && !(viewDec.toLowerCase().equals("weight")) && !(viewDec.toLowerCase().equals("length"))) {
                                System.out.println("\nEnter the valid word(\"weight\" to sort by weight, \"length\" to sort by length \"species\" to sort by species(alphabetical order)):");
                                viewDec = scan.nextLine();
                            }
                            if (viewDec.toLowerCase().equals("weight")) {
                                fishTank.sortByWeight();
                                System.out.println("\nYou have sorted your fish list by their weight:");
                                System.out.println(fishTank.toString());
                            }
                            else if (viewDec.toLowerCase().equals("length")) {
                                fishTank.sortByLength();
                                System.out.println("\nYou have sorted your fish list by their length:");
                                System.out.println(fishTank.toString());
                            }
                            else if (viewDec.toLowerCase().equals("species")) {
                                System.out.println("\nEnter 1 to sort by weight within the species, 2 to sort by length within the species, 0 to keep the order within the species:");
                                int num = scan.nextInt();
                                while (num > 2 || num < 0) {
                                    System.out.println("\nPlease enter the valid number:");
                                    num = scan.nextInt();
                                }
                                fishTank.sortBySpecies(num);
                                System.out.println(fishTank.toString());
                                decOnFt = scan.nextLine();
                            }
                            System.out.println("What would you like to do now?");
                            System.out.println("Enter \"release\" to release fish, \"sort\" to sort your aquarium(least to greatest, or by species), else to go back to the menu:");
                            decOnFt = scan.nextLine();
                        }
                        else if (decOnFt.toLowerCase().equals("release")){
                            //release method here
                            //after release method the loop goes below
                            System.out.println("\nWould you like to release by species(Enter \"yes\" to release by species, \"no\" to release individually)?");
                            String yesOrNo = scan.nextLine();
                            while (!(yesOrNo.toLowerCase().equals("yes")) && !(yesOrNo.toLowerCase().equals("no"))) {
                                System.out.println("\nEnter the valid response please:");
                                yesOrNo = scan.nextLine();
                            }
                            if (yesOrNo.toLowerCase().equals("no")){
                                //releasing individually
                                int fishNum = fishTank.size();
                                System.out.println(fishTank.toStringWithNums());
                                System.out.println("Enter the assigned numbers of fish that you want to release, -1 to stop:");
                                int assigned = scan.nextInt();
                                //index numbers added to nums
                                ArrayList<Integer> nums = new ArrayList<Integer>();
                                while (assigned != -1) {
                                    while (assigned > fishTank.size() || assigned < -1 || assigned == 0) {
                                        System.out.println("\nEnter the valid assigned number please:");
                                        assigned = scan.nextInt();
                                    }
                                    if (assigned == -1) {
                                        break;
                                    }
                                    nums.add(assigned - 1);
                                    assigned = scan.nextInt(); 
                                }
                                System.out.println("");
                                for (int i = 0; i < nums.size(); i++) {
                                    Fish temp = new Fish();
                                    int indexNum = nums.get(i);
                                    if (fishTank.get(indexNum).getWeight() != 0 && fishTank.get(indexNum).getLength() != 0){
                                        System.out.print("You have released " + (indexNum + 1) + ": " + fishTank.get(indexNum).toString() + "\n");    
                                    }
                                    fishTank.set(indexNum, temp);
                                }
                                for (int i = 0; i < fishTank.size(); i++) {
                                    if (fishTank.get(i).getLength() == 0.0 && fishTank.get(i).getWeight() == 0) {
                                        fishTank.remove(i);
                                        i--;
                                    }
                                }
                                int FishReleased = fishNum - fishTank.size();
                                FishTank.increaseAfter(FishReleased);
                                System.out.println(fishTank.toString());
                                System.out.println("What would you like to do now?");
                                System.out.println("Enter \"release\" to release fish again, \"sort\" to sort your aquarium(least to greatest, or by species), else to go back to the menu:");
                                decOnFt = scan.nextLine();
                                decOnFt = scan.nextLine();
                            }
                            else if (yesOrNo.toLowerCase().equals("yes")){
                                //implement a method to release by species
                                //you can make a tap out method by writing decOnFt below the spell check while loop
                                //and then make an if statement that goes if it equals tap out, break so it would go back to the menu
                                System.out.println("\nEnter the species that you want to release:");
                                String species = scan.nextLine().replace(" ", "").toLowerCase();
                                while (!(isThereThisSpecies(species, fishTank))) {
                                    System.out.println("\nThe entered species doesn't exist in your aquarium. Please enter the valid species: ");
                                    species = scan.nextLine().replace(" ", "").toLowerCase();
                                }
                                //break; goes back to the menu since this else if is inside the release or sort while loop, which is 
                                //inside the menu while loop. so this break stops the release or sort while loop, so it goes back
                                // up to the menu
                                //
                                System.out.println("");
                                String tem = "";
                                int count = 0;
                                for (int i = 0; i < fishTank.size(); i++) {
                                    if (fishTank.get(i).getSpecies().replace(" ", "").toLowerCase().equals(species)) {
                                        tem = fishTank.get(i).getSpecies();
                                        fishTank.remove(i);
                                        count++;
                                        i--;
                                    }
                                }
                                System.out.println("You have released all the " + tem + "(" + count + " fish)!");
                                FishTank.increaseAfter(count);
                                System.out.println(fishTank.toString());
                                System.out.println("What would you like to do now?");
                                System.out.println("Enter \"release\" to release fish again, \"sort\" to sort your aquarium(least to greatest, or by species), else to go back to the menu:");
                                decOnFt = scan.nextLine();
                                //decOnFt = scan.nextLine();
                            }
                        }
                    }   
                }
            }
            else if(menu.toLowerCase().equals("exit")){
                break;
            }
            else{//menu equals start
                if (!fishTank.isItFull(storage)){
                    System.out.println("\nYou're on a fishing trip!");
                    System.out.println("Please choose a place to go fishing(Enter \"pond\" or \"river\"):");
                    String place = scan.nextLine();
                    //below is fishing at the pond
                    while (!(place.toLowerCase().equals("pond")) && !(place.toLowerCase().equals("river"))) {
                        System.out.println("\nEnter the valid word(\"pond\" or \"river\"): ");
                        place = scan.nextLine();
                    }
                    if (place.toLowerCase().equals("pond")){
                        System.out.println("\nThese are the types of fish in the pond:\nBluegill, Crappie, and Largemouth Bass.\n");
                        System.out.println("The maximum fish you can store in your aquarium is " + storage + ".");
                        System.out.println("\nEnter \"c\" to make your first cast, \"v\" to view your aquarium, else to go back to the menu:");
                        String choice = scan.nextLine();
                        while (choice.toLowerCase().equals("c") || choice.toLowerCase().equals("v")) {
                            if (fishTank.isItFull(storage) && choice.toLowerCase().equals("c")) {
                                System.out.println("\nYour aquarium is full(" + fishTank.size() + "/" + storage + "), try releasing some of the fish to continue fishing.");
                                System.out.println("Going back to the menu...");
                                break;
                            }
                            while (choice.toLowerCase().equals("c")){
                                if (fishTank.isItFull(storage)) {
                                    break;
                                }
                                int probC = (int)(Math.random()*100);//0-99
                                for (int i = 5; i > 0; i--) {
                                    System.out.print(" . ");
                                    Thread.sleep(1000);
                                }
                                choice = castPond(probC, scan);
                                
                            }
                            if (!(choice.toLowerCase().equals("c")) && !(choice.toLowerCase().equals("v"))) {
                                System.out.println("\nYou paused." + fishTank.toString());
                                System.out.println("Enter \"c\" to continue fishing, else to stop fishing and go back to the menu:");
                                choice = scan.nextLine();
                                if(choice.toLowerCase().equals("c")){
                                    System.out.println("\nEnter \"c\" to make a cast, \"v\" to view your aquarium, and else go back to the menu:");
                                    choice = scan.nextLine();
                                }
                            }
                            if (choice.toLowerCase().equals("v")) {
                                System.out.println(fishTank.toString());
                                System.out.println("Enter \"c\" to make a cast, \"v\" to view your aquarium again, else to stop fishing and go back to the menu:");
                                choice = scan.nextLine();
                            }
                        }
                    }
                    //river
                    else if (place.toLowerCase().equals("river")){
                        System.out.println("\nThese are the types of fish in the river:\nCarp, Catfish, Muskellunge, Perch, Pike, and Smallmouth Bass.\n");
                        System.out.println("The maximum fish you can store in your aquarium is " + storage + ".");
                        System.out.println("\nEnter \"c\" to make your first cast, \"v\" to view your aquarium, else to go back to the menu:");
                        String choice = scan.nextLine();
                        while (choice.toLowerCase().equals("c") || choice.toLowerCase().equals("v")) {
                            if (fishTank.isItFull(storage) && choice.toLowerCase().equals("c")) {
                                System.out.println("\nYour aquarium is full(" + fishTank.size() + "/" + storage + "), try releasing some of the fish to continue fishing.");
                                System.out.println("Going back to the menu...");
                                break;
                            }
                            while (choice.toLowerCase().equals("c")){
                                if (fishTank.isItFull(storage)) {
                                    break;
                                }
                                int probC = (int)(Math.random()*100);//0-99, change 100 to 1000 to add one decimal to the percentage.
                                // 100 = 0.0n. 1000 = 0.00n
                                //System.out.println("");
                                //scan.wait();
                                for (int i = 5; i > 0; i--) {
                                    System.out.print(" . ");
                                    Thread.sleep(1000);
                                }
                                choice = castRiver(probC, scan);
                                
                            }
                            if (!(choice.toLowerCase().equals("c")) && !(choice.toLowerCase().equals("v"))) {
                                System.out.println("\nYou paused." + fishTank.toString());
                                System.out.println("Enter \"c\" to continue fishing, else to stop fishing and go back to the menu:");
                                choice = scan.nextLine();
                                if(choice.toLowerCase().equals("c")){
                                    System.out.println("\nEnter \"c\" to make a cast, \"v\" to view your aquarium, and else go back to the menu:");
                                    choice = scan.nextLine();
                                }
                            }
                            if (choice.toLowerCase().equals("v")) {
                                System.out.println(fishTank.toString());
                                System.out.println("Enter \"c\" to make a cast, \"v\" to view your aquarium again, else to stop fishing and go back to the menu:");
                                choice = scan.nextLine();
                            }
                        }
                    }
                }
                //if the storage is full
                else if (fishTank.isItFull(storage)) {
                    System.out.println("\nYour aquarium is full(" + fishTank.size() + "/" + storage + "), try releasing some of the fish to continue fishing.");
                    System.out.println("Going back to the menu...");
                }
            }
        }
        System.out.println("\nCheck out the report file created for you!");
        System.out.println("Hope to see you again!");
        //filewriter here:
        //for the file name, write where you want your file to be created. 
        //Write only the name of the file if you don't care
        FileWriter fileWriter = new FileWriter("/Users/eunhaklee/Library/Mobile Documents/com~apple~CloudDocs/EunieCoding/JavaCoding/Fishing_Game/Report_of_the_Day");
        String report = "This is the fishing report of the day:\n\nTotal fish caught: " + (FishTank.totalFishKept() + FishTank.fishReleasedDuringFishing()) + "\nTotal fish kept: " + FishTank.totalFishKept() + "\nTotal fish released during fishing: " + FishTank.fishReleasedDuringFishing() + "\nTotal fish released after fishing: " + FishTank.fishReleasedAfterFishing() + "\nTotal fish released overall: " + (FishTank.fishReleasedAfterFishing() + FishTank.fishReleasedDuringFishing()) + "\nTotal number of fish currently in the aquarium: " + fishTank.size() + "\n\nBiggest fish caught: " + biggestFish.toString() + "\n" + fishTank.toString();
        fileWriter.write(report);
        scan.close();
        fileWriter.close();
    }
    
    /**
     * checking if entered species exists in my fishtank
     * @param str fish species trying to find  
     * @param f my fishtank
     * @return returns true if it's there, false if there isn't
     */
    public static boolean isThereThisSpecies(String str, FishTank f){
        boolean bool = false;
        ArrayList<String> fishSpecies = new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            //overridden, so it returns largemouth, bluegill, etc as species, instead of Fish
            fishSpecies.add(f.get(i).getSpecies());
        }
        for (int i = 0; i < fishSpecies.size(); i++) {
            if (fishSpecies.get(i).replace(" ", "").toLowerCase().equals(str)) {
                bool = true;
            }
        }
        return bool;
    }

    /**
     * deciding whether to release or keep the fish
     * @param a fish value
     * @param ans answer to keep or no
     * @return returns the decision
     */
    public static void decideOnFish(Fish a, String ans, FishTank f){
        if (ans.toLowerCase().equals("k")){
            f.keepFish(a);
            System.out.println("\nFish kept(" + f.size() + "/" + f.maxCapacity() + ")!");
        }
        else{
            FishTank.increaseDuring();
            System.out.println("\nYou have released the fish.");
        }
    }

    public static String castRiver(int prob, Scanner scan){
        String choice = "";
        //scan.notify();
        if (prob > 94){
            //5% of catching carp
            int probS = (int)(Math.random()*100);
            Carp c = new Carp();
            c = Carp.carpRiver(probS);
            if (c.getWeight() > biggestFish.getWeight()) {
                biggestFish = c;
            }
            System.out.println("\nYou caught " + c.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(c, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if (prob > 87){
            //7% of catching catfish
            int probS = (int)(Math.random()*100);
            Catfish c = new Catfish();
            c = Catfish.catfishRiver(probS);
            if (c.getWeight() > biggestFish.getWeight()) {
                biggestFish = c;
            }
            System.out.println("\nYou caught " + c.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(c, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if(prob > 86){
            //1% of catching muskie
            int probS = (int)(Math.random()*100);
            Muskellunge m = new Muskellunge();
            m = Muskellunge.muskieRiver(probS);
            if (m.getWeight() > biggestFish.getWeight()) {
                biggestFish = m;
            }
            System.out.println("\nYou caught " + m.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(m, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if(prob > 77){
            //9% of catching perch
            int probS = (int)(Math.random()*100);
            Perch p = new Perch();
            p = Perch.perchRiver(probS);
            if (p.getWeight() > biggestFish.getWeight()) {
                biggestFish = p;
            }
            System.out.println("\nYou caught " + p.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(p, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if(prob > 68){
            //9% of catching pike
            int probS = (int)(Math.random()*100);
            Pike p = new Pike();
            p = Pike.pikeRiver(probS);
            if (p.getWeight() > biggestFish.getWeight()) {
                biggestFish = p;
            }
            System.out.println("\nYou caught " + p.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(p, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if(prob > 54){
            //14% of catching smallmouth bass
            int probS = (int)(Math.random()*100);
            Smallmouth s = new Smallmouth();
            s = Smallmouth.smallieRiver(probS);
            if (s.getWeight() > biggestFish.getWeight()) {
                biggestFish = s;
            }
            System.out.println("\nYou caught " + s.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(s, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else {
            //55% of catching nothing
            System.out.println("\nYou caught nothing...");
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        return choice;
    }

    public static String castPond(int prob, Scanner scan){
        String choice = "";
        if (prob > 74){
            //25% of catching largemouth bass
            int probS = (int)(Math.random()*100);
            Largemouth l = new Largemouth();
            l = Largemouth.LBassPond(probS);
            if (l.getWeight() > biggestFish.getWeight()) {
                biggestFish = l;
            }
            System.out.println("\nYou caught " + l.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(l, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if (prob > 34){
            //40% of catching bluegill
            int probS = (int)(Math.random()*100);
            Bluegill b = new Bluegill();
            b = Bluegill.BGillPond(probS);
            if (b.getWeight() > biggestFish.getWeight()) {
                biggestFish = b;
            }
            System.out.println("\nYou caught " + b.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(b, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else if (prob > 24){
            //10% of catching crappie
            int probS = (int)(Math.random()*100);
            Crappie c = new Crappie();
            c = Crappie.CrappiePond(probS);
            if (c.getWeight() > biggestFish.getWeight()) {
                biggestFish = c;
            }
            System.out.println("\nYou caught " + c.toString());
            System.out.println("Enter \"k\" to keep, else to release:");
            String dec = scan.nextLine();
            decideOnFish(c, dec, fishTank);
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        else {
            //25% of catching nothing
            System.out.println("\nYou caught nothing...");
            System.out.println("Enter \"c\" to cast again, \"v\" to view your aquarium, else to pause:");
            choice = scan.nextLine();
        }
        return choice;
    }


}
