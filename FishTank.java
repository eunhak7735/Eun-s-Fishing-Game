package JavaCoding.Fishing_Game;

import java.util.ArrayList;

public class FishTank {
    private ArrayList<Fish> ft;
    private static int fishKept = 0;
    private static int releasedDuringFishing = 0;
    private static int releasedAfterFishing = 0;
    
    //fishtank capacity
    private int max = 15;

    public FishTank(ArrayList<Fish> t1){
        ft = t1;
    }

    public void keepFish(Fish f){
        ft.add(f);
        fishKept++;
    }

    public static int totalFishKept(){
        return fishKept;
    }

    public static int fishReleasedDuringFishing(){
        return releasedDuringFishing;
    }

    public static void increaseDuring(){
        releasedDuringFishing++;
    }

    public static int fishReleasedAfterFishing(){
        return releasedAfterFishing;
    }

    public static void increaseAfter(int i){
        releasedAfterFishing += i;
    }

    public int maxCapacity(){
        return max;
    }

    public boolean isItFull(int s){
        boolean bool = false;
        if (s <= ft.size()) {
            bool = true;
        }
        return bool;
    }

    public void add(Fish f){
        ft.add(f);
    }

    public int size(){
        return ft.size();
    }

    public Fish get(int i){
        return ft.get(i);
    }

    public void set(int i, Fish f){
        ft.set(i, f);
    }

    public void clear(){
        ft.clear();
    }

    public void remove(int i){
        ft.remove(i);
    }

    public String toString(){
        String str = "\nHere is your aquarium:\n";
        if(ft.size() == 0){
            str += "Your aquarium is empty!";
        }
        else{
            for (Fish fish : ft) {
                str += fish.toString() + "\n";
            }
            str += "(" + ft.size() + "/" + max + ")\n";
        }
        return str;
    }

    public String toStringWithNums(){
        String str = "\nHere is your aquarium:\n";
        if(ft.size() == 0){
            str += "Your aquarium is empty!";
        }
        else{
            for (int i = 0; i < ft.size(); i++) {
                str = str + (i + 1) + ": " + ft.get(i).toString() + "\n"; 
            }
            str += "(" + ft.size() + "/" + max + ")\n";
        }
        return str;
    }

    /**
     * This sorts all the fish lightest to heaviest in weight
     * to CHANGE the sort(e.g. heaviest to lightest), just simply change the sign in the WHILE loop. ">" <- change that sign
     * @param ft is fish tank value
     */
    public void sortByWeight(){
        for (int i = 1; i < ft.size(); i++) {
            int numsLeft = i;
            Fish temp = ft.get(i);
            while (numsLeft > 0 && ft.get(numsLeft - 1).getWeight() > temp.getWeight()) {
                ft.set(numsLeft, ft.get(numsLeft - 1));
                numsLeft--;
            }
            ft.set(numsLeft, temp);
        }
    }

    /**
     * This sorts all the fish shortest to longest in length
     * to CHANGE the sort(e.g. longest to shortest), just simply change the sign in the WHILE loop. ">" <- change that sign
     * @param ft is fish tank value
     */
    public void sortByLength(){
        for (int i = 1; i < ft.size(); i++) {
            Fish temp = ft.get(i);
            int numsLeft = i;
            while (numsLeft > 0 && temp.getLength() < ft.get(numsLeft - 1).getLength()) {
                ft.set(numsLeft, ft.get(numsLeft - 1));
                numsLeft--;
            }
            ft.set(numsLeft, temp);
        }
    }

    /**
     * This methods sorts the fishtank by species(alphabetical order)
     * @param i it determines if further sorting is needed
     * if i is 0, no further sorting done, all the fish stay where they were except now 
     * they are with their species
     * if i is 1, it sorts by weight within the species
     * if i is 2, it sorts by length within the species
     * 
     * if more fish are made, more fishtanks required to be made
     */
    public void sortBySpecies(int i){
        //largie
        ArrayList<Fish> largemouth = new ArrayList<Fish>();
        FishTank fishTankforLargemouth = new FishTank(largemouth);
        //bluegill
        ArrayList<Fish> bluegill = new ArrayList<Fish>();
        FishTank fishTankforBluegill = new FishTank(bluegill);
        //crappie
        ArrayList<Fish> crappie = new ArrayList<Fish>();
        FishTank fishTankforCrappie = new FishTank(crappie);
        //carp
        ArrayList<Fish> carp = new ArrayList<Fish>();
        FishTank fishTankforCarp = new FishTank(carp);
        //catfish
        ArrayList<Fish> catfish = new ArrayList<Fish>();
        FishTank fishTankforCatfish = new FishTank(catfish);
        //muskie
        ArrayList<Fish> muskie = new ArrayList<Fish>();
        FishTank fishTankforMuskie = new FishTank(muskie);
        //perch
        ArrayList<Fish> perch = new ArrayList<Fish>();
        FishTank fishTankforPerch = new FishTank(perch);
        //pike
        ArrayList<Fish> pike = new ArrayList<Fish>();
        FishTank fishTankforPike = new FishTank(pike);
        //smallie
        ArrayList<Fish> smallmouth = new ArrayList<Fish>();
        FishTank fishTankforSmallmouth = new FishTank(smallmouth);
        for (Fish fish : ft) {
            if (fish.getSpecies().equals("Bluegill")) {
                fishTankforBluegill.add(fish);
            }
            else if (fish.getSpecies().equals("Largemouth Bass")){
                fishTankforLargemouth.add(fish);
            }
            else if (fish.getSpecies().equals("Crappie")){
                fishTankforCrappie.add(fish);
            }
            else if (fish.getSpecies().equals("Carp")){
                fishTankforCarp.add(fish);
            }
            else if (fish.getSpecies().equals("Catfish")){
                fishTankforCatfish.add(fish);
            }
            else if (fish.getSpecies().equals("Muskellunge")){
                fishTankforMuskie.add(fish);
            }
            else if (fish.getSpecies().equals("Perch")){
                fishTankforPerch.add(fish);
            }
            else if (fish.getSpecies().equals("Pike")){
                fishTankforPike.add(fish);
            }
            else if (fish.getSpecies().equals("Smallmouth Bass")){
                fishTankforSmallmouth.add(fish);
            }
        }
        ft.clear();
        String str = "";
        if (i == 1) {
            str += "and weight.";
            fishTankforBluegill.sortByWeight();
            fishTankforCrappie.sortByWeight();
            fishTankforLargemouth.sortByWeight();
            fishTankforCarp.sortByWeight();
            fishTankforCatfish.sortByWeight();
            fishTankforMuskie.sortByWeight();
            fishTankforPerch.sortByWeight();
            fishTankforPike.sortByWeight();
            fishTankforSmallmouth.sortByWeight();
        }
        else if (i == 2) {
            str += "and length.";
            fishTankforBluegill.sortByLength();
            fishTankforCrappie.sortByLength();
            fishTankforLargemouth.sortByLength();
            fishTankforCarp.sortByLength();
            fishTankforCatfish.sortByLength();
            fishTankforMuskie.sortByLength();
            fishTankforPerch.sortByLength();
            fishTankforPike.sortByLength();
            fishTankforSmallmouth.sortByLength();
        }
        //readding fish into the fish tank
        //THIS HAS TO BE ADDED IN ALPHABETICAL ORDER!!!
        for (int j = 0; j < fishTankforBluegill.size(); j++) {
            ft.add(fishTankforBluegill.get(j));
        }
        for (int j = 0; j < fishTankforCarp.size(); j++) {
            ft.add(fishTankforCarp.get(j));
        }
        for (int j = 0; j < fishTankforCatfish.size(); j++) {
            ft.add(fishTankforCatfish.get(j));
        }
        for (int j = 0; j < fishTankforCrappie.size(); j++) {
            ft.add(fishTankforCrappie.get(j));
        }
        for (int j = 0; j < fishTankforLargemouth.size(); j++) {
            ft.add(fishTankforLargemouth.get(j));
        }
        for (int j = 0; j < fishTankforMuskie.size(); j++) {
            ft.add(fishTankforMuskie.get(j));
        }
        for (int j = 0; j < fishTankforPerch.size(); j++) {
            ft.add(fishTankforPerch.get(j));
        }
        for (int j = 0; j < fishTankforPike.size(); j++) {
            ft.add(fishTankforPike.get(j));
        }
        for (int j = 0; j < fishTankforSmallmouth.size(); j++) {
            ft.add(fishTankforSmallmouth.get(j));
        }
        System.out.println("\nYou have sorted your fish list by their species " + str);
    }
}