package com.getgames.resource;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.getgames.model.Usuario;
import com.getgames.repository.usuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")

public class UsuarioResource {

	@Autowired
	private usuarioRepository usuarios;

	@PostMapping("/cadastrar")
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarios.save(usuario);

	}

	@GetMapping("")
	public List<Usuario> listar() {
		return usuarios.findAll()  ;
	}
	

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		Usuario usuario = usuarios.findOne(id);
		if (usuario == null) {	
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		Usuario existente = usuarios.findOne(id);
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(usuario, existente, "id");
		existente = usuarios.save(existente);
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Usuario usuario = usuarios.findOne(id);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		usuarios.delete(usuario);
		return ResponseEntity.noContent().build();
	}
	
	  @RequestMapping("/login")
	    public boolean login(@RequestBody Usuario usuario) {
	        return
	        usuario.getEmail().equals("email") && usuario.getPassword().equals("password");
	    }
	     
	  @RequestMapping("/usuario")
	    public Principal usuario(HttpServletRequest request) {
	        String authToken = request.getHeader("Authorization")
	          .substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	    }
	  }
