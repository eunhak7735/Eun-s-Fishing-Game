public class Pike extends Fish {
    private String species;

    public Pike(){
        super();
    }

    public Pike(double w, double l){
        super(w, l);
        species = "Pike";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Pike
     * 
     * size: increments of 0.1
     * 
     * 10% of Pike caught are huge 
     * 15-20lb 32-40in
     * 
     * 55% they are regular 
     * 6-15lb 20-32in
     * 
     * 35% they are small
     * 2-6lb 10-20in
     * 
     * @param i % of catching different sizes of Pike
     * @return returns the Pike with appropriate size and weight
     * depending on the percentage or probability(return the Pike caught)
     */
    public static Pike pikeRiver(int i){
        Pike p = new Pike();
        if (i > 90){
            double weight = Math.round((Math.random()*5 + 15)*10.0)/10.0;
            double length = Math.round((Math.random()*8 + 32)*10.0)/10.0;
            Pike p1 = new Pike(weight, length);
            p = p1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*9 + 6)*10.0)/10.0;
            double length = Math.round((Math.random()*12 + 20)*10.0)/10.0;
            Pike p1 = new Pike(weight, length);
            p = p1;           
        }
        else{
            double weight = Math.round((Math.random()*4 + 2)*10.0)/10.0;
            double length = Math.round((Math.random()*10 + 10)*10.0)/10.0;
            Pike p1 = new Pike(weight, length);
            p = p1;     
        }
        return p;
    }

    public String toString(){
        String str = "";
        double l = super.getLength();
        if (l >= 32){
            str = super.getWeight() + "lb & " + l + "inch Huge " + species + "!";
        }
        else if (l >= 20){
            str = super.getWeight() + "lb & " + l + "inch " + species + "!";
        }
        else{
            str = super.getWeight() + "lb & " + l + "inch Small " + species + "!";
        }
        return str; 
    }
}
