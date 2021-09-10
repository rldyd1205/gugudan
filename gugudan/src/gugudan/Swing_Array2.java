package gugudan;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;

public class Swing_Array2 extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField 				textField;
	private GridBagLayout 			gridBagLayout;
	private JTextArea 				textArea;
	private GridBagConstraints 		gbc_textField, gbc_textArea, gbc_btnSend, gbc_btnClear;
	private JButton 				btnSend, btnClear;
	private JScrollPane 			jsp;

	public Swing_Array2() {
		super("2차원 배열 구구단");

		this.init();
		this.setLayout();
		this.addListener();
		this.showFrame();
	}

	private void init() {
		this.gridBagLayout 					= new GridBagLayout();
		this.gridBagLayout.columnWidths 	= new int[] { 0, 0, 0, 0, 0 };
		this.gridBagLayout.rowHeights 		= new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.gridBagLayout.columnWeights 	= new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.gridBagLayout.rowWeights 		= new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

		this.textArea 						= new JTextArea();
		this.jsp 							= new JScrollPane(this.textArea);

		this.gbc_textArea 					= new GridBagConstraints();
		this.gbc_textArea.gridheight 		= 8;
		this.gbc_textArea.gridwidth 		= 4;
		this.gbc_textArea.insets 			= new Insets(0, 0, 5, 5);
		this.gbc_textArea.fill 				= GridBagConstraints.BOTH;
		this.gbc_textArea.gridx 			= 0;
		this.gbc_textArea.gridy 			= 0;

		this.textField 						= new JTextField();
		this.gbc_textField 					= new GridBagConstraints();
		this.gbc_textField.gridwidth 		= 2;
		this.gbc_textField.insets 			= new Insets(0, 0, 0, 5);
		this.gbc_textField.fill 			= GridBagConstraints.HORIZONTAL;
		this.gbc_textField.gridx 			= 0;
		this.gbc_textField.gridy 			= 8;

		this.btnSend 						= new JButton("보내기");
		this.gbc_btnSend 					= new GridBagConstraints();
		this.gbc_btnSend.insets 			= new Insets(0, 0, 0, 5);
		this.gbc_btnSend.gridx 				= 2;
		this.gbc_btnSend.gridy 				= 8;

		this.btnClear 						= new JButton("지우기");
		this.gbc_btnClear 					= new GridBagConstraints();
		this.gbc_btnClear.gridx 			= 3;
		this.gbc_btnClear.gridy 			= 8;
	}

	private void setLayout() {
		this.setLayout(gridBagLayout);
		this.textField.setColumns(10);
		this.textArea.setEditable(false);

		this.add(this.jsp, this.gbc_textArea);
		this.add(this.textField, this.gbc_textField);
		this.add(this.btnSend, this.gbc_btnSend);
		this.add(this.btnClear, this.gbc_btnClear);

	}

	private void addListener() {
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columns();
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columns();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
	}
	
	public void columns() {
		String str = textField.getText();
		if (!str.equals("")) {
			int a = Integer.parseInt(str);
			// 입력받은 값 까지만 구구단 작성
			int[][] gugu = new int[a][9];
			for (int i = 2; i <= a; i++) {
				for (int j = 1; j <= 9; j++) {
					gugu[i-2][j-1] = i * j;
				}
			}
			textArea.append("textField에 " + a + "를 입력하면?" + "\n");
			// 구구단 출력 코드
			for (int i = 0; i < gugu.length-1; i++) {
				textArea.append((i+2) + "단 :" + Arrays.toString(gugu[i]) + "\n");
			}
			textArea.append("\n");
		}
		textField.setText("");
	}
	
	private void showFrame() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Swing_Array2();

	} //main
}
