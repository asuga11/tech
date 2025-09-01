package mn.onlinrshop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")

public class Customers extends BaseEntity{
    @Column(name = "name",length = 40 ,nullable = false)
    private  String name;
    @Column(name = "email",length = 40 ,nullable = true)
    private String email;
    private String phone;
    private String address;
    @Column(name = "city_region")
    private String cityRegion;
    @Column(name = "cc_number")
    private String cc_number;

    public Customers(){

    }

    public Customers(String name, String email, String phone, String address, String cityRegion, String cc_number) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cityRegion = cityRegion;
        this.cc_number = cc_number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityRegion() {
        return cityRegion;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }
}