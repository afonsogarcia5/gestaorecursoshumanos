/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.controlo;

import dao.DepartamentoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import rh.modelo.Departamento;
import rh.modelo.Funcionario;
import rh.modelo.Sexo;

/**
 *
 * @author DGTALE
 */
@Named(value = "funcionarioCDIBean")
@SessionScoped
public class FuncionarioCDIBean implements Serializable {

    Funcionario funcionario = new Funcionario();
    DepartamentoDAO dao = new DepartamentoDAO();
    List<Funcionario> funcionarios;

    @PostConstruct
    public void inicizalizar() {
        funcionarios = new ArrayList<>();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<SelectItem> getSelectDepartamentos() {
        List<SelectItem> lista = new ArrayList<>();
        for (Departamento d : dao.listaDepartamentos()) {
            lista.add(new SelectItem(d, d.getNome()));
        }
        return lista;
    }
    
     public List<SelectItem> getSelectSexos() {
        List<SelectItem> lista = new ArrayList<>();
        for (Sexo s : Sexo.values()) {
            lista.add(new SelectItem(s, s.getExtensao()));
        }
        return lista;
    }
    

    public List<Departamento> getListaDepartamentos() {
        List<Departamento> lista = new ArrayList<>();
        lista = dao.listaDepartamentos();
        return lista;

    }

    public String guardar() {

        funcionarios.add(funcionario);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String meuNome = "Joaquim Hangalo";

        FacesMessage facesMessage
                = new FacesMessage(null, "Funcionario Guardado com sucesso" + " " + meuNome);

        facesContext.addMessage(null, facesMessage);

        return "lista-funcionarios";
    }

}
