package ec.edu.uce.proyectocentralfood.dominio;

public class LocalExterno extends LocalComida {

    private String callePrincipal;
    private boolean esHuecaTradicional;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public LocalExterno() {
        super();
        this.callePrincipal = "Sin asignar";
        this.esHuecaTradicional = false;
    }

    // CONSTRUCTOR PARAMETRIZADO (AQUÍ SE IMPLEMENTAN LAS RELACIONES)
    public LocalExterno(int idLocal, String nombre, String descripcion, String telefono,
                        String horarioAtencion, String estadoLocal, String rangoPrecio,
                        Ubicacion ubicacion, CategoriaGastronomica categoria, // <- Relaciones implementadas
                        String callePrincipal, boolean esHuecaTradicional) {

        super(idLocal, nombre, descripcion, telefono, horarioAtencion, estadoLocal, rangoPrecio);

        // Asignamos las relaciones usando los métodos heredados del padre
        setUbicacion(ubicacion);
        setCategoria(categoria);

        setCallePrincipal(callePrincipal);
        setEsHuecaTradicional(esHuecaTradicional);
    }

    // MÉTODOS ACCESORES Y MODIFICADORES
    public String getCallePrincipal() {
        return callePrincipal;
    }

    public boolean setCallePrincipal(String callePrincipal) {
        if (callePrincipal != null && !callePrincipal.trim().isEmpty()) {
            this.callePrincipal = callePrincipal;
            return true;
        }
        return false;
    }

    public boolean isEsHuecaTradicional() {
        return esHuecaTradicional;
    }

    public void setEsHuecaTradicional(boolean esHuecaTradicional) {
        this.esHuecaTradicional = esHuecaTradicional;
    }

    // MÉTODO DE LÓGICA DE NEGOCIO
    public String promocionarLocal() {
        if (esHuecaTradicional) {
            return "⭐ ¡Hueca Tradicional Recomendada por la comunidad!";
        }
        return "Local ubicado en los alrededores de la UCE.";
    }

    // POLIMORFISMO
    @Override
    public String toString() {
        return super.toString() +
                "\n   [INFO EXTERNA] -> Calle: '" + callePrincipal + "' | " + promocionarLocal();
    }
}