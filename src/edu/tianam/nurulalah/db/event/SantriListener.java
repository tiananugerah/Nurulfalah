/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tianam.nurulalah.db.event;

import edu.tianam.nurulalah.db.entity.Santri;
import edu.tianam.nurulalah.db.model.SantriModel;

/**
 *
 * @author THOSHIBA
 */
public interface SantriListener {

    public void onInsert(Santri santri);

    public void onDelete();

    public void onUpdate(Santri santri);

    public void onChange(SantriModel model);

}
