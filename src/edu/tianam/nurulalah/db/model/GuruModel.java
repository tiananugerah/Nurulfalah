/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.model;

import edu.tianam.nurulalah.db.database.NurulFalahDatabase;
import edu.tianam.nurulalah.db.entity.Guru;
import edu.tianam.nurulalah.db.error.GuruException;
import edu.tianam.nurulalah.db.event.GuruListener;
import edu.tianam.nurulalah.db.service.GuruDao;
import java.sql.SQLException;

/**
 *
 * @author THOSHIBA
 */
public class GuruModel {

    private String nama_guru;
    private String no_ktp_guru;
    private String no_kk_guru;
    private String alamat_lengkap;
    private String unit_kerja;
    private GuruListener listener;

    public GuruListener getListener() {
        return listener;
    }

    public void setListener(GuruListener listener) {
        this.listener = listener;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
        fireOnChange();
    }

    public String getNo_ktp_guru() {
        return no_ktp_guru;
    }

    public void setNo_ktp_guru(String no_ktp_guru) {
        this.no_ktp_guru = no_ktp_guru;
        fireOnChange();
    }

    public String getNo_kk_guru() {
        return no_kk_guru;
    }

    public void setNo_kk_guru(String no_kk_guru) {
        this.no_kk_guru = no_kk_guru;
        fireOnChange();
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
        fireOnChange();
    }

    public String getUnit_kerja() {
        return unit_kerja;
    }

    public void setUnit_kerja(String unit_kerja) {
        this.unit_kerja = unit_kerja;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Guru guru) {
        if (listener != null) {
            listener.onInsert(guru);
        }
    }

    protected void fireOnUpdate(Guru guru) {
        if (listener != null) {
            listener.onUpdate(guru);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertGuru() throws SQLException, GuruException {
        GuruDao dao = NurulFalahDatabase.getGuruDao();

        Guru guru = new Guru();
        guru.setNama_guru(nama_guru);
        guru.setNo_ktp_guru(no_ktp_guru);
        guru.setNo_kk_guru(no_kk_guru);
        guru.setAlamat_lengkap(alamat_lengkap);
        guru.setUnit_kerja(unit_kerja);

        dao.insertGuru(guru);
        fireOnInsert(guru);

    }

    public void updateGuru() throws SQLException, GuruException {
        GuruDao dao = NurulFalahDatabase.getGuruDao();

        Guru guru = new Guru();
        guru.setNama_guru(nama_guru);
        guru.setNo_ktp_guru(no_ktp_guru);
        guru.setNo_kk_guru(no_kk_guru);
        guru.setAlamat_lengkap(alamat_lengkap);
        guru.setUnit_kerja(unit_kerja);

        dao.updateGuru(guru);
        fireOnUpdate(guru);
    }

    public void deleteGuru() throws SQLException, GuruException {

        GuruDao dao = NurulFalahDatabase.getGuruDao();
        dao.deleteGuru(no_ktp_guru);
        fireOnDelete();
    }
    
    public void cariGuru(String nama) throws SQLException,GuruException{
        GuruDao dao = NurulFalahDatabase.getGuruDao();
        Guru guru = new Guru();
        dao.selectCariGuru(nama_guru);
        fireOnInsert(guru);
    }

    public void resetGuru() {
        setNama_guru("");
        setNo_ktp_guru("");
        setNo_kk_guru("");
        setAlamat_lengkap("");
        setUnit_kerja("");

    }
}
