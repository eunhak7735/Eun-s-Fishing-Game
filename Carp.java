package JavaCoding.Fishing_Game;

public class Carp extends Fish {
    private String species;

    public Carp(){
        super();
    }

    public Carp(double w, double l){
        super(w, l);
        species = "Carp";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Carp
     *
     * size: increments of 0.1
     * 
     * 20% of Carp caught are huge 
     * 27-33lb 25-33in
     * 
     * 45% they are regular 
     * 7-27lb 20-25in
     * 
     * 35% they are small
     * 3-7lb 13-20in
     * 
     * @param i % of catching different sizes of Carp
     * @return returns the Carp with appropriate size and weight
     * depending on the percentage or probability(return the Carp caught)
     */
    public static Carp carpRiver(int i){
        Carp c = new Carp();
        if (i > 80){
            double weight = Math.round((Math.random()*6 + 27)*10.0)/10.0;
            double length = Math.round((Math.random()*8 + 25)*10.0)/10.0;
            Carp c1 = new Carp(weight, length);
            c = c1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*20 + 7)*10.0)/10.0;
            double length = Math.round((Math.random()*5 + 20)*10.0)/10.0;
            Carp c1 = new Carp(weight, length);
            c = c1;           
        }
        else{
            double weight = Math.round((Math.random()*4 + 3)*10.0)/10.0;
            double length = Math.round((Math.random()*7 + 13)*10.0)/10.0;
            Carp c1 = new Carp(weight, length);       
            c = c1;     
        }
        return c;
    }

    public String toString(){
        String str = "";
        double w = super.getWeight();
        if (w >= 27){
            str = w + "lb & " + super.getLength() + "inch Huge " + species + "!";
        }
        else if (w >= 7){
            str = w + "lb & " + super.getLength() + "inch " + species + "!";
        }
        else{
            str = w + "lb & " + super.getLength() + "inch Small " + species + "!";
        }
        return str; 
    }
}
