package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import net.miginfocom.swing.MigLayout;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	
	/**
	 * Create the frame.
	 */
	
	public VentanaPpal() {
		
		setTitle("Base de datos de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow][]", "[][][][][][][]"));
		
		JButton btnNewButton = new JButton("Mostrar Editoriales");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarEditoriales();
			}
		});
		contentPane.add(btnNewButton, "cell 1 1,growx");
		
		JButton btnNewButton_4 = new JButton("Insertar Editorial");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarNuevaEditorial();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Mostrar Libros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarNuevoLibro();
			}
		});
		contentPane.add(btnNewButton_1, "cell 3 1,growx");
		contentPane.add(btnNewButton_4, "cell 1 3,growx");
		
		JButton btnNewButton_2 = new JButton("Insertar Libros");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarNuevoLibro();
			}
		});
		contentPane.add(btnNewButton_2, "cell 3 3,growx");
	}



	/**
	 * @param controlador el controlador a establecer
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	

}
