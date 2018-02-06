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
public class Santri {

    private String nis_lokal;
    private String nama_lengkap_santri;
    private String tempat_lahir;
    private String tgl_lahir;
    private String bln_lahir;
    private String thn_lahir;
    private String jenis_kelamin;
    private String agama;
    private String alamat_santri;
    private String kecamatan;
    private String kab_kota;
    private String provinsi;

    public Santri() {

    }

    public Santri(String nis_lokal, String nama_lengkap_santri, String tempat_lahir, String tgl_lahir, String bln_lahir, String thn_lahir, String jenis_kelamin, String agama, String alamat_santri, String kecamatan, String kab_kota, String provinsi) {
        this.nis_lokal = nis_lokal;
        this.nama_lengkap_santri = nama_lengkap_santri;
        this.tempat_lahir = tempat_lahir;
        this.tgl_lahir = tgl_lahir;
        this.bln_lahir = bln_lahir;
        this.thn_lahir = thn_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.agama = agama;
        this.alamat_santri = alamat_santri;
        this.kecamatan = kecamatan;
        this.kab_kota = kab_kota;
        this.provinsi = provinsi;
    }

    public String getNis_lokal() {
        return nis_lokal;
    }

    public void setNis_lokal(String nis_lokal) {
        this.nis_lokal = nis_lokal;
    }

    public String getNama_lengkap_santri() {
        return nama_lengkap_santri;
    }

    public void setNama_lengkap_santri(String nama_lengkap_santri) {
        this.nama_lengkap_santri = nama_lengkap_santri;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getBln_lahir() {
        return bln_lahir;
    }

    public void setBln_lahir(String bln_lahir) {
        this.bln_lahir = bln_lahir;
    }

    public String getThn_lahir() {
        return thn_lahir;
    }

    public void setThn_lahir(String thn_lahir) {
        this.thn_lahir = thn_lahir;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat_santri() {
        return alamat_santri;
    }

    public void setAlamat_santri(String alamat_santri) {
        this.alamat_santri = alamat_santri;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKab_kota() {
        return kab_kota;
    }

    public void setKab_kota(String kab_kota) {
        this.kab_kota = kab_kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nis_lokal);
        hash = 97 * hash + Objects.hashCode(this.nama_lengkap_santri);
        hash = 97 * hash + Objects.hashCode(this.tempat_lahir);
        hash = 97 * hash + Objects.hashCode(this.tgl_lahir);
        hash = 97 * hash + Objects.hashCode(this.bln_lahir);
        hash = 97 * hash + Objects.hashCode(this.thn_lahir);
        hash = 97 * hash + Objects.hashCode(this.jenis_kelamin);
        hash = 97 * hash + Objects.hashCode(this.agama);
        hash = 97 * hash + Objects.hashCode(this.alamat_santri);
        hash = 97 * hash + Objects.hashCode(this.kecamatan);
        hash = 97 * hash + Objects.hashCode(this.kab_kota);
        hash = 97 * hash + Objects.hashCode(this.provinsi);
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
        final Santri other = (Santri) obj;
        if (!Objects.equals(this.nis_lokal, other.nis_lokal)) {
            return false;
        }
        if (!Objects.equals(this.nama_lengkap_santri, other.nama_lengkap_santri)) {
            return false;
        }
        if (!Objects.equals(this.tempat_lahir, other.tempat_lahir)) {
            return false;
        }
        if (!Objects.equals(this.tgl_lahir, other.tgl_lahir)) {
            return false;
        }
        if (!Objects.equals(this.bln_lahir, other.bln_lahir)) {
            return false;
        }
        if (!Objects.equals(this.thn_lahir, other.thn_lahir)) {
            return false;
        }
        if (!Objects.equals(this.jenis_kelamin, other.jenis_kelamin)) {
            return false;
        }
        if (!Objects.equals(this.agama, other.agama)) {
            return false;
        }
        if (!Objects.equals(this.alamat_santri, other.alamat_santri)) {
            return false;
        }
        if (!Objects.equals(this.kecamatan, other.kecamatan)) {
            return false;
        }
        if (!Objects.equals(this.kab_kota, other.kab_kota)) {
            return false;
        }
        if (!Objects.equals(this.provinsi, other.provinsi)) {
            return false;
        }
        return true;
    }

   
}
