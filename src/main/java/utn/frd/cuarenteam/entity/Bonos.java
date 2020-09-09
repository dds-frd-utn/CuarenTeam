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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fausto
 */
@Entity
@Table(name = "bonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonos.findAll", query = "SELECT b FROM Bonos b"),
    @NamedQuery(name = "Bonos.findById", query = "SELECT b FROM Bonos b WHERE b.id= :id"),
    @NamedQuery(name = "Bonos.findByNum_cuenta", query = "SELECT b FROM Bonos b WHERE b.num_cuenta = :num_cuenta"),
    @NamedQuery(name = "Bonos.findByTipo", query = "SELECT b FROM Bonos b WHERE b.tipo = :tipo")})

public class Bonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cuenta")
    private Integer num_cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tipo")
    private String tipo;

    public Bonos() {
    }

    public Bonos(Integer id) {
        this.id= id;
    }

    public Bonos(Integer id, Integer num_cuenta, String tipo) {
        this.id= id;
        this.num_cuenta = num_cuenta;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { 
        this.id= id;
    }

    /* GetId renombrado a setId */
    
    public Integer getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Bonos)) {
            return false;
        }
        Bonos other = (Bonos) object;
        if ((this.id== null && other.id!= null) || (this.id!= null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.cuarenteam.entity.Bonos[ id=" +id+ " ]";
    }
    
}
