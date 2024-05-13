package JavaCoding.Fishing_Game;

public class Perch extends Fish {
    private String species;

    public Perch(){
        super();
    }

    public Perch(double w, double l){
        super(w, l);
        species = "Perch";
    }

    public String getSpecies(){
        return species;
    }

    /**
     * Catching Perch
     * 
     * size: increments of 0.1
     * 
     * 10% of Bluegill caught are huge 
     * 1.5-2lb 6-10in
     * 
     * 55% they are regular 
     * 0.5-1.5lb 4-6in
     * 
     * 35% they are small
     * 0.2-0.5lb 3-4in
     * 
     * @param i % of catching different sizes of Perch
     * @return returns the Perch with appropriate size and weight
     * depending on the percentage or probability(return the Perch caught)
     */
    public static Perch perchRiver(int i){
        Perch p = new Perch();
        if (i > 90){
            double weight = Math.round((Math.random()*0.5 + 1.5)*10.0)/10.0;
            double length = Math.round((Math.random()*4 + 6)*10.0)/10.0;
            Perch p1 = new Perch(weight, length);
            p = p1;           
        }
        else if (i > 35){
            double weight = Math.round((Math.random()*1 + 0.5)*10.0)/10.0;
            double length = Math.round((Math.random()*2 + 4)*10.0)/10.0;
            Perch p1 = new Perch(weight, length);
            p = p1;           
        }
        else{
            double weight = Math.round((Math.random()*0.3 + 0.2)*10.0)/10.0;
            double length = Math.round((Math.random()*1 + 3)*10.0)/10.0;
            Perch p1 = new Perch(weight, length);
            p = p1;     
        }
        return p;
    }

    public String toString(){
        String str = "";
        double w = super.getWeight();
        if (w >= 1.5){
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
