package com.penulisan.ilmiah.service.impl;

import com.penulisan.ilmiah.dao.KebudayaanDao;
import com.penulisan.ilmiah.domain.Kebudayaan;
import com.penulisan.ilmiah.service.KebudayaanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Irman Juliansyah
 */
@Service
@Transactional(readOnly = true)
public class KebudayaanServiceImpl implements KebudayaanService {

    @Autowired
    private KebudayaanDao kebudayaanDao;

    @Transactional
    @Override
    public void save(Kebudayaan kebudayaan) {
        kebudayaanDao.save(kebudayaan);
    }

    @Transactional
    @Override
    public void update(Kebudayaan kebudayaan) {
        kebudayaanDao.update(kebudayaan);
    }

    @Transactional
    @Override
    public void delete(Kebudayaan kebudayaan) {
        kebudayaanDao.delete(kebudayaan);
    }

    @Override
    public Kebudayaan getKebudayaan(String idKebudayaan) {
        return kebudayaanDao.getKebudayaan(idKebudayaan);
    }

    @Override
    public List<Kebudayaan> getKebudayaans() {
        return kebudayaanDao.getKebudayaans();
    }

}
