package org.musql.services;

import java.util.List;

import org.musql.dao.RolesRepository;
import org.musql.dao.UsersRepository;
import org.musql.entities.Roles;
import org.musql.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class UsersRestService {

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private RolesRepository rolesRepository;
	
	@RequestMapping(value="/users/add")
	public Users save(Users u)
	{
		return userRepository.save(u);
	}
	
	@RequestMapping(value="/users")
	public List<Users> getListUsers()
	{
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/roles/add")
	public Roles save(Roles r)
	{
		return rolesRepository.save(r);
	}
	
	@RequestMapping(value="/roles")
	public List<Roles> getListRoles()
	{
		return rolesRepository.findAll();
	}
	
	@RequestMapping(value="/users/addRoleUser")
	public Users saveRoleUser(String username,String role)
	{
		Users user=userRepository.findOne(username);
		Roles roles=rolesRepository.findOne(role);
		user.getList_roles().add(roles);
		userRepository.save(user);
		return user;
	}
}
