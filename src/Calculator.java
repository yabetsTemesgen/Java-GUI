import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
//import java.math.*;

class Calculator extends JFrame implements ActionListener {
	static JFrame frame;
	static JTextField text;

	String str0, str1, str2;

	Calculator() {
		str0 = str1 = str2;
	}

	public static void main(String args[]) {
		frame = new JFrame("Simple calculator");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		Calculator cal = new Calculator();

		// text field to display
		text = new JTextField(20);
		text.setEditable(false);

		// buttons for the numbers and operators
		JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnDiv, btnMul, btnDot,
				btnReset, btnEqual, btnSin, btnCos, btnTan, btnSq;

		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnEqual = new JButton("=");
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnDiv = new JButton("/");
		btnMul = new JButton("*");
		btnReset = new JButton("C");
		btnDot = new JButton(".");
		btnSin = new JButton("sin");
		btnCos = new JButton("cos");
		btnTan = new JButton("tan");
		btnSq = new JButton("Root");

		btnEqual.setBackground(Color.GREEN);
		btnEqual.setForeground(Color.GREEN);
		btnReset.setBackground(Color.RED);
		btnReset.setForeground(Color.RED);
		btn0.setBackground(Color.decode("#274472"));
		btn1.setBackground(Color.decode("#274472"));
		btn2.setBackground(Color.decode("#274472"));
		btn3.setBackground(Color.decode("#274472"));
		btn4.setBackground(Color.decode("#274472"));
		btn5.setBackground(Color.decode("#274472"));
		btn6.setBackground(Color.decode("#274472"));
		btn7.setBackground(Color.decode("#274472"));
		btn8.setBackground(Color.decode("#274472"));
		btn9.setBackground(Color.decode("#274472"));
		btnAdd.setBackground(Color.decode("#2ca089"));
		btnSub.setBackground(Color.decode("#2ca089"));
		btnDiv.setBackground(Color.decode("#2ca089"));
		btnMul.setBackground(Color.decode("#2ca089"));
		JPanel panel = new JPanel();
		// adding action listeners

		btnMul.addActionListener(cal);
		btnDiv.addActionListener(cal);
		btnSub.addActionListener(cal);
		btnAdd.addActionListener(cal);
		btn9.addActionListener(cal);
		btn8.addActionListener(cal);
		btn7.addActionListener(cal);
		btn6.addActionListener(cal);
		btn5.addActionListener(cal);
		btn4.addActionListener(cal);
		btn3.addActionListener(cal);
		btn2.addActionListener(cal);
		btn1.addActionListener(cal);
		btn0.addActionListener(cal);
		btnDot.addActionListener(cal);
		btnReset.addActionListener(cal);
		btnEqual.addActionListener(cal);
		btnSin.addActionListener(cal);
		btnCos.addActionListener(cal);
		btnTan.addActionListener(cal);
		btnSq.addActionListener(cal);
		// add elements to panel
		panel.add(text);
		panel.add(btnAdd);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btnSub);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btnMul);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btnDiv);
		panel.add(btnDot);
		panel.add(btn0);
		panel.add(btnReset);
		panel.add(btnSin);
		panel.add(btnCos);
		panel.add(btnTan);
		panel.add(btnSq);
		panel.add(btnEqual);
		// setting the background color
		// panel.setBackground(RGBtoHSB(255, 0, 0, 1));
		panel.setBackground(Color.decode("#C3E0E5")); // set background color #2ca089

		// adding the panel to the frame
		frame.add(panel);
		frame.setSize(220, 240);
		frame.setVisible(true);
		// frame.show();
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		// number
		if ((str.charAt(0) >= '0' && str.charAt(0) <= '9') || str.charAt(0) == '.') {
			if (!str1.equals(""))
				str2 = str2 + str;
			else
				str0 = str0 + str;
			// set the value of the text
			text.setText(str0 + str1 + str2);
		} else if (str.charAt(0) == 'C') {
			// clear the letter
			str0 = str1 = str2 = "";

			text.setText(str0 + str1 + str2);
		} else if (str.charAt(0) == '=') {
			double result;

			if (str1.equals("+"))
				result = (Double.parseDouble(str0) + Double.parseDouble(str2));
			else if (str1.equals("-"))
				result = (Double.parseDouble(str0) - Double.parseDouble(str2));
			else if (str1.equals("/"))
				result = (Double.parseDouble(str0) / Double.parseDouble(str2));
			else if (str1.equals("sin"))
				result = Math.sin(Double.parseDouble(str0));
			else if (str1.equals("cos"))
				result = Math.cos(Double.parseDouble(str0));
			else if (str1.equals("tan"))
				result = Math.tan(Double.parseDouble(str0));
			else if (str1.equals("Root"))
				result = Math.sqrt(Double.parseDouble(str0));
			else
				result = (Double.parseDouble(str0) * Double.parseDouble(str2));

			text.setText(str0 + str1 + str2 + "=" + result);
			str0 = Double.toString(result);
			str1 = str2 = "";
		} else {
			// no operand
			if (str1.equals("") || str2.equals(""))
				str1 = str;
			else {
				double result;

				if (str1.equals("+"))
					result = (Double.parseDouble(str0) + Double.parseDouble(str2));
				else if (str1.equals("-"))
					result = (Double.parseDouble(str0) - Double.parseDouble(str2));
				else if (str1.equals("/"))
					result = (Double.parseDouble(str0) / Double.parseDouble(str2));
				else if (str1.equals("sin"))
					result = Math.sin(Double.parseDouble(str0));
				else if (str1.equals("cos"))
					result = Math.cos(Double.parseDouble(str0));
				else if (str1.equals("tan"))
					result = Math.tan(Double.parseDouble(str0));
				else if (str1.equals("Root"))
					result = Math.sqrt(Double.parseDouble(str0));
				else
					result = (Double.parseDouble(str0) * Double.parseDouble(str2));
				str0 = Double.toString(result);
				str1 = str;
				str2 = "";
			}
			text.setText(str0 + str1 + str2);
		}
	}
}
