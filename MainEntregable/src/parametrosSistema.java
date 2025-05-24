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

    public void setNombreEmpresa(String nombreEmpresa) throws parametrosInvalidosException {
        if (nombreEmpresa == null || nombreEmpresa.length() < 3 || nombreEmpresa.length() > 100) {
            throw new parametrosInvalidosException("El nombre de la empresa debe tener entre 3 y 100 caracteres.");
        }
        this.nombreEmpresa = nombreEmpresa;
    }

    private void setLogoEmpresa(String logoEmpresa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setIdioma(String idioma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setZonaHoraria(String zonaHoraria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTiempoVencimientoTickets(int tiempoVencimientoTickets) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setNivelesPrioridad(List<String> nivelesPrioridad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

