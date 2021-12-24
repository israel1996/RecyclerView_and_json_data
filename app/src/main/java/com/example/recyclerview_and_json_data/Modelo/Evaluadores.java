package com.example.recyclerview_and_json_data.Modelo;

public class Evaluadores {
    private String idevaluador;
    private String nombres;
    private String area;
    private String urlImagenJPG;
    private String urlImagenjpg;

    public Evaluadores(){ }

    public Evaluadores(String idevaluador, String nombres, String area, String urlImagenJPG, String urlImagenjpg) {
        this.idevaluador = idevaluador;
        this.nombres = nombres;
        this.area = area;
        this.urlImagenJPG = urlImagenJPG;
        this.urlImagenjpg = urlImagenjpg;
    }

    public String getIdevaluador() {
        return idevaluador;
    }

    public void setIdevaluador(String idevaluador) {
        this.idevaluador = idevaluador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUrlImagenJPG() {
        return urlImagenJPG;
    }

    public void setUrlImagenJPG(String urlImagenJPG) {
        this.urlImagenJPG = urlImagenJPG;
    }

    public String getUrlImagenjpg() {
        return urlImagenjpg;
    }

    public void setUrlImagenjpg(String urlImagenjpg) {
        this.urlImagenjpg = urlImagenjpg;
    }

}
