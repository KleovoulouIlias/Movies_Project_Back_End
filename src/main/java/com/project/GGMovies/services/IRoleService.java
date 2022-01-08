package com.project.GGMovies.services;

import com.project.GGMovies.dtos.RoleDto;

public interface IRoleService {
    
    public RoleDto getRoleById(Integer roleId);
    public RoleDto getRoleByRoleName(String name);
}
