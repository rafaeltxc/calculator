package calculator.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField field;
	List<JButton> numbers;
	List<JButton> functions;
	
	public static void main(String[] args) {
		Frame f = new Frame();
	}
	
	Frame() {
		//total size
		int width = 400, height = 350;
		// text field
		int fieldWidth = width-10, fieldHeight = (int) (height * 0.15);
		//rows, columns and spaces between
		int nmRows = 4, nmCol = 3, fnRows = 4, fnCol = 2, spaceBt = 5;
		//numbers division
		int nmWidth = (int) (width * 0.65), nmHeightEnd = height-fieldHeight-(nmRows*spaceBt)-50;
		//operations division
		int fnWidthStart = nmWidth+10, nmWidthEnd = width-nmWidth-(nmCol*spaceBt), fnHeightEnd = height-fieldHeight-(nmRows*spaceBt)-50;
		
		JFrame frame = new JFrame("Calculator");
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.black);
		frame.setSize(width, height);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		field = new JTextField();
		field.setBounds(5, 5, fieldWidth, fieldHeight);
		field.setBackground(Color.black);
		field.setBorder(BorderFactory.createCompoundBorder(field.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		field.setFont(new Font("Courier", Font.PLAIN, 20));
		field.setForeground(Color.white);
		frame.add(field);
		
		numbers = new ArrayList<JButton>();
		
		JButton percOpen = new JButton("(");
		JButton percClose = new JButton(")");
		numbers.add(percOpen);
		numbers.add(percClose);
		
		for(int i=9; i>=0; i--) {
			numbers.add(new JButton(String.valueOf(i)));
		}
		
		for(int i=0; i<numbers.size(); i++) {
			numbers.get(i).addActionListener(this);
			numbers.get(i).setFocusable(false);
			numbers.get(i).setBackground(Color.black);
			numbers.get(i).setForeground(Color.white);
		}
		
		JPanel nbPanel = new JPanel();
		nbPanel.setBounds(5, fieldHeight+15, nmWidth, nmHeightEnd);
		nbPanel.setLayout(new GridLayout(nmRows, nmCol, spaceBt, spaceBt));
		nbPanel.setBackground(Color.black);
		
		
		for(int i=0; i<numbers.size(); i++) {
			nbPanel.add(numbers.get(i));
		}
		
		frame.add(nbPanel);
		
		functions = new ArrayList<JButton>();
		functions.add(new JButton("Del"));
		functions.add(new JButton("="));
		functions.add(new JButton("+"));
		functions.add(new JButton("-"));
		functions.add(new JButton("x"));
		functions.add(new JButton("/"));
		functions.add(new JButton("%"));
		functions.add(new JButton("."));
		
		for(int i=0; i<functions.size(); i++) {
			functions.get(i).addActionListener(this);
			functions.get(i).setFocusable(false);
			functions.get(i).setBackground(Color.black);
			functions.get(i).setForeground(Color.white);
		}
		
		JPanel fnPanel = new JPanel();
		fnPanel.setBounds(fnWidthStart, fieldHeight+15, nmWidthEnd, fnHeightEnd);
		fnPanel.setLayout(new GridLayout(fnRows, fnCol, spaceBt, spaceBt));
		fnPanel.setBackground(Color.black);
		
		for(int i=0; i<functions.size(); i++) {
			fnPanel.add(functions.get(i));
		}
		
		frame.add(fnPanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<numbers.size(); i++) {
			if(e.getSource().equals(numbers.get(i))) {
				field.setText(field.getText().concat(String.valueOf(numbers.get(i).getText())));
			}
		}
		
		for(int i=0; i<functions.size(); i++) {
			if(e.getSource().equals(functions.get(i))) {
				if(functions.get(i).getText().equals("Del")) {
					String expression = field.getText();
					if(expression.length()<1) {
						break;
					} else {
						field.setText(expression.substring(0, expression.length()-1));
						break;
					}
				} else if(functions.get(i).getText().equals("=")) {
					break;
				}
				field.setText(field.getText().concat(String.valueOf(functions.get(i).getText())));
			}
		}
	}
	
}
