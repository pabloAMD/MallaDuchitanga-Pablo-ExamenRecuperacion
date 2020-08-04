package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.CuentaBancaria;


@Stateless
public class CuentaBancariaFacade extends AbstractFacade<CuentaBancaria> {

	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public CuentaBancariaFacade() {
		super(CuentaBancaria.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public CuentaBancaria readCuentaBancaria(String cedula) {
		Query query = em.createNamedQuery("getByCuentaBancaria");
		query.setParameter("cedula", cedula);
		List result = query.getResultList();
		CuentaBancaria respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (CuentaBancaria)result.get(0);
		}
		return respuesta;
	}

}
