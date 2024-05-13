public class Largemouth extends Fish {
    private String species;

    public Largemouth(){
        super();
    }

    public Largemouth(double w, double l){
        super(w, l);
        species = "Largemouth Bass";
    }

    public String getSpecies(){
        return species;
    }

    public double getWeight(){
        return super.getWeight();
    }

    public double getLength(){
        return super.getLength();
    }

    /**
     * Catching Largemouth bass
     * 
     * size: increments of 0.1
     * 
     * 10% of Largemouth bass caught are huge 
     * 5-8lb 15-18in
     * 
     * 45% they are regular 
     * 2-5lb 10-15in
     * 
     * 45% they are small
     * 0.5-1.5lb 5-10in
     * 
     * @param i % of catching different sizes of Largemouth bass
     * @return returns the Largemouth bass with appropriate size and weight
     * depending on the percentage or probability(returns the Largemouth bass caught)
     */
    public static Largemouth LBassPond(int i){
        Largemouth l = new Largemouth();
        if (i > 90){
            double weight = Math.round((Math.random()*3 + 5)*10.0)/10.0;
            double length = Math.round((Math.random()*3 + 15)*10.0)/10.0;
            Largemouth f1 = new Largemouth(weight, length);
            l = f1;           
        }
        else if (i > 45){
            double weight = Math.round((Math.random()*3 + 2.0)*10.0)/10.0;
            double length = Math.round((Math.random()*5 + 10)*10.0)/10.0;
            Largemouth f1 = new Largemouth(weight, length);
            l = f1;           
        }
        else{
            double weight = Math.round((Math.random()*1.5 + 0.5)*10.0)/10.0;
            double length = Math.round((Math.random()*5 + 5)*10.0)/10.0;
            Largemouth f1 = new Largemouth(weight, length);       
            l = f1;     
        }
        return l;
    }

    public String toString(){
        return super.toString() + species + "!";
    }

}
