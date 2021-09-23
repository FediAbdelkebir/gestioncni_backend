package com.springjpa.model;
import java.io.Serializable;



import javax.persistence.*;

@Entity
@Table(name="structure" ,schema="public")
public class Structure implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private int ids;

@Id
@Column(name="code", nullable=false)
private String code;

@Column(name="lib_ar", nullable=false)
private String lib_ar;

@Column(name="lib_latin", nullable=false)
private String lib_latin;

public int getIds() {
	return ids;
}
 
public void setIds(int ids) {
	this.ids = ids;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getLib_ar() {
	return lib_ar;
}

public void setLib_ar(String lib_ar) {
	this.lib_ar = lib_ar;
}

public String getLib_latin() {
	return lib_latin;
}

public void setLib_latin(String lib_latin) {
	this.lib_latin = lib_latin;
}

@Override
public String toString() {
	return "Structure [ids=" + ids + ", code=" + code + ", lib_ar=" + lib_ar + ", lib_latin=" + lib_latin + "]";
}

public Structure(String code, String lib_ar, String lib_latin) {
	super();
	this.code = code;
	this.lib_ar = lib_ar;
	this.lib_latin = lib_latin;
}

public Structure() {}

}
