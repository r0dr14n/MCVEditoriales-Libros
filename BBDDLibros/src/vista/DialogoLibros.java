package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Editorial;
import modelo.Libro;
import net.miginfocom.swing.MigLayout;

public class DialogoLibros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Controlador controlador;


	/**
	 * Create the dialog.
	 */
	public DialogoLibros() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		{
			JLabel lblNewLabel = new JLabel("Listado de libros:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel, "cell 0 0");
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 0 1,alignx center,growy");
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ISBN", "T\u00EDtulo", "codEditorial", "A\u00F1o", "NumPags", "Precio", "Cantidad", "PrecioCD"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(99);
				scrollPane.setViewportView(table);
			}
		}
		{
			{
				JPanel panel = new JPanel();
				contentPanel.add(panel, "cell 0 2,grow");
				panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JButton btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							llamarActualizar();
						}
					});
					{
						JButton btnEliminar = new JButton("Eliminar");
						btnEliminar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								llamarEliminar();
							}
						});
						panel.add(btnEliminar);
					}
					panel.add(btnModificar);
					btnModificar.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				JButton btnCerrar = new JButton("Cerrar");
				panel.add(btnCerrar);
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			}
		}
	}
	
	protected void llamarEliminar() {
		int fila = table.getSelectedRow();
		if (fila==-1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un libro");
		} else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			String isbn = (String) modelo.getValueAt(fila, 0);
			controlador.eliminarLibro(isbn);
		}
	}

	protected void llamarActualizar() {
		int fila = table.getSelectedRow();
		if (fila==-1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una editorial");
		} else {
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			String isbn = (String) modelo.getValueAt(fila, 0);
			controlador.mostrarActualizarLibro(isbn);
		}
	}

	public void setListaLibros (ArrayList<Libro> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Libro libro : lista) {
			Object [] fila = {
					libro.getTitulo(),libro.getIsbn(),libro.getNumPag()
			};
			modelo.addRow(fila);
		}
	}

	/**
	 * @param controlador el controlador a establecer
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}


}
