/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.impl;

import edu.tianam.nurulalah.db.entity.Santri;
import edu.tianam.nurulalah.db.error.SantriException;
import edu.tianam.nurulalah.db.service.SantriDao;
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
public class SantriDaoImpl implements SantriDao {

    private Connection connection;

    private final String insertSantri = "INSERT INTO TABLE_SANTRI (NIS_LOKALT,NAMA_LENGKAP_SANTRI,TEMPAT_LAHIR,TGL_LAHIR,BLN_LAHIR,THN_LAHIR,JENIS_KELAMIN,AGAMA,ALAMAT_SANTRI,KECAMATAN,KAB_KOTA,PROVINSI) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String updateSantri = "DELETE FROM TABLE_SANTRI WHERE UPDATE TABLE_SANTRI SET NSDT=?,NIS_LOKAL=?,NISN=?,NIK_PASSPORT=?,NAMA_LENGKAP_SANTRI=?,TEMPAT_LAHIR=?,TGL_LAHIR=?,BLN_LAHIR=?,THN_LAHIR=?,JENIS_KELAMIN=?,AGAMA=?,KEWARGANEGARAAN=?,NO_TELEPON=?,NO_HP=?,TUNA_RUNGU=?,TUNA_NETRA=?,TUNA_DAKSA=?,TUNA_GRAHITA=?,TUNA_LARAS=?,LAMBAN_BELAJAR=?,SULIT_BELAJAR=?,GANGGUAN_BELAJAR=?,BAKAT_LUAR_BIASA=?,TGL_MASUK=?,BLN_MASUK=?,THN_MASUK=?,STATUS_SANTRI=?,JENIS_PENDIDIKAN=?,JENJANG_PENDIDIKAN=?,TINGKAT_KELAS=?,JENIS_PEKERJAAN_SANTRI=?,PENGHASILAN_PERBULAN_SANTRI=?,JENIS_PENDIDIKAN_TERAKHIR=?,JENJANG_PENDIDIKAN_AKHIR=?,TAHUN_LULUS_AKHIR=?,STATUS_IJAZAH_AKHIR=?,JENIS_TEMPAT_TINGGAL_SANTRI=?,ALAMAT_SANTRI=?,KECAMATAN=?,KAB_KOTA=?,PROVINSI=?,NOMOR_KK=?,NAMA_KEPALA_KELUARGA_DALAM_KK=?,STATUS_KEPALA_KELUARGA_DALAM_KK=?,NOMR_KKS_KPS=?,NOMOR_KARTU_PKH=?,BIDANG_PRESTASI_SANTRI=?,TINGKAT_PRESTASI_SANTRI=?,PERINGKAT_YANG_DIRAIH_SANTRI=?,TAHUN_MERAIH_PRESTASI_SANTRI=?,NAMA_LENGKAP_AYAH=?,STATUS_HIDUP_AYAH=?,NIK_NOMOR_KTP_AYAH=?,PENDIDIKAN_AYAH=?,PEKERJAAN_AYAH=?,NAMA_LENGKEAP_IBU=?,STATUS_HIDUP_IBU=?,NIK_NOMOR_KTP_IBU=?,PENDIDIKAN_IBU=?,PEKERJAAN_IBU=?,NAMA_LENGKAP_WALI_SANTRI=?,HUBUNGAN_WALI_SANTRI=?,NIK_NOMOR_KTP_WALI_SANTRI=?,PENDIDIKAN_WALI_SANTRI=?,PEKERJAAN_WALI_SANTRI=?,PENGHASILAN_ORANGTUA_WALI_SANTRI=?";

    private final String deleteSantri = "DELETE FROM TABLE_SANTRI WHERE NIS_LOKAL=?";

    private final String getByNis_Lokal = "SELECT * FROM TABLE_SANTRI WHERE NIS_LOKAL=?";

    private final String selectAll = "SELECT * FROM TABLE_SANTRI";

    public SantriDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertSantri(Santri santri) throws SantriException {
        PreparedStatement Statement = null;
        try {
            connection.setAutoCommit(false);
            Statement = connection.prepareStatement(insertSantri, Statement.RETURN_GENERATED_KEYS);
            Statement.setString(1, santri.getNis_lokal());
            Statement.setString(2, santri.getNama_lengkap_santri());
            Statement.setString(3, santri.getTempat_lahir());
            Statement.setString(4, santri.getTgl_lahir());
            Statement.setString(5, santri.getBln_lahir());
            Statement.setString(6, santri.getThn_lahir());
            Statement.setString(7, santri.getJenis_kelamin());
            Statement.setString(8, santri.getAgama());
            Statement.setString(9, santri.getAlamat_santri());
            Statement.setString(10, santri.getKecamatan());
            Statement.setString(11, santri.getKab_kota());
            Statement.setString(12, santri.getProvinsi());
            Statement.executeUpdate();

            ResultSet result = Statement.getGeneratedKeys();
            if (result.next()) {
                santri.setNis_lokal(result.getString(1));
            }

            connection.commit();

        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SantriException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (Statement != null) {
                try {
                    Statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void updateSantri(Santri santri) throws SantriException {
        PreparedStatement Statement = null;
        try {
            connection.setAutoCommit(false);
            Statement = connection.prepareStatement(updateSantri);
            Statement.setString(1, santri.getNis_lokal());
            Statement.setString(2, santri.getNama_lengkap_santri());
            Statement.setString(3, santri.getTempat_lahir());
            Statement.setString(4, santri.getTgl_lahir());
            Statement.setString(5, santri.getBln_lahir());
            Statement.setString(6, santri.getThn_lahir());
            Statement.setString(7, santri.getJenis_kelamin());
            Statement.setString(8, santri.getAgama());
            Statement.setString(9, santri.getAlamat_santri());
            Statement.setString(10, santri.getKecamatan());
            Statement.setString(11, santri.getKab_kota());
            Statement.setString(12, santri.getProvinsi());
            Statement.executeUpdate();

            ResultSet result = Statement.getGeneratedKeys();
            if (result.next()) {
                santri.setNis_lokal(result.getString(1));
            }

            connection.commit();

        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SantriException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (Statement != null) {
                try {
                    Statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void deleteSantri(String nis_lokal) throws SantriException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(deleteSantri);
            statement.setString(1, nis_lokal);
            statement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SantriException(e.getMessage());
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
    public Santri getSantri(String nis_lokal) throws SantriException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(getByNis_Lokal);
            statement.setString(1, nis_lokal);

            ResultSet result = statement.executeQuery();
            Santri santri = null;

            if (result.next()) {
                santri = new Santri();
                santri.setNis_lokal(result.getString("NISA_LOKAL"));
                santri.setNama_lengkap_santri(result.getString("NAMA_LENGKAP_SANTRI"));
                santri.setTempat_lahir(result.getString("TEMPAT_LAHIR"));
                santri.setTgl_lahir(result.getString("TGL_LAHIR"));
                santri.setBln_lahir(result.getString("BLN_LAHIR"));
                santri.setThn_lahir(result.getString("THN_LAHIR"));
                santri.setJenis_kelamin(result.getString("JENIS_KELAMIN"));
                santri.setAgama(result.getString("AGAMA"));
                santri.setAlamat_santri(result.getString("ALAMAT_SANTRI"));
                santri.setKecamatan(result.getString("KECAMATAN"));
                santri.setKab_kota(result.getString("KAB_KOTA"));
                santri.setProvinsi(result.getString("PROVINSI"));
            } else {
                throw new SantriException("Pelanggan dengan NIS" + nis_lokal + "tidak ditemukan");
            }
            connection.commit();
            return santri;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SantriException(e.getMessage());
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
    public List<Santri> selectAllSantri() throws SantriException {
        Statement statement = null;
        List<Santri> list = new ArrayList<Santri>();
        try {
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Santri santri = null;

            if (result.next()) {
                santri = new Santri();
                santri.setNis_lokal(result.getString("NISA_LOKAL"));
                santri.setNama_lengkap_santri(result.getString("NAMA_LENGKAP_SANTRI"));
                santri.setTempat_lahir(result.getString("TEMPAT_LAHIR"));
                santri.setTgl_lahir(result.getString("TGL_LAHIR"));
                santri.setBln_lahir(result.getString("BLN_LAHIR"));
                santri.setThn_lahir(result.getString("THN_LAHIR"));
                santri.setJenis_kelamin(result.getString("JENIS_KELAMIN"));
                santri.setAgama(result.getString("AGAMA"));
                santri.setAlamat_santri(result.getString("ALAMAT_SANTRI"));
                santri.setKecamatan(result.getString("KECAMATAN"));
                santri.setKab_kota(result.getString("KAB_KOTA"));
                santri.setProvinsi(result.getString("PROVINSI"));

                list.add(santri);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SantriException(e.getMessage());
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
