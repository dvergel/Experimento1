/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.business;

import com.ecos.controller.persistence.entities.Episodios;
import com.ecos.controller.persistence.entities.facades.EpisodiosFacade;
import com.ecos.exceptions.ExceptionApp;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Dev
 */
public class EpisodiosEJB {
    @EJB
    EpisodiosFacade facade;
    
    public Episodios consultarId(BigDecimal id) throws Exception {
        return facade.find(id);
    }
    
    public List<Episodios> consultarLista(BigDecimal paciente) throws Exception {
        Hashtable<String, Object> params = new Hashtable<String, Object>();
        params.put("paciente", paciente);
        return facade.findByNamedQuery("Episodios.findByPaciente", params);
    }


    public void save(Episodios selectedRecord) throws Exception {
        if (selectedRecord.getId() == null) {
            facade.create(selectedRecord);
        } else {
            facade.edit(selectedRecord);
        }
    }

    public void remove(Episodios selectedRecord) throws Exception {
        if (selectedRecord.getId() == null) {
            throw new ExceptionApp("Se debe enviar el id del objeto");
        } else {
            facade.remove(selectedRecord, selectedRecord.getId());
        }
    }
    
}
