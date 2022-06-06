import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax. swing.JFrame;
import javax.swing. Timer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.IconView;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StickFigure extends JComponent{
    final int SCREEN_WIDTH=900;
    final int SCREEN_HEIGTH=800;
    static boolean Foreward=false;
    static boolean Backward=false;
    Timer t;


    int baseX;
    int baseY;
    int neck;
    Color colorStickF;
    Color temp;
    int headSize;
    int bodySize;
    int piedY;
    int handY;
    int handXLeft;
    int handXRight;
    int Unit;
    int size;
    


    JCheckBox legs;
    JCheckBox arms;
    JCheckBox eye;
    JCheckBox mouth;

    JSlider slider;

    JComboBox combo;

   

    StickFigure(int x, int y, Color c, int s){
        this.baseX=x;
        this.baseY=y;
        this.colorStickF=c;
        //temp = c;
        size=s;
        ActionListener a = new TimerGeneral();
        final int DELAY = 250; // Milliseconds between timer ticks
        Timer e = new Timer(DELAY, a);
        e.start();
    }
    
    public void paintComponent (Graphics SF)
    {
        //temp = colorStickF;
        
        this.Unit=size/10;
       int headCenterX = this.baseX;
       int headCenterY = this.neck - headSize/2;

        this.bodySize=Unit*4;
        this.headSize=Unit*3;
        this.neck=this.baseY-this.bodySize;

        this.handY=this.baseY;
        this.handXLeft=this.baseX-Unit;
        this.handXRight=this.baseX+Unit;

        this.piedY=this.baseY+this.bodySize;


      /*SF.setColor (Color.gray);
      SF.fillRect (0, 175, 300, 50);  // ground

      page.setColor (Color.yellow);
      page.fillOval (-40, -40, 80, 80);  // sun */
        
      SF.setColor (colorStickF);
      SF.fillOval(headCenterX-headSize/2,headCenterY-headSize/2,headSize,headSize);  // head
      SF.setColor (Color.black);
      SF.fillRect(this.baseX, this.neck, 10, this.bodySize); //body with rectangle
     // SF.drawLine(this.baseX, this.baseY, this.baseX, this.neck); //body
      SF.setColor(Color.BLACK);
      if(arms.isSelected()){ 
        SF.drawLine(this.baseX, this.neck + this.Unit, this.handXLeft, this.baseY-this.Unit); // left Arm
        SF.drawLine(this.baseX+10, this.neck + this.Unit, this.handXRight, this.baseY-this.Unit); // Rigth Arm
      }
      if(legs.isSelected()){ 
        SF.drawLine(this.baseX, this.baseY, this.baseX - this.Unit, this.baseY+this.Unit*2); // left leg
        SF.drawLine(this.baseX+10, this.baseY, this.baseX + this.Unit , this.baseY+this.Unit*2); // Rigth leg
      }
    
      if(eye.isSelected()){ 
        SF.setColor (Color.blue);
        SF.fillOval (headCenterX-headSize/4, headCenterY, headSize/16, headSize/16);   // left eye
        SF.fillOval (headCenterX+headSize/4, headCenterY, headSize/16, headSize/16);    // right eye
      }
      if(mouth.isSelected()){ 
        SF.setColor(Color.red);
        SF.fillRect(headCenterX-headSize/4,headCenterY+headSize/4 , headSize/2, headSize/16);   // smile
      }
      //this.baseX+=50;
    }  
    /*public void move (int dx) //PART1
    {
        if(this.baseX-this.Unit >= this.SCREEN_WIDTH){
            this.baseX=0;
        }
        
       this.baseX = this.baseX + dx;
       repaint();
    } */
    public class TimerListener implements ActionListener{ //PART1
        public void actionPerformed (ActionEvent event)
        {
            //move(); 
            if(Foreward){
                moveForeward(50);
            }
            else if(Backward){
                moveBackward(50);
            }
            else{
                repaint();
            }
        } 
    }  
    public class TimerGeneral implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
        
    }
    
    //PART 2
    /*public void move(){
        if(Foreward){
            moveForeward(50);
        }
        else if(Backward){
            moveBackward(50);
        }
    } */
    public void moveForeward(int dx){
        if(this.baseX-this.Unit >= this.SCREEN_WIDTH){
            this.baseX=0;
        }
       this.baseX = this.baseX + dx;
       repaint();
    }
    public void moveBackward(int e){
        if(this.baseX+this.Unit <= 0){
            this.baseX=this.SCREEN_WIDTH;
        } 
       this.baseX = this.baseX - e;
       repaint(); 
    }
   public class ClickListener implements ActionListener{ //Move foreward
        public void actionPerformed(ActionEvent event){
            Backward=false;
            Foreward=true;
            ActionListener listener = new TimerListener();
            final int DELAY = 250; // Milliseconds between timer ticks
            t = new Timer(DELAY, listener);
            t.start();
            repaint();
        }
   }
   public class ClickListener2 implements ActionListener{
    public void actionPerformed(ActionEvent event){
        //this.baseX+=50;
        Foreward=false;
        Backward=true;
        ActionListener listener = new TimerListener();
        final int DELAY = 250; // Milliseconds between timer ticks
        t = new Timer(DELAY, listener);
        t.start();
        repaint();
    }
   }
   public class ClickListener3 implements ActionListener{
       public void actionPerformed(ActionEvent event){
           Foreward=false;
           Backward=false;
           t.stop();
           repaint();
       }
   }
   
   public class ComboListener implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==combo){
            colorStickF=(Color) combo.getSelectedItem();
            repaint();
        }
    }

   }
   public void createButton(JPanel panel){
    
        legs = new JCheckBox("Legs");
        arms = new JCheckBox("Arms");
        eye = new JCheckBox("Eye");
        mouth = new JCheckBox("Mouth");
        panel.add(eye);
        panel.add(mouth);
        panel.add(legs);
        panel.add(arms);

        ChangeListener cl = new sizeChanger();
        slider= new JSlider(JSlider.HORIZONTAL,-50,50,0);
        slider.addChangeListener(cl);
        panel.add(slider,BorderLayout.SOUTH);

        combo = new JComboBox<>();
        combo.addItem(Color.yellow);
        combo.addItem(Color.red);
        combo.addItem(Color.black);
        combo.addItem(Color.green);
        combo.addItem(Color.magenta);
        ItemListener i = new ComboListener();
        combo.addItemListener(i);
        panel.add(combo);
        
       //Foreward
        JButton button = new JButton("Move Forward");
        button.setBounds(100, 100, 200, 100);
        button.setForeground(Color.MAGENTA);
        button.setBackground(Color.black);
        panel.add(button,BorderLayout.EAST);
        ActionListener li = new ClickListener();
        button.addActionListener(li);
        //Backward
        JButton button2 = new JButton("Move Backward");
        button2.setBounds(100, 100, 200, 100);
        button2.setForeground(Color.MAGENTA);
        button2.setBackground(Color.black);
        panel.add(button2,BorderLayout.WEST);
        ActionListener li2 = new ClickListener2();
        button2.addActionListener(li2);
        //Stop
        JButton buttonStop = new JButton("Stop");
        buttonStop.setBounds(100, 100, 200, 100);
        buttonStop.setForeground(Color.MAGENTA);
        buttonStop.setBackground(Color.black);
        panel.add(buttonStop,BorderLayout.SOUTH);
        ActionListener li3 = new ClickListener3();
        buttonStop.addActionListener(li3);

        
   }

   public class sizeChanger implements ChangeListener{
    
    @Override
    public void stateChanged(ChangeEvent e) {
        size += slider.getValue();
        repaint();
    }
   }
    
    public static void main(String[] args) {
        StickFigure man = new StickFigure(0,500,Color.yellow,400);
        JFrame f = new JFrame();
        f.add(man);
        f.setVisible(true);
        f.setSize(man.SCREEN_WIDTH,man.SCREEN_HEIGTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        man.createButton(buttonPanel);
        f.add(buttonPanel);
        

    }
}