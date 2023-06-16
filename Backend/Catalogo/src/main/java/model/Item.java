
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="items")
public class Item {
    @Id
    private String codigo;
    private String nombre;
    private BigDecimal precio;
    private String URL;
    private Integer s;
    private Integer m;
    private Integer l;

    public Item() {
    }

    public Item(String codigo, String nombre, BigDecimal precio, String URL, Integer s, Integer m, Integer l) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.URL = URL;
        this.s = s;
        this.m = m;
        this.l = l;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * @return the s
     */
    public Integer getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Integer s) {
        this.s = s;
    }

    /**
     * @return the m
     */
    public Integer getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Integer m) {
        this.m = m;
    }

    /**
     * @return the l
     */
    public Integer getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(Integer l) {
        this.l = l;
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    
}
