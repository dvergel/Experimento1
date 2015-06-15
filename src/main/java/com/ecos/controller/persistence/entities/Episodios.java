/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.controller.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dev
 */
@Entity
@TableGenerator(name = "seqepisodios", initialValue = 1, allocationSize = 1)
@Table(name = "EPISODIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episodios.findAll", query = "SELECT e FROM Episodios e"),
    @NamedQuery(name = "Episodios.findById", query = "SELECT e FROM Episodios e WHERE e.id = :id"),
    @NamedQuery(name = "Episodios.findByFecha", query = "SELECT e FROM Episodios e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Episodios.findByMedicamentos", query = "SELECT e FROM Episodios e WHERE e.medicamentos = :medicamentos"),
    @NamedQuery(name = "Episodios.findByNiveldolor", query = "SELECT e FROM Episodios e WHERE e.niveldolor = :niveldolor"),
    @NamedQuery(name = "Episodios.findByPatronessueno", query = "SELECT e FROM Episodios e WHERE e.patronessueno = :patronessueno"),
    @NamedQuery(name = "Episodios.findByActividades", query = "SELECT e FROM Episodios e WHERE e.actividades = :actividades"),
    @NamedQuery(name = "Episodios.findByPaciente", query = "SELECT e FROM Episodios e WHERE e.paciente = :paciente")})
public class Episodios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqepisodios")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 4000)
    @Column(name = "MEDICAMENTOS", length = 4000)
    private String medicamentos;
    @Size(max = 4000)
    @Column(name = "NIVELDOLOR", length = 4000)
    private String niveldolor;
    @Size(max = 4000)
    @Column(name = "PATRONESSUENO", length = 4000)
    private String patronessueno;
    @Size(max = 4000)
    @Column(name = "ACTIVIDADES", length = 4000)
    private String actividades;
    @OneToMany(mappedBy = "episodio")
    private List<Diagnostico> diagnosticoList;
    @JoinColumn(name = "PACIENTE", referencedColumnName = "ID")
    @ManyToOne
    private Pacientes paciente;
    @OneToMany(mappedBy = "episodio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Audioepisodio> audioepisodioList;

    public Episodios() {
    }

    public Episodios(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getNiveldolor() {
        return niveldolor;
    }

    public void setNiveldolor(String niveldolor) {
        this.niveldolor = niveldolor;
    }

    public String getPatronessueno() {
        return patronessueno;
    }

    public void setPatronessueno(String patronessueno) {
        this.patronessueno = patronessueno;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    @XmlTransient
    public List<Audioepisodio> getAudioepisodioList() {
        return audioepisodioList;
    }

    public void setAudioepisodioList(List<Audioepisodio> audioepisodioList) {
        this.audioepisodioList = audioepisodioList;
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
        if (!(object instanceof Episodios)) {
            return false;
        }
        Episodios other = (Episodios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ecos.controller.persistence.entities.Episodios[ id=" + id + " ]";
    }
}
