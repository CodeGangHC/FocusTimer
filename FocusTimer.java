package Focus_Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusTimer implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JButton fiveMinButton = new JButton("5");
    JButton tenMinButton = new JButton("10");
    JButton fifteenMinButton = new JButton("15");
    JButton thirtyMinButton = new JButton("30");
    JButton sixtyMinButton = new JButton("60");
    JButton nintyMinButton = new JButton("90");
    JLabel timeLabel = new JLabel();
    private int elapsedTime = 0; // millisec
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
  
    Timer timer = new Timer(1000, new ActionListener() { // 1000 milli sec = 1 sec. Passing 1000 milli sec into Action Listener
        @Override
        public void actionPerformed(ActionEvent e) { // define action performed method = what timer is going to do every 1000 milli sec
            elapsedTime -= 1000;
            isZero();
            hours = (elapsedTime/3600000) % 60;
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });

    FocusTimer(){

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(35,0,420,300);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,70));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(35,300,210,100);
        startButton.setFont(new Font("Verdana",Font.PLAIN,30));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(245,300,210,100);
        resetButton.setFont(new Font("Verdana",Font.PLAIN,30));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        fiveMinButton.setBounds(35,400,70,100);
        fiveMinButton.setFont(new Font("Verdana",Font.PLAIN,25));
        fiveMinButton.setFocusable(false);
        fiveMinButton.addActionListener(this);

        tenMinButton.setBounds(105,400,70,100);
        tenMinButton.setFont(new Font("Verdana",Font.PLAIN,25));
        tenMinButton.setFocusable(false);
        tenMinButton.addActionListener(this);

        fifteenMinButton.setBounds(175,400,70,100);
        fifteenMinButton.setFont(new Font("Verdana",Font.PLAIN,25));
        fifteenMinButton.setFocusable(false);
        fifteenMinButton.addActionListener(this);

        thirtyMinButton.setBounds(245,400,70,100);
        thirtyMinButton.setFont(new Font("Verdana",Font.PLAIN,25));
        thirtyMinButton.setFocusable(false);
        thirtyMinButton.addActionListener(this);

        sixtyMinButton.setBounds(315,400,70,100);
        sixtyMinButton.setFont(new Font("Verdana",Font.PLAIN,25));
        sixtyMinButton.setFocusable(false);
        sixtyMinButton.addActionListener(this);

        nintyMinButton.setBounds(385,400,70,100);
        nintyMinButton.setFont(new Font("Verdana",Font.PLAIN,25));
        nintyMinButton.setFocusable(false);
        nintyMinButton.addActionListener(this);

        frame.add(nintyMinButton);
        frame.add(sixtyMinButton);
        frame.add(thirtyMinButton);
        frame.add(tenMinButton);
        frame.add(fifteenMinButton);
        frame.add(fiveMinButton);
        frame.add(resetButton);
        frame.add(startButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            if(started == false){ // once hit 'START' button, timer will start and button will switch to 'STOP' button.
                started = true;
                startButton.setText("STOP");
                start();
            }
            else{ // once hit the 'STOP' button, timer will stop and button will switch to 'START' button
                started = false;
                startButton.setText("START");
                stop();
            }
        }
        if(e.getSource() == resetButton){
            started = false;
            startButton.setText("START");
            reset();
        }
        if(e.getSource() == fiveMinButton){
            five();
        }
        if(e.getSource() == tenMinButton){
            ten();
        }
        if(e.getSource() == fifteenMinButton){
            fifteen();
        }
        if(e.getSource() == thirtyMinButton){
            thirty();
        }
        if(e.getSource() == sixtyMinButton){
            sixty();
        }
        if(e.getSource() == nintyMinButton){
            ninty();
        }
    }
    void five(){
        elapsedTime += 300000;
        current_time();
    }
    void ten(){
        elapsedTime += 300000*2;
        current_time();
    }
    void fifteen(){
        elapsedTime += 300000*3;
        current_time();
    }
    void thirty(){
        elapsedTime += 300000*6;
        current_time();
    }
    void sixty(){
        elapsedTime += 300000*12;
        current_time();
    }
    void ninty(){
        elapsedTime += 300000*18;
        current_time();
    }
    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }
    void current_time(){
        hours = (elapsedTime/3600000) % 60;
        minutes = (elapsedTime/60000) % 60;
        seconds = (elapsedTime/1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
    void reset(){
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
    void isZero(){
        if (started && elapsedTime<=0){
            Toolkit.getDefaultToolkit().beep();
        }

    }
}
