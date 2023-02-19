// Java Program to Illustrate DepartmentServiceImpl.java
// File

// Importing required packages
package com.trackingapp.project.service;

import com.trackingapp.project.entity.User;
import com.trackingapp.project.repository.UserRepository;

// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class implementing DepartmentService class
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	// Save operation
	@Override
	public User saveUsuario(User usuario)
	{
		return userRepository.save(usuario);
	}
	
	// Read operation
	@Override public List<User> fetchUsuarioList()
	{
		return (List<User>)
		userRepository.findAll();
	}
	
	// Read operation
    @Override public User getUsuario(Long id)
    {
        return userRepository.findById(id).get();
    }

	// Update operation
	@Override
	public User
	updateUsuario(User usuario,Long id)
	{

		User Usuario = userRepository.findById(id).get();

		if (Objects.nonNull(usuario.getUsername())
			&& !"".equalsIgnoreCase(
					usuario.getUsername())) {
			Usuario.setUsername(
					usuario.getUsername());
		}

		return userRepository.save(Usuario);
	}

	// Delete operation
	@Override
	public void deleteUsuarioById(Long id)
	{
		userRepository.deleteById(id);
	}

}
