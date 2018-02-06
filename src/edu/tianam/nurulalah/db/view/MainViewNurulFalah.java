/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.view;

import edu.tianam.nurulalah.db.controller.GuruController;
import edu.tianam.nurulalah.db.database.NurulFalahDatabase;
import edu.tianam.nurulalah.db.entity.Guru;
import edu.tianam.nurulalah.db.error.GuruException;
import edu.tianam.nurulalah.db.event.GuruListener;
import edu.tianam.nurulalah.db.model.GuruModel;
import edu.tianam.nurulalah.db.model.TabelGuruCari;
import edu.tianam.nurulalah.db.model.TabelGuruModel;
import edu.tianam.nurulalah.db.service.GuruDao;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author IDC
 */
public class MainViewNurulFalah extends javax.swing.JFrame implements GuruListener, ListSelectionListener {

    /**
     * Creates new form MainViewShop
     */
    private TabelGuruModel tabelModel;
    private TabelGuruCari tabelCari;
    private GuruModel model;
    private GuruController controller;
    private TableModel tmodel;
    private String cari2;
    private String username;
    private String pass;

    public MainViewNurulFalah() {
        tabelModel = new TabelGuruModel();
        tabelCari = new TabelGuruCari();
        tmodel = new DefaultTableModel();

        model = new GuruModel();
        model.setListener(this);

        controller = new GuruController();
        controller.setModel(model);

        initComponents();
        jTableGuru.getSelectionModel().addListSelectionListener((ListSelectionListener) this);
        jTableGuru.setModel(tabelModel);
        hasilCari.setModel(tabelCari);

        panelRegister.setVisible(false);
        panelMenu.setVisible(false);
        menuLeft.setVisible(false);
        menuTop.setVisible(false);
        menuCount.setVisible(false);
        menuEdit.setVisible(false);
        menuShow.setVisible(false);
        menuGuru.setVisible(true);
    }

    String cariGuru;
    String unitKerja;

    public String getUnitKerja() {
        return unitKerja;
    }

    public void setUnitKerja(String unitKerja) {
        this.unitKerja = unitKerja;
    }

    public TabelGuruModel getTabelModel() {
        return tabelModel;
    }

    public void setTabelModel(TabelGuruModel tabelModel) {
        this.tabelModel = tabelModel;
    }

    public TabelGuruCari getTabelCari() {
        return tabelCari;
    }

    public void setTabelCari(TabelGuruCari tabelCari) {
        this.tabelCari = tabelCari;
    }

    public GuruModel getModel() {
        return model;
    }

    public void setModel(GuruModel model) {
        this.model = model;
    }

    public GuruController getController() {
        return controller;
    }

    public void setController(GuruController controller) {
        this.controller = controller;
    }

    public TableModel getTmodel() {
        return tmodel;
    }

    public void setTmodel(TableModel tmodel) {
        this.tmodel = tmodel;
    }

    public String getCari2() {
        return cari2;
    }

    public void setCari2(String cari2) {
        this.cari2 = cari2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Color getHitam() {
        return hitam;
    }

    public void setHitam(Color hitam) {
        this.hitam = hitam;
    }

    public Color getHitam2() {
        return hitam2;
    }

    public void setHitam2(Color hitam2) {
        this.hitam2 = hitam2;
    }

    public Color getAbu() {
        return abu;
    }

    public void setAbu(Color abu) {
        this.abu = abu;
    }

    public String getCariGuru() {
        return cariGuru;
    }

    public void setCariGuru(String cariGuru) {
        this.cariGuru = cariGuru;
    }


    public JPanel getDeleteData() {
        return DeleteData;
    }

    public void setDeleteData(JPanel DeleteData) {
        this.DeleteData = DeleteData;
    }

    public JPanel getBtnAddData() {
        return btnAddData;
    }

    public void setBtnAddData(JPanel btnAddData) {
        this.btnAddData = btnAddData;
    }

    public JPanel getBtnAddData1() {
        return btnAddData1;
    }

    public void setBtnAddData1(JPanel btnAddData1) {
        this.btnAddData1 = btnAddData1;
    }

    public JPanel getBtnAddGuru() {
        return btnAddGuru;
    }

    public void setBtnAddGuru(JPanel btnAddGuru) {
        this.btnAddGuru = btnAddGuru;
    }

    public JPanel getBtnDeleteBarang() {
        return btnDeleteBarang;
    }

    public void setBtnDeleteBarang(JPanel btnDeleteBarang) {
        this.btnDeleteBarang = btnDeleteBarang;
    }

    public JPanel getBtnDeleteData() {
        return btnDeleteData;
    }

    public void setBtnDeleteData(JPanel btnDeleteData) {
        this.btnDeleteData = btnDeleteData;
    }

    public JPanel getBtnDeleteData1() {
        return btnDeleteData1;
    }

    public void setBtnDeleteData1(JPanel btnDeleteData1) {
        this.btnDeleteData1 = btnDeleteData1;
    }

    public JPanel getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JPanel btnExit) {
        this.btnExit = btnExit;
    }

    public JPanel getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JPanel btnLogin) {
        this.btnLogin = btnLogin;
    }

    public JLabel getBtnLogin2() {
        return btnLogin2;
    }

    public void setBtnLogin2(JLabel btnLogin2) {
        this.btnLogin2 = btnLogin2;
    }

    public JPanel getBtnMenuCounting() {
        return btnMenuCounting;
    }

    public void setBtnMenuCounting(JPanel btnMenuCounting) {
        this.btnMenuCounting = btnMenuCounting;
    }

    public JPanel getBtnMenuEasy() {
        return btnMenuEasy;
    }

    public void setBtnMenuEasy(JPanel btnMenuEasy) {
        this.btnMenuEasy = btnMenuEasy;
    }

    public JPanel getBtnMenuEdit() {
        return btnMenuEdit;
    }

    public void setBtnMenuEdit(JPanel btnMenuEdit) {
        this.btnMenuEdit = btnMenuEdit;
    }

    public JPanel getBtnMenuShow() {
        return btnMenuShow;
    }

    public void setBtnMenuShow(JPanel btnMenuShow) {
        this.btnMenuShow = btnMenuShow;
    }

    public JPanel getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(JPanel btnRegister) {
        this.btnRegister = btnRegister;
    }

    public JLabel getBtnRegister2() {
        return btnRegister2;
    }

    public void setBtnRegister2(JLabel btnRegister2) {
        this.btnRegister2 = btnRegister2;
    }

    public JPanel getBtnResetGuru() {
        return btnResetGuru;
    }

    public void setBtnResetGuru(JPanel btnResetGuru) {
        this.btnResetGuru = btnResetGuru;
    }

    public JPanel getBtnUpdateBarang() {
        return btnUpdateBarang;
    }

    public void setBtnUpdateBarang(JPanel btnUpdateBarang) {
        this.btnUpdateBarang = btnUpdateBarang;
    }

    public JPanel getBtnUpdateData() {
        return btnUpdateData;
    }

    public void setBtnUpdateData(JPanel btnUpdateData) {
        this.btnUpdateData = btnUpdateData;
    }

    public JPanel getBtnUpdateData1() {
        return btnUpdateData1;
    }

    public void setBtnUpdateData1(JPanel btnUpdateData1) {
        this.btnUpdateData1 = btnUpdateData1;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JTextField getCari() {
        return cari;
    }

    public void setCari(JTextField cari) {
        this.cari = cari;
    }

    public JTable getHasilCari() {
        return hasilCari;
    }

    public void setHasilCari(JTable hasilCari) {
        this.hasilCari = hasilCari;
    }

    public JTextField getjAddAlamatLengkap() {
        return jAddAlamatLengkap;
    }

    public void setjAddAlamatLengkap(JTextField jAddAlamatLengkap) {
        this.jAddAlamatLengkap = jAddAlamatLengkap;
    }

    public JTextField getjAddNamaGuru() {
        return jAddNamaGuru;
    }

    public void setjAddNamaGuru(JTextField jAddNamaGuru) {
        this.jAddNamaGuru = jAddNamaGuru;
    }

    public JTextField getjAddNoKkGuru() {
        return jAddNoKkGuru;
    }

    public void setjAddNoKkGuru(JTextField jAddNoKkGuru) {
        this.jAddNoKkGuru = jAddNoKkGuru;
    }

    public JTextField getjAddNoKtpGuru() {
        return jAddNoKtpGuru;
    }

    public void setjAddNoKtpGuru(JTextField jAddNoKtpGuru) {
        this.jAddNoKtpGuru = jAddNoKtpGuru;
    }

    public JTextField getjAddUniKerja() {
        return jAddUniKerja;
    }

    public void setjAddUniKerja(JTextField jAddUniKerja) {
        this.jAddUniKerja = jAddUniKerja;
    }

    public JPanel getjAddUnitKerja() {
        return jAddUnitKerja;
    }

    public void setjAddUnitKerja(JPanel jAddUnitKerja) {
        this.jAddUnitKerja = jAddUnitKerja;
    }

    public JTextField getjDeleteNoKtp() {
        return jDeleteNoKtp;
    }

    public void setjDeleteNoKtp(JTextField jDeleteNoKtp) {
        this.jDeleteNoKtp = jDeleteNoKtp;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JLabel getjLabel22() {
        return jLabel22;
    }

    public void setjLabel22(JLabel jLabel22) {
        this.jLabel22 = jLabel22;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public JLabel getjLabel24() {
        return jLabel24;
    }

    public void setjLabel24(JLabel jLabel24) {
        this.jLabel24 = jLabel24;
    }

    public JLabel getjLabel25() {
        return jLabel25;
    }

    public void setjLabel25(JLabel jLabel25) {
        this.jLabel25 = jLabel25;
    }

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public JLabel getjLabel27() {
        return jLabel27;
    }

    public void setjLabel27(JLabel jLabel27) {
        this.jLabel27 = jLabel27;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public JLabel getjLabel32() {
        return jLabel32;
    }

    public void setjLabel32(JLabel jLabel32) {
        this.jLabel32 = jLabel32;
    }

    public JLabel getjLabel33() {
        return jLabel33;
    }

    public void setjLabel33(JLabel jLabel33) {
        this.jLabel33 = jLabel33;
    }

    public JLabel getjLabel35() {
        return jLabel35;
    }

    public void setjLabel35(JLabel jLabel35) {
        this.jLabel35 = jLabel35;
    }

    public JLabel getjLabel36() {
        return jLabel36;
    }

    public void setjLabel36(JLabel jLabel36) {
        this.jLabel36 = jLabel36;
    }

    public JLabel getjLabel37() {
        return jLabel37;
    }

    public void setjLabel37(JLabel jLabel37) {
        this.jLabel37 = jLabel37;
    }

    public JLabel getjLabel39() {
        return jLabel39;
    }

    public void setjLabel39(JLabel jLabel39) {
        this.jLabel39 = jLabel39;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPasswordField getjLoginPassword() {
        return jLoginPassword;
    }

    public void setjLoginPassword(JPasswordField jLoginPassword) {
        this.jLoginPassword = jLoginPassword;
    }

    public JTextField getjLoginUsername() {
        return jLoginUsername;
    }

    public void setjLoginUsername(JTextField jLoginUsername) {
        this.jLoginUsername = jLoginUsername;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel20() {
        return jPanel20;
    }

    public void setjPanel20(JPanel jPanel20) {
        this.jPanel20 = jPanel20;
    }

    public JPanel getjPanel25() {
        return jPanel25;
    }

    public void setjPanel25(JPanel jPanel25) {
        this.jPanel25 = jPanel25;
    }

    public JPanel getjPanel26() {
        return jPanel26;
    }

    public void setjPanel26(JPanel jPanel26) {
        this.jPanel26 = jPanel26;
    }

    public JPanel getjPanel27() {
        return jPanel27;
    }

    public void setjPanel27(JPanel jPanel27) {
        this.jPanel27 = jPanel27;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel31() {
        return jPanel31;
    }

    public void setjPanel31(JPanel jPanel31) {
        this.jPanel31 = jPanel31;
    }

    public JPanel getjPanel32() {
        return jPanel32;
    }

    public void setjPanel32(JPanel jPanel32) {
        this.jPanel32 = jPanel32;
    }

    public JPanel getjPanel33() {
        return jPanel33;
    }

    public void setjPanel33(JPanel jPanel33) {
        this.jPanel33 = jPanel33;
    }

    public JPanel getjPanel35() {
        return jPanel35;
    }

    public void setjPanel35(JPanel jPanel35) {
        this.jPanel35 = jPanel35;
    }

    public JPanel getjPanel36() {
        return jPanel36;
    }

    public void setjPanel36(JPanel jPanel36) {
        this.jPanel36 = jPanel36;
    }

    public JPanel getjPanel37() {
        return jPanel37;
    }

    public void setjPanel37(JPanel jPanel37) {
        this.jPanel37 = jPanel37;
    }

    public JPanel getjPanel38() {
        return jPanel38;
    }

    public void setjPanel38(JPanel jPanel38) {
        this.jPanel38 = jPanel38;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel40() {
        return jPanel40;
    }

    public void setjPanel40(JPanel jPanel40) {
        this.jPanel40 = jPanel40;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JPanel getjPanel8() {
        return jPanel8;
    }

    public void setjPanel8(JPanel jPanel8) {
        this.jPanel8 = jPanel8;
    }

    public JTextField getjRegEmail() {
        return jRegEmail;
    }

    public void setjRegEmail(JTextField jRegEmail) {
        this.jRegEmail = jRegEmail;
    }

    public JPasswordField getjRegPassword() {
        return jRegPassword;
    }

    public void setjRegPassword(JPasswordField jRegPassword) {
        this.jRegPassword = jRegPassword;
    }

    public JTextField getjRegTelephone() {
        return jRegTelephone;
    }

    public void setjRegTelephone(JTextField jRegTelephone) {
        this.jRegTelephone = jRegTelephone;
    }

    public JTextField getjRegUsername() {
        return jRegUsername;
    }

    public void setjRegUsername(JTextField jRegUsername) {
        this.jRegUsername = jRegUsername;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTableGuru() {
        return jTableGuru;
    }

    public void setjTableGuru(JTable jTableGuru) {
        this.jTableGuru = jTableGuru;
    }

    public JTextField getjUpdateAlamatKerja() {
        return jUpdateAlamatKerja;
    }

    public void setjUpdateAlamatKerja(JTextField jUpdateAlamatKerja) {
        this.jUpdateAlamatKerja = jUpdateAlamatKerja;
    }

    public JTextField getjUpdateNamaGuru() {
        return jUpdateNamaGuru;
    }

    public void setjUpdateNamaGuru(JTextField jUpdateNamaGuru) {
        this.jUpdateNamaGuru = jUpdateNamaGuru;
    }

    public JTextField getjUpdateNoKk() {
        return jUpdateNoKk;
    }

    public void setjUpdateNoKk(JTextField jUpdateNoKk) {
        this.jUpdateNoKk = jUpdateNoKk;
    }

    public JTextField getjUpdateNoKtp() {
        return jUpdateNoKtp;
    }

    public void setjUpdateNoKtp(JTextField jUpdateNoKtp) {
        this.jUpdateNoKtp = jUpdateNoKtp;
    }

    public JTextField getjUpdateUnitKerja() {
        return jUpdateUnitKerja;
    }

    public void setjUpdateUnitKerja(JTextField jUpdateUnitKerja) {
        this.jUpdateUnitKerja = jUpdateUnitKerja;
    }

    public JLabel getjUserName() {
        return jUserName;
    }

    public void setjUserName(JLabel jUserName) {
        this.jUserName = jUserName;
    }

    public JLabel getjWallpaper() {
        return jWallpaper;
    }

    public void setjWallpaper(JLabel jWallpaper) {
        this.jWallpaper = jWallpaper;
    }

    public JLabel getjWallpaper1() {
        return jWallpaper1;
    }

    public void setjWallpaper1(JLabel jWallpaper1) {
        this.jWallpaper1 = jWallpaper1;
    }

    public JPanel getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(JPanel menuCount) {
        this.menuCount = menuCount;
    }

    public JPanel getMenuEdit() {
        return menuEdit;
    }

    public void setMenuEdit(JPanel menuEdit) {
        this.menuEdit = menuEdit;
    }

    public JPanel getMenuGuru() {
        return menuGuru;
    }

    public void setMenuGuru(JPanel menuGuru) {
        this.menuGuru = menuGuru;
    }

    public JPanel getMenuLeft() {
        return menuLeft;
    }

    public void setMenuLeft(JPanel menuLeft) {
        this.menuLeft = menuLeft;
    }

    public JPanel getMenuRight() {
        return menuRight;
    }

    public void setMenuRight(JPanel menuRight) {
        this.menuRight = menuRight;
    }

    public JPanel getMenuShow() {
        return menuShow;
    }

    public void setMenuShow(JPanel menuShow) {
        this.menuShow = menuShow;
    }

    public JPanel getMenuTop() {
        return menuTop;
    }

    public void setMenuTop(JPanel menuTop) {
        this.menuTop = menuTop;
    }

    public JPanel getPanelLogin() {
        return panelLogin;
    }

    public void setPanelLogin(JPanel panelLogin) {
        this.panelLogin = panelLogin;
    }

    public JPanel getPanelMenu() {
        return panelMenu;
    }

    public void setPanelMenu(JPanel panelMenu) {
        this.panelMenu = panelMenu;
    }

    public JPanel getPanelRegister() {
        return panelRegister;
    }

    public void setPanelRegister(JPanel panelRegister) {
        this.panelRegister = panelRegister;
    }

    public JLabel getTxt() {
        return txt;
    }

    public void setTxt(JLabel txt) {
        this.txt = txt;
    }

    public JLabel getTxt1() {
        return txt1;
    }

    public void setTxt1(JLabel txt1) {
        this.txt1 = txt1;
    }

    public JLabel getTxt2() {
        return txt2;
    }

    public void setTxt2(JLabel txt2) {
        this.txt2 = txt2;
    }

    public JLabel getTxt3() {
        return txt3;
    }

    public void setTxt3(JLabel txt3) {
        this.txt3 = txt3;
    }

    public JLabel getTxt4() {
        return txt4;
    }

    public void setTxt4(JLabel txt4) {
        this.txt4 = txt4;
    }

    public JPanel getUpdateData() {
        return updateData;
    }

    public void setUpdateData(JPanel updateData) {
        this.updateData = updateData;
    }

    public JPanel getWarna1() {
        return warna1;
    }

    public void setWarna1(JPanel warna1) {
        this.warna1 = warna1;
    }

    public JPanel getWarna2() {
        return warna2;
    }

    public void setWarna2(JPanel warna2) {
        this.warna2 = warna2;
    }

    public JPanel getWarna3() {
        return warna3;
    }

    public void setWarna3(JPanel warna3) {
        this.warna3 = warna3;
    }

    public JPanel getWarna4() {
        return warna4;
    }

    public void setWarna4(JPanel warna4) {
        this.warna4 = warna4;
    }

    public JRootPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(JRootPane rootPane) {
        this.rootPane = rootPane;
    }

    public boolean isRootPaneCheckingEnabled() {
        return rootPaneCheckingEnabled;
    }

    public void setRootPaneCheckingEnabled(boolean rootPaneCheckingEnabled) {
        this.rootPaneCheckingEnabled = rootPaneCheckingEnabled;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    

    Color hitam = new Color(18, 18, 18);
    Color hitam2 = new Color(20, 20, 20);
    Color abu = new Color(24, 24, 24);

    private void btnReset() {
        panelLogin.setVisible(false);
        panelRegister.setVisible(false);
        panelMenu.setVisible(false);
        menuLeft.setVisible(false);
        menuTop.setVisible(false);
        menuCount.setVisible(false);
        menuEdit.setVisible(false);
        menuShow.setVisible(false);
        menuGuru.setVisible(false);
    }

    private void btnDefaultMenu() {
        panelMenu.setVisible(true);
        menuLeft.setVisible(true);
        menuTop.setVisible(true);
    }

    private void btnLogin() {
        btnReset();
        panelLogin.setVisible(true);
    }

    private void btnRegister() {
        btnReset();
        panelRegister.setVisible(true);
    }

    private void btnMenu() {
        btnReset();
        btnDefaultMenu();
        menuGuru.setVisible(true);
        jUserName.setText(username);
    }

    private void btnEasy() {
        btnReset();
        btnDefaultMenu();
        menuGuru.setVisible(true);
    }

    private void btnEasyClick() {
        warna1.setBackground(Color.WHITE);
        warna2.setBackground(hitam);
        warna3.setBackground(hitam);
        warna4.setBackground(hitam);
    }

    private void btnEdit() {
        btnReset();
        btnDefaultMenu();
        menuEdit.setVisible(true);
    }

    private void btnEditClick() {
        warna1.setBackground(hitam);
        warna2.setBackground(Color.WHITE);
        warna3.setBackground(hitam);
        warna4.setBackground(hitam);
    }

    private void btnShow() {
        btnReset();
        btnDefaultMenu();
        menuShow.setVisible(true);
    }

    private void btnShowClick() {
        warna1.setBackground(hitam);
        warna2.setBackground(hitam);
        warna3.setBackground(Color.WHITE);
        warna4.setBackground(hitam);
    }

    private void btnCount() {
        btnReset();
        btnDefaultMenu();
        menuCount.setVisible(true);;
    }

    private void btnCountClick() {
        warna1.setBackground(hitam);
        warna2.setBackground(hitam);
        warna3.setBackground(hitam);
        warna4.setBackground(Color.WHITE);
    }

    private void btnMenuEnter(JPanel btn) {
        btnMenuEasy.setBackground(hitam);
        btnMenuEdit.setBackground(hitam);
        btnMenuCounting.setBackground(hitam);
        btnMenuShow.setBackground(hitam);
        if (btn == btnMenuEasy) {
            btnMenuEasy.setBackground(hitam2);
        } else if (btn == btnMenuEdit) {
            btnMenuEdit.setBackground(hitam2);
        } else if (btn == btnMenuShow) {
            btnMenuShow.setBackground(hitam2);
        } else if (btn == btnMenuCounting) {
            btnMenuCounting.setBackground(hitam2);
        }
    }

    private void btnMenuExit(JPanel btn) {
        btnMenuEasy.setBackground(hitam);
        btnMenuEdit.setBackground(hitam);
        btnMenuCounting.setBackground(hitam);
        btnMenuShow.setBackground(hitam);
        if (btn == btnMenuEasy) {
            btnMenuEasy.setBackground(hitam);
        } else if (btn == btnMenuEdit) {
            btnMenuEdit.setBackground(hitam);
        } else if (btn == btnMenuShow) {
            btnMenuShow.setBackground(hitam);
        } else if (btn == btnMenuCounting) {
            btnMenuCounting.setBackground(hitam);
        }
    }

    public void btnAdd() {
        jAddUnitKerja.setVisible(true);
        updateData.setVisible(false);
        DeleteData.setVisible(false);
        jAddNamaGuru.setText("Kode Barang");
        jAddNoKtpGuru.setText("Nama Barang");
        jAddNoKkGuru.setText("Stok");
        jAddAlamatLengkap.setText("Harga Beli");
        jAddUniKerja.setText("Harga Jual");

    }

    private void btnupdate() {
        jAddUnitKerja.setVisible(false);
        updateData.setVisible(true);
        DeleteData.setVisible(false);
        jUpdateNoKtp.setText("Kode Barang");
        jUpdateNamaGuru.setText("Nama Barang");
        jUpdateNoKk.setText("Stok");
        jUpdateAlamatKerja.setText("Harga Beli");
        jUpdateUnitKerja.setText("Harga Jual");
    }

    private void btnDelete() {
        jAddUnitKerja.setVisible(false);
        updateData.setVisible(false);
        DeleteData.setVisible(true);
        jDeleteNoKtp.setText("Kode Barang");
    }

    private void btnEditColor(JPanel btn) {
        btnAddData.setBackground(hitam);
        btnUpdateData.setBackground(hitam);
        btnDeleteData.setBackground(hitam);
        if (btn == btnAddData) {
            btnAddData.setBackground(abu);
        } else if (btn == btnUpdateData) {
            btnUpdateData.setBackground(abu);
        } else if (btn == btnDeleteData) {
            btnDeleteData.setBackground(abu);
        }
    }

    public void resetText(JTextField text, String same) {
        if (text.getText().equals(same)) {
            text.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLoginPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLoginUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegister2 = new javax.swing.JLabel();
        jWallpaper = new javax.swing.JLabel();
        panelRegister = new javax.swing.JPanel();
        btnLogin2 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRegPassword = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jRegUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jRegEmail = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jRegTelephone = new javax.swing.JTextField();
        jWallpaper1 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        menuLeft = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnMenuEasy = new javax.swing.JPanel();
        warna1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnMenuEdit = new javax.swing.JPanel();
        warna2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnMenuShow = new javax.swing.JPanel();
        warna3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnMenuCounting = new javax.swing.JPanel();
        warna4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnExit = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menuRight = new javax.swing.JPanel();
        menuTop = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        menuGuru = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hasilCari = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        cari = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        menuEdit = new javax.swing.JPanel();
        btnAddData = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnUpdateData = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnDeleteData = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jAddUnitKerja = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jAddNoKkGuru = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jAddNoKtpGuru = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jAddNamaGuru = new javax.swing.JTextField();
        btnAddGuru = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jAddAlamatLengkap = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jAddUniKerja = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnResetGuru = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        updateData = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jUpdateNoKk = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jUpdateNamaGuru = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jUpdateNoKtp = new javax.swing.JTextField();
        btnUpdateBarang = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jUpdateUnitKerja = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jUpdateAlamatKerja = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        DeleteData = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jDeleteNoKtp = new javax.swing.JTextField();
        btnDeleteBarang = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        menuShow = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGuru = new javax.swing.JTable();
        btnAddData1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnUpdateData1 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnDeleteData1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        menuCount = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy Shop");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLoginPassword.setText("jPasswordField1");
        jLoginPassword.setBorder(null);
        jLoginPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoginPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLoginPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelLogin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 260, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLoginUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLoginUsername.setText("Username");
        jLoginUsername.setBorder(null);
        jLoginUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoginUsernameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLoginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelLogin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 260, 40));

        btnLogin.setBackground(new java.awt.Color(51, 51, 51));
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign In");

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 90, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Easy Shop");
        panelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 180, -1));

        btnRegister2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnRegister2.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister2.setText("Sign Up");
        btnRegister2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegister2MouseClicked(evt);
            }
        });
        panelLogin.add(btnRegister2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, 30));

        jWallpaper.setBackground(new java.awt.Color(255, 255, 255));
        jWallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jWallpaper.setToolTipText("");
        panelLogin.add(jWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        panelRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnLogin2.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin2.setText("Sign In");
        btnLogin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin2MouseClicked(evt);
            }
        });
        panelRegister.add(btnLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, 30));

        btnRegister.setBackground(new java.awt.Color(51, 51, 51));
        btnRegister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sign Up");

        javax.swing.GroupLayout btnRegisterLayout = new javax.swing.GroupLayout(btnRegister);
        btnRegister.setLayout(btnRegisterLayout);
        btnRegisterLayout.setHorizontalGroup(
            btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
            .addGroup(btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegisterLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        btnRegisterLayout.setVerticalGroup(
            btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnRegisterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        panelRegister.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 90, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jRegPassword.setText("jPasswordField1");
        jRegPassword.setBorder(null);
        jRegPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 260, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jRegUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jRegUsername.setText("Username");
        jRegUsername.setBorder(null);
        jRegUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegUsernameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 260, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  Easy Shop");
        panelRegister.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 180, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jRegEmail.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jRegEmail.setText("Email");
        jRegEmail.setBorder(null);
        jRegEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegEmailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 260, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jRegTelephone.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jRegTelephone.setText("Telephone");
        jRegTelephone.setBorder(null);
        jRegTelephone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRegTelephoneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegTelephone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelRegister.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 260, 40));
        panelRegister.add(jWallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        getContentPane().add(panelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLeft.setBackground(new java.awt.Color(18, 18, 18));
        menuLeft.setPreferredSize(new java.awt.Dimension(200, 650));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nurul Falah");

        btnMenuEasy.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuEasy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuEasyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuEasyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuEasyMouseExited(evt);
            }
        });
        btnMenuEasy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna1.setBackground(new java.awt.Color(255, 255, 255));
        warna1.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna1Layout = new javax.swing.GroupLayout(warna1);
        warna1.setLayout(warna1Layout);
        warna1Layout.setHorizontalGroup(
            warna1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna1Layout.setVerticalGroup(
            warna1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuEasy.add(warna1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cari Data");
        btnMenuEasy.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        btnMenuEdit.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuEditMouseExited(evt);
            }
        });
        btnMenuEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna2.setBackground(new java.awt.Color(18, 18, 18));
        warna2.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna2Layout = new javax.swing.GroupLayout(warna2);
        warna2.setLayout(warna2Layout);
        warna2Layout.setHorizontalGroup(
            warna2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna2Layout.setVerticalGroup(
            warna2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuEdit.add(warna2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Edit Data");
        btnMenuEdit.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        btnMenuShow.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuShowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuShowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuShowMouseExited(evt);
            }
        });
        btnMenuShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna3.setBackground(new java.awt.Color(18, 18, 18));
        warna3.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna3Layout = new javax.swing.GroupLayout(warna3);
        warna3.setLayout(warna3Layout);
        warna3Layout.setHorizontalGroup(
            warna3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna3Layout.setVerticalGroup(
            warna3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuShow.add(warna3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Show Data");
        btnMenuShow.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 110, 30));

        btnMenuCounting.setBackground(new java.awt.Color(18, 18, 18));
        btnMenuCounting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuCountingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuCountingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuCountingMouseExited(evt);
            }
        });
        btnMenuCounting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warna4.setBackground(new java.awt.Color(18, 18, 18));
        warna4.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout warna4Layout = new javax.swing.GroupLayout(warna4);
        warna4.setLayout(warna4Layout);
        warna4Layout.setHorizontalGroup(
            warna4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        warna4Layout.setVerticalGroup(
            warna4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMenuCounting.add(warna4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("About");
        btnMenuCounting.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        btnExit.setBackground(new java.awt.Color(18, 18, 18));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(18, 18, 18));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnExit.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 40));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Exit");
        btnExit.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3, 90, 30));

        javax.swing.GroupLayout menuLeftLayout = new javax.swing.GroupLayout(menuLeft);
        menuLeft.setLayout(menuLeftLayout);
        menuLeftLayout.setHorizontalGroup(
            menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnMenuEasy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMenuEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMenuShow, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btnMenuCounting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLeftLayout.setVerticalGroup(
            menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(menuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuLeftLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnMenuEasy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuCounting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMenu.add(menuLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuRight.setBackground(new java.awt.Color(255, 255, 255));
        menuRight.setPreferredSize(new java.awt.Dimension(900, 650));
        menuRight.setRequestFocusEnabled(false);
        menuRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuTop.setBackground(new java.awt.Color(18, 18, 18));

        jUserName.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jUserName.setForeground(new java.awt.Color(255, 255, 255));
        jUserName.setText("Username");

        javax.swing.GroupLayout menuTopLayout = new javax.swing.GroupLayout(menuTop);
        menuTop.setLayout(menuTopLayout);
        menuTopLayout.setHorizontalGroup(
            menuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTopLayout.createSequentialGroup()
                .addContainerGap(646, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jUserName)
                .addGap(69, 69, 69))
        );
        menuTopLayout.setVerticalGroup(
            menuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTopLayout.createSequentialGroup()
                .addGroup(menuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuTopLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel15))
                    .addGroup(menuTopLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jUserName)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        menuRight.add(menuTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 100));

        menuGuru.setBackground(new java.awt.Color(24, 24, 24));
        menuGuru.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hasilCari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(hasilCari);

        menuGuru.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 740, 180));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        cari.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cari.setText("Cari Guru");
        cari.setBorder(null);
        cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariMouseClicked(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuGuru.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 740, 40));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Cara Mudah Cari Guru");
        menuGuru.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Nurul Falah");
        menuGuru.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        menuRight.add(menuGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        menuEdit.setBackground(new java.awt.Color(24, 24, 24));
        menuEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddData.setBackground(new java.awt.Color(24, 24, 24));
        btnAddData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddDataMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Add Data");

        javax.swing.GroupLayout btnAddDataLayout = new javax.swing.GroupLayout(btnAddData);
        btnAddData.setLayout(btnAddDataLayout);
        btnAddDataLayout.setHorizontalGroup(
            btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnAddDataLayout.setVerticalGroup(
            btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnAddDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuEdit.add(btnAddData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        btnUpdateData.setBackground(new java.awt.Color(18, 18, 18));
        btnUpdateData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateDataMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Update Data");

        javax.swing.GroupLayout btnUpdateDataLayout = new javax.swing.GroupLayout(btnUpdateData);
        btnUpdateData.setLayout(btnUpdateDataLayout);
        btnUpdateDataLayout.setHorizontalGroup(
            btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnUpdateDataLayout.setVerticalGroup(
            btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnUpdateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuEdit.add(btnUpdateData, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 300, -1));

        btnDeleteData.setBackground(new java.awt.Color(18, 18, 18));
        btnDeleteData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteDataMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Delete Data");

        javax.swing.GroupLayout btnDeleteDataLayout = new javax.swing.GroupLayout(btnDeleteData);
        btnDeleteData.setLayout(btnDeleteDataLayout);
        btnDeleteDataLayout.setHorizontalGroup(
            btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnDeleteDataLayout.setVerticalGroup(
            btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnDeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteDataLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuEdit.add(btnDeleteData, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 300, -1));

        jAddUnitKerja.setBackground(new java.awt.Color(24, 24, 24));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jAddNoKkGuru.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddNoKkGuru.setBorder(null);
        jAddNoKkGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddNoKkGuruMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddNoKkGuru))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddNoKkGuru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jAddNoKtpGuru.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddNoKtpGuru.setBorder(null);
        jAddNoKtpGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddNoKtpGuruMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddNoKtpGuru))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddNoKtpGuru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jAddNamaGuru.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddNamaGuru.setBorder(null);
        jAddNamaGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddNamaGuruMouseClicked(evt);
            }
        });
        jAddNamaGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddNamaGuruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddNamaGuru, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddNamaGuru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnAddGuru.setBackground(new java.awt.Color(18, 18, 18));
        btnAddGuru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnAddGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddGuruMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Add");

        javax.swing.GroupLayout btnAddGuruLayout = new javax.swing.GroupLayout(btnAddGuru);
        btnAddGuru.setLayout(btnAddGuruLayout);
        btnAddGuruLayout.setHorizontalGroup(
            btnAddGuruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddGuruLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(116, 116, 116))
        );
        btnAddGuruLayout.setVerticalGroup(
            btnAddGuruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddGuruLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(42, 42, 42))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jAddAlamatLengkap.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddAlamatLengkap.setBorder(null);
        jAddAlamatLengkap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddAlamatLengkapMouseClicked(evt);
            }
        });
        jAddAlamatLengkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddAlamatLengkapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAddAlamatLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddAlamatLengkap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jAddUniKerja.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jAddUniKerja.setBorder(null);
        jAddUniKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAddUniKerjaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddUniKerja))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jAddUniKerja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Nama Guru");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("No KTP Guru");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setText("No KK Guru");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setText("Alamat");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setText("Unit Kerja");

        btnResetGuru.setBackground(new java.awt.Color(18, 18, 18));
        btnResetGuru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnResetGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetGuruMouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Reset");

        javax.swing.GroupLayout btnResetGuruLayout = new javax.swing.GroupLayout(btnResetGuru);
        btnResetGuru.setLayout(btnResetGuruLayout);
        btnResetGuruLayout.setHorizontalGroup(
            btnResetGuruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnResetGuruLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(116, 116, 116))
        );
        btnResetGuruLayout.setVerticalGroup(
            btnResetGuruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnResetGuruLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jAddUnitKerjaLayout = new javax.swing.GroupLayout(jAddUnitKerja);
        jAddUnitKerja.setLayout(jAddUnitKerjaLayout);
        jAddUnitKerjaLayout.setHorizontalGroup(
            jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32))
                .addGap(68, 68, 68)
                .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAddUnitKerjaLayout.createSequentialGroup()
                            .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(68, 68, 68)))
                    .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(249, 249, 249)))
                .addGap(24, 24, 24)
                .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResetGuru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddGuru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jAddUnitKerjaLayout.setVerticalGroup(
            jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jAddUnitKerjaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15)))
                .addGap(26, 26, 26)
                .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                        .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel6)))
                        .addGroup(jAddUnitKerjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel16)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel29)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel32)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(jAddUnitKerjaLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnAddGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnResetGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuEdit.add(jAddUnitKerja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 510));

        updateData.setBackground(new java.awt.Color(24, 24, 24));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateNoKk.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateNoKk.setBorder(null);
        jUpdateNoKk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateNoKkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jUpdateNoKk, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateNoKk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateNamaGuru.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateNamaGuru.setBorder(null);
        jUpdateNamaGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateNamaGuruMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jUpdateNamaGuru, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateNamaGuru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateNoKtp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateNoKtp.setText("Nomor KTP");
        jUpdateNoKtp.setBorder(null);
        jUpdateNoKtp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateNoKtpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jUpdateNoKtp, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateNoKtp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnUpdateBarang.setBackground(new java.awt.Color(18, 18, 18));
        btnUpdateBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnUpdateBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateBarangMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Update");

        javax.swing.GroupLayout btnUpdateBarangLayout = new javax.swing.GroupLayout(btnUpdateBarang);
        btnUpdateBarang.setLayout(btnUpdateBarangLayout);
        btnUpdateBarangLayout.setHorizontalGroup(
            btnUpdateBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUpdateBarangLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(116, 116, 116))
        );
        btnUpdateBarangLayout.setVerticalGroup(
            btnUpdateBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUpdateBarangLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(42, 42, 42))
        );

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Masukan No KTP Guru Yang akan di ubah");

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateUnitKerja.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateUnitKerja.setBorder(null);
        jUpdateUnitKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateUnitKerjaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jUpdateUnitKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateUnitKerja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jUpdateAlamatKerja.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jUpdateAlamatKerja.setBorder(null);
        jUpdateAlamatKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateAlamatKerjaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jUpdateAlamatKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUpdateAlamatKerja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel33.setText("Nama Guru");

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel35.setText("No KK Guru");

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel36.setText("Alamat");

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel37.setText("Unit Kerja");

        javax.swing.GroupLayout updateDataLayout = new javax.swing.GroupLayout(updateData);
        updateData.setLayout(updateDataLayout);
        updateDataLayout.setHorizontalGroup(
            updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDataLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel36)
                        .addComponent(jLabel35)
                        .addComponent(jLabel37)))
                .addGap(10, 10, 10)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdateBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateDataLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateDataLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(135, Short.MAX_VALUE))))
        );
        updateDataLayout.setVerticalGroup(
            updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDataLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel33)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel35)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel36)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel37))
                    .addGroup(updateDataLayout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(updateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateDataLayout.createSequentialGroup()
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnUpdateBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        menuEdit.add(updateData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 510));

        DeleteData.setBackground(new java.awt.Color(24, 24, 24));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jDeleteNoKtp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jDeleteNoKtp.setText("No KTP");
        jDeleteNoKtp.setBorder(null);
        jDeleteNoKtp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDeleteNoKtpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDeleteNoKtp, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDeleteNoKtp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnDeleteBarang.setBackground(new java.awt.Color(18, 18, 18));
        btnDeleteBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        btnDeleteBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteBarangMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Delete");

        javax.swing.GroupLayout btnDeleteBarangLayout = new javax.swing.GroupLayout(btnDeleteBarang);
        btnDeleteBarang.setLayout(btnDeleteBarangLayout);
        btnDeleteBarangLayout.setHorizontalGroup(
            btnDeleteBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDeleteBarangLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(116, 116, 116))
        );
        btnDeleteBarangLayout.setVerticalGroup(
            btnDeleteBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDeleteBarangLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(42, 42, 42))
        );

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Masukan No KTP yang akan di Hapus");

        javax.swing.GroupLayout DeleteDataLayout = new javax.swing.GroupLayout(DeleteData);
        DeleteData.setLayout(DeleteDataLayout);
        DeleteDataLayout.setHorizontalGroup(
            DeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDataLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        DeleteDataLayout.setVerticalGroup(
            DeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDataLayout.createSequentialGroup()
                .addGroup(DeleteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteDataLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel24))
                    .addGroup(DeleteDataLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90)
                .addComponent(btnDeleteBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        menuEdit.add(DeleteData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 900, 510));

        menuRight.add(menuEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        menuShow.setBackground(new java.awt.Color(24, 24, 24));
        menuShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Daftar Barang");
        menuShow.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 200, 30));

        jTableGuru.setBackground(new java.awt.Color(204, 204, 204));
        jTableGuru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGuru.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableGuru);

        menuShow.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 840, 350));
        jScrollPane1.getAccessibleContext().setAccessibleParent(this);

        btnAddData1.setBackground(new java.awt.Color(18, 18, 18));
        btnAddData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAddData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddData1MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Add Data");

        javax.swing.GroupLayout btnAddData1Layout = new javax.swing.GroupLayout(btnAddData1);
        btnAddData1.setLayout(btnAddData1Layout);
        btnAddData1Layout.setHorizontalGroup(
            btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
            .addGroup(btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnAddData1Layout.setVerticalGroup(
            btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(btnAddData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAddData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuShow.add(btnAddData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 160, -1));

        btnUpdateData1.setBackground(new java.awt.Color(18, 18, 18));
        btnUpdateData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnUpdateData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateData1MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Update Data");

        javax.swing.GroupLayout btnUpdateData1Layout = new javax.swing.GroupLayout(btnUpdateData1);
        btnUpdateData1.setLayout(btnUpdateData1Layout);
        btnUpdateData1Layout.setHorizontalGroup(
            btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnUpdateData1Layout.setVerticalGroup(
            btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(btnUpdateData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnUpdateData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuShow.add(btnUpdateData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        btnDeleteData1.setBackground(new java.awt.Color(18, 18, 18));
        btnDeleteData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnDeleteData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteData1MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Delete Data");

        javax.swing.GroupLayout btnDeleteData1Layout = new javax.swing.GroupLayout(btnDeleteData1);
        btnDeleteData1.setLayout(btnDeleteData1Layout);
        btnDeleteData1Layout.setHorizontalGroup(
            btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
            .addGroup(btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnDeleteData1Layout.setVerticalGroup(
            btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
            .addGroup(btnDeleteData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDeleteData1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuShow.add(btnDeleteData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, -1, -1));

        menuRight.add(menuShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        menuCount.setBackground(new java.awt.Color(24, 24, 24));
        menuCount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txt.setForeground(new java.awt.Color(255, 255, 255));
        txt.setText("-10116497 / Adam Jordy");
        menuCount.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        txt1.setFont(new java.awt.Font("Bernard MT Condensed", 1, 80)); // NOI18N
        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setText("EASY SHOP");
        menuCount.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        txt2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setText("Developed by : ");
        menuCount.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        txt3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txt3.setForeground(new java.awt.Color(255, 255, 255));
        txt3.setText("-10116488 / Ma'mun Basyari");
        menuCount.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        txt4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txt4.setForeground(new java.awt.Color(255, 255, 255));
        txt4.setText("-10116494 / Imam Dwi Cahyo");
        menuCount.add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        menuRight.add(menuCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 900, 550));

        panelMenu.add(menuRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 899, 650));

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginUsernameMouseClicked
        resetText(jLoginUsername, "Username");
    }//GEN-LAST:event_jLoginUsernameMouseClicked

    private void jLoginPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginPasswordMouseClicked
        resetText(jLoginPassword, "jPasswordField1");
    }//GEN-LAST:event_jLoginPasswordMouseClicked

    private void jRegPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegPasswordMouseClicked
        resetText(jRegPassword, "jPasswordField1");
    }//GEN-LAST:event_jRegPasswordMouseClicked

    private void jRegUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegUsernameMouseClicked
        resetText(jRegUsername, "Username");
    }//GEN-LAST:event_jRegUsernameMouseClicked

    private void jRegEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegEmailMouseClicked
        resetText(jRegEmail, "Email");
    }//GEN-LAST:event_jRegEmailMouseClicked

    private void jRegTelephoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegTelephoneMouseClicked
        resetText(jRegTelephone, "Telephone");
    }//GEN-LAST:event_jRegTelephoneMouseClicked

    private void btnLogin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin2MouseClicked
        btnLogin();
    }//GEN-LAST:event_btnLogin2MouseClicked

    private void btnRegister2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegister2MouseClicked
        btnRegister();
        jRegUsername.setText("Username");
        jRegPassword.setText("jPasswordField1");
        jRegTelephone.setText("Telephone");
        jRegEmail.setText("Email");
    }//GEN-LAST:event_btnRegister2MouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        if (jLoginUsername.getText().equals(username) && jLoginPassword.getText().equals(pass)) {
            btnMenu();
            btnEasyClick();
        } else {
            JOptionPane.showMessageDialog(null, "Username atau Password salah");
        }


    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        btnLogin();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnMenuEasyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEasyMouseClicked
        btnEasy();
        btnEasyClick();
        cari.setText("Cari Barang");
    }//GEN-LAST:event_btnMenuEasyMouseClicked

    private void btnMenuEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEditMouseClicked
        btnEdit();
        btnEditClick();
    }//GEN-LAST:event_btnMenuEditMouseClicked

    private void btnMenuShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuShowMouseClicked
        btnShow();
        btnShowClick();
    }//GEN-LAST:event_btnMenuShowMouseClicked

    private void btnMenuCountingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuCountingMouseClicked
        btnCount();
        btnCountClick();
    }//GEN-LAST:event_btnMenuCountingMouseClicked

    private void btnAddDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDataMouseClicked
        btnAdd();
        btnEditColor(btnAddData);
    }//GEN-LAST:event_btnAddDataMouseClicked

    private void btnUpdateDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateDataMouseClicked
        btnupdate();
        btnEditColor(btnUpdateData);
    }//GEN-LAST:event_btnUpdateDataMouseClicked

    private void btnDeleteDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteDataMouseClicked
        btnDelete();
        btnEditColor(btnDeleteData);
    }//GEN-LAST:event_btnDeleteDataMouseClicked

    private void btnAddGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddGuruMouseClicked
        // TODO add your handling code here:
        controller.insertBarang(this);
    }//GEN-LAST:event_btnAddGuruMouseClicked

    private void btnUpdateBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateBarangMouseClicked
        // TODO add your handling code here:
        controller.updateBarang(this);
    }//GEN-LAST:event_btnUpdateBarangMouseClicked

    private void btnDeleteBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBarangMouseClicked
        // TODO add your handling code here:
        controller.deleteBarang(this);
    }//GEN-LAST:event_btnDeleteBarangMouseClicked

    private void btnMenuEasyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEasyMouseEntered
        // TODO add your handling code here:
        btnMenuEnter(btnMenuEasy);
    }//GEN-LAST:event_btnMenuEasyMouseEntered

    private void btnMenuEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEditMouseEntered
        // TODO add your handling code here:
        btnMenuEnter(btnMenuEdit);
    }//GEN-LAST:event_btnMenuEditMouseEntered

    private void btnMenuShowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuShowMouseEntered
        // TODO add your handling code here:
        btnMenuEnter(btnMenuShow);
    }//GEN-LAST:event_btnMenuShowMouseEntered

    private void btnMenuCountingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuCountingMouseEntered
        // TODO add your handling code here:
        btnMenuEnter(btnMenuCounting);
    }//GEN-LAST:event_btnMenuCountingMouseEntered

    private void btnMenuEasyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEasyMouseExited
        // TODO add your handling code here:
        btnMenuExit(btnMenuEasy);
    }//GEN-LAST:event_btnMenuEasyMouseExited

    private void btnMenuEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuEditMouseExited
        // TODO add your handling code here:
        btnMenuExit(btnMenuEdit);
    }//GEN-LAST:event_btnMenuEditMouseExited

    private void btnMenuShowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuShowMouseExited
        // TODO add your handling code here:
        btnMenuExit(btnMenuShow);
    }//GEN-LAST:event_btnMenuShowMouseExited

    private void btnMenuCountingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuCountingMouseExited
        // TODO add your handling code here:
        btnMenuExit(btnMenuCounting);
    }//GEN-LAST:event_btnMenuCountingMouseExited

    private void jAddNamaGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddNamaGuruMouseClicked
        // TODO add your handling code here:
        resetText(jAddNamaGuru, "Kode Barang");
    }//GEN-LAST:event_jAddNamaGuruMouseClicked

    private void jAddNoKtpGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddNoKtpGuruMouseClicked
        // TODO add your handling code here:
        resetText(jAddNoKtpGuru, "Nama Barang");
    }//GEN-LAST:event_jAddNoKtpGuruMouseClicked

    private void jAddNoKkGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddNoKkGuruMouseClicked
        // TODO add your handling code here:
        resetText(jAddNoKkGuru, "Stok");
    }//GEN-LAST:event_jAddNoKkGuruMouseClicked

    private void jAddAlamatLengkapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddAlamatLengkapMouseClicked
        // TODO add your handling code here:
        resetText(jAddAlamatLengkap, "Harga Beli");
    }//GEN-LAST:event_jAddAlamatLengkapMouseClicked

    private void jAddUniKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddUniKerjaMouseClicked
        // TODO add your handling code here:
        resetText(jAddUniKerja, "Harga Jual");
    }//GEN-LAST:event_jAddUniKerjaMouseClicked

    private void jUpdateNoKtpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateNoKtpMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateNoKtp, "Kode Barang");
    }//GEN-LAST:event_jUpdateNoKtpMouseClicked

    private void jUpdateNamaGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateNamaGuruMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateNamaGuru, "Nama Barang");
    }//GEN-LAST:event_jUpdateNamaGuruMouseClicked

    private void jUpdateNoKkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateNoKkMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateNoKk, "Stok");
    }//GEN-LAST:event_jUpdateNoKkMouseClicked

    private void jUpdateAlamatKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateAlamatKerjaMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateAlamatKerja, "Harga Beli");
    }//GEN-LAST:event_jUpdateAlamatKerjaMouseClicked

    private void jUpdateUnitKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateUnitKerjaMouseClicked
        // TODO add your handling code here:
        resetText(jUpdateUnitKerja, "Harga Jual");
    }//GEN-LAST:event_jUpdateUnitKerjaMouseClicked

    private void jDeleteNoKtpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDeleteNoKtpMouseClicked
        // TODO add your handling code here:
        resetText(jDeleteNoKtp, "Kode Barang");
    }//GEN-LAST:event_jDeleteNoKtpMouseClicked

    private void btnAddData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddData1MouseClicked
        // TODO add your handling code here:
        btnReset();
        btnDefaultMenu();
        menuEdit.setVisible(true);
        btnAdd();
        btnEditClick();
    }//GEN-LAST:event_btnAddData1MouseClicked

    private void btnUpdateData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateData1MouseClicked
        // TODO add your handling code here:
        if (getjTableGuru().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan diubah");
            return;
        }
        btnEdit();
        updateData.setVisible(true);
        jAddUnitKerja.setVisible(false);
        DeleteData.setVisible(false);
        btnEditColor(btnUpdateData);
        btnEditClick();
    }//GEN-LAST:event_btnUpdateData1MouseClicked

    private void btnDeleteData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteData1MouseClicked
        // TODO add your handling code here:
        if (getjTableGuru().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus");
            return;
        }
        btnEdit();
        updateData.setVisible(false);
        jAddUnitKerja.setVisible(false);
        DeleteData.setVisible(true);
        btnEditColor(btnDeleteData);
        btnEditClick();
    }//GEN-LAST:event_btnDeleteData1MouseClicked

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        hasilCari.setModel(tmodel);
        cari2 = cari.getText();
        try {
            GuruDao dao = NurulFalahDatabase.getGuruDao();
            tabelCari.setList(dao.selectCariGuru(cari2));
            hasilCari.setModel(tabelCari);
        } catch (SQLException ex) {
            Logger.getLogger(MainViewNurulFalah.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GuruException ex) {
            Logger.getLogger(MainViewNurulFalah.class.getName()).log(Level.SEVERE, null, ex);
        }
        hasilCari.setModel(tabelCari);
        onChange(model);
    }//GEN-LAST:event_cariKeyReleased

    private void cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariMouseClicked
        // TODO add your handling code here:
        resetText(cari, "Cari Barang");
    }//GEN-LAST:event_cariMouseClicked

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        // TODO add your handling code here:
        username = jRegUsername.getText();
        pass = jRegPassword.getText();
        JOptionPane.showMessageDialog(null, "Pendaftaran berhasil silakan lakukan login");
        btnReset();
        btnLogin();
        jLoginPassword.setText("jPasswordField1");
        jLoginUsername.setText("Username");
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void jAddNamaGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddNamaGuruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddNamaGuruActionPerformed

    private void jAddAlamatLengkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddAlamatLengkapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddAlamatLengkapActionPerformed

    private void btnResetGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetGuruMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetGuruMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainViewNurulFalah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainViewNurulFalah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainViewNurulFalah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewNurulFalah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainViewNurulFalah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeleteData;
    private javax.swing.JPanel btnAddData;
    private javax.swing.JPanel btnAddData1;
    private javax.swing.JPanel btnAddGuru;
    private javax.swing.JPanel btnDeleteBarang;
    private javax.swing.JPanel btnDeleteData;
    private javax.swing.JPanel btnDeleteData1;
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel btnLogin2;
    private javax.swing.JPanel btnMenuCounting;
    private javax.swing.JPanel btnMenuEasy;
    private javax.swing.JPanel btnMenuEdit;
    private javax.swing.JPanel btnMenuShow;
    private javax.swing.JPanel btnRegister;
    private javax.swing.JLabel btnRegister2;
    private javax.swing.JPanel btnResetGuru;
    private javax.swing.JPanel btnUpdateBarang;
    private javax.swing.JPanel btnUpdateData;
    private javax.swing.JPanel btnUpdateData1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari;
    private javax.swing.JTable hasilCari;
    private javax.swing.JTextField jAddAlamatLengkap;
    private javax.swing.JTextField jAddNamaGuru;
    private javax.swing.JTextField jAddNoKkGuru;
    private javax.swing.JTextField jAddNoKtpGuru;
    private javax.swing.JTextField jAddUniKerja;
    private javax.swing.JPanel jAddUnitKerja;
    private javax.swing.JTextField jDeleteNoKtp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jLoginPassword;
    private javax.swing.JTextField jLoginUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jRegEmail;
    private javax.swing.JPasswordField jRegPassword;
    private javax.swing.JTextField jRegTelephone;
    private javax.swing.JTextField jRegUsername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGuru;
    private javax.swing.JTextField jUpdateAlamatKerja;
    private javax.swing.JTextField jUpdateNamaGuru;
    private javax.swing.JTextField jUpdateNoKk;
    private javax.swing.JTextField jUpdateNoKtp;
    private javax.swing.JTextField jUpdateUnitKerja;
    private javax.swing.JLabel jUserName;
    private javax.swing.JLabel jWallpaper;
    private javax.swing.JLabel jWallpaper1;
    private javax.swing.JPanel menuCount;
    private javax.swing.JPanel menuEdit;
    private javax.swing.JPanel menuGuru;
    private javax.swing.JPanel menuLeft;
    private javax.swing.JPanel menuRight;
    private javax.swing.JPanel menuShow;
    private javax.swing.JPanel menuTop;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelRegister;
    private javax.swing.JLabel txt;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JPanel updateData;
    private javax.swing.JPanel warna1;
    private javax.swing.JPanel warna2;
    private javax.swing.JPanel warna3;
    private javax.swing.JPanel warna4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(GuruModel model) {
        jUpdateNamaGuru.setText(model.getNama_guru());
        jUpdateNoKtp.setText(model.getNo_ktp_guru());
        jUpdateNoKk.setText(model.getNo_kk_guru());
        jUpdateUnitKerja.setText(model.getAlamat_lengkap() + "");
        jUpdateAlamatKerja.setText(model.getUnit_kerja() + "");
    }

    @Override
    public void onInsert(Guru guru) {
        tabelModel.add(guru);
    }

    @Override
    public void onDelete() {
        int index = jTableGuru.getSelectedRow();
        tabelModel.remove(index);
    }

    @Override
    public void onUpdate(Guru guru) {
        int index = jTableGuru.getSelectedRow();
        tabelModel.set(index, guru);
    }

    public void loadDatabase() throws SQLException, GuruException {
        GuruDao dao = NurulFalahDatabase.getGuruDao();
        tabelModel.setList(dao.selectAllGuru());
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        try {
            Guru model = tabelModel.get(jTableGuru.getSelectedRow());
            jUpdateNoKtp.setText(model.getNo_ktp_guru());
            jUpdateNoKtp.setText(model.getNo_ktp_guru());
            jUpdateNamaGuru.setText(model.getNama_guru());
            jUpdateNoKk.setText(model.getNo_kk_guru());
            jUpdateUnitKerja.setText(model.getAlamat_lengkap() + "");
            jUpdateAlamatKerja.setText(model.getUnit_kerja() + "");
        } catch (IndexOutOfBoundsException exception) {
        }
    }

}
