package JavaProjects.Rock_Paper_Sissors;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate a RockPaperScissor Class object
                RockPaperScissors rockPaperScissor = new RockPaperScissors();

                // display the GUI
                rockPaperScissor.setVisible(true);

            }
        });
    }

}
