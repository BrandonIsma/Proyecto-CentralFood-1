package ec.edu.uce.proyectocentralfood.dominio;

public class LocalInterno extends LocalComida {

    private String bloque;
    private boolean tieneMicroondas;
    private boolean tieneComedor;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public LocalInterno() {
        super(); // Llama al constructor vacío de LocalComida (inicializa los arreglos de Platos y Reseñas)
        this.bloque = "Sin asignar";
        this.tieneMicroondas = false;
        this.tieneComedor = false;
    }

    // CONSTRUCTOR PARAMETRIZADO (AQUÍ SE IMPLEMENTAN LAS RELACIONES)
    public LocalInterno(int idLocal, String nombre, String descripcion, String telefono,
                        String horarioAtencion, String estadoLocal, String rangoPrecio,
                        Ubicacion ubicacion, CategoriaGastronomica categoria, // <- Relaciones implementadas
                        String bloque, boolean tieneMicroondas, boolean tieneComedor) {

        // Llamada a la superclase para que gestione sus propios atributos básicos
        super(idLocal, nombre, descripcion, telefono, horarioAtencion, estadoLocal, rangoPrecio);

        // Asignamos las relaciones usando los métodos heredados del padre
        setUbicacion(ubicacion);
        setCategoria(categoria);

        setBloque(bloque);
        setTieneMicroondas(tieneMicroondas);
        setTieneComedor(tieneComedor);
    }

    // MÉTODOS ACCESORES Y MODIFICADORES
    public String getBloque() {
        return bloque;
    }

    public boolean setBloque(String bloque) {
        if (bloque != null && !bloque.trim().isEmpty()) {
            this.bloque = bloque;
            return true;
        }
        return false;
    }

    public boolean isTieneMicroondas() {
        return tieneMicroondas;
    }

    public void setTieneMicroondas(boolean tieneMicroondas) {
        this.tieneMicroondas = tieneMicroondas;
    }

    public boolean isTieneComedor() {
        return tieneComedor;
    }

    public void setTieneComedor(boolean tieneComedor) {
        this.tieneComedor = tieneComedor;
    }

    // MÉTODO DE LÓGICA DE NEGOCIO
    public String consultarFacilidades() {
        if (tieneComedor && tieneMicroondas) {
            return "Cuenta con mesas y microondas disponible.";
        } else if (tieneComedor) {
            return "Cuenta con área de mesas para comer.";
        } else if (tieneMicroondas) {
            return "Solo cuenta con microondas para calentar.";
        } else {
            return "No cuenta con área de comedor ni microondas.";
        }
    }

    // POLIMORFISMO
    @Override
    public String toString() {
        return super.toString() +
                "\n   [INFO INTERNA] -> Bloque: '" + bloque + "' | Facilidades: " + consultarFacilidades();
    }
}