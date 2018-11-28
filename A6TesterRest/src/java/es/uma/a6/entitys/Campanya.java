/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.a6.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "CAMPANYA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campanya.findAll", query = "SELECT c FROM Campanya c")
    , @NamedQuery(name = "Campanya.findByNombre", query = "SELECT c FROM Campanya c WHERE c.campanyaPK.nombre = :nombre")
    , @NamedQuery(name = "Campanya.findByFecha", query = "SELECT c FROM Campanya c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Campanya.findByModulo", query = "SELECT c FROM Campanya c WHERE c.campanyaPK.modulo = :modulo")})
public class Campanya implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampanyaPK campanyaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "MODULO", referencedColumnName = "NOMBRE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulo modulo1;

    public Campanya() {
    }

    public Campanya(CampanyaPK campanyaPK) {
        this.campanyaPK = campanyaPK;
    }

    public Campanya(CampanyaPK campanyaPK, Date fecha) {
        this.campanyaPK = campanyaPK;
        this.fecha = fecha;
    }

    public Campanya(String nombre, String modulo) {
        this.campanyaPK = new CampanyaPK(nombre, modulo);
    }

    public CampanyaPK getCampanyaPK() {
        return campanyaPK;
    }

    public void setCampanyaPK(CampanyaPK campanyaPK) {
        this.campanyaPK = campanyaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Modulo getModulo1() {
        return modulo1;
    }

    public void setModulo1(Modulo modulo1) {
        this.modulo1 = modulo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campanyaPK != null ? campanyaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campanya)) {
            return false;
        }
        Campanya other = (Campanya) object;
        if ((this.campanyaPK == null && other.campanyaPK != null) || (this.campanyaPK != null && !this.campanyaPK.equals(other.campanyaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uma.a6.entitys.Campanya[ campanyaPK=" + campanyaPK + " ]";
    }
    
}
