/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.persistence.entities.facades;

import com.ecos.controller.persistence.entities.Episodios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dev
 */
@Stateless
public class EpisodiosFacade extends AbstractFacade<Episodios> {

    @PersistenceContext(unitName = "com.ecos_ExperimentoECOS1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EpisodiosFacade() {
        super(Episodios.class);
    }
}
