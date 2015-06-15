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
import javax.persistence.Lob;
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
@TableGenerator(name = "seqaudioepisodio", initialValue = 1, allocationSize = 1)
@Table(name = "AUDIOEPISODIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audioepisodio.findAll", query = "SELECT a FROM Audioepisodio a"),
    @NamedQuery(name = "Audioepisodio.findById", query = "SELECT a FROM Audioepisodio a WHERE a.id = :id"),
    @NamedQuery(name = "Audioepisodio.findByCampo", query = "SELECT a FROM Audioepisodio a WHERE a.campo = :campo")})
public class Audioepisodio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqaudioepisodio")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Size(max = 30)
    @Column(name = "CAMPO", length = 30)
    private String campo;
    @Lob
    @Column(name = "AUDIO")
    private byte[] audio;
    @JoinColumn(name = "EPISODIO", referencedColumnName = "ID")
    @ManyToOne
    private Episodios episodio;

    public Audioepisodio() {
    }

    public Audioepisodio(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
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
        if (!(object instanceof Audioepisodio)) {
            return false;
        }
        Audioepisodio other = (Audioepisodio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ecos.controller.persistence.entities.Audioepisodio[ id=" + id + " ]";
    }
    
}
