import java.util.Random;

public static void main(String[] args) {
    int totalGames = 1000;
    int winsWithSwitch = 0;
    int winsWithoutSwitch = 0;

    for (int i = 0; i < totalGames; i++) {
        int prizeDoor = new Random().nextInt(3) + 1;
        int playerChoice = new Random().nextInt(3) + 1;

        int openDoor;
        do {
            openDoor = new Random().nextInt(3) + 1;
        } while (openDoor == prizeDoor || openDoor == playerChoice);

        int remainingDoor;
        do {
            remainingDoor = new Random().nextInt(3) + 1;
        } while (remainingDoor == playerChoice || remainingDoor == openDoor);

        boolean switchDoor = new Random().nextBoolean();

        if (switchDoor) {
            playerChoice = remainingDoor;
        }

        if (playerChoice == prizeDoor) {
            if (switchDoor) {
                winsWithSwitch++;
            } else {
                winsWithoutSwitch++;
            }
        }
    }

    System.out.println("Total games: " + totalGames);
    System.out.println("Wins with switch: " + winsWithSwitch);
    System.out.println("Wins without switch: " + winsWithoutSwitch);
}