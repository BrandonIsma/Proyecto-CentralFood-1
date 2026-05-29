package ec.edu.uce.proyectocentralfood.dominio;

public class LocalComida {

    // Atributos base
    private int idLocal;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String horarioAtencion;
    private String estadoLocal;
    private String rangoPrecio;

    // RELACIONES (Arreglos y Objetos)
    private Ubicacion ubicacion;
    private CategoriaGastronomica categoria;
    private Plato[] platos;
    private Resena[] resenas;

    // 1. CONSTRUCTOR VACÍO (Inicializado para evitar NullPointer)
    public LocalComida() {
        this.idLocal = 0;
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripción";
        this.telefono = "0000000000";
        this.horarioAtencion = "00:00-00:00";
        this.estadoLocal = "CERRADO";
        this.rangoPrecio = "MEDIO";

        // Inicialización de asociaciones y arreglos vacíos
        this.ubicacion = new Ubicacion();
        this.categoria = new CategoriaGastronomica();
        this.platos = new Plato[0];
        this.resenas = new Resena[0];
    }

    // 2. CONSTRUCTOR CON PARÁMETROS
    public LocalComida(int idLocal, String nombre, String descripcion, String telefono,
                       String horarioAtencion, String estadoLocal, String rangoPrecio) {
        this(); // Llama al constructor vacío para inicializar los arreglos y objetos primero
        setIdLocal(idLocal);
        setNombre(nombre);
        setDescripcion(descripcion);
        setTelefono(telefono);
        setHorarioAtencion(horarioAtencion);
        setEstadoLocal(estadoLocal);
        setRangoPrecio(rangoPrecio);
    }

    // 3. GETTERS Y SETTERS CON VALIDACIÓN DE FONDO (Sin usar la clase Validador)

    public int getIdLocal() { return idLocal; }
    public boolean setIdLocal(int idLocal) {
        if (idLocal > 0) {
            this.idLocal = idLocal;
            return true;
        }
        return false;
    }

    public String getNombre() { return nombre; }
    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getDescripcion() { return descripcion; }
    public boolean setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
            return true;
        }
        return false;
    }

    public String getTelefono() { return telefono; }
    public boolean setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono;
            return true;
        }
        return false;
    }

    public String getHorarioAtencion() { return horarioAtencion; }
    public boolean setHorarioAtencion(String horarioAtencion) {
        if (horarioAtencion != null && !horarioAtencion.trim().isEmpty()) {
            this.horarioAtencion = horarioAtencion;
            return true;
        }
        return false;
    }

    public String getEstadoLocal() { return estadoLocal; }
    public boolean setEstadoLocal(String estadoLocal) {
        if (estadoLocal != null && !estadoLocal.trim().isEmpty()) {
            this.estadoLocal = estadoLocal;
            return true;
        }
        return false;
    }

    public String getRangoPrecio() { return rangoPrecio; }
    public boolean setRangoPrecio(String rangoPrecio) {
        if (rangoPrecio != null && !rangoPrecio.trim().isEmpty()) {
            this.rangoPrecio = rangoPrecio;
            return true;
        }
        return false;
    }

    // 4. GETTERS Y SETTERS DE ASOCIACIONES

    public Ubicacion getUbicacion() { return ubicacion; }
    public void setUbicacion(Ubicacion ubicacion) {
        if (ubicacion != null) { this.ubicacion = ubicacion; }
    }

    public CategoriaGastronomica getCategoria() { return categoria; }
    public void setCategoria(CategoriaGastronomica categoria) {
        if (categoria != null) { this.categoria = categoria; }
    }

    public Plato[] getPlatos() { return platos; }
    public void setPlatos(Plato[] platos) {
        if (platos != null) { this.platos = platos; }
    }

    public Resena[] getResenas() { return resenas; }
    public void setResenas(Resena[] resenas) {
        if (resenas != null) { this.resenas = resenas; }
    }

    // 5. MÉTODOS DE COMPORTAMIENTO DINÁMICO DE ARREGLOS (La magia para no usar Listas)

    public void agregarPlato(Plato plato) {
        if (plato != null) {
            // Se crea un arreglo temporal con un espacio extra
            Plato[] nuevoArreglo = new Plato[this.platos.length + 1];
            // Se copian los platos antiguos al nuevo arreglo
            System.arraycopy(this.platos, 0, nuevoArreglo, 0, this.platos.length);
            // Se añade el nuevo plato en la última posición
            nuevoArreglo[this.platos.length] = plato;
            // Se sobreescribe el arreglo original
            this.platos = nuevoArreglo;
        }
    }

    public boolean eliminarPlato(int idPlato) {
        int indice = -1;
        // Buscar el índice del plato a eliminar
        for (int i = 0; i < platos.length; i++) {
            if (platos[i].getIdPlato() == idPlato) {
                indice = i;
                break;
            }
        }
        // Si no se encuentra, retorna falso
        if (indice == -1) return false;

        // Se crea un arreglo temporal con un espacio menos
        Plato[] nuevoArreglo = new Plato[this.platos.length - 1];
        // Se copia la primera mitad antes del elemento a borrar
        System.arraycopy(this.platos, 0, nuevoArreglo, 0, indice);
        // Se copia la segunda mitad después del elemento a borrar
        System.arraycopy(this.platos, indice + 1, nuevoArreglo, indice, this.platos.length - indice - 1);

        this.platos = nuevoArreglo;
        return true;
    }

    public void recibirResena(Resena resena) {
        if (resena != null) {
            Resena[] nuevoArreglo = new Resena[this.resenas.length + 1];
            System.arraycopy(this.resenas, 0, nuevoArreglo, 0, this.resenas.length);
            nuevoArreglo[this.resenas.length] = resena;
            this.resenas = nuevoArreglo;
        }
    }

    public boolean eliminarResena(int idResena) {
        int indice = -1;
        for (int i = 0; i < resenas.length; i++) {
            if (resenas[i].getIdResena() == idResena) {
                indice = i;
                break;
            }
        }
        if (indice == -1) return false;

        Resena[] nuevoArreglo = new Resena[this.resenas.length - 1];
        System.arraycopy(this.resenas, 0, nuevoArreglo, 0, indice);
        System.arraycopy(this.resenas, indice + 1, nuevoArreglo, indice, this.resenas.length - indice - 1);
        this.resenas = nuevoArreglo;
        return true;
    }

    // 6. TOSTRING ACTUALIZADO
    @Override
    public String toString() {
        String infoCategoria = (categoria != null && categoria.getNombreCategoria() != null)
                ? categoria.getNombreCategoria() : "Sin categoría";

        return "LocalComida [" +
                "ID: " + idLocal +
                " | Nombre: '" + nombre + '\'' +
                " | Categoría: '" + infoCategoria + '\'' +
                " | Platos Ofertados: " + platos.length +
                " | Reseñas: " + resenas.length +
                ']';
    }
}