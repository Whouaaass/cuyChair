/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.user;

import domain.user;
import java.util.List;

/**
 *
 * @author julia
 */
public interface IRepositoryUser {
    public boolean storeUser(user objUser);
    public List<user> listUser();
}
