package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.springjpa.model.Role;
@Service
public interface RoleRepository extends JpaRepository<Role,Long>{
    @Query(value="SELECT idrole,Role FROM role ",nativeQuery = true)
    List<Role> findallRoles();
    
    @Query(value="SELECT idrole FROM role a WHERE a.id = :id ",nativeQuery = true)
    int findByid(@Param("id") int id);
  
}
