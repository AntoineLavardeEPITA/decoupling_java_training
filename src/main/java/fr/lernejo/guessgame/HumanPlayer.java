package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    final Logger logger = LoggerFactory.getLogger("player");

    final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.print("Your guess: ");
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            logger.log("The goal is greater");
        }else{
            logger.log("The goal is lower");
        }
    }
}