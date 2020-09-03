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
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t"),
    @NamedQuery(name = "Transacciones.findById", query = "SELECT t FROM Transacciones t WHERE t.id= :id"),
    @NamedQuery(name = "Transacciones.findByCuenta_origen", query = "SELECT t FROM Transacciones t WHERE t.cuenta_origen = :cuenta_origen"),
    @NamedQuery(name = "Transacciones.findByMonto", query = "SELECT t FROM Transacciones t WHERE t.monto = :monto"),
    @NamedQuery(name = "Transacciones.findByCuenta_destino", query = "SELECT t FROM Transacciones t WHERE t.cuenta_destino = :cuenta_destino")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_origen")
    private Integer cuenta_origen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private Float monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_destino")
    private Integer cuenta_destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private String fecha;

    public Transacciones() {
    }

    public Transacciones(Integer id) {
        this.id= id;
    }

    public Transacciones(Integer id, Integer cuenta_origen, Float monto, Integer cuenta_destino,String fecha) {
        this.id= id;
        this.cuenta_origen = cuenta_origen;
        this.monto = monto;
        this.cuenta_destino = cuenta_destino;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void GetId(Integer id) {
        this.id= id;
    }

    public Integer getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(Integer cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
    
    public Integer getCuenta_destino() {
        return cuenta_destino;
    }
    
    public void setCuenta_destino(Integer cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.id== null && other.id!= null) || (this.id!= null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.cuarenteam.entity.Transacciones[ id=" +id+ " ]";
    }
    
}
