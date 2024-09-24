/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.paper;

import domain.Paper;
import java.util.List;

/**
 *
 * @author julia
 */
public interface IRepositoryPaper {
    public boolean storePaper(Paper objPaper);
    public List<Paper> listPaper();
}
