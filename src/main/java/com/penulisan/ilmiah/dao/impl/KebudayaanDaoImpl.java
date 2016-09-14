package com.penulisan.ilmiah.dao.impl;

import com.penulisan.ilmiah.dao.KebudayaanDao;
import com.penulisan.ilmiah.domain.Kebudayaan;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Irman Juliansyah
 */

@Repository
public class KebudayaanDaoImpl implements KebudayaanDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Kebudayaan kebudayaan) {
        sessionFactory.getCurrentSession().save(kebudayaan);
    }

    @Override
    public void update(Kebudayaan kebudayaan) {
        sessionFactory.getCurrentSession().update(kebudayaan);
    }

    @Override
    public void delete(Kebudayaan kebudayaan) {
        sessionFactory.getCurrentSession().delete(kebudayaan);
    }

    @Override
    public Kebudayaan getKebudayaan(String idKebudayaan) {
        return sessionFactory.getCurrentSession().get(Kebudayaan.class, idKebudayaan);
    }

    @Override
    public List<Kebudayaan> getKebudayaans() {
        return sessionFactory.getCurrentSession().createCriteria(Kebudayaan.class).list();
    }

}
