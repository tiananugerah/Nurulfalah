/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.impl;

import edu.tianam.nurulalah.db.entity.Guru;
import edu.tianam.nurulalah.db.error.GuruException;
import edu.tianam.nurulalah.db.service.GuruDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THOSHIBA
 */
public class GuruDaoImpl implements GuruDao {

    private Connection connection;
    private final String insertGuru = "INSERT INTO TABLE_GURU (NAMA_GURU,NO_KTP_GURU,NO_KK_GURU,ALAMAT_LENGKAP,UNIT_KERJA) VALUES (?,?,?,?,?)";

    private final String updateGuru = "UPDATE TABLE_GURU SET NAMA_GURU=?,NO_KK_GURU=?,ALAMAT_LENGKAP=?,UNIT_KERJA=? WHERE NO_KTP_GURU=?";

    private final String deleteGuru = "DELETE FROM TABLE_GURU WHERE NO_KP_GURU=?";

    private final String getNo_ktp_guru = "SELECT * FROM TABLE_GURU WHERE NO_KP_GURU = ?";

    private final String selectAll = "SELECT * FROM TABLE_GURU";

    private final String cariGuru = "SELECT * FROM TABLE_GURU WHERE NAMA_GURU=?";

    public GuruDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertGuru(Guru guru) throws GuruException {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertGuru);
            statement.setString(1, guru.getNama_guru());
            statement.setString(2, guru.getNo_ktp_guru());
            statement.setString(3, guru.getNo_kk_guru());
            statement.setString(4, guru.getAlamat_lengkap());
            statement.setString(5, guru.getUnit_kerja());

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new GuruException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void updateGuru(Guru guru) throws GuruException {
        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateGuru);
            statement = connection.prepareStatement(insertGuru, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, guru.getNama_guru());
            statement.setString(2, guru.getNo_ktp_guru());
            statement.setString(3, guru.getNo_kk_guru());
            statement.setString(4, guru.getAlamat_lengkap());
            statement.setString(5, guru.getUnit_kerja());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new GuruException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void deleteGuru(String no_ktp_guru) throws GuruException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteGuru);
            statement.setString(1, no_ktp_guru);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new GuruException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Guru getGuruGuru(String no_ktp_guru) throws GuruException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getNo_ktp_guru);
            statement.setString(1, no_ktp_guru);

            ResultSet result = statement.executeQuery();
            Guru guru = null;
            if (result.next()) {
                guru = new Guru();
                guru.setNama_guru(result.getString("NAMA_GURU"));
                guru.setNo_ktp_guru(result.getString("NO_KTP_GURU"));
                guru.setNo_kk_guru(result.getString("NO_KK_GURU"));
                guru.setAlamat_lengkap(result.getString("ALAMAT_LENGKAP"));
                guru.setUnit_kerja(result.getString("UNIT_KERJA"));
            } else {
                throw new GuruException("Pelanggan dengan Nomor Ktp " + no_ktp_guru + " tidak ditemukan");
            }
            connection.commit();
            return guru;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new GuruException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Guru> selectAllGuru() throws GuruException {

        Statement statement = null;
        List<Guru> list = new ArrayList<Guru>();
        try {

            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(cariGuru);
            while (result.next()) {
                Guru guru = new Guru();
                guru.setNama_guru(result.getString("NAMA_GURU"));
                guru.setNo_ktp_guru(result.getString("NO_KTP_GURU"));
                guru.setNo_kk_guru(result.getString("NO_KK_GURU"));
                guru.setAlamat_lengkap(result.getString("ALAMAT_LENGKAP"));
                guru.setUnit_kerja(result.getString("UNIT_KERJA"));
                list.add(guru);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new GuruException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    @Override
    public List<Guru> selectCariGuru(String nama_guru) throws GuruException {
        Statement statement = null;
        List<Guru> list = new ArrayList<Guru>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(cariGuru);
            while (result.next()) {
                Guru guru = new Guru();
                guru.setNama_guru(result.getString("NAMA_GURU"));
                guru.setNo_ktp_guru(result.getString("NO_KTP_GURU"));
                guru.setNo_kk_guru(result.getString("NO_KK_GURU"));
                guru.setAlamat_lengkap(result.getString("ALAMAT_LENGKAP"));
                guru.setUnit_kerja(result.getString("UNIT_KERJA"));
                list.add(guru);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new GuruException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }

        }
    }

    @Override
    public Guru getCari(String cari) throws GuruException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(cariGuru);
            statement.setString(1, cari);

            ResultSet result = statement.executeQuery();
            Guru guru = null;
            if (result.next()) {
                guru = new Guru();
                guru.setNama_guru(result.getString("NAMA_GURU"));
                guru.setNo_ktp_guru(result.getString("NO_KTP_GURU"));
                guru.setNo_kk_guru(result.getString("NO_KK_GURU"));
                guru.setAlamat_lengkap(result.getString("ALAMAT_LENGKAP"));
                guru.setUnit_kerja(result.getString("UNIT_KERJA"));
            } else {
                throw new GuruException("Nama  dengan No ktp " + cari + " tidak ditemukan");
            }
            connection.commit();
            return guru;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new GuruException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
