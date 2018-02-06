/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.main;

import edu.tianam.nurulalah.db.database.NurulFalahDatabase;
import edu.tianam.nurulalah.db.entity.Guru;
import edu.tianam.nurulalah.db.entity.Santri;
import edu.tianam.nurulalah.db.error.GuruException;
import edu.tianam.nurulalah.db.error.SantriException;
import edu.tianam.nurulalah.db.service.GuruDao;
import edu.tianam.nurulalah.db.service.SantriDao;
import edu.tianam.nurulalah.db.view.MainViewNurulFalah;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author TOSHIBA NIM : 10116473 NAMA : Tian Anugerah Mulyana KELAS : PBO11
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, GuruException {
        // TODO code application logic here        SwingUtilities.invokeLater(new Runnable() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewNurulFalah guru = new MainViewNurulFalah();
                    guru.loadDatabase();
                    guru.setVisible(true);
                } catch (SQLException e) {
                } catch (GuruException ex) {
                    Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
