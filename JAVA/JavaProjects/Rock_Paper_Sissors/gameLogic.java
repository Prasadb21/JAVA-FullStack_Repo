package JavaProjects.Rock_Paper_Sissors;


// backend

import java.util.Random;

public class gameLogic {

    // all of the choices that a computer can choose
    private static final String[] computerChoices = {"Rock" , "Paper", "Scissors"};

    // store the scores so that we can retrieve the value and display it to the frontend;
    private int computerScore,playerScore;

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    // store the computer choice so that we can retrieve the value and display it to the frontend;
    private String computerChoice;

    // use to generate a random number to randomly choose an option fot the computer
    private Random random;

    // constructor - to initialize random object
    public gameLogic()
    {
        random = new Random();

    }

    // call this method to begin playing the game
    // playerCHoice - is the choice made by the player
    // this method will return the result of the game (i.e computer win, player win , draw)
    public String playRockPapersScissors(String playerChoice)
    {
        // generate the choice of the computer
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //will contain the returning message indicating the result of the game
        String gameResult;

        // evaluate the winner
        if (computerChoice.equals("Rock"))
        {
            if(playerChoice.equals("Paper"))
            {
                gameResult = "Player Wins !!!";
                playerScore++;
            }
            else if(playerChoice.equals("Scissors"))
            {
                gameResult = "Computer Wins !!!";
                computerScore++;
            }
            else
            {
                gameResult = "Draw";
            }
        }
        else if (computerChoice.equals("Paper"))
        {
            if(playerChoice.equals("Scissors"))
            {
                gameResult = "Player Wins !!!";
                playerScore++;
            }
            else if(playerChoice.equals("Rock"))
            {
                gameResult = "Computer Wins !!!";
                computerScore++;
            }
            else
            {
                gameResult = "Draw";
            }
        }
        else
        // computer chooses Scissors
        {
            if(playerChoice.equals("Rock"))
            {
                gameResult = "Player Wins !!!";
                playerScore++;
            }
            else if(playerChoice.equals("Paper"))
            {
                gameResult = "Computer Wins !!!";
                computerScore++;
            }
            else
            {
                gameResult = "Draw";
            }
        }

        return gameResult;

    }


}
