package co.edu.upb.appmed.feature.Entities;

public class User {

    private String name;
    private String last_name;
    private String email;
    private String phone;
    private String cell_phone;

    public User() {
    }

    public User(String name, String last_name, String email, String phone, String cell_phone) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.cell_phone = cell_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }
}
