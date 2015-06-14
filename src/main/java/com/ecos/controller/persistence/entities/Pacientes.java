/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dev
 */
@Entity
@TableGenerator(name = "seqpacientes", initialValue = 1, allocationSize = 1)
@Table(name = "PACIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findById", query = "SELECT p FROM Pacientes p WHERE p.id = :id"),
    @NamedQuery(name = "Pacientes.findByIdentificacion", query = "SELECT p FROM Pacientes p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "Pacientes.findByPrimernombre", query = "SELECT p FROM Pacientes p WHERE p.primernombre = :primernombre"),
    @NamedQuery(name = "Pacientes.findBySegundonombre", query = "SELECT p FROM Pacientes p WHERE p.segundonombre = :segundonombre"),
    @NamedQuery(name = "Pacientes.findByPrimerapellido", query = "SELECT p FROM Pacientes p WHERE p.primerapellido = :primerapellido"),
    @NamedQuery(name = "Pacientes.findBySegundoapellido", query = "SELECT p FROM Pacientes p WHERE p.segundoapellido = :segundoapellido")})
public class Pacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqpacientes")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Column(name = "IDENTIFICACION")
    private BigInteger identificacion;
    @Size(max = 250)
    @Column(name = "PRIMERNOMBRE", length = 250)
    private String primernombre;
    @Size(max = 250)
    @Column(name = "SEGUNDONOMBRE", length = 250)
    private String segundonombre;
    @Size(max = 250)
    @Column(name = "PRIMERAPELLIDO", length = 250)
    private String primerapellido;
    @Size(max = 250)
    @Column(name = "SEGUNDOAPELLIDO", length = 250)
    private String segundoapellido;
    @OneToMany(mappedBy = "paciente")
    private List<Episodios> episodiosList;

    public Pacientes() {
    }

    public Pacientes(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(BigInteger identificacion) {
        this.identificacion = identificacion;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    @XmlTransient
    public List<Episodios> getEpisodiosList() {
        return episodiosList;
    }

    public void setEpisodiosList(List<Episodios> episodiosList) {
        this.episodiosList = episodiosList;
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
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ecos.controller.persistence.entities.Pacientes[ id=" + id + " ]";
    }
    
}
