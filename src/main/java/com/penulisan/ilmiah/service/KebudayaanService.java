package com.penulisan.ilmiah.service;

import com.penulisan.ilmiah.domain.Kebudayaan;

import java.util.List;

/**
 * @author Irman Juliansyah
 */
public interface KebudayaanService {

    void save(Kebudayaan kebudayaan);

    void update(Kebudayaan kebudayaan);

    void delete(Kebudayaan kebudayaan);

    Kebudayaan getKebudayaan(String idKebudayaan);

    List<Kebudayaan> getKebudayaans();

}
