import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
public class Checkersa extends JFrame implements ActionListener, WindowListener, KeyListener
{    
    int player1 = 0;
    int player2 = 0;
    private JButton words[][];
    private JButton dummy4;
    private char letters[][];
    private JButton newGame;
    private String[] text = new String[17];
    String check = "";
    private JButton XB;
    private JButton OB;
    boolean turn = false;
    boolean white = false,blue1 = false,blue2 = false,blue3 = false,blue4 = false,blue5 = false,blue6 = false,blue7 = false,blue8 = false,red = false,red1 = false,red2 = false,red3 = false,red4 = false,red5 = false,red6 = false,red7 = false,red8 = false,win = false, win2 = false,newgame = false,X = false, O = false,restart;
    int num = 0;
    double number = 0;
    private JTextField QuestionDisplay;
    private JTextField WinDisplay;
    private JTextField CounterDisplay;
    int odd = 0;
    boolean one = true, two = false, three = false, four = false, five = false, six = false;
    boolean go = true;
    private ImageIcon ico = new ImageIcon("white.png");
    private ImageIcon icob = new ImageIcon("blue.png");
    private ImageIcon icor = new ImageIcon("red.png");
    private ImageIcon icorr = new ImageIcon("red circle.png");
    private ImageIcon icoy = new ImageIcon("whitecircle.png");
    private ImageIcon icoyk = new ImageIcon("king white.png");
    private ImageIcon icork = new ImageIcon("king red.png");

    public Checkersa()
    {    
        go = false;
        dummy4 = new JButton();
        turn = false;
        ico = new ImageIcon("white.png");
        icob = new ImageIcon("black.png");
        icor = new ImageIcon("red.png");
        icorr = new ImageIcon("red circle.png");
        icoy = new ImageIcon("whitecircle.png");
        icoyk = new ImageIcon("kingwhite.png");
        icork = new ImageIcon("king red.png");
        words = new JButton[8][8];
        letters = new char[8][8];
        setLayout(new BorderLayout());
        newGame = new JButton();
        XB = new JButton();
        OB = new JButton();
        QuestionDisplay = new JTextField("Red equals O. Blue equals X. Blue has won "+player1+" times. Red has won "+player2+" times.");
        QuestionDisplay.setEditable(false);
        Panel PanelGame = new Panel(new GridLayout(2,4));
        add(PanelGame,BorderLayout.NORTH);
        PanelGame.add(newGame);
        PanelGame.add(QuestionDisplay);
        Panel PanelX = new Panel(new GridLayout(1,1));
        add(PanelX,BorderLayout.WEST);
        PanelX.add(XB);
        XB.setIcon(new ImageIcon("white3.png"));
        XB.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    if(X == false && O == false)
                    {
                        X = true;
                        num = 2;
                    }                    
                }
            });
        Panel PanelO = new Panel(new GridLayout(1,1));
        add(PanelO,BorderLayout.EAST);
        PanelO.add(OB);
        OB.setIcon(new ImageIcon("white3.png"));
        OB.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    if(X == false && O == false)
                    {
                        O = true;
                        num = 3;
                    }                    
                }
            });
        setFocusable(true);
        addKeyListener(this);
        WinDisplay = new JTextField("No one has won yet.");
        add(WinDisplay,BorderLayout.SOUTH);
        WinDisplay.setEditable(false);        

        Panel panelGraphics = new Panel(new GridLayout(8, 8));
        add(panelGraphics, BorderLayout.CENTER);
        add(panelGraphics,BorderLayout.CENTER); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setTitle("Game");
        setSize(900,900);
        setVisible(true);
        /*
        [0 ] [6 ] [12] [18] [24] [30] [36]
        [1 ] [7 ] [13] [19] [25] [31] [37]
        [2 ] [8 ] [14] [20] [26] [32] [38]
        [3 ] [9 ] [15] [21] [27] [33] [39]
        [4 ] [10] [16] [22] [29] [34] [40]

        [5 ] [11] [17] [23] [29] [35] [41]                           
         */
        
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {       
                letters[x][y] = ' ';
                words[x][y] = new JButton();
                words[x][y].setIcon(ico);
                if(x < 3 && y % 2 == 0 && x % 2 ==0)
                {
                    words[x][y].setIcon(icorr);
                }
                if(x < 3 && y % 2 == 1 && x % 2 ==1)
                {
                    words[x][y].setIcon(icorr);
                }
                if(x > 4 && y % 2 == 0 && x % 2 ==0)
                {
                    words[x][y].setIcon(icoy);
                }
                if(x > 4 && y % 2 == 1 && x % 2 ==1)
                {
                    words[x][y].setIcon(icoy);
                }
                if(x == 4 && y % 2 == 0)
                {
                    words[x][y].setIcon(icob);
                }
                if(x == 3 && y % 2 == 1)
                {
                    words[x][y].setIcon(icob);
                }
                panelGraphics.add(words[x][y]);
                words[x][y].addActionListener(this);
            }          
        }

        newGame.setIcon(new ImageIcon("white2.png"));
        newGame.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt)
                {        
                    dispose();
                    new Checkersa();
                }
            });   

    }

    public void CountdownToChange(){
        Timer timer = new Timer(1000, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                    }

                });
        timer.start();
    }    

    public static void main(String[] args) {
        new Checkersa();      
    }

    @Override
    public void actionPerformed(ActionEvent evt) {   
        JButton dummy = (JButton) evt.getSource(); 
        JButton dummy2 = new JButton();
        JButton dummy3 = new JButton();
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {       

                if(go == true && words[x][y] == dummy && y != 0 && y != 7 && dummy.getIcon() == icob && turn == false && (words[x-1][y-1].getIcon() == icorr || words[x-1][y+1].getIcon() == icorr) && (words[x-1][y-1] == dummy4 || words[x-1][y+1] == dummy4 ) )
                {
                    turn = true;
                    dummy.setIcon(icorr);
                    dummy2 = words[x-1][y-1];
                    dummy3 = words[x-1][y+1];
                    dummy4.setIcon(icob);
                    go = false;

                    if(x == 7)
                    {
                        dummy.setIcon(icork);
                    }

                    return;
                    /*if(dummy2.getIcon() == icorr)
                    dummy2.setIcon(icob);
                    else
                    dummy3 .setIcon(icob);
                     */
                }                
                if (go == true && y == 0 && words[x][y] == dummy && dummy.getIcon() == icob && turn == false && words[x-1][y+1].getIcon() == icorr && go == true && words[x-1][y+1] == dummy4 )
                {
                    turn = true;
                    dummy.setIcon(icorr);
                    dummy3 = words[x-1][y+1];
                    dummy4.setIcon(icob);
                    go = false;

                    if(x == 7)
                    {
                        dummy.setIcon(icork);
                    }

                    return;

                    /*
                    if(dummy3.getIcon() == icorr)
                    dummy3.setIcon(icob);
                     */
                }
                if (go == true && y == 7 && words[x][y] == dummy && dummy.getIcon() == icob && turn == false && words[x-1][y-1].getIcon() == icorr && go == true && words[x-1][y-1] == dummy4 )
                {
                    turn = true;

                    dummy.setIcon(icorr);             
                    dummy2 = words[x-1][y-1]; 
                    dummy4.setIcon(icob);
                    go = false;

                    if(x == 7)
                    {
                        dummy.setIcon(icork);
                    }                   
                    return;
                    /*
                    if(dummy2.getIcon() == icorr)
                    dummy2.setIcon(icob);
                     */
                }
                if(go == true && words[x][y] == dummy && dummy.getIcon() == icob && turn == false )
                {                    
                    if((words[x-1][y+1].getIcon() == icoy || words[x-1][y-1].getIcon() == icoy) && y < 8)
                    {
                        if(y < 6)
                        {  
                            if(words[x-2][y+2].getIcon() == icorr && dummy4 == words[x-2][y+2])
                            {
                                dummy3 = words[x-1][y+1];
                                turn = true;
                                dummy.setIcon(icorr);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                            if(words[x-2][y-2].getIcon() == icorr && dummy4 == words[x-2][y-2])
                            {
                                dummy3 = words[x-1][y-1];
                                turn = true;
                                dummy.setIcon(icorr);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                        }
                        else if(y > 5)
                        {
                            if(words[x+2][y-2].getIcon() == icorr && dummy4 == words[x-2][y-2])
                            {
                                dummy4 = words[x-2][y-2];
                                dummy3 = words[x-1][y-1];
                                turn = true;
                                dummy.setIcon(icoy);
                                dummy3.setIcon(icob);
                                dummy4.setIcon(icob);
                                go = false;
                            }                        
                        }                        
                    }
                    if(y < 8 && (words[x-1][y+1].getIcon() == icoy || words[x-1][y-1].getIcon() == icoy))
                    {
                        if(y < 1)
                        {
                            if(words[x-2][y+2].getIcon() == icorr && dummy4 == words[x-2][y+2])
                            {
                                dummy3 = words[x-1][y+1];
                                turn = true;
                                dummy.setIcon(icorr);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                        }
                        else if(y < 6)
                        {
                            if(words[x-2][y+2].getIcon() == icorr && dummy4 == words[x-2][y+2])
                            {
                                dummy3 = words[x-1][y+1];
                                turn = true;
                                dummy.setIcon(icorr);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                            if(words[x-2][y-2].getIcon() == icorr && dummy4 == words[x-2][y-2])
                            {
                                dummy3 = words[x-1][y-1];
                                turn = true;
                                dummy.setIcon(icorr);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                        }
                    }
                    if(x == 7)
                    {
                        dummy.setIcon(icork);
                    }

                    return;                    
                }

                if(go == true && words[x][y] == dummy && y != 0 && y != 7 && dummy.getIcon() == icob && turn == true && (words[x+1][y+1].getIcon() == icoy || words[x+1][y-1].getIcon() == icoy) && go == true && (words[x+1][y-1] == dummy4 || words[x+1][y+1] == dummy4 ))
                {
                    turn = false;
                    dummy.setIcon(icoy);
                    dummy2 = words[x+1][y+1];
                    dummy3 = words[x+1][y-1];
                    dummy4.setIcon(icob);
                    go = false;

                    if(x == 0)
                    {
                        dummy.setIcon(icoyk);
                    }
                    return;

                    /*
                    if(dummy2.getIcon() == icoy)
                    dummy2.setIcon(icob);
                    else
                    dummy3.setIcon(icob);
                     */
                }

                if (go == true && y == 0 && words[x][y] == dummy && dummy.getIcon() == icob && turn == true && words[x+1][y+1].getIcon() == icoy && go == true && words[x+1][y+1] == dummy4 )
                {
                    turn = false;
                    dummy.setIcon(icoy);                   
                    dummy3 = words[x+1][y+1];
                    dummy4.setIcon(icob);
                    go = false;

                    if(x == 0)
                    {
                        dummy.setIcon(icoyk);
                    }
                    return;
                    /*
                    if(dummy3.getIcon() == icoy)
                    dummy3.setIcon(icob);
                     */
                }
                if (go == true && y == 7 && words[x][y] == dummy && dummy.getIcon() == icob && turn == true && words[x+1][y-1].getIcon() == icoy && go == true && words[x+1][y-1] == dummy4 )
                {
                    turn = false;
                    dummy.setIcon(icoy);                   
                    dummy2 = words[x+1][y-1];
                    dummy4.setIcon(icob);
                    go = false;

                    if(x == 0)
                    {
                        dummy.setIcon(icoyk);
                    }
                    return;
                    /* 
                    if(dummy2.getIcon() == icoy)
                    dummy2.setIcon(icob);
                     */
                }
                if(go == true && words[x][y] == dummy && dummy.getIcon() == icob && turn == true )
                {                    
                    if((words[x+1][y+1].getIcon() == icorr || words[x+1][y-1].getIcon() == icorr) && y < 8)
                    {
                        if(y < 6)
                        {  
                            if(words[x+2][y+2].getIcon() == icoy && dummy4 == words[x+2][y+2])
                            {
                                dummy3 = words[x+1][y+1];
                                turn = false;
                                dummy.setIcon(icoy);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                            if(words[x+2][y-2].getIcon() == icoy && dummy4 == words[x+2][y-2])
                            {
                                dummy3 = words[x+1][y-1];
                                turn = false;
                                dummy.setIcon(icoy);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                        }
                        else if(y > 5)
                        {
                            if(words[x+2][y-2].getIcon() == icoy)
                            {
                                dummy4 = words[x+2][y-2];
                                dummy3 = words[x+1][y-1];
                                turn = false;
                                dummy.setIcon(icoy);
                                dummy4.setIcon(icob);
                                go = false;
                            }                        
                        }                        
                    }
                    if(y < 8 && (words[x+1][y+1].getIcon() == icorr || words[x+1][y-1].getIcon() == icorr))
                    {
                        if(y < 1)
                        {
                            if(words[x+2][y+2].getIcon() == icoy && dummy4 == words[x+2][y+2])
                            {
                                dummy3 = words[x+1][y+1];
                                turn = false;
                                dummy.setIcon(icoy);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                        }
                        else if(y < 6)
                        {
                            if(words[x+2][y+2].getIcon() == icoy && dummy4 == words[x+2][y+2])
                            {
                                dummy3 = words[x+1][y+1];
                                turn = false;
                                dummy.setIcon(icoy);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                            if(words[x+2][y-2].getIcon() == icoy && dummy4 == words[x+2][y-2])
                            {
                                dummy3 = words[x+1][y-1];
                                turn = false;
                                dummy.setIcon(icoy);
                                dummy4.setIcon(icob);
                                dummy3.setIcon(icob);
                                go = false;
                            }
                        }
                    }

                    if(dummy2.getIcon() == icorr)
                    {
                        dummy2.setIcon(icob); 
                    }
                    else if(dummy3.getIcon() == icorr)
                    {
                        dummy3.setIcon(icob); 
                    }
                    if(x == 0)
                    {
                        dummy.setIcon(icoyk);
                    }

                    return;                    
                }
                if(go == false && words[x][y] == dummy && y != 0 && y != 7 && dummy.getIcon() == icorr && (words[x+1][y+1].getIcon() == icob || words[x+1][y-1].getIcon() == icob) && turn == false)
                {
                    dummy4 = words[x][y];
                    go = true;
                    return;
                }
                if(go == false && words[x][y] == dummy && y == 0 && dummy.getIcon() == icorr && words[x+1][y+1].getIcon() == icob && turn == false)
                {
                    dummy4 = words[x][y];
                    go = true;
                    return;
                }
                if(go == false && words[x][y] == dummy && y == 7 && dummy.getIcon() == icorr && words[x+1][y-1].getIcon() == icob && turn == false)
                {
                    dummy4 = words[x][y];
                    go = true;
                    return;
                }
                if(go == false && words[x][y] == dummy && y != 0 && y != 7 && dummy.getIcon() == icoy && (words[x-1][y+1].getIcon() == icob || words[x-1][y-1].getIcon() == icob) && turn == true)
                {
                    dummy4 = words[x][y];
                    go = true;
                    return;
                }
                if(go == false && words[x][y] == dummy && y == 0 && dummy.getIcon() == icoy && words[x-1][y+1].getIcon() == icob && turn == true)
                {
                    dummy4 = words[x][y];
                    go = true;
                    return;
                }
                if(go == false && words[x][y] == dummy && y == 7 && dummy.getIcon() == icoy && words[x-1][y-1].getIcon() == icob && turn == true)
                {
                    dummy4 = words[x][y];
                    go = true;
                    return;
                }                

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {    
        int keytheytyped = e.getKeyCode();
        if(keytheytyped == KeyEvent.VK_R)
        {
            restart = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e)    { 
    }

    @Override
    public void keyReleased(KeyEvent e)    { }

    @Override
    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }

    @Override public void windowOpened(WindowEvent evt) { }   

    @Override public void windowClosed(WindowEvent evt) { }   

    @Override public void windowIconified(WindowEvent evt) { }   

    @Override public void windowDeiconified(WindowEvent evt) { }   

    @Override public void windowActivated(WindowEvent evt) { }   

    @Override public void windowDeactivated(WindowEvent evt) { }
}
