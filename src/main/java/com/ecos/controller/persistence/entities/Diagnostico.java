/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dev
 */
@Entity
@TableGenerator(name = "seqdiagnostico", initialValue = 1, allocationSize = 1)
@Table(name = "DIAGNOSTICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findById", query = "SELECT d FROM Diagnostico d WHERE d.id = :id"),
    @NamedQuery(name = "Diagnostico.findByCatalizadoresdolor", query = "SELECT d FROM Diagnostico d WHERE d.catalizadoresdolor = :catalizadoresdolor"),
    @NamedQuery(name = "Diagnostico.findByFormula", query = "SELECT d FROM Diagnostico d WHERE d.formula = :formula")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqdiagnostico")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "CATALIZADORESDOLOR", length = 4000)
    private String catalizadoresdolor;
    @Size(max = 4000)
    @Column(name = "FORMULA", length = 4000)
    private String formula;
    @JoinColumn(name = "EPISODIO", referencedColumnName = "ID")
    @ManyToOne
    private Episodios episodio;

    public Diagnostico() {
    }

    public Diagnostico(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCatalizadoresdolor() {
        return catalizadoresdolor;
    }

    public void setCatalizadoresdolor(String catalizadoresdolor) {
        this.catalizadoresdolor = catalizadoresdolor;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Episodios getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Episodios episodio) {
        this.episodio = episodio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ecos.controller.persistence.entities.Diagnostico[ id=" + id + " ]";
    }
    
}
