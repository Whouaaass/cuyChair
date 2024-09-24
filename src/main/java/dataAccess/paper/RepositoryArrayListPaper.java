/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paper;

import domain.Paper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositoryArrayListPaper implements IRepositoryPaper{
    private ArrayList<Paper> PaperList;
     /**
     * Instancia un objeto de la clase PaperStoreService
     * @param objRepositoryPaperRef Repositorio que utilizara el servicio
     */
    public RepositoryArrayListPaper(ArrayList<Paper> PaperList) {
        this.PaperList = new ArrayList();
    }
     /**
     * Guarda un paper
     * @param objPaper Paper a guardar
     * @return si el guardado fue correcto
     */
    @Override
    public boolean storePaper(Paper objPaper) {
        boolean varFlag=this.PaperList.add(objPaper);
        return varFlag;
    }
    /**
     * Lista los papers
     * @return lista de papers
     */
    @Override
    public List<Paper> listPaper() {
        return this.PaperList;
    }
    
}
