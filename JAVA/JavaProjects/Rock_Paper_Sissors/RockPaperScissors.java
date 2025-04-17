package JavaProjects.Rock_Paper_Sissors;

// frontend

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JFrame implements ActionListener{

    // player buttons

    JButton rockButton , paperButton , ScissorButton;

    // will display the choice of the computer
    JLabel computerChoice;

    // Score tracking variable
    JLabel computerScoreLabel , playerScoreLabel;

    // backend object
    gameLogic rockPaperScissorBackend;

    public RockPaperScissors()
    {
        // invoke JFrame constructor and add title to the GUI.
        super("Rock-Paper-Scissor");

        // set the size of GUI
        setSize(450,575);

        // set layout to null to disable layout management, so we can use absolute positioning for the elements
        // i,e setting x,y coordinates and width/height values.
        setLayout(null);

        // terminate the Java virtual machine when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // load GUI in the center of the screen every time we run the application
        setLocationRelativeTo(null);

        // initialize our backend object
        rockPaperScissorBackend = new gameLogic();

        // add GUI Components
        addGUIComponents();


    }

    private void addGUIComponents()
    {
        // create computer score label
        computerScoreLabel = new JLabel("Computer: 0");

        // set x,y coordinates and width/height values
        computerScoreLabel.setBounds(0,43,450,30);

        // set the font to have a font family dialog, font-weight of bold and a font-size of 26
        computerScoreLabel.setFont(new Font("Dialog" , Font.BOLD , 26));

        // place the text in center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);


        // add the label to the GUI(JFrame)
        add(computerScoreLabel);

        // create computer's choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog" , Font.PLAIN , 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        // create a black border around computers choice
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        // create player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog" , Font.BOLD , 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(playerScoreLabel);

        // player buttons

        // rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN , 18));
        rockButton.addActionListener(this);
        add(rockButton);

        // paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN , 18));
        paperButton.addActionListener(this);
        add(paperButton);

        // scissor button
        ScissorButton = new JButton("Scissors");
        ScissorButton.setBounds(290,387,105,81);
        ScissorButton.setFont(new Font("Dialog", Font.PLAIN , 18));
        ScissorButton.addActionListener(this);
        add(ScissorButton);


    }

    // display a message dialog which will show the winner and a try again button to play again
    private void showDialog(String message)
    {
        JDialog result = new JDialog(this , "Result" , true);
        result.setSize(227,124);
        result.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        result.setResizable(false);

        // message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog" , Font.BOLD , 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        result.add(resultLabel , BorderLayout.CENTER);

        // try again button
        JButton tryAgainButton = new JButton("Try Again!!!");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // reset computer choice
                computerChoice.setText("?");

                // close the dialog box so that user can press the buttons again
                result.dispose();


            }
        });

        result.add(tryAgainButton , BorderLayout.SOUTH);

        result.setLocationRelativeTo(this);
        result.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // get player choice
        String playerChoice = e.getActionCommand().toString();

        // play rock paper scissors and store the result into string var
        String result = rockPaperScissorBackend.playRockPapersScissors(playerChoice);

        // load computer's choice
        computerChoice.setText(rockPaperScissorBackend.getComputerChoice());

        // update score
        computerScoreLabel.setText("Computer: " + rockPaperScissorBackend.getComputerScore());
        playerScoreLabel.setText("Player : " + rockPaperScissorBackend.getPlayerScore());

        //display result dialog
        showDialog(result);


    }
}
