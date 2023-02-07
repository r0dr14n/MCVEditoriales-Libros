package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Editorial;
import modelo.Libro;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumPag;
	private JTextField txtIsbn;
	private JTextField txtTitulo;
	private Libro libro;
	private Controlador controlador;
	private JTextField txtCodEditorial;
	private JTextField txtAnio;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTextField txtPrecioCD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoLibro frame = new NuevoLibro();
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
	public NuevoLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][][][grow][][grow][][][][]", "[][][][][][][][][]"));
		
		JLabel lbl1 = new JLabel("Insertar Libro");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setBackground(new Color(0, 0, 0));
		lbl1.setOpaque(true);
		contentPane.add(lbl1, "cell 0 0 12 2,grow");
		
		JLabel lblNewLabel = new JLabel("Título:");
		contentPane.add(lblNewLabel, "cell 1 3,alignx center");
		
		txtTitulo = new JTextField();
		contentPane.add(txtTitulo, "cell 2 3 4 1,growx");
		txtTitulo.setColumns(10);
		
		JLabel lblAnio = new JLabel("Año:");
		contentPane.add(lblAnio, "cell 6 3,alignx center");
		
		txtAnio = new JTextField();
		contentPane.add(txtAnio, "cell 7 3 4 1,growx");
		txtAnio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN:");
		contentPane.add(lblNewLabel_1, "cell 1 4,alignx center");
		
		txtIsbn = new JTextField();
		contentPane.add(txtIsbn, "cell 2 4 4 1,growx");
		txtIsbn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		contentPane.add(lblNewLabel_3, "cell 6 4,alignx center");
		
		txtCantidad = new JTextField();
		contentPane.add(txtCantidad, "cell 7 4 4 1,growx");
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NumPags:");
		contentPane.add(lblNewLabel_2, "cell 1 5,alignx center");
		
		txtNumPag = new JTextField();
		contentPane.add(txtNumPag, "cell 2 5 4 1,growx");
		txtNumPag.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Precio:");
		contentPane.add(lblNewLabel_5, "cell 6 5,alignx center");
		
		txtPrecio = new JTextField();
		contentPane.add(txtPrecio, "cell 7 5 4 1,growx");
		txtPrecio.setColumns(10);
		
		JLabel lblcodEditorial = new JLabel("codEditorial");
		contentPane.add(lblcodEditorial, "cell 1 6,alignx trailing");
		
		txtCodEditorial = new JTextField();
		contentPane.add(txtCodEditorial, "cell 2 6 4 1,growx");
		txtCodEditorial.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PrecioCD:");
		contentPane.add(lblNewLabel_7, "cell 6 6,alignx trailing");
		
		txtPrecioCD = new JTextField();
		contentPane.add(txtPrecioCD, "cell 7 6 4 1,growx");
		txtPrecioCD.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarLibro();
			}
		});
		contentPane.add(btnInsertar, "cell 9 8");
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnCancel, "cell 10 8 2 1");
	}
	
	protected void insertarLibro() {
		try {
			String isbn = txtIsbn.getText();
			String titulo = txtTitulo.getText();
			int codEditorial = Integer.parseInt(txtCodEditorial.getText());
			int anio = Integer.parseInt(txtAnio.getText());
			int numPag = Integer.parseInt(txtIsbn.getText());
			double precio = Double.parseDouble(txtPrecio.getText());
			int cantidad = Integer.parseInt(txtCantidad.getText());
			double precioCD = Double.parseDouble(txtPrecioCD.getText());
			
			
			//Editorial ed = new Editorial(0,nombre,año);
			Libro ed = new Libro();
			
			ed.setIsbn(isbn);
			ed.setTitulo(titulo);
			ed.setCodEditorial(codEditorial);
			ed.setAnio(anio);
			ed.setNumPag(numPag);
			ed.setPrecio(precio);
			ed.setCantidad(cantidad);
			ed.setPrecioCD(precioCD);
			
			if (this.libro == null)
				controlador.insertarLibro(ed);
			else {
				ed.setIsbn(this.libro.getIsbn());
				controlador.actualizarLibro(ed);
				
			}
		} catch (NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "Introduzca un año correcto");
		}	
	}
	
	public void setLibro(Libro e) {
		libro = e;
		if (e!=null) {
			txtIsbn.setText(""+libro.getIsbn());
			txtTitulo.setText(libro.getTitulo());
			txtCodEditorial.setText(""+libro.getCodEditorial());
			txtAnio.setText(""+libro.getAnio());
			txtNumPag.setText(""+libro.getNumPag());
			txtPrecio.setText(""+libro.getPrecio());
			txtCantidad.setText(""+libro.getCantidad());
			txtPrecioCD.setText(""+libro.getPrecioCD());
		} else {
			txtIsbn.setText("");
			txtTitulo.setText("");
			txtCodEditorial.setText("");
			txtAnio.setText("");
			txtNumPag.setText("");
			txtPrecio.setText("");
			txtCantidad.setText("");
			txtPrecioCD.setText("");
		}
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

}
