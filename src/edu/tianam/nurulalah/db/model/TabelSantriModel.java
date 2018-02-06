/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.model;

import edu.tianam.nurulalah.db.entity.Santri;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THOSHIBA
 */
public class TabelSantriModel extends AbstractTableModel {

    private List<Santri> list = new ArrayList<Santri>();

    public void setList(List<Santri> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 66;
    }

    public boolean add(Santri e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Santri get(int i) {
        return list.get(i);
    }

    public Santri set(int index, Santri element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Santri remove(int i) {
        try {
            return list.remove(i);
        } finally {
            fireTableRowsDeleted(i, i);
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NISA_LOKAL";
            case 1:
                return "NAMA_LENGKAP_SANTRI";
            case 2:
                return "TEMPAT_LAHIR";
            case 3:
                return "TGL_LAHIR";
            case 4:
                return "BLN_LAHIR";
            case 5:
                return "THN_LAHIR";
            case 6:
                return "JENIS_KELAMIN";
            case 7:
                return "AGAMA";
            case 8:
                return "ALAMAT_SANTRI";
            case 9:
                return "KECAMATAN";
            case 10:
                return "KAB_KOTA";
            case 11:
                return "PROVINSI";
            default:
                return null;
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNis_lokal();
            case 1:
                return list.get(rowIndex).getNama_lengkap_santri();
            case 2:
                return list.get(rowIndex).getTempat_lahir();
            case 3:
                return list.get(rowIndex).getTgl_lahir();
            case 4:
                return list.get(rowIndex).getBln_lahir();
            case 5:
                return list.get(rowIndex).getThn_lahir();
            case 6:
                return list.get(rowIndex).getJenis_kelamin();
            case 7:
                return list.get(rowIndex).getAgama();
            case 8:
                return list.get(rowIndex).getAlamat_santri();
            case 9:
                return list.get(rowIndex).getKecamatan();
            case 10:
                return list.get(rowIndex).getKab_kota();
            case 11:
                return list.get(rowIndex).getProvinsi();
            default:
                return null;
        }
    }

}
