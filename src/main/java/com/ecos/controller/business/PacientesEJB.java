/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.business;

import com.ecos.controller.persistence.entities.Pacientes;
import com.ecos.controller.persistence.entities.facades.PacientesFacade;
import com.ecos.exceptions.ExceptionApp;
import java.math.BigDecimal;
import java.util.Hashtable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Dev
 */
@Stateless
public class PacientesEJB {
    @EJB
    PacientesFacade facade;
    
    public Pacientes consultarId(BigDecimal id) throws Exception {
        return facade.find(id);
    }
    
    public Pacientes consultarIdentificacion(BigDecimal identificacion) throws Exception {
        Hashtable<String, Object> params = new Hashtable<String, Object>();
        params.put("identificacion", identificacion);
        return facade.findByNamedQuery("Pacientes.findByIdentificacion", params).get(0);
    }

    public void save(Pacientes selectedRecord) throws Exception {
        if (selectedRecord.getId() == null) {
            facade.create(selectedRecord);
        } else {
            facade.edit(selectedRecord);
        }
    }

    public void remove(Pacientes selectedRecord) throws Exception {
        if (selectedRecord.getId() == null) {
            throw new ExceptionApp("Se debe enviar el id del objeto");
        } else {
            facade.remove(selectedRecord, selectedRecord.getId());
        }
    }
}
