public class Approach {
    private int duration;
    private double weight;
    private int attemptsQuantity;

    Approach(){
        weight = 0;
        duration = 2;
        attemptsQuantity = 12;
    }
    Approach(int duration, double weight, int attemptsQuantity){
        this.duration = duration;
        this.weight = weight;
        this.attemptsQuantity = attemptsQuantity;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public int getAttemptsQuantity(){
        return attemptsQuantity;
    }
    public void setAttemptsQuantity(int attemptsQuantity){
        this.attemptsQuantity = attemptsQuantity;
    }
    @Override
    public String toString(){
        return String.format("w: %f kg #: %d t: %d min", weight, attemptsQuantity, duration);
    }
    @Override
    public int hashCode() {
        return Double.valueOf(attemptsQuantity).hashCode()*Double.valueOf(weight).hashCode();
    }
    @Override
    public boolean equals(Object object){
        Approach app = (Approach) object;
        return weight == app.weight && duration == app.duration && attemptsQuantity == app.attemptsQuantity;
    }
}
