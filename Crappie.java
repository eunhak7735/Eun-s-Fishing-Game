public class Crappie extends Fish {
    private String species;

    public Crappie(){
        super();
    }

    public Crappie(double w, double l){
        super(w, l);
        species = "Crappie";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Crappie
     * 
     * size: increments of 0.1
     * 
     * 10% of Crappie caught are huge 
     * 1.8-2.3lb 12-15in
     * 
     * 45% they are regular 
     * 0.8-1.8lb 5-12in
     * 
     * 45% they are small
     * 0.6-0.8lb 1-5in
     * 
     * @param i % of catching different sizes of Crappie
     * @return returns the Crappie with appropriate size and weight
     * depending on the percentage or probability(return the Crappie caught)
     */
    public static Crappie CrappiePond(int i){
        Crappie c = new Crappie();
        if (i > 90){
            double weight = Math.round((Math.random()*0.5 + 1.8)*10.0)/10.0;
            double length = Math.round((Math.random()*3 + 12)*10.0)/10.0;
            Crappie c1 = new Crappie(weight, length);
            c = c1;           
        }
        else if (i > 45){
            double weight = Math.round((Math.random()*1 + 0.8)*10.0)/10.0;
            double length = Math.round((Math.random()*7 + 5)*10.0)/10.0;
            Crappie c1 = new Crappie(weight, length);
            c = c1;           
        }
        else{
            double weight = Math.round((Math.random()*0.2 + 0.6)*10.0)/10.0;
            double length = Math.round((Math.random()*1 + 4)*10.0)/10.0;
            Crappie c1 = new Crappie(weight, length);       
            c = c1;     
        }
        return c;
    }

    public String toString(){
        String str = "";
        double w = super.getWeight();
        if (w >= 1.8){
            str = w + "lb & " + super.getLength() + "inch Huge " + species + "!";
        }
        else if (w >= 0.8){
            str = w + "lb & " + super.getLength() + "inch " + species + "!";
        }
        else{
            str = w + "lb & " + super.getLength() + "inch Small " + species + "!";
        }
        return str; 
    }
}
