public class Workout{
    private Aerobics[] exercises;
    private int size;
    private int total;

    public Workout(){
        this.size = 16;
        this.exercises = new Aerobics[size];
    }
    public Workout(int size){
        this.size = size;
        this.exercises = new Aerobics[size];
    }
    public Workout(Aerobics[] exercises){
        this.exercises = exercises;
    }

    public boolean add(Aerobics exercise){
        Aerobics[] newExercises = new Aerobics[size*2];
        if(total == size){
            for(int i = 0; i < size; i++){
                newExercises[i] = exercises[i];
            }
            size *=2;
            exercises = newExercises;
        }
        for(int i = 0; i < size; i++) {
            if(exercises[i] == null) {
                exercises[i] = exercise;
                total++;
                return true;
            }
        }
        return false;
    }
    public boolean add(int index, Aerobics exercise){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        if(index < size && exercises[index] == null) {
            exercises[index] = exercise;
            total++;
            return true;
        }
        return false;
    }
    public Aerobics get(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        return exercises[index];
    }
    public Aerobics set(int index, Aerobics exercise){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        exercises[index] = exercise;
        return exercises[index];
    }
    public Aerobics remove(int index){
        if (index < 0) {
            throw new IndexOutOfBoundsException("index <0");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("index > size");
        }
        Aerobics exercise = exercises[index];
        exercises[index] = null;
        total--;
        return exercise;
    }
    public int removeAll(String exerciseName){
            int count = 0;
            for(int i = 0; i < size; i++){
                if(exercises[i] != null && exercises[i].getName().equals(exerciseName)){
                    Aerobics exercise = exercises[i];
                    total--;
                    for(int j = i + 1; j < size; j++){
                        exercises[j-1] = exercises[j];
                    }
                    exercises[size-1] = null;
                }
                count++;
            }
            return count;
    }
    public int size(){
        return total;
    }
    public Aerobics[] getExercises(){
        Aerobics[] getExercises = new Aerobics[total];
        int j = 0;
        for(int i = 0; i < size; i++){
            if(exercises[i] != null){
                getExercises[j] = exercises[i];
                j++;
            }
        }
        return getExercises;
    }
    public boolean hasExercise(String exerciseName){
        for(int i = 0; i < size; i++){
            if(exercises[i] != null && exercises[i].getName().equals(exerciseName)){
                return true;
            }
        }
        return false;
    }
    public int durationTotal(){
        int result = 0;
        for(int i = 0; i < size; i++){
            if(exercises[i] != null) {
               result += exercises[i].getDuration();
            }
        }
        return result;
    }
    public Aerobics[] getExercisesWithoutEquipments(){
        int count = 0;
        for(int i = 0; i < size; i++){
            if(exercises[i].getEquipments() == Equipments.NONE){
                count++;
            }
        }
        Aerobics[] exercisesWithoutEquipments = new Aerobics[count];
        int j = 0;
        for(int i = 0; i < size; i++){
            if(exercises[i].getEquipments() == Equipments.NONE){
                exercisesWithoutEquipments[j] = exercises[i];
                j++;
            }
        }
        return exercisesWithoutEquipments;
    }
    public boolean remove(Exercise exercise){
        for(int i = 0; i < size; i++){
            if(exercises[i] != null && exercises[i].equals(exercise)){
                //Aerobics exercise = exercises[i];
                total--;
                for(int j = i + 1; j < size; j++){
                    exercises[j-1] = exercises[j];
                }
                exercises[size-1] = null;
            }
            return true;
        }
        return false;
    }
    public int IndexOf(Exercise exercise){
        for (int i = 0; i < size; ++i) {
            if (exercises[i] != null) {
                if (exercises[i].equals(exercise)) {
                    return i;
                }
            }
        }

        return -1;
    }
    public int lastIndexOf(Exercise exercise){
        int index = -1;
        for (int i = 0; i < size; ++i) {
            if (exercises[i] != null) {
                if (exercises[i].equals(exercise)) {
                    index = i;
                }
            }
        }
        return index;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("Workout:\n");
        for (Exercise exercise: exercises){
            if(exercise != null){
                str.append(exercise.toString()).append("\n");
            }
        }
        return str.toString();
    }
}
