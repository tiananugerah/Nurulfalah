/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.service;

import edu.tianam.nurulalah.db.entity.Guru;
import edu.tianam.nurulalah.db.error.GuruException;
import java.util.List;

/**
 *
 * @author THOSHIBA
 */
public interface GuruDao {

    public void insertGuru(Guru guru) throws GuruException;

    public void updateGuru(Guru guru) throws GuruException;

    public void deleteGuru(String no_ktp_guru) throws GuruException;

    public Guru getGuruGuru(String no_ktp_guru) throws GuruException;

    public Guru getCari(String cari) throws GuruException;

    public List<Guru> selectAllGuru() throws GuruException;

    public List<Guru> selectCariGuru(String nama_guru) throws GuruException;

}
