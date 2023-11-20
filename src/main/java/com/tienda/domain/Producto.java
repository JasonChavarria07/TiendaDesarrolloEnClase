package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")

/*Serialización va a almacenar datos*/
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L; // Para poder hacer el ciclo de la sumatoria de la categoría (AUTO_INCREMENT)

    @Id // Id es la llave de la tabla categoría
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto") //Nombre específico de la columna de la base de datos
    private long idProducto;
    //private long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_categoria", updatable=false)
    List<Producto> productos;

    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
