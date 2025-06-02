
package model;

/**
 *
 * @author 52551
 */
public class EspaciosFisicos {
    private String tipoEspacio;
    private int capacidadPersonas;
    private String caracteristicasEspacio;

    public EspaciosFisicos() {
    }

    public EspaciosFisicos(String tipoEspacio, int capacidadPersonas, String caracteristicasEspacio) {
        this.tipoEspacio = tipoEspacio;
        this.capacidadPersonas = capacidadPersonas;
        this.caracteristicasEspacio = caracteristicasEspacio;
    }

    public String getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(String tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public String getCaracteristicasEspacio() {
        return caracteristicasEspacio;
    }

    public void setCaracteristicasEspacio(String caracteristicasEspacio) {
        this.caracteristicasEspacio = caracteristicasEspacio;
    }
    
    
}
