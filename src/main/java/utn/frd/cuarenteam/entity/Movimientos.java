/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.cuarenteam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fausto
 */
@Entity
@Table(name = "movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT t FROM Movimientos t"),
    @NamedQuery(name = "Movimientos.findById", query = "SELECT t FROM Movimientos t WHERE t.id= :id"),
    @NamedQuery(name = "Movimientos.findByFecha", query = "SELECT t FROM Movimientos t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Movimientos.findByTipo", query = "SELECT t FROM Movimientos t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Movimientos.findByMonto", query = "SELECT t FROM Movimientos t WHERE t.monto = :monto"),
    @NamedQuery(name = "Movimientos.findByCuenta", query = "SELECT t FROM Movimientos t WHERE t.cuenta = :cuenta")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta")
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private Integer monto;

    public Movimientos() {
    }

    public Movimientos(Integer id) {
        this.id= id;
    }

    public Movimientos(Integer id, String fecha, String tipo, Integer monto) {
        this.id= id;
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void GetId(Integer id) {
        this.id= id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Integer getMonto() {
        return monto;
    }
    
    public void setMonto(Integer monto) {
        this.monto = monto;
    }
    
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id!= null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case theidfields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.id== null && other.id!= null) || (this.id!= null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.cuarenteam.entity.Movimientos[ id=" +id+ " ]";
    }
    
}
