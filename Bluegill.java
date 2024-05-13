public class Bluegill extends Fish{
    private String species;

    public Bluegill(){
        super();
    }

    public Bluegill(double w, double l){
        super(w, l);
        species = "Bluegill";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Bluegill
     * 
     * size: increments of 0.1
     * 
     * 10% of Bluegill caught are huge 
     * 1.0-1.5lb 7-9in
     * 
     * 55% they are regular 
     * 0.5-1.0lb 4-7in
     * 
     * 35% they are small
     * 0.1-0.5lb 2-4in
     * 
     * @param i % of catching different sizes of Bluegill
     * @return returns the Bluegill with appropriate size and weight
     * depending on the percentage or probability(returns the Bluegill caught)
     */
    public static Bluegill BGillPond(int i){
        Bluegill b = new Bluegill();
        if (i > 90){
            double weight = Math.round((Math.random()*0.5 + 1)*10.0)/10.0;
            double length = Math.round((Math.random()*2 + 7)*10.0)/10.0;
            Bluegill b1 = new Bluegill(weight, length);
            b = b1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*0.5 + 0.5)*10.0)/10.0;
            double length = Math.round((Math.random()*3 + 4)*10.0)/10.0;
            Bluegill b1 = new Bluegill(weight, length);
            b = b1;           
        }
        else{
            double weight = Math.round((Math.random()*0.4 + 0.1)*10.0)/10.0;
            double length = Math.round((Math.random()*2 + 2)*10.0)/10.0;
            Bluegill b1 = new Bluegill(weight, length);       
            b = b1;     
        }
        return b;
    }

    public String toString(){
        String str = "";
        double w = super.getWeight();
        if (w >= 1.0){
            str = w + "lb & " + super.getLength() + "inch Huge " + species + "!";
        }
        else if (w >= 0.5){
            str = w + "lb & " + super.getLength() + "inch " + species + "!";
        }
        else{
            str = w + "lb & " + super.getLength() + "inch Small " + species + "!";
        }
        return str; 
    }
}
