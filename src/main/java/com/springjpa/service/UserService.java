package com.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.security.BCrypt;
import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;

@Service
public class UserService {
	private static String secretKey = "isverysecret";
	private static String salt = "saltysalt";
	
@Autowired
private CustomerRepository CR;
BCrypt BCrypt;

public void Register(Customer customer) {
String Securepw=BCrypt.encrypt(customer.getPassword(), secretKey);
customer.setPassword(Securepw);
System.out.print(customer.getRole());
Customer _customer = CR.save(customer);
System.out.print(_customer);
}

public boolean login(String email,String password) {
	String fake =BCrypt.encrypt(password, secretKey);
String result = CR.findCustomer(email,fake);
	if (result==null) {System.out.print("false");
	System.out.print(result);
	System.out.print(fake);
	return false;}
	else {
		System.out.print("true");
		System.out.print(result);
		return true;
	}
}
public int account(String email) {
	return CR.find(email);
}
public void update(int id,String email,String lastname,String name,String password,int tel) {
	String fake =BCrypt.encrypt(password, secretKey);
	  CR.update(id,email,lastname,name,fake,tel);
}
public void delete(int id) {
	CR.delete(id);
}
public List findall(String CodeStruct) {
	
	List<Customer> List= CR.findAllCustomers(CodeStruct);
	System.out.print(List);
	return List;
}

public List findcustomerroles() {
	List List=CR.findAllCustomerRoles();
	System.out.println(List);
	return List;
}
public String findR(String email) {
	int id;
	System.out.println(email);
	id=CR.findid(email);
	System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST");
	System.out.println(id);
	System.out.println(CR.findRole(id));
	System.out.println("TRUUE");
	return CR.findRole(id);
}
public String findS(String email) {
	int id;
	System.out.println(email);
	id=CR.findid(email);
	System.out.println("Structure");
	System.out.println(id);
	System.out.println(CR.findAllCustomerStructure(id));
	return CR.findAllCustomerStructure(id);
}
public int findid(String email) {
	
	return CR.findid(email);
}

}
