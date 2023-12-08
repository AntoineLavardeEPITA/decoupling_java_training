package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
        }else if("-interactive".equals(args[0])){
            SecureRandom random = new SecureRandom();
            int i = random.nextInt(100);
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(i);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }else if ("-auto".equals(args[0])){
            try {
                long number = Long.parseLong(args[1]);
                Simulation simulation = new Simulation(new ComputerPlayer());
                simulation.initialize(number);
                simulation.loopUntilPlayerSucceed(1000);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                printUsage();
            }
        }else{
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println(
            """
                Usage:
                    -interactive
                    -auto <secretNumber>
                """
        );
    }
}