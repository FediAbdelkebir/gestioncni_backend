package com.springjpa.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.springjpa.model.Customer;
@Service
public interface CustomerRepository extends JpaRepository<Customer,Long>{


    @Query(value="SELECT email,password FROM customer a WHERE a.email = :email AND a.password = :password ",nativeQuery = true)
    String findCustomer(@Param("email") String email, @Param("password") String password);
    
    @Query(value="SELECT * FROM customer WHERE id_structure = :CodeStruct ",nativeQuery = true)
	List<Customer> findAllCustomers(@Param("CodeStruct") String CodeStruct);
    
    @Query(value="SELECT * FROM customer a WHERE a.email = :email ",nativeQuery = true)
    int find(@Param("email") String email);
    
    @Query(value="SELECT id FROM customer a WHERE a.email = :email ",nativeQuery = true)
    int findid(@Param("email") String email);
    
    /*Te5dm Donc Najem nkml*/
    @Query(value="SELECT idrole FROM customer a WHERE a.id = :id",nativeQuery = true)
    String findRole(@Param("id") int id);
   
    @Query(value="SELECT idrole FROM customer",nativeQuery = true)
    List findAllCustomerRoles();
   
    @Query(value="SELECT id_structure FROM customer a WHERE a.id = :id",nativeQuery = true)
    String findAllCustomerStructure(@Param("id") int id);
 
    @Transactional
    @Modifying
    @Query(value="UPDATE customer SET email= :email,last_name= :lastname,name= :name,password= :password,phone= :tel  WHERE id = :id ",nativeQuery = true)
    void update(@Param("id") int id,@Param("email") String email,@Param("lastname") String lastname,@Param("name") String name,@Param("password") String password,@Param("tel") int tel);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM customer WHERE id = :id ",nativeQuery = true)
    void delete(@Param("id") int id);



	

	
}
