/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fskn
 */
@Entity
public class AddressOne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    
    //ManyToMany bidrectional
    @ManyToMany(mappedBy = "address", cascade = {CascadeType.PERSIST})
    private List<CustomerOne> customerOnes;
    
    /* //OneTomany where customerOne has "onetomany" and address is manytoOne (bidirectional)
    @ManyToOne
    private CustomerOne customerOne;
    */
    /* //bidirectional
    @OneToOne(mappedBy = "address") 
    private CustomerOne customerOne;
    */
   
    public AddressOne() {
    }

    public AddressOne(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    /* // OneToMany bidrectional and unidirectional
    public CustomerOne getCustomerOne() {
        return customerOne;
    }

    public void setCustomerOne(CustomerOne customerOne) {
        this.customerOne = customerOne;
        customerOne.addAddress(this);
    }*/
   
    
    //ManyToMany
    public List<CustomerOne> getCustomerOnes() {
        return customerOnes;
    }

    public void addCustomerOnes(CustomerOne customerOne) {
        customerOnes.add(customerOne);
    }

    @Override
    public String toString() {
        return "AddressOne{" + "id=" + id + ", street=" + street + ", city=" + city + '}';
    }
    

    
    
}
