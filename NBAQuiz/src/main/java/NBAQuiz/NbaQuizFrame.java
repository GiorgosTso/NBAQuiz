package NBAQuiz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

public class NbaQuizFrame extends JFrame{
    int points = 0;
    private JSlider slider;
    private JLabel  label4 = new JLabel("How satisfied are you with the quiz so far: ");
    private ButtonGroup group;
    JTextField userText = new JTextField(30);
    JPasswordField passText = new JPasswordField(30);
    private Formatter output;    
    private final String colorNames[] = { "Black", "Blue", "Cyan", 
        "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
        "Orange", "Pink", "Red", "White", "Yellow" };
    private final Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN, 
        Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, 
         Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, 
         Color.YELLOW };    
    private JList colorJList = new JList( colorNames );
    
    public NbaQuizFrame()
    {
        super("This is the Nba Quiz!");
        
        //Menu File + About
        JMenu fileMenu = new JMenu("Options");
        fileMenu.setMnemonic('O');
        
        JMenuItem aboutItem = new JMenuItem( "About the exercise");
        aboutItem.setMnemonic('A');
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    JOptionPane.showMessageDialog(NbaQuizFrame.this,"I couldn't find\nanything better from GUI2","About", JOptionPane.PLAIN_MESSAGE );
                }
            }
        );
        JMenuItem exitItem = new JMenuItem("Exit"); 
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);
        exitItem.addActionListener(
        new ActionListener()
        {    
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            } 
        } 
      );
      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      bar.add(fileMenu);
      
        //Create an account Tab
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel0 = new JPanel();
        JLabel mess1 = new JLabel("Please create an account for the following Quiz.");
        JLabel mess2 = new JLabel("Your username and password will be saved in our database. Thanks!");
        JLabel userLabel = new JLabel("Username: ");
        
        JLabel passLabel = new  JLabel("Password: ");
        
        JButton button = new JButton("Create Account");
        panel0.add(mess1);
        panel0.add(mess2);
        panel0.add(userLabel);
        panel0.add(userText);
        panel0.add(passLabel);
        panel0.add(passText);
        panel0.add(button);
        
        
        tabbedPane.addTab( "Register Tab: " , null, panel0, "Register Panel" ); 
        
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String text = userText.getText();
                try
                {
                    File file = new File("accounts.txt");
                    if(!file.exists())
                    {
                        file.createNewFile();
                    }
                    
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(text);
                    bw.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Value initialized to no-username");
                    text = "no-username";
                }
                JOptionPane.showMessageDialog(null,"Accoount created succesfully!");
            }
        });
        
        //1st Tab        
        JLabel label1 = new JLabel("What is Michael's Jordan jersey number:", SwingConstants.CENTER );
        JPanel panel1 = new JPanel();
        ImageIcon logo = new ImageIcon("logo.png");
        JLabel label = new JLabel("NBA Quiz", logo, SwingConstants.LEFT);
        JButton b1 = new JButton("Check answer");
        JTextField field1 = new JTextField(4);
        panel1.add(label);
        panel1.add(label1);
        panel1.add(field1);
        panel1.add(b1);
        
        tabbedPane.addTab( "First Tab: " , null, panel1, "First Panel" ); 
        
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(field1.getText().equals("23"))
                {
                    points++;
                    JOptionPane.showMessageDialog(null,"Correct! You have " + points + " point!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong answer! You have " + points + " points!");
                }
            }
        });
        
        //2nd Tab
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Which player is the best 3 point-shooter");
        JTextField field2 = new JTextField(12);
        JButton b2 = new JButton("Check answer");
        panel2.add(label2);
        panel2.add(field2);
        panel2.add(b2);
        tabbedPane.addTab("Second Tab: ", null, panel2, "Second Panel");
        
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(field2.getText().equalsIgnoreCase("stephen curry") || field2.getText().equalsIgnoreCase("Curry"))
                {
                    points++;
                    JOptionPane.showMessageDialog(null,"Correct! You have " + points + " points!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong answer! You have " + points + " points!");
                }
            }
        });
        
        
        
        //3rd Tab       
        JPanel panel4 = new JPanel();
        JLabel label5 = new JLabel("How many points did Lebron James average in the 2007-2008 season: ");
        JRadioButton rb1 = new JRadioButton("28.4");
        JRadioButton rb2 = new JRadioButton("30.0");
        JRadioButton rb3 = new JRadioButton("31.4");
        JButton b3 = new JButton("Check answer");
        
        group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        
        panel4.add(label5);
        panel4.add(rb1);
        panel4.add(rb2);
        panel4.add(rb3);
        panel4.add(b3);
        
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(rb2.isSelected())
                {
                    points++;
                    JOptionPane.showMessageDialog(null,"Correct! You have " + points + " points!");
                }
                else if(rb1.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Wrong answer! You have " + points + " points!");
                }
                else if(rb3.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Wrong answer! You have " + points + " points!");
                }
            }
        });
        
        tabbedPane.addTab( "Third Tab: " , null, panel4, "Third Panel" );        
        
        // 4th Tab
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Slider");
        panel3.add(label3);
        tabbedPane.addTab("Fourth Tab: ", null, panel3, "Fourth Panel");

        slider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        slider.setPreferredSize(new Dimension(100,200));
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        
        event e = new event();
        panel3.add(slider);
        panel3.add(label4);
        slider.addChangeListener(e);
        
        //5th Tab
        JPanel panel5 = new JPanel();
        JLabel label6 = new JLabel("What color are the Los Angeles Lakers city edition Jerseys: ");
        colorJList.setVisibleRowCount( 5 ); 
        colorJList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
      
        panel5.add(label6);
        panel5.add(new JScrollPane( colorJList ));
      
        colorJList.addListSelectionListener(
            new ListSelectionListener() 
            {   
           
                public void valueChanged( ListSelectionEvent event )
                {
                    String SelectedColor = (String) colorJList.getSelectedValue();
                    if(SelectedColor.equals("Magenta"))
                    {
                        points++;
                        JOptionPane.showMessageDialog(null,"Correct! You have " + points + " points!");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer! You have " + points + " points!");
                    }
                } 
            });               
        tabbedPane.addTab( "Fifth Tab: " , null, panel5, "Fifth Panel" ); 
        
        
        //6th Tab
        JPanel panel6 = new JPanel();
        JLabel label7 = new JLabel("Which player holds the record for the most points in the regular season: ");
        JRadioButton rb4 = new JRadioButton("Oscar Robertson");
        JRadioButton rb5 = new JRadioButton("Michael Jordan");
        JRadioButton rb6 = new JRadioButton("Kobe Bryant");
        JRadioButton rb7 = new JRadioButton("Wilt Chamberlain");       
        JRadioButton rb8 = new JRadioButton("Kareem Abdul-Jabbar");
        JButton b4 = new JButton("Check answer");
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(rb4);
        group2.add(rb5);
        group2.add(rb6);
        group2.add(rb7);
        group2.add(rb8);
        
        panel6.add(label7);
        panel6.add(rb4);
        panel6.add(rb5);
        panel6.add(rb6);
        panel6.add(rb7);
        panel6.add(rb8);
        panel6.add(b4);
        
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(rb7.isSelected())
                {
                    points++;
                    JOptionPane.showMessageDialog(null,"Correct! You have " + points + " points!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong answer! You have " + points + " points!");
                }
            }
        });
        
        tabbedPane.addTab("Sixth Tab:", null, panel6, "Sixth Panel");
        
        add(tabbedPane); 
    }
    
    public void openFile()
    {
        try
        {
            FileWriter file = new FileWriter("accounts.txt", true);
            output = new Formatter(file);  
        }
        catch(IOException ex)
        {
            System.out.println("Error in creating/opening the file");
        }
        catch(SecurityException ex)
        {
            System.out.println("You do not have the write access to this file");
        }
        catch(Exception ex)
        {
            System.out.println(("Something went wrong"));
        }
        
    }
    
    public void closeFile()
    {
        if(output != null)
        {
            output.close();
        }
    }
    
    public void addRecords()
    {
        String un = userText.getText();
        CreateAccount acc1 = new CreateAccount(un);
            try
            {
                output.format(acc1.getUsername() + "\n"); 
            }
            catch(FormatterClosedException ex)
            {
                System.out.println("Error writing in file");
            }
            catch(NoSuchElementException ex)
            {
                System.out.println("Files does not exit");
            }
            catch(Exception ex)
            {
                System.out.println("Something went wrong");
            }
    }
    
    public class event implements ChangeListener {
        public void stateChanged(ChangeEvent e)
        {
            int value = slider.getValue();
            label4.setText("How satisfied are you with the quiz so far: " + value + "/100");
            
        }
    }
}