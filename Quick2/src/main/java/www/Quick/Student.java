package www.Quick;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

@Entity
public class Student {
	@Id
	private int rollno;
	private StudentName name;
	private int marks;
	@AttributeOverrides({
        @AttributeOverride(name="street",column=@Column(name="H_STREET_NAME")),
        @AttributeOverride(name="city",column=@Column(name="H_CITY_NAME")),
        @AttributeOverride(name="state",column=@Column(name="H_STATE_NAME")),
        @AttributeOverride(name="pincode",column=@Column(name="H_PIN_CODE")),
    })
	private Address homeadd;
	@AttributeOverrides({
        @AttributeOverride(name="street",column=@Column(name="S_STREET_NAME")),
        @AttributeOverride(name="city",column=@Column(name="S_CITY_NAME")),
        @AttributeOverride(name="state",column=@Column(name="S_STATE_NAME")),
        @AttributeOverride(name="pincode",column=@Column(name="S_PIN_CODE")),
    })
	private Address schooladd;
	
    @ElementCollection
    @JoinTable(name = "student_add" , joinColumns = @JoinColumn(name = "Student_Id"))
    @GenericGenerator(name="hilo-gen", strategy="hilo")
    @CollectionId(columns = @Column(name="Add_id"), generator = "hilo-gen", type = @Type(type="long"))
    private Collection<Address> listofadd = new ArrayList<Address>();
    
	
	public Collection<Address> getListofadd() {
		return listofadd;
	}
	public void setListofadd(Collection<Address> listofadd) {
		this.listofadd = listofadd;
	}
	public Address getHomeadd() {
		return homeadd;
	}
	public void setHomeadd(Address homeadd) {
		this.homeadd = homeadd;
	}
	public Address getSchooladd() {
		return schooladd;
	}
	public void setSchooladd(Address schooladd) {
		this.schooladd = schooladd;
	}
	public StudentName getName() {
		return name;
	}
	public void setName(StudentName name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

}
