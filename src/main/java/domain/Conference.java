/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Conference {
    private String fldTitle;
    private String fldDescription;
    //Organizador de la conferencia
    private User fldConferenceAdmin;
    //Usuarios en la conferencia
    private ArrayList<User> fldUsersList;
    //Papers en la conferencia
    private ArrayList<PaperReview> fldPaperReviewsList;
}
