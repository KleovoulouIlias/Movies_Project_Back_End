package com.project.GGMovies.services;

import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.models.Role;
import com.project.GGMovies.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface IRoleService {
    
    public RoleDto getRoleById(Integer roleId);
    public RoleDto getRoleByRoleName(String name);
}
