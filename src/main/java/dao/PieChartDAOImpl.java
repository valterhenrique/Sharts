package dao;

import model.PieChart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Author: Valter
 */
public class PieChartDAOImpl implements PieChartDAO
{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(PieChart p)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@Override
	public void save(List<PieChart> list)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		list.forEach(session::persist);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PieChart> list()
	{
		Session session = this.sessionFactory.openSession();
		List list = session.createQuery("from PieChart").list();
		session.close();
		return list;
	}
}
