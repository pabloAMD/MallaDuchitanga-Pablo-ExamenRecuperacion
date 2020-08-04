package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Deposito
 *
 */
@Entity

public class Deposito implements Serializable {

	
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
	private CuentaBancaria cuentaBancariaD;

	public Deposito() {
		super();
	}

	public Deposito(String fecha, String hora, String descripcion, double montoTotal,
			CuentaBancaria cuentaBancariaD) {
		super();
		
		this.fecha = fecha;
		this.hora = hora;
		this.descripcion = descripcion;
		this.montoTotal = montoTotal;
		this.cuentaBancariaD = cuentaBancariaD;
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

	public CuentaBancaria getCuentaBancariaD() {
		return cuentaBancariaD;
	}

	public void setCuentaBancariaD(CuentaBancaria cuentaBancariaD) {
		this.cuentaBancariaD = cuentaBancariaD;
	}
	
	
   
}
