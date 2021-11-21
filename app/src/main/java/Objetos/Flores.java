package Objetos;

public class Flores {
    int id;
    String[] tipos = {"Rosas", "Margaritas", "Gladiolos", "lirios", "Tulipanes"};
    int[] precio = {2500, 2000, 1500, 2000, 2000};

    public Flores() {
        id = 1;
    }

    public Flores(int id, String[] tipos, int[] precio) {
        this.id = id;
        this.tipos = tipos;
        this.precio = precio;
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

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }


    //////////////////////////






    public int calcular_PrecioTotal1Docena(int precio, int precios)
    {
        int total = precios + (precio * 12);
        return total;
    }

    public int calcular_PrecioTotal2Docena(int precio, int precios)
    {
        int total = precios + (precio * 24);
        return total;
    }
}