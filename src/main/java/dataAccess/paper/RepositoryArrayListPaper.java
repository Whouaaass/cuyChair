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

    public RepositoryArrayListPaper(ArrayList<Paper> PaperList) {
        this.PaperList = new ArrayList();
    }
    
    @Override
    public boolean storePaper(Paper objPaper) {
        boolean varFlag=this.PaperList.add(objPaper);
        return varFlag;
    }

    @Override
    public List<Paper> listPaper() {
        return this.PaperList;
    }
    
}
