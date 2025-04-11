import java.util.List;
import main.parametrosInvalidosException;

public class parametrosSistema {
    private String nombreEmpresa;
    private String logoEmpresa;
    private String idioma;
    private String zonaHoraria;
    private int tiempoVencimientoTickets;
    private List<String> nivelesPrioridad;

    public parametrosSistema(String nombreEmpresa, String logoEmpresa, String idioma, String zonaHoraria,
                             int tiempoVencimientoTickets, List<String> nivelesPrioridad) throws parametrosInvalidosException {
        setNombreEmpresa(nombreEmpresa);
        setLogoEmpresa(logoEmpresa);
        setIdioma(idioma);
        setZonaHoraria(zonaHoraria);
        setTiempoVencimientoTickets(tiempoVencimientoTickets);
        setNivelesPrioridad(nivelesPrioridad);
    }

    // Getters y setters con validación
    public String getNombreEmpresa() { return nombreEmpresa; }

    public void setNombreEmpresa(String nombreEmpresa) throws parametrosInvalidosException {
        if (nombreEmpresa == null || nombreEmpresa.length() < 3 || nombreEmpresa.length() > 100) {
            throw new parametrosInvalidosException("El nombre de la empresa debe tener entre 3 y 100 caracteres.");
        }
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLogoEmpresa() { return logoEmpresa; }

    public void setLogoEmpresa(String logoEmpresa) throws parametrosInvalidosException {
        if (logoEmpresa == null || !(logoEmpresa.endsWith(".jpg") || logoEmpresa.endsWith(".png"))) {
            throw new parametrosInvalidosException("El logo debe ser un archivo .jpg o .png.");
        }
        this.logoEmpresa = logoEmpresa;
    }

    public String getIdioma() { return idioma; }

    public void setIdioma(String idioma) throws parametrosInvalidosException {
        if (!(idioma.equals("Español") || idioma.equals("Inglés"))) {
            throw new parametrosInvalidosException("Idioma no soportado. Solo Español o Inglés.");
        }
        this.idioma = idioma;
    }

    public String getZonaHoraria() { return zonaHoraria; }

    public void setZonaHoraria(String zonaHoraria) throws parametrosInvalidosException {
        if (zonaHoraria == null || zonaHoraria.isEmpty()) {
            throw new parametrosInvalidosException("Debe seleccionar una zona horaria válida.");
        }
        this.zonaHoraria = zonaHoraria;
    }

    public int getTiempoVencimientoTickets() { return tiempoVencimientoTickets; }

    public void setTiempoVencimientoTickets(int tiempoVencimientoTickets) throws parametrosInvalidosException {
        if (tiempoVencimientoTickets < 1 || tiempoVencimientoTickets > 365) {
            throw new parametrosInvalidosException("El tiempo de vencimiento debe estar entre 1 y 365 días.");
        }
        this.tiempoVencimientoTickets = tiempoVencimientoTickets;
    }

    public List<String> getNivelesPrioridad() { return nivelesPrioridad; }

    public void setNivelesPrioridad(List<String> nivelesPrioridad) throws parametrosInvalidosException {
        if (nivelesPrioridad == null || nivelesPrioridad.size() < 3) {
            throw new parametrosInvalidosException("Debe haber al menos 3 niveles de prioridad.");
        }
        this.nivelesPrioridad = nivelesPrioridad;
    }

    public void mostrarParametros() {
        System.out.println("Configuración del sistema:");
        System.out.println("Empresa: " + nombreEmpresa);
        System.out.println("Logo: " + logoEmpresa);
        System.out.println("Idioma: " + idioma);
        System.out.println("Zona Horaria: " + zonaHoraria);
        System.out.println("Vencimiento Tickets: " + tiempoVencimientoTickets + " días");
        System.out.println("Prioridades: " + nivelesPrioridad);
    }
}

