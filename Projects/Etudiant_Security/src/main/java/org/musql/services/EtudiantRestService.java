package org.musql.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.musql.dao.EtudiantRepository;
import org.musql.entities.Etudiants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantRestService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Secured(value="ROLE_ADMIN")
	@RequestMapping(value="/etudiants",method=RequestMethod.POST)
	public Object save(@RequestBody @Valid Etudiants etudiant,BindingResult bindingresult)
	{
		if(bindingresult.hasErrors())
		{
			Map<String,Object> errors=new HashMap<>();
			errors.put("errors", true);
			for(FieldError fe:bindingresult.getFieldErrors())
			{
				errors.put(fe.getField(),fe.getDefaultMessage());
			}
			return errors;
		}
		return etudiantRepository.save(etudiant);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value="/etudiants")
	public Page<Etudiants> listEtudiants(
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="3")int size)
	{
		return etudiantRepository.findAll(new PageRequest(page,size));
	}
	
	@RequestMapping(value="/profile")
	public Map<String, Object> getLogedUser(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
				SecurityContext securityContext=(SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		Collection<String> lists_roles=new ArrayList<>();
		for(GrantedAuthority grante:securityContext.getAuthentication().getAuthorities())
		{
			lists_roles.add(grante.getAuthority());
		}
		Map<String,Object> params=new HashMap<>();
		params.put("username",username);
		params.put("roles", lists_roles);
		
		return params;
		
	}
}
