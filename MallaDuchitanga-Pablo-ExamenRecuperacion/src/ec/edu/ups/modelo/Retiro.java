package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Retiro
 *
 */
@Entity

public class Retiro implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int codigo;

	private String fecha;
	private String hora;
	
	private String descripcion;
	private double montoTotal;
	
	@ManyToOne
	@JoinColumn
	private CuentaBancaria cuentaBancariaR;

	public Retiro() {
		super();
	}

	public Retiro(String fecha, String hora, String descripcion, double montoTotal,
			CuentaBancaria cuentaBancariaR) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.descripcion = descripcion;
		this.montoTotal = montoTotal;
		this.cuentaBancariaR = cuentaBancariaR;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public CuentaBancaria getCuentaBancariaR() {
		return cuentaBancariaR;
	}

	public void setCuentaBancariaR(CuentaBancaria cuentaBancariaR) {
		this.cuentaBancariaR = cuentaBancariaR;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retiro other = (Retiro) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
   
}
