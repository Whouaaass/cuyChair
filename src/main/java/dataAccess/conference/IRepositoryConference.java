/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
import java.util.List;

/**
 *
 * @author julia
 */
public interface IRepositoryConference {
    public boolean storeConference(Conference objConference);
    public List<Conference> listConference();
}
