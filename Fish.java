public class Fish {
    private double weight;
    private double length;
    private String species;

    public Fish(){
        this(0, 0);
    }
    public Fish(double w, double l){
        weight = w;
        length = l;
        species = "Fish";
    }

    //default: largemouth bass
    public String toString(){
        String str = "";
        if (weight >= 5.0){
            str = weight + "lb & " + length + "inch Huge ";
        }
        else if (weight >= 2.0){
            str = weight + "lb & " + length + "inch ";
        }
        else{
            str = weight + "lb & " + length + "inch Small ";
        }
        return str;
    }

    public String getSpecies(){
        return species;
    }

    public double getLength(){
        return length;
    }

    public double getWeight(){
        return weight;
    }
    
}
