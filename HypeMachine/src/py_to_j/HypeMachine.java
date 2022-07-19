package py_to_j;

public class HypeMachine {

    public static void main(String[] args) {
        int repeats = Integer.parseInt(args[0]);
        while (repeats > 0) {
            int randomNumber = (int) (Math.random() * 3);
            if (randomNumber == 0) {
                System.out.println("You are awesome!");
            } else if (randomNumber == 1) {
                    System.out.println("You are the best!!!");
                } else {
                    System.out.println("Keep upt the great work!");
                }
            repeats -= 1;
        }
    }
}
