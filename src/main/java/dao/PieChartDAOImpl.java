package dao;

import model.PieChart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Valter on 7/30/2015.
 */
public class PieChartDAOImpl implements PieChartDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(PieChart p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    @Override
    public void save(List<PieChart> list) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (PieChart p : list)
            session.persist(p);
        tx.commit();
        session.close();
    }

    @Override
    public List<PieChart> list() {
        Session session = this.sessionFactory.openSession();
        List<PieChart> list = session.createQuery("from PieChart").list();
        session.close();
        return list;
    }
}
