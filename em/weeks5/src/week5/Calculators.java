package week5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.Actionlistener;
import java.awt.event.
import javax.swing.*;

public class Calculators extends JFrame implements ActionListener {
      //private JTextFeild textField;
      private String operator="";
      private double num1=0;
	  private JTextField textField;
	  public Calculators() {
		  setTitle("MY CALCULATOR");
		  setSize(300,400);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		  setLayout(new GridLayout(5,4));
		  textField  =new JTextField();
		  add(textField);
		  String[] buttons = {"1","2","3","4","5","6","7","8","9","0","/","*","-","+","=","c"};
		  for(String label : buttons) {
			  JButton button = new JButton(label);
			  add(button);
		  }
		  setVisible(true);
	  }
       

	   @Override
	   public void actionPerformed(ActionEvent e) {
		   
	   
		// TODO Auto-generated method stub
	   }
	   
	   public static void main(String[] args) {
		   
		   new Calculators();
	   }
 }

