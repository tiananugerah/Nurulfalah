/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.model;

import edu.tianam.nurulalah.db.database.NurulFalahDatabase;
import edu.tianam.nurulalah.db.entity.Santri;
import edu.tianam.nurulalah.db.error.SantriException;
import edu.tianam.nurulalah.db.event.SantriListener;
import edu.tianam.nurulalah.db.service.SantriDao;
import java.sql.SQLException;

/**
 *
 * @author THOSHIBA
 */
public class SantriModel {

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

    private SantriListener listener;

    public SantriListener getListener() {
        return listener;
    }

    public void setListener(SantriListener listener) {
        this.listener = listener;
    }

    public String getNis_lokal() {
        return nis_lokal;
    }

    public void setNis_lokal(String nis_lokal) {
        this.nis_lokal = nis_lokal;
        fireOnChange();
    }

    public String getNama_lengkap_santri() {
        return nama_lengkap_santri;
    }

    public void setNama_lengkap_santri(String nama_lengkap_santri) {
        this.nama_lengkap_santri = nama_lengkap_santri;
        fireOnChange();
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
        fireOnChange();
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
        fireOnChange();
    }

    public String getBln_lahir() {
        return bln_lahir;
    }

    public void setBln_lahir(String bln_lahir) {
        this.bln_lahir = bln_lahir;
        fireOnChange();
    }

    public String getThn_lahir() {
        return thn_lahir;
    }

    public void setThn_lahir(String thn_lahir) {
        this.thn_lahir = thn_lahir;
        fireOnChange();
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
        fireOnChange();
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
        fireOnChange();
    }

    public String getAlamat_santri() {
        return alamat_santri;
    }

    public void setAlamat_santri(String alamat_santri) {
        this.alamat_santri = alamat_santri;
        fireOnChange();
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
        fireOnChange();
    }

    public String getKab_kota() {
        return kab_kota;
    }

    public void setKab_kota(String kab_kota) {
        this.kab_kota = kab_kota;
        fireOnChange();
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Santri santri) {
        if (listener != null) {
            listener.onInsert(santri);
        }

    }

    protected void fireOnUpdate(Santri santri) {
        if (listener != null) {
            listener.onUpdate(santri);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertSantri() throws SQLException, SantriException {

        SantriDao dao = NurulFalahDatabase.getSantriDao();
        Santri santri = new Santri();
        santri.setNis_lokal(nis_lokal);
        santri.setNama_lengkap_santri(nama_lengkap_santri);
        santri.setTempat_lahir(tempat_lahir);
        santri.setTgl_lahir(tgl_lahir);
        santri.setBln_lahir(bln_lahir);
        santri.setThn_lahir(thn_lahir);
        santri.setJenis_kelamin(jenis_kelamin);
        santri.setAgama(agama);
        santri.setAlamat_santri(alamat_santri);
        santri.setKecamatan(kecamatan);
        santri.setKab_kota(kab_kota);
        santri.setProvinsi(provinsi);

        dao.insertSantri(santri);
        fireOnInsert(santri);

    }

    public void updatePelanggan() throws SQLException, SantriException {

        SantriDao dao = NurulFalahDatabase.getSantriDao();
        Santri santri = new Santri();
        santri.setNis_lokal(nis_lokal);
        santri.setNama_lengkap_santri(nama_lengkap_santri);
        santri.setTempat_lahir(tempat_lahir);
        santri.setTgl_lahir(tgl_lahir);
        santri.setBln_lahir(bln_lahir);
        santri.setThn_lahir(thn_lahir);
        santri.setJenis_kelamin(jenis_kelamin);
        santri.setAgama(agama);
        santri.setAlamat_santri(alamat_santri);
        santri.setKecamatan(kecamatan);
        santri.setKab_kota(kab_kota);
        santri.setProvinsi(provinsi);
        dao.updateSantri(santri);
        fireOnInsert(santri);

    }

    public void deletePelanggan() throws SQLException, SantriException {

        SantriDao dao = NurulFalahDatabase.getSantriDao();
        dao.deleteSantri(nis_lokal);
        fireOnDelete();

    }

    public void resetSantri() {
        setNis_lokal("");
        setNama_lengkap_santri("");
        setTempat_lahir("");
        setTgl_lahir("");
        setBln_lahir("");
        setThn_lahir("");
        setJenis_kelamin("");
        setAgama("");
        setAlamat_santri("");
        setKecamatan("");
        setKab_kota("");
        setProvinsi("");
    }

}
