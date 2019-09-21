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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fskn
 */
@Entity
public class CustomerOne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    
    //ManyToMany bidirectional
    @ManyToMany (cascade = {CascadeType.PERSIST})
    private List<AddressOne> address = new ArrayList();
    
    
    /*//OneToMany bidirectional
    @OneToMany(mappedBy = "customerOne", cascade = {CascadeType.PERSIST})
    private List<AddressOne> address = new ArrayList();
    */
    /* //unidirectional 
    @OneToMany (cascade = {CascadeType.PERSIST})
    @JoinColumn //by using joincolum it will put remove a table and put address id into customer instead of a table with customer id and address id in one
    List<AddressOne> address = new ArrayList();
    */
    
    /*
    @OneToOne(cascade ={CascadeType.PERSIST}) //Looks the same as the one below - difference is that this is bidirectional and create reference in addressOne class
    private AddressOne address;
    */
    /*@OneToOne(cascade={CascadeType.PERSIST}) // Looks the same as the one above - difference is that this is unidirectional
    private AddressOne address; 
    */

    public CustomerOne() {
    }

    public CustomerOne(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    /*public AddressOne getAddress() {
        return address;
    }

    public void setAddress(AddressOne address) {
        this.address = address;
        this.address.setCustomerOne(this);
    }*/

    /* //OneTomany unidirectional and bidirectional
    public List<AddressOne> getAddress() {
        return address;
    }

    public void addAddress(AddressOne add) {
        address.add(add);
    }*/
    
    
    //ManyToMany
    public List<AddressOne> getAddress() {
        return address;
    }

    public void setAddress(AddressOne add) {
        address.add(add);
    }

    @Override
    public String toString() {
        return "CustomerOne{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname +'}';
    }
    
    
    
}
