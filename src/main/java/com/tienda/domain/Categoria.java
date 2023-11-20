
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")

/*Serialización va a almacenar datos*/
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L; // Para poder hacer el ciclo de la sumatoria de la categoría (AUTO_INCREMENT)
    
    @Id // Id es la llave de la tabla categoría
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") //Nombre específico de la columna de la base de datos
    private long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
}
