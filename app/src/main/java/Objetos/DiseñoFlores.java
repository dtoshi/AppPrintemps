package Objetos;

public class DiseñoFlores {
    int id;
    String [] tipos = {"Arreglos Florales","Caja de Flores","Ramos"};
    int[] precios = {20000, 15000, 9000};

    public DiseñoFlores(){
        id = 1;
    }

    public DiseñoFlores(int id, String[] tipos, int[] precios) {
        this.id = id;
        this.tipos = tipos;
        this.precios = precios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

}
