package com.penulisan.ilmiah.dao;

import com.penulisan.ilmiah.domain.Kebudayaan;

import java.util.List;

/**
 * @author Irman Juliansyah
 */
public interface KebudayaanDao {

    void save(Kebudayaan kebudayaan);

    void update(Kebudayaan kebudayaan);

    void delete(Kebudayaan kebudayaan);

    Kebudayaan getKebudayaan(String idKebudayaan);

    List<Kebudayaan> getKebudayaans();
}
