/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositoryArrayListConference implements IRepositoryConference{
    private ArrayList<Conference> ConferenceList;

    public RepositoryArrayListConference(ArrayList<Conference> ConferenceList) {
        this.ConferenceList = new ArrayList();
    }

    @Override
    public boolean storeConference(Conference objConference) {
        boolean varFlag=this.ConferenceList.add(objConference);
        return varFlag;
    }

    @Override
    public List<Conference> listConference() {
        return this.ConferenceList;
    }
    
}
