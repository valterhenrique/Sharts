package dao;

import model.RingChart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Author: Valter
 */
public class RingChartDAOImpl implements RingChartDAO
{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(RingChart ringChart)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(ringChart);
		tx.commit();
		session.close();
	}

	@Override
	public void save(List<RingChart> ringChartList)
	{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ringChartList.forEach(session::persist);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RingChart> list()
	{
		Session session = this.sessionFactory.openSession();
		List list = session.createQuery("from RingChart").list();
		session.close();
		return list;
	}
}
