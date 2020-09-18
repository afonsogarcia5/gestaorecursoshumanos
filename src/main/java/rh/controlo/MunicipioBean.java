/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.MunicipioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import rh.modelo.Municipio;
import rh.modelo.Provincia;

/**
 *
 * @author DGTALE
 */
@Named(value = "municipioBean")
@RequestScoped
public class MunicipioBean {

    MunicipioDAO dao = new MunicipioDAO();
    Municipio municipio = new Municipio();
    List<Municipio> municipios;
    
    List<Municipio> municipiosProvincia;
    
    List<Municipio> municipiosComLetras;

    String nomeDaProvincia;
    
    String letrasNomeMunicipio;
    
    Provincia provincia = new Provincia();

    @PostConstruct
    public void inicizalizar() {
        municipios = new ArrayList<>();
    }

    public List<Municipio> getListaMunicipioos() {
        List<Municipio> lista = new ArrayList<>();
        lista = dao.listaMunicipios();
        return lista;

    }

    public List<Municipio> getListaMunicipiosDaProvincia() {
        municipiosProvincia = new ArrayList<>();
        municipiosProvincia = dao.listaMunicipiosByProvincia(nomeDaProvincia);
        return municipiosProvincia;

    }

    public List<Municipio> getMunicipiosPorLetra(){
    municipiosComLetras = new ArrayList<>();
    municipiosComLetras = dao.listaMunicipiosByNome(letrasNomeMunicipio);
    return municipiosComLetras;
    
    
    }
    
    public List<SelectItem> getSelectMunicipios() {
        List<SelectItem> lista = new ArrayList<>();
        for (Municipio m : dao.listaMunicipios()) {
            lista.add(new SelectItem(m, m.getNomeMunicipio()));
        }
        return lista;
    }

    
    
    
    public String getNomeDaProvincia() {
        return nomeDaProvincia;
    }

    public void setNomeDaProvincia(String nomeDaProvincia) {
        this.nomeDaProvincia = nomeDaProvincia;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getLetrasNomeMunicipio() {
        return letrasNomeMunicipio;
    }

    public void setLetrasNomeMunicipio(String letrasNomeMunicipio) {
        this.letrasNomeMunicipio = letrasNomeMunicipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
    
  public void listaMunicipiosDaProvincia(AjaxBehaviorEvent event){
    municipios = dao.listaMunicipiosDaProvincia(provincia);
    }
}
