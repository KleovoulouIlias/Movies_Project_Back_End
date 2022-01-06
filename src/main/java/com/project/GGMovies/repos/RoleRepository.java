package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    @Query("SELECT new com.project.GGMovies.dtos.RoleDto(r.roleId, r.name) from Role r where r.name=?1")
    public RoleDto getRoleByRoleName(String name);
    
}
