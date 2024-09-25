/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paper;

import dataAccess.user.RepositorySQLiteUser;
import domain.Paper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author julia
 * @author Juan
 */
public class RepositoryArrayListPaper implements IRepositoryPaper{
    private Connection conn;
    private ArrayList<Paper> PaperList;
     /**
     * Instancia un objeto de la clase PaperStoreService
     * @param objRepositoryPaperRef Repositorio que utilizara el servicio
     */
    public RepositoryArrayListPaper() {
        this.PaperList = new ArrayList();
        initDatabase();
    }
     /**
     * Guarda un paper
     * @param objPaper Paper a guardar
     * @return si el guardado fue correcto
     */
    @Override
    public boolean storePaper(Paper objPaper) {

        try {
            this.conect();
            String insertPaper = "INSERT INTO Paper VALUES(?, ?, ?)";

            PreparedStatement pst=conn.prepareStatement(insertPaper);
            pst.setString(1, objPaper.getFldTitle());
            pst.setString(2, objPaper.getFldDescription());
            pst.setString(3, objPaper.getFldAutor().getUserEmail());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeconection();
        boolean varFlag=this.PaperList.add(objPaper);
        return varFlag;
    }
    /**
     * Lista los papers
     * @return lista de papers
     */
    @Override
    public List<Paper> listPaper() {
        RepositorySQLiteUser repoUser=new RepositorySQLiteUser();
        ArrayList<Paper> List=new ArrayList<>();
        try {
            String listPaper = "SELECT * FROM Paper";

            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(listPaper);
            while(rs.next()){
                Paper newPaper=new Paper();
                newPaper.setFldTitle(rs.getString(1));
                newPaper.setFldDescription(rs.getString(2));
                newPaper.setFldAutor(repoUser.getUserByEmail(rs.getString(3)));
                List.add(newPaper);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeconection();
        return List;
    }

    public void initDatabase(){
        try{
            this.conect();
            String tablePaper="CREATE TABLE IF NOT EXISTS Paper(\n "
                    +"fldTitle text NOT NULL,\n"
                    +"fldDescription text NOT NULL,\n"
                    +"fldEmail text NOT NULL,\n"
                    +"FOREIGN KEY (fldEmail) REFERENCES User(fldEmail)\n"
                    +");";

            Statement st= conn.createStatement();
            st.execute(tablePaper);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeconection();
    }

    public void conect(){
        String URL="jdbc:sqlite:MyBd.db";
        try{
            conn=DriverManager.getConnection(URL);
        }catch (SQLException e){
            System.out.println("Fallo conexion a la base de datos");
            e.printStackTrace();
        }
    }

    public void closeconection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Base de datos");
                e.printStackTrace();
            }
        }
    }
    
}
