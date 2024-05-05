package ar.edu.unju.fi.ejercicio5.productos;

public class Producto {
	
	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabri;
	private Categoria categoria;
	private boolean Estado;
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	

	public Producto(int codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabri,
			Categoria categoria, boolean Estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabri = origenFabri;
		this.categoria = categoria;
		this.Estado = Estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabri() {
		return origenFabri;
	}

	public void setOrigenFabri(OrigenFabricacion origenFabri) {
		this.origenFabri = origenFabri;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean Estado) {
		this.Estado = Estado;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabri=" + origenFabri + ", categoria=" + categoria + ", Estado=" + Estado
				+ "]";
	}

	
	
	
}
