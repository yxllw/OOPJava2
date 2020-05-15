public class Aerobics extends AbstractExercise implements Exercise{
    public int duration;
    private static final int DEFAULT_DURATION = 3;

    public Aerobics(int duration){
        this.duration = duration;
    }
    public Aerobics(String name, int duration, Equipments equipments){
        super(name, equipments);
        this.duration = duration;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    @Override
    public String toString(){
        String str = String.format(", %d min ", duration);
        return super.toString() + str;
    }
    @Override
    public int hashCode(){
        return super.hashCode() * 53;
    }
    @Override
    public boolean equals(Object object){
        return super.equals(object);
    }
}
