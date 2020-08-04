package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Deposito;

@Stateless
public class DepositoFacade extends AbstractFacade<Deposito> {

	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public DepositoFacade() {
		super(Deposito.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}


}
