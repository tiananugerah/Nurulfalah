/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.model;

import edu.tianam.nurulalah.db.entity.Guru;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author THOSHIBA
 */
public class TabelGuruModel extends AbstractTableModel {

       private List<Guru> list = new ArrayList<Guru>();

    public void setList(List<Guru> list) {
        this.list = list;
    }

    public boolean add(Guru e) {
        
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Guru get(int index) {
        return list.get(index);
    }

    public Guru set(int index, Guru element) {
        
        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }
        
    }

    public Guru remove(int index) {
        
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
        
    }

    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NAMA_GURU";
            case 1:
                return "NO_KTP_GURU";
            case 2:
                return "NO_KK_GURU";
            case 3:
                return "ALAMAT_LENGKAP";
            case 4:
                return "UNIT_KERJA";
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNama_guru();
            case 1:
                return list.get(rowIndex).getNo_ktp_guru();
            case 2:
                return list.get(rowIndex).getNo_kk_guru();
            case 3:
                return list.get(rowIndex).getAlamat_lengkap();
            case 4:
                return list.get(rowIndex).getUnit_kerja();
            default:
                return null;
        }
    }
    
}
