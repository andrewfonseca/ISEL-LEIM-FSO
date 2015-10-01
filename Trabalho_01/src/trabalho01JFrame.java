import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class trabalho01JFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtOffsetEsquerda;
	private JTextField txtOffsetDireita;
	private JLabel lblOffsetDireita;
	private JTextField txtLog;
	private JLabel lblRobot;
	private JTextField txtRobot;
	private JTextField txtRaio;
	private JLabel lblAngulo;
	private JTextField txtAngulo;
	private JLabel lblDistancia;
	private JTextField txtDistancia;
	private JButton btnEsquerda;
	private JButton btnParar;
	private JButton btnDireita;
	private JButton btnRectaguarda;
	
	JCheckBox chckbxDebug;
	JRadioButton rdbtnOnOff;
	
	private int offsetLeft;
	private int offsetRight;
	private String robotName;
	private String debugText;
	private int radius;
	private int distance;
	private int angle;
	private boolean onOff;
	private boolean debug;
	
	/**
	 * Initializes variables
	 */
	void initVariables() {
		robotName = "Moura Guedes";
		offsetLeft = 0;
		offsetRight = 0;
		radius = 0;
		angle = 0;
		distance = 0;
		debug = true;
		onOff = true;
	}
	
	/**
	 * Updates GUI components
	 */
	void updateVariables() {
		txtOffsetDireita.setText(Integer.toString(offsetRight));
		txtOffsetEsquerda.setText(Integer.toString(offsetLeft));
		txtRobot.setText(robotName);
		txtAngulo.setText(Integer.toString(angle));
		txtDistancia.setText(Integer.toString(distance));
		txtRaio.setText(Integer.toString(radius));
		rdbtnOnOff.setSelected(onOff);
		chckbxDebug.setSelected(debug);
		txtLog.setText(debugText);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trabalho01JFrame frame = new trabalho01JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public trabalho01JFrame() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOffsetEsquerda = new JLabel("Offset esquerda");
		lblOffsetEsquerda.setBounds(60, 14, 125, 15);
		contentPane.add(lblOffsetEsquerda);
		
		txtOffsetEsquerda = new JTextField();
		txtOffsetEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				offsetLeft = stringToInteger(txtOffsetEsquerda.getText());
				offsetLeft = stringToInteger(txtOffsetEsquerda.getText());
				log("Offset esquerda:" + Integer.toString(offsetLeft));
			}
		});
		txtOffsetEsquerda.setBounds(12, 12, 30, 19);
		contentPane.add(txtOffsetEsquerda);
		txtOffsetEsquerda.setColumns(10);
		
		txtOffsetDireita = new JTextField();
		txtOffsetDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				offsetRight = stringToInteger(txtOffsetDireita.getText());
				log("Offset direita:" + Integer.toString(offsetRight));
			}	
		});
		txtOffsetDireita.setColumns(10);
		txtOffsetDireita.setBounds(398, 12, 30, 19);
		contentPane.add(txtOffsetDireita);
		
		lblOffsetDireita = new JLabel("Offset direita");
		lblOffsetDireita.setBounds(278, 14, 102, 15);
		contentPane.add(lblOffsetDireita);
		
		chckbxDebug = new JCheckBox("Debug");
		chckbxDebug.setBounds(12, 243, 77, 23);
		contentPane.add(chckbxDebug);
		
		txtLog = new JTextField();
		txtLog.setBounds(143, 245, 285, 19);
		contentPane.add(txtLog);
		txtLog.setColumns(10);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(95, 247, 30, 15);
		contentPane.add(lblLog);
		
		lblRobot = new JLabel("Robot");
		lblRobot.setBounds(60, 39, 51, 15);
		contentPane.add(lblRobot);
		
		txtRobot = new JTextField();
		txtRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				robotName = txtRobot.getText();
				log("Robot:" + robotName);
			}
		});
		txtRobot.setColumns(10);
		txtRobot.setBounds(130, 37, 90, 19);
		contentPane.add(txtRobot);
		
		rdbtnOnOff = new JRadioButton("On/Off");
		rdbtnOnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOff = rdbtnOnOff.isSelected();
				log("On/Off:" + Boolean.toString(onOff));
			}
		});
		rdbtnOnOff.setBounds(258, 35, 70, 23);
		contentPane.add(rdbtnOnOff);
		
		JLabel lblRaiocm = new JLabel("Raio (cm)");
		lblRaiocm.setBounds(60, 66, 70, 15);
		contentPane.add(lblRaiocm);
		
		txtRaio = new JTextField();
		txtRaio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radius = stringToInteger(txtRaio.getText());
				log("Raio:" + Integer.toString(radius));
			}
		});
		txtRaio.setColumns(10);
		txtRaio.setBounds(130, 64, 30, 19);
		contentPane.add(txtRaio);
		
		lblAngulo = new JLabel("Ângulo (º)");
		lblAngulo.setBounds(178, 66, 77, 15);
		contentPane.add(lblAngulo);
		
		txtAngulo = new JTextField();
		txtAngulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angle = stringToInteger(txtAngulo.getText());
				log("Angulo:" + Integer.toString(angle));
			}
		});
		txtAngulo.setColumns(10);
		txtAngulo.setBounds(258, 64, 30, 19);
		contentPane.add(txtAngulo);
		
		lblDistancia = new JLabel("Distância (cm)");
		lblDistancia.setBounds(306, 66, 77, 15);
		contentPane.add(lblDistancia);
		
		txtDistancia = new JTextField();
		txtDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				distance = stringToInteger(txtDistancia.getText());
				log("Distancia:" + Integer.toString(distance));
			}
		});
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(398, 64, 30, 19);
		contentPane.add(txtDistancia);
		
		JButton btnFrente = new JButton("Frente");
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveRobot(stringToInteger(txtDistancia.getText()), 0, 0, btnFrente.getText());
			}
		});
		btnFrente.setBackground(Color.GREEN);
		btnFrente.setBounds(178, 95, 117, 40);
		contentPane.add(btnFrente);
		
		btnEsquerda = new JButton("Esquerda");
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveRobot(stringToInteger(txtDistancia.getText()), stringToInteger(txtRaio.getText()), stringToInteger(txtDistancia.getText()), btnEsquerda.getText());
			}
		});
		btnEsquerda.setBackground(Color.YELLOW);
		btnEsquerda.setBounds(49, 147, 117, 40);
		contentPane.add(btnEsquerda);
		
		btnParar = new JButton("Parar");
		btnParar.setBackground(Color.RED);
		btnParar.setBounds(178, 147, 117, 40);
		contentPane.add(btnParar);
		
		btnDireita = new JButton("Direita");
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveRobot(stringToInteger(txtDistancia.getText()), stringToInteger(txtRaio.getText()), stringToInteger(txtDistancia.getText()), btnDireita.getText());
			}
		});
		btnDireita.setBackground(Color.MAGENTA);
		btnDireita.setBounds(306, 146, 117, 40);
		contentPane.add(btnDireita);
		
		btnRectaguarda = new JButton("Retaguarda");
		btnRectaguarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveRobot(stringToInteger(txtDistancia.getText()), 0, 0, btnRectaguarda.getText());
			}
		});
		btnRectaguarda.setBackground(Color.BLUE);
		btnRectaguarda.setBounds(178, 199, 117, 40);
		contentPane.add(btnRectaguarda);
		
		initVariables();
		updateVariables();
		
		//if (txtRobot.getText() instanceof String)
		//{
			
		//}
	}
	
	int stringToInteger(String s) {
		try {
			return Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			return 0;
		}
		
	}
	
	void log(String v) {
		if (!chckbxDebug.isSelected()) {
			return;
		}
		
		if (debug) {
			txtLog.setText(v);
		}
	}
	
	void moveRobot(int distance, int radius, int angle, String direction) {
		if (!onOff) {
			return;
		}
		
		this.distance = distance;
		this.angle = angle;
		this.radius = radius;
		log("[" + direction + "] distancia: " + this.distance + " angulo: " + this.angle + " raio: " + this.radius);
	}
	
}