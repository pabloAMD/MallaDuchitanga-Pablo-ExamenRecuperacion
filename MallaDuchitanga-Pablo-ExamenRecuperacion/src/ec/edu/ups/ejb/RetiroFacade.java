package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Retiro;


@Stateless
public class RetiroFacade extends AbstractFacade<Retiro> {

	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public RetiroFacade() {
		super(Retiro.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
