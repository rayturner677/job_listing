package com.joblisting.joblisting.forms;

public class EmployerForm {
    public   String email;
    public String name;
    public String position;
    public   String address;
    public String description;
    public String benefits;
    public String logo_url;

    public EmployerForm(String name, String address, String position, String description, String benefits, String email, String logo_url) {
        this.name = name;
        this.address = address;
        this.position = position;
        this.description = description;
        this.benefits = benefits;
        this.email = email;
        this.logo_url = logo_url;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getBenefits() {
        return benefits;
    }



    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid(){return name != null && address != null && position != null && description != null && email != null
            && benefits != null && logo_url != null;}
}
