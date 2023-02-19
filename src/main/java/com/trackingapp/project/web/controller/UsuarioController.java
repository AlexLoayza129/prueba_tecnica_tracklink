// Java Program to Illustrate DepartmentController.java File

// Importing packages modules
package com.trackingapp.project.web.controller;

import com.trackingapp.project.entity.User;
import com.trackingapp.project.service.UserService;
import java.util.List;

// Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Validate origin
@CrossOrigin(origins = {"http://localhost:4200"})

// Annotation
@RestController
// Class
public class UsuarioController {

	@Autowired private UserService usuarioService;

	// Save operation
	@PostMapping("/api/usuarios")
	public User saveUsuario(@RequestBody User usuario)
	{
		return usuarioService.saveUsuario(usuario);
	}

	// Read operation
	@GetMapping("/api/usuarios")

	public List<User> fetchUsuarioList()
	{
		return usuarioService.fetchUsuarioList();
	}
	
	// Read operation
    @GetMapping("/api/usuarios/{id}")

    public User getUsuario(@PathVariable("id") Long id)
    {
        return usuarioService.getUsuario(id);
    }

	// Update operation
	@PutMapping("/api/usuarios/{id}")

	public User
	updateUsuario(@RequestBody User usuario,
					@PathVariable("id") Long id)
	{
		return usuarioService.updateUsuario(
			usuario, id);
	}

	// Delete operation
	@DeleteMapping("/api/usuarios/{id}")

	public String deleteUsuarioById(@PathVariable("id")
									Long id)
	{
		usuarioService.deleteUsuarioById(
			id);
		return "Deleted Successfully";
	}

}
