package com.penulisan.ilmiah.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Irman Juliansyah
 */
@Entity
@Table(name = "tb_kebudayaan")
public class Kebudayaan implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idKebudayaan;

    @Column(name = "judulKebudayaan", length = 50)
    private String judulKebudayaan;

    @Column(name = "provinsi", length = 30)
    private String provinsi;

    @Column(name = "kategori", length = 30)
    private String kategori;

    @Column(name = "gambar")
    private String gambar;

    @Lob
    @Column(name = "deskripsi")
    private String deskripsi;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getIdKebudayaan() {
        return idKebudayaan;
    }

    public void setIdKebudayaan(String idKebudayaan) {
        this.idKebudayaan = idKebudayaan;
    }

    public String getJudulKebudayaan() {
        return judulKebudayaan;
    }

    public void setJudulKebudayaan(String judulKebudayaan) {
        this.judulKebudayaan = judulKebudayaan;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

}
