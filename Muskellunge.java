package JavaCoding.Fishing_Game;

public class Muskellunge extends Fish {
    private String species;

    public Muskellunge(){
        super();
    }

    public Muskellunge(double w, double l){
        super(w, l);
        species = "Muskellunge";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Muskie
     * 
     * size: increments of 0.1
     * 
     * 5% of Muskie caught are huge 
     * 27-32lb 45-52in
     * 
     * 60% they are regular 
     * 5-27lb 25-45in
     * 
     * 35% they are small
     * 3-5lb 18-25in
     * 
     * @param i % of catching different sizes of Muskie
     * @return returns the Muskie with appropriate size and weight
     * depending on the percentage or probability(return the Muskie caught)
     */
    public static Muskellunge muskieRiver(int i){
        Muskellunge m = new Muskellunge();
        if (i > 95){
            double weight = Math.round((Math.random()*5 + 27)*10.0)/10.0;
            double length = Math.round((Math.random()*7 + 45)*10.0)/10.0;
            Muskellunge m1 = new Muskellunge(weight, length);
            m = m1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*22 + 5)*10.0)/10.0;
            double length = Math.round((Math.random()*20 + 25)*10.0)/10.0;
            Muskellunge m1 = new Muskellunge(weight, length);
            m = m1;           
        }
        else{
            double weight = Math.round((Math.random()*2 + 3)*10.0)/10.0;
            double length = Math.round((Math.random()*7 + 18)*10.0)/10.0;
            Muskellunge m1 = new Muskellunge(weight, length);    
            m = m1;     
        }
        return m;
    }

    public String toString(){
        String str = "";
        double l = super.getLength();
        if (l >= 45){
            str = super.getWeight() + "lb & " + l + "inch Huge " + species + "!";
        }
        else if (l >= 25){
            str = super.getWeight() + "lb & " + l + "inch " + species + "!";
        }
        else{
            str = super.getWeight() + "lb & " + l + "inch Small " + species + "!";
        }
        return str; 
    }
}
