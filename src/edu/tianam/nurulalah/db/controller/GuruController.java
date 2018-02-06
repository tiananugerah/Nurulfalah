/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.controller;

import edu.tianam.nurulalah.db.error.GuruException;
import edu.tianam.nurulalah.db.model.GuruModel;
import edu.tianam.nurulalah.db.model.TabelGuruCari;
import edu.tianam.nurulalah.db.view.MainViewNurulFalah;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author THOSHIBA
 */
public class GuruController {
    private GuruModel model;

    public void setModel(GuruModel model) {
        this.model = model;
    }
    
    public void resetBarang(MainViewNurulFalah view){
        model.resetGuru();
    }
    
    public void insertBarang(MainViewNurulFalah view){
        String nama_guru = view.getjAddNamaGuru().getText();
        String no_ktp_guru = view.getjAddNoKtpGuru().getText();
        String no_kk_guru =view.getjAddNoKkGuru().getText();
        String alamat_lengkap = view.getjAddAlamatLengkap().getText();
        String unir_kerja = view.getjAddUniKerja().getText();
        
        if (nama_guru.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (no_ktp_guru.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode tidak boleh kosong");
        } else if (no_ktp_guru.length()>13){
            JOptionPane.showMessageDialog(view, "Kode tidak boleh melebiki 13 karakter");
        } else if (nama_guru.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh melebihi 255 karekter");
        } else {
            model.setNama_guru(nama_guru);
            model.setNo_ktp_guru(no_ktp_guru);
            model.setNo_kk_guru(no_kk_guru);
            model.setAlamat_lengkap(alamat_lengkap);
            model.setUnit_kerja(unir_kerja);
            try {
                model.insertGuru();
                JOptionPane.showMessageDialog(view, "Data barang berhasil ditambahkan");
                model.resetGuru();
                view.btnAdd();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, "Terjadi eror \n Eror Code "+throwable.getMessage());
            }
        }
    }
    
    public void updateBarang(MainViewNurulFalah view){
        /**if (view.getjTableBarang().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silakan pilih data yang akan di ubah");
            return;
        }*/
        
        String nama_guru = view.getjAddNamaGuru().getText();
        String no_ktp_guru = view.getjAddNoKtpGuru().getText();
        String no_kk_guru =view.getjAddNoKkGuru().getText();
        String alamat_lengkap = view.getjAddAlamatLengkap().getText();
        String unir_kerja = view.getjAddUniKerja().getText();
        
        if (nama_guru.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (no_ktp_guru.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode tidak boleh kosong");
        } else if (no_ktp_guru.length()>13){
            JOptionPane.showMessageDialog(view, "Kode tidak boleh melebiki 13 karakter");
        } else if (no_ktp_guru.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh melebihi 255 karekter");
        } else {
            model.setNama_guru(nama_guru);
            model.setNo_ktp_guru(no_ktp_guru);
            model.setNo_kk_guru(no_kk_guru);
            model.setAlamat_lengkap(alamat_lengkap);
            model.setUnit_kerja(unir_kerja);
            try {
                model.updateGuru();
                JOptionPane.showMessageDialog(view, "Data barang berhasil diubah");
                model.resetGuru();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, "Terjadi eror \n Eror Code "+throwable.getMessage());
            }
        }
    }
    
    public void deleteBarang(MainViewNurulFalah view){
        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus data ini?")==JOptionPane.OK_OPTION) {
            String no_ktp_guru = view.getjDeleteNoKtp().getText();
            model.setNo_ktp_guru(no_ktp_guru);
            
            try {
                model.deleteGuru();
                JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
                model.resetGuru();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, "Terjadi eror \n Eror Code "+throwable.getMessage());
            }
        }
        
    }
    
    public void cariGuru1(MainViewNurulFalah view) throws SQLException, GuruException{
        String nama_guru = view.getCari().getText();
        TabelGuruCari tabelcari = new TabelGuruCari();
        model.cariGuru(nama_guru);
        view.getHasilCari().setModel(tabelcari);
    }
}
