
// Java Program to Illustrate DepartmentService.java File
 
// Importing packages
package com.trackingapp.project.service;
import com.trackingapp.project.entity.User;
// Importing required classes
import java.util.List;
 
// Class
public interface UserService{
 
    // Save operation
	User saveUsuario(User usuario);
 
    // Read operation
    List<User> fetchUsuarioList();
 
    // Update operation
    User updateUsuario(User usuario,
                                Long id);
 
    // Delete operation
    void deleteUsuarioById(Long id);

    User getUsuario(Long id);

}