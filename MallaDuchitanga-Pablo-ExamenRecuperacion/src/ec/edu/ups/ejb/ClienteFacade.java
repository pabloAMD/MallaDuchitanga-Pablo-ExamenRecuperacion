package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Cliente;


@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
	
	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;

	public ClienteFacade() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Cliente readCliente(String cedula) {
		Query query = em.createNamedQuery("getByCliente");
		query.setParameter("cedula", cedula);
		List result = query.getResultList();
		Cliente respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Cliente)result.get(0);
		}
		return respuesta;
	}

}
