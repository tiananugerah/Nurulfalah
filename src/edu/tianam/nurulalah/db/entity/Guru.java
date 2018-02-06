/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.entity;

import java.util.Objects;

/**
 *
 * @author THOSHIBA
 */
public class Guru {

    private String nama_guru;
    private String no_ktp_guru;
    private String no_kk_guru;
    private String alamat_lengkap;
    private String unit_kerja;

    public Guru() {
    }

    public Guru(String nama_guru, String no_ktp_guru, String no_kk_guru, String alamat_lengkap, String unit_kerja) {
        this.nama_guru = nama_guru;
        this.no_ktp_guru = no_ktp_guru;
        this.no_kk_guru = no_kk_guru;
        this.alamat_lengkap = alamat_lengkap;
        this.unit_kerja = unit_kerja;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getNo_ktp_guru() {
        return no_ktp_guru;
    }

    public void setNo_ktp_guru(String no_ktp_guru) {
        this.no_ktp_guru = no_ktp_guru;
    }

    public String getNo_kk_guru() {
        return no_kk_guru;
    }

    public void setNo_kk_guru(String no_kk_guru) {
        this.no_kk_guru = no_kk_guru;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getUnit_kerja() {
        return unit_kerja;
    }

    public void setUnit_kerja(String unit_kerja) {
        this.unit_kerja = unit_kerja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nama_guru);
        hash = 59 * hash + Objects.hashCode(this.no_ktp_guru);
        hash = 59 * hash + Objects.hashCode(this.no_kk_guru);
        hash = 59 * hash + Objects.hashCode(this.alamat_lengkap);
        hash = 59 * hash + Objects.hashCode(this.unit_kerja);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Guru other = (Guru) obj;
        if (!Objects.equals(this.nama_guru, other.nama_guru)) {
            return false;
        }
        if (!Objects.equals(this.no_ktp_guru, other.no_ktp_guru)) {
            return false;
        }
        if (!Objects.equals(this.no_kk_guru, other.no_kk_guru)) {
            return false;
        }
        if (!Objects.equals(this.alamat_lengkap, other.alamat_lengkap)) {
            return false;
        }
        if (!Objects.equals(this.unit_kerja, other.unit_kerja)) {
            return false;
        }
        return true;
    }

}
