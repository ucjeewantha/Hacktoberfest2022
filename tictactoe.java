import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.TextAction;



public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton [] buttons = new JButton[9];
    JButton reset_button = new JButton();
    boolean player1_turn;


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setBackground(Color.DARK_GRAY);
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("MV Boli",Font.BOLD,55));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        reset_button= new JButton("Reset");
        reset_button.addActionListener(this);
        reset_button.setHorizontalAlignment(JLabel.LEFT);
        reset_button.setBounds(0,0,1,20);


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,150);


        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.black);

        for (int i = 0; i < 9; i++) {
            buttons[i]= new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
        }


        title_panel.add(textfield);
        title_panel.add(reset_button,BorderLayout.LINE_START);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();     
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i <9; i++) {
            if (e.getSource()==buttons[i]) {

                if (player1_turn) {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn =false;
                        textfield.setText("0 turn");
                        check();
                    }   
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("0");
                        player1_turn =true;
                        textfield.setText("X turn");
                        check();
                    }   

                }

                
            }
           
        }
            
    }
   
  

    public void firstTurn(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn =true;
            textfield.setText("X Turn");
        }else{
            player1_turn =false;
            textfield.setText("0 Turn");

        }

    }

    public void check(){
        //check X win
        if ((buttons[0].getText()=="X")&&
            (buttons[1].getText()=="X")&&
            (buttons[2].getText()=="X")) {
                xWins(0, 1, 2);
            
        }
        if ((buttons[3].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[5].getText()=="X")) {
                xWins(3, 4, 5);
            
        }
        if ((buttons[6].getText()=="X")&&
            (buttons[7].getText()=="X")&&
            (buttons[8].getText()=="X")) {
                xWins(6, 7, 8);
            
        }
        if ((buttons[0].getText()=="X")&&
            (buttons[3].getText()=="X")&&
            (buttons[6].getText()=="X")) {
                xWins(0, 3, 6);
            
        }
        if ((buttons[1].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[7].getText()=="X")) {
                xWins(1, 4, 7);
            
        }
        if ((buttons[2].getText()=="X")&&
            (buttons[5].getText()=="X")&&
            (buttons[8].getText()=="X")) {
                xWins(2, 5, 8);
            
        }
        if ((buttons[0].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[8].getText()=="X")) {
                xWins(0, 4, 8);
            
        }
        if ((buttons[2].getText()=="X")&&
            (buttons[4].getText()=="X")&&
            (buttons[6].getText()=="X")) {
                xWins(2, 4, 6);
            
        }
        //0 win condition
        if ((buttons[0].getText()=="0")&&
            (buttons[1].getText()=="0")&&
            (buttons[2].getText()=="0")) {
                oWins(0, 1, 2);
            
        }
        if ((buttons[3].getText()=="0")&&
            (buttons[4].getText()=="0")&&
            (buttons[5].getText()=="0")) {
                oWins(3, 4, 5);
            
        }
        if ((buttons[6].getText()=="0")&&
            (buttons[7].getText()=="0")&&
            (buttons[8].getText()=="0")) {
                oWins(6, 7, 8);
            
        }
        if ((buttons[0].getText()=="0")&&
            (buttons[3].getText()=="0")&&
            (buttons[6].getText()=="0")) {
                oWins(0, 3, 6);
            
        }
        if ((buttons[1].getText()=="0")&&
            (buttons[4].getText()=="0")&&
            (buttons[7].getText()=="0")) {
                oWins(1, 4, 7);
            
        }
        if ((buttons[2].getText()=="0")&&
            (buttons[5].getText()=="0")&&
            (buttons[8].getText()=="0")) {
                oWins(2, 5, 8);
             
        }
        if ((buttons[0].getText()=="0")&&
            (buttons[4].getText()=="0")&&
            (buttons[8].getText()=="0")) {
                oWins(0, 4, 8);
            
        }
        if ((buttons[2].getText()=="0")&&
            (buttons[4].getText()=="0")&&
            (buttons[6].getText()=="0")) {
                oWins(2, 4, 6);
            
        }
        

    }

    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);   
        }
        textfield.setText("X won!");
    }

    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);   
        }
        textfield.setText("0 won!");

    }
    
    public static void main(String[] args) {
        new TicTacToe();
        
    }
}
    

