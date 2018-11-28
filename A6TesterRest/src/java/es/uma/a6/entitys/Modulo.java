/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m")
    , @NamedQuery(name = "Modulo.findByNombre", query = "SELECT m FROM Modulo m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Modulo.findByAlpha", query = "SELECT m FROM Modulo m WHERE m.alpha = :alpha")
    , @NamedQuery(name = "Modulo.findByBeta", query = "SELECT m FROM Modulo m WHERE m.beta = :beta")
    , @NamedQuery(name = "Modulo.findByGamma", query = "SELECT m FROM Modulo m WHERE m.gamma = :gamma")
    , @NamedQuery(name = "Modulo.findByKappa", query = "SELECT m FROM Modulo m WHERE m.kappa = :kappa")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALPHA")
    private double alpha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BETA")
    private double beta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAMMA")
    private double gamma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KAPPA")
    private double kappa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo1")
    private List<Campanya> campanyaList;

    public Modulo() {
    }

    public Modulo(String nombre) {
        this.nombre = nombre;
    }

    public Modulo(String nombre, double alpha, double beta, double gamma, double kappa) {
        this.nombre = nombre;
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
        this.kappa = kappa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public double getKappa() {
        return kappa;
    }

    public void setKappa(double kappa) {
        this.kappa = kappa;
    }

    @XmlTransient
    public List<Campanya> getCampanyaList() {
        return campanyaList;
    }

    public void setCampanyaList(List<Campanya> campanyaList) {
        this.campanyaList = campanyaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uma.a6.entitys.Modulo[ nombre=" + nombre + " ]";
    }
    
}
