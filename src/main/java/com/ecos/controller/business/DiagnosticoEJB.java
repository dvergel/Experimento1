/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.business;

import com.ecos.controller.persistence.entities.Diagnostico;
import com.ecos.controller.persistence.entities.Pacientes;
import com.ecos.controller.persistence.entities.facades.DiagnosticoFacade;
import com.ecos.exceptions.ExceptionApp;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Dev
 */
@Stateless
public class DiagnosticoEJB {

    @EJB
    DiagnosticoFacade facade;
    
    public Diagnostico consultarId(BigDecimal id) throws Exception {
        return facade.find(id);
    }

    public void save(Diagnostico selectedRecord) throws Exception {
        if (selectedRecord.getId() == null) {
            facade.create(selectedRecord);
        } else {
            facade.edit(selectedRecord);
        }
    }

    public void remove(Diagnostico selectedRecord) throws Exception {
        if (selectedRecord.getId() == null) {
            throw new ExceptionApp("Se debe enviar el id del objeto");
        } else {
            facade.remove(selectedRecord, selectedRecord.getId());
        }
    }
}
