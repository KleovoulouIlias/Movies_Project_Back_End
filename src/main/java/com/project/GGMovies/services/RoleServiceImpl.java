package com.project.GGMovies.services;

import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.models.Role;
import com.project.GGMovies.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService{
    
    
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public RoleDto getRoleById(Integer roleId){
        
        return new RoleDto(roleRepository.getById(roleId));
    }

    @Override
    public RoleDto getRoleByRoleName(String name) {
        return roleRepository.getRoleByRoleName(name);
    }
}
