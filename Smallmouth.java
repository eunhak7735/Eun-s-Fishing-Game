package JavaCoding.Fishing_Game;

public class Smallmouth extends Fish{
    private String species;

    public Smallmouth(){
        super();
    }

    public Smallmouth(double w, double l){
        super(w, l);
        species = "Smallmouth Bass";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Smallmouth bass
     *  
     * size: increments of 0.1
     * 
     * 10% of Smallmouth bass caught are huge 
     * 3.7-5.5lb 14-18in
     * 
     * 55% they are regular 
     * 1.5-3.7lb 8-14in
     * 
     * 35% they are small
     * 0.5-1.5lb 5-8in
     * 
     * @param i % of catching different sizes of Smallmouth bass
     * @return returns the Smallmouth bass with appropriate size and weight
     * depending on the percentage or probability(return the Smallmouth bass caught)
     */
    public static Smallmouth smallieRiver(int i){
        Smallmouth s = new Smallmouth();
        if (i > 90){
            double weight = Math.round((Math.random()*1.8 + 3.7)*10.0)/10.0;
            double length = Math.round((Math.random()*4 + 14)*10.0)/10.0;
            Smallmouth s1 = new Smallmouth(weight, length);
            s = s1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*2.2 + 1.5)*10.0)/10.0;
            double length = Math.round((Math.random()*6 + 8)*10.0)/10.0;
            Smallmouth s1 = new Smallmouth(weight, length);
            s = s1;           
        }
        else{
            double weight = Math.round((Math.random()*1 + 0.5)*10.0)/10.0;
            double length = Math.round((Math.random()*3 + 5)*10.0)/10.0;
            Smallmouth s1 = new Smallmouth(weight, length);
            s = s1;     
        }
        return s;
    }

    public String toString(){
        String str = "";
        double w = super.getWeight();
        if (w > 3.7){
            str = w + "lb & " + super.getLength() + "inch Huge " + species + "!";
        }
        else if (w > 2){
            str = w + "lb & " + super.getLength() + "inch " + species + "!";
        }
        else{
            str = w + "lb & " + super.getLength() + "inch Small " + species + "!";
        }
        return str; 
    }
}
