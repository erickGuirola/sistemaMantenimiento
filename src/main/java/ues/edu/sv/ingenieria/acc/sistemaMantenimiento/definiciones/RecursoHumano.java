
package ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author erick
 */

@Entity
@Table(name = "recurso_humano", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursoHumano.findAll", query = "SELECT r FROM RecursoHumano r")
    , @NamedQuery(name = "RecursoHumano.findByIdRecursoHumano", query = "SELECT r FROM RecursoHumano r WHERE r.idRecursoHumano = :idRecursoHumano")
    , @NamedQuery(name = "RecursoHumano.findByNombre", query = "SELECT r FROM RecursoHumano r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "RecursoHumano.findByApellido", query = "SELECT r FROM RecursoHumano r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "RecursoHumano.findByTelefono", query = "SELECT r FROM RecursoHumano r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "RecursoHumano.findByObservaciones", query = "SELECT r FROM RecursoHumano r WHERE r.observaciones = :observaciones")})

public class RecursoHumano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recurso_humano", nullable = false)
    private Integer idRecursoHumano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Size(max = 8)
    @Column(name = "telefono", length = 8)
    private String telefono;
    @Size(max = 200)
    @Column(name = "observaciones", length = 200)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecursoHumano")
    private List<OrdenTrabajo> ordenTrabajoList;

    public RecursoHumano() {
    }

    public RecursoHumano(Integer idRecursoHumano) {
        this.idRecursoHumano = idRecursoHumano;
    }

    public RecursoHumano(Integer idRecursoHumano, String nombre, String apellido) {
        this.idRecursoHumano = idRecursoHumano;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdRecursoHumano() {
        return idRecursoHumano;
    }

    public void setIdRecursoHumano(Integer idRecursoHumano) {
        this.idRecursoHumano = idRecursoHumano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @JsonbTransient
    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecursoHumano != null ? idRecursoHumano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoHumano)) {
            return false;
        }
        RecursoHumano other = (RecursoHumano) object;
        if ((this.idRecursoHumano == null && other.idRecursoHumano != null) || (this.idRecursoHumano != null && !this.idRecursoHumano.equals(other.idRecursoHumano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.ingenieria.acc.sistemaMantenimiento.definiciones.RecursoHumano[ idRecursoHumano=" + idRecursoHumano + " ]";
    }
    
}
