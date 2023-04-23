package NBAQuiz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Welcome to the NBA Quiz, do not google anything :).\nPress ok to continue: ", "This is an NBA Quiz" , JOptionPane.INFORMATION_MESSAGE);
        NbaQuizFrame nbaQuizFrame = new NbaQuizFrame();
        nbaQuizFrame.setSize(450,550);
        nbaQuizFrame.setVisible(true);
        nbaQuizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        NbaQuizFrame application = new NbaQuizFrame();
        
        application.openFile();
        application.addRecords();
        application.closeFile();
    }
    
}
