/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.event;

import edu.tianam.nurulalah.db.entity.Guru;
import edu.tianam.nurulalah.db.model.GuruModel;

/**
 *
 * @author THOSHIBA
 */
public interface GuruListener {

    public void onInsert(Guru Guru);

    public void onDelete();

    public void onUpdate(Guru guru);

    public void onChange(GuruModel model);
}
