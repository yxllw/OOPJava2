public class Aerobics implements Exercise {
    private String name;
    private int duration;
    private static final int DEFAULT_DURATION = 3;

    public Aerobics() { }
    public Aerobics(String name) {
       this(name,DEFAULT_DURATION);
    }
    public Aerobics(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
}
