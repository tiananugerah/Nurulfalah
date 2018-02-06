/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.service;

import edu.tianam.nurulalah.db.entity.Santri;
import edu.tianam.nurulalah.db.error.SantriException;
import java.util.List;

/**
 *
 * @author THOSHIBA
 */
public interface SantriDao {

    public void insertSantri(Santri santri) throws SantriException;

    public void updateSantri(Santri santri) throws SantriException;

    public void deleteSantri(String nis_lokal) throws SantriException;

    public Santri getSantri(String nis_lokal) throws SantriException;

    public List<Santri> selectAllSantri() throws SantriException;


}
