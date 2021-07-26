package com.sise.entity;

public class Employee {
    private Long id;

    private String name;

    private String number;

    private Byte sex;

    private Byte age;

    private String role;

    private String phone;

    private Integer salary;

    private Byte stay;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Byte getStay() {
        return stay;
    }

    public void setStay(Byte stay) {
        this.stay = stay;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", role=").append(role);
        sb.append(", phone=").append(phone);
        sb.append(", salary=").append(salary);
        sb.append(", stay=").append(stay);
        sb.append("]");
        return sb.toString();
    }
}