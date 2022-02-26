package calculator;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.SystemColor;

//On or off
//sin, cos, tan
//Parenthesis
//negative sign
//pi
//mod

public class CalcPanel extends JPanel implements ActionListener {
	String num1 = "";
	String num2 = "";
	ArrayList <String> num= new ArrayList<String>();
	String operator = "";
	boolean usingFirst = true;
	double total = 0;
	JTextField display;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b0;
	JButton bdec;
	JButton bclear;
	JButton bequals;
	JButton bplus;
	JButton bsubtract;
	JButton bmultiple;
	JButton bdivide;
	JButton bmod;
	JButton bPower;
	JButton bsign;
	

	public CalcPanel() {
		this.setBackground(Color.white);
		setLayout(null);
		display = new JTextField();
		display.setEditable(false);

		b1 = new JButton("1");
		b1.setBackground(SystemColor.controlLtHighlight);
		b2 = new JButton("2");
		b2.setBackground(SystemColor.controlLtHighlight);
		b3 = new JButton("3");
		b3.setBackground(SystemColor.controlLtHighlight);
		b4 = new JButton("4");
		b4.setBackground(SystemColor.controlLtHighlight);
		b5 = new JButton("5");
		b5.setBackground(SystemColor.controlLtHighlight);
		b6 = new JButton("6");
		b6.setBackground(SystemColor.controlLtHighlight);
		b7 = new JButton("7");
		b7.setBackground(SystemColor.controlLtHighlight);
		b8 = new JButton("8");
		b8.setBackground(SystemColor.controlLtHighlight);
		b9 = new JButton("9");
		b9.setBackground(SystemColor.controlLtHighlight);
		b0 = new JButton("0");
		b0.setBackground(SystemColor.controlLtHighlight);
		bdec = new JButton(".");
		bdec.setBackground(SystemColor.controlLtHighlight);
		bclear = new JButton("C");
		bclear.setBackground(SystemColor.control);
		bequals = new JButton("=");
		bequals.setBackground(SystemColor.controlHighlight);
		bplus = new JButton("+");
		bplus.setBackground(SystemColor.controlHighlight);
		bsubtract = new JButton("-");
		bsubtract.setBackground(SystemColor.controlHighlight);
		bmultiple = new JButton("x");
		bmultiple.setBackground(SystemColor.controlHighlight);
		bdivide = new JButton("÷");
		bdivide.setBackground(SystemColor.controlHighlight);
		bmod = new JButton("mod");
		bmod.setFont(new Font("Tahoma", Font.BOLD, 10));
		bmod.setBackground(SystemColor.controlHighlight);
		bPower = new JButton("^");
		bPower.setBackground(SystemColor.controlHighlight);
		bsign=new JButton("±");
		bsign.setBackground(SystemColor.controlHighlight);

		display.setBounds(10, 10, 205, 50);

		b1.setBounds(12, 250, 50, 50);
		b2.setBounds(63, 250, 50, 50);
		b3.setBounds(113, 250, 50, 50);

		b4.setBounds(12, 200, 50, 50);
		b5.setBounds(63, 200, 50, 50);
		b6.setBounds(113, 200, 50, 50);

		b7.setBounds(12, 150, 50, 50);
		b8.setBounds(63, 150, 50, 50);
		b9.setBounds(113, 150, 50, 50);

		b0.setBounds(63, 300, 50, 50);
		bdec.setBounds(113, 300, 50, 50);
		bclear.setBounds(163, 97, 53, 53);
		bequals.setBounds(165, 300, 50, 50);
		bplus.setBounds(165, 250, 50, 50);
		bsubtract.setBounds(165, 200, 50, 50);
		bmultiple.setBounds(165, 150, 50, 50);
		bdivide.setBounds(113, 98, 50, 50);
		bmod.setBounds(12, 98, 56, 50);
		bsign.setBounds(12, 300, 50, 50);
		bPower.setBounds(68, 98, 45, 50);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b0);
		add(bdec);
		add(display);
		add(bclear);
		add(bequals);
		add(bplus);
		add(bsubtract);
		add(bmultiple);
		add(bdivide);
		add(bmod);
		add(bPower);
		add(bsign);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bequals.addActionListener(this);
		bplus.addActionListener(this);
		bclear.addActionListener(this);
		bdec.addActionListener(this);
		bsubtract.addActionListener(this);
		bmultiple.addActionListener(this);
		bdivide.addActionListener(this);
		bmod.addActionListener(this);
		bPower.addActionListener(this);
		bsign.addActionListener(this);
		

	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4")
				|| s.equals("5") || s.equals("6")
				|| s.equals("7") || s.equals("8") 
				|| s.equals("9") || s.equals("0") || s.equals(".")) {

					

			if (usingFirst) {
				num1 = num1 + s;
				display.setText(num1);
			} else {
				num2 = num2 + s;
				display.setText(num2);
			}
		}
		if(s.equals(".")) {
			bdec.setEnabled(false);
					
			
			if (display.getText().startsWith(".")) {
				display.setText("0.");
				num1="0."+num1.substring(1);
				usingFirst = true;
				} 
			
		}
		if (s.equals("+")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			usingFirst = false;
			operator = "+";
			defaultColor();
			bplus.setBackground(new Color(240, 248, 255));
			display.setText(getText.);
		}
		if (s.equals("-")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			usingFirst = false;
			operator = "-";
			defaultColor();
			bsubtract.setBackground(new Color(240, 248, 255));

		}
		if (s.equals("x")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			usingFirst = false;
			operator = "x";
			defaultColor();
			bmultiple.setBackground(new Color(240, 248, 255));

		}
		if (s.equals("÷")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			usingFirst = false;
			operator = "÷";
			defaultColor();
			bdivide.setBackground(new Color(240, 248, 255));

		}
		if (s.equals("mod")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			usingFirst = false;
			operator = "mod";
			defaultColor();
			bmod.setBackground(new Color(240, 248, 255));

		}
		if (s.equals("^")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			usingFirst = false;
			operator = "^";
			defaultColor();
			bPower.setBackground(new Color(240, 248, 255));

		} if(s.equals("±")) {
			bdec.setEnabled(true);
			bsign.setEnabled(false);
			if (usingFirst) {
				num1="-"+num1;
				display.setText(num1);
			}else {
				num2="-"+num2;
				display.setText(num2);
			}	
			
			defaultColor();
		
		}

		if (s.equals("=")) {
			try {

				switch (operator) {
				case "+":
					total = Double.parseDouble(num1) + Double.parseDouble(num2);
					display.setText("" + total);
					//num1=String.valueOf(total);				

					break;
				case "-":
					total = Double.parseDouble(num1) - Double.parseDouble(num2);
					display.setText("" + total);
					break;
				case "x":
					total = Double.parseDouble(num1) * Double.parseDouble(num2);
					display.setText("" + total);
					break;
				case "÷":
					total = Double.parseDouble(num1) / Double.parseDouble(num2);
					if (Double.parseDouble(num2) == 0) {
						display.setText("" + "undefined");
					} else {
						display.setText("" + total);
					}

					break;
				case "mod":
					total = Double.parseDouble(num1) % Double.parseDouble(num2);
					display.setText("" + total);
					break;
				case "^":
					total = Math.pow(Double.parseDouble(num1), Double.parseDouble(num2));
					display.setText("" + total);
					break;
				
				}
			} catch (Exception error) {
				display.setText("Error");
			}

			usingFirst = true;
			num1 = "";
			num2 = "";
			operator = "";
			defaultColor();
			bequals.setBackground(new Color(240, 248, 255));
		}
		if (s.equals("C")) {
			bdec.setEnabled(true);
			bsign.setEnabled(true);
			display.setText("");
			usingFirst = true;
			num1 = "";
			num2 = "";
			total = 0;
			defaultColor();
		} // end of if

	}// end of method
	
	private void defaultColor() {
		bplus.setBackground(SystemColor.controlHighlight);
		bPower.setBackground(SystemColor.controlHighlight);
		bsubtract.setBackground(SystemColor.controlHighlight);
		bdivide.setBackground(SystemColor.controlHighlight);
		bmod.setBackground(SystemColor.controlHighlight);
		bmultiple.setBackground(SystemColor.controlHighlight);
		bequals.setBackground(SystemColor.controlHighlight);
		
		
	}
}// end of class
