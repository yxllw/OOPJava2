public class Test {
    public static void main(String[] args) {
        //lab1tests
        /* Aerobics firstEx = new Aerobics("Run", 5);
        Aerobics secondEx = new Aerobics("Push-ups", 6);
        Aerobics thirdEx = new Aerobics();
        thirdEx.setName("Squats");
        thirdEx.setDuration(5);
        Aerobics fourthEx = new Aerobics("Exercise1", 15);
        Aerobics fifthEx = new Aerobics("Exercise2",5);

        Workout first = new Workout(2);
        first.add(firstEx);
        first.add(secondEx);
        first.add(thirdEx);
        first.add(fourthEx);
        first.add(fifthEx);
        System.out.println(first.durationTotal());
        System.out.println(first.size());
        System.out.println(first.hasExercise("Run"));
        System.out.println(first.get(4));
        Aerobics[] exercises;
        exercises = first.getExercises();
        for (Aerobics exercise1: exercises) {
            System.out.println(exercise1.getName());
        }

         */
        //lab2tests

        Approach app1 = new Approach(5,10,15);
        Approach app2 = new Approach(3,12,17);
        Approach app3 = new Approach(7,13,22);
        app3.setDuration(10);
        app2.setAttemptsQuantity(12);
        app1.setWeight(10);
        WeightTraining wt1 = new WeightTraining("Random");
        WeightTraining wt2 = new WeightTraining("Push-ups");
        wt1.add(app1);
        wt1.add(app2);
        wt2.add(app3);
        System.out.println(wt1.getDuration());
        System.out.println(wt1.size());
        System.out.println(wt1.getName());
        System.out.println(wt2.getName());
        wt1.remove(0);
        System.out.println(wt1.size());
        System.out.println(app2.getAttemptsQuantity());

    }
}