package modelo;

import java.util.Objects;

public class Libro {
	
	private String isbn;
	private String titulo;
	private int codEditorial;
	private int anio;
	private int numPag;
	private double precio;
	private int cantidad;
	private double precioCD;
	
	
	public Libro() {
		this.isbn="";
		this.titulo="";
		this.codEditorial=0;
		this.anio=0;
		this.numPag=0;
		this.precio=0;
		this.cantidad=0;
		this.precioCD=0;
	}
	
	public Libro(String isbn, String titulo, int codEditorial, int anio, int numPag, double precio, int cantidad,
			double precioCD) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.codEditorial = codEditorial;
		this.anio = anio;
		this.numPag = numPag;
		this.precio = precio;
		this.cantidad = cantidad;
		this.precioCD = precioCD;
	}
	
	public Libro(Libro l) {
		this.isbn = l.isbn;
		this.titulo = l.titulo;
		this.codEditorial = l.codEditorial;
		this.anio = l.anio;
		this.numPag = l.numPag;
		this.precio = l.precio;
		this.cantidad = l.cantidad;
		this.precioCD = l.precioCD;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getCodEditorial() {
		return codEditorial;
	}

	public int getAnio() {
		return anio;
	}

	public int getNumPag() {
		return numPag;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecioCD() {
		return precioCD;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCodEditorial(int codEditorial) {
		this.codEditorial = codEditorial;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecioCD(double precioCD) {
		this.precioCD = precioCD;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, cantidad, codEditorial, isbn, numPag, precio, precioCD, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return anio == other.anio && cantidad == other.cantidad && Objects.equals(codEditorial, other.codEditorial)
				&& Objects.equals(isbn, other.isbn) && numPag == other.numPag
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Double.doubleToLongBits(precioCD) == Double.doubleToLongBits(other.precioCD)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", codEditorial=" + codEditorial + ", anio=" + anio
				+ ", numPag=" + numPag + ", precio=" + precio + ", cantidad=" + cantidad + ", precioCD=" + precioCD
				+ "]";
	}
	
	
	

}