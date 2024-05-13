public class Catfish extends Fish {
    private String species;

    public Catfish(){
        super();
    }

    public Catfish(double w, double l){
        super(w, l);
        species = "Catfish";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Catfish
     *
     * size: increments of 0.1
     * 
     * 10% of Catfish caught are huge 
     * 35-45lb 27-35in
     * 
     * 55% they are regular 
     * 5-35lb 18-27in
     * 
     * 35% they are small
     * 1-5lb 8-18in
     * 
     * @param i % of catching different sizes of Catfish
     * @return returns the Catfish with appropriate size and weight
     * depending on the percentage or probability(return the Catfish caught)
     */
    public static Catfish catfishRiver(int i){
        Catfish c = new Catfish();
        if (i > 90){
            double weight = Math.round((Math.random()*10 + 35)*10.0)/10.0;
            double length = Math.round((Math.random()*8 + 27)*10.0)/10.0;
            Catfish c1 = new Catfish(weight, length);
            c = c1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*30 + 5)*10.0)/10.0;
            double length = Math.round((Math.random()*9 + 18)*10.0)/10.0;
            Catfish c1 = new Catfish(weight, length);
            c = c1;           
        }
        else{
            double weight = Math.round((Math.random()*5 + 1)*10.0)/10.0;
            double length = Math.round((Math.random()*10 + 8)*10.0)/10.0;
            Catfish c1 = new Catfish(weight, length);     
            c = c1;     
        }
        return c;
    }

    public String toString(){
        String str = "";
        double w = super.getWeight();
        if (w >= 35){
            str = w + "lb & " + super.getLength() + "inch Huge " + species + "!";
        }
        else if (w >= 5){
            str = w + "lb & " + super.getLength() + "inch " + species + "!";
        }
        else{
            str = w + "lb & " + super.getLength() + "inch Small " + species + "!";
        }
        return str; 
    }
}
