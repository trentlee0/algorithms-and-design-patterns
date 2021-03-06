package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Organization {
    private String name;
    private String des;

    public Organization(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public Organization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void add(Organization component) {
        throw new UnsupportedOperationException();
    }

    public void remove(Organization component) {
        throw new UnsupportedOperationException();
    }

    public abstract void show();
}

abstract class College extends Organization {

    private List<Organization> components;

    public College(String name, String des) {
        super(name, des);
        components = new ArrayList<>();
    }

    public College() {
        this(null, null);
    }

    @Override
    public void add(Organization component) {
        components.add(component);
    }

    @Override
    public void remove(Organization component) {
        components.remove(component);
    }

    @Override
    public void show() {
        System.out.println("======= " + getName() + " =======");
        for (Organization component : components) {
            component.show();
        }
    }
}

class University extends College {
    public University(String name, String des) {
        super(name, des);
    }

    public University() {
        super();
    }
}

class Institute extends College {
    public Institute(String name, String des) {
        super(name, des);
    }

    public Institute() {
        super();
    }
}

class Department extends Organization {
    public Department(String name, String des) {
        super(name, des);
    }

    public Department() {
    }

    @Override
    public void add(Organization component) {
        super.add(component);
    }

    @Override
    public void remove(Organization component) {
        super.remove(component);
    }

    @Override
    public void show() {
        System.out.println(getName() + " -> " + getDes());
    }
}

class Client {
    public static void main(String[] args) {
        Organization university = new University();
        university.setName("????????????");
        university.setDes("??????????????????");

        Organization computerInstitute = new Institute("???????????????", "???????????????");
        Organization infoEngineerInstitute = new Institute("??????????????????", "??????????????????");

        computerInstitute.add(new Department("????????????", "??????????????????"));
        computerInstitute.add(new Department("????????????", "??????????????????"));
        computerInstitute.add(new Department("????????????????????????", "??????????????????????????????"));

        infoEngineerInstitute.add(new Department("????????????", "??????????????????"));
        infoEngineerInstitute.add(new Department("????????????", "??????????????????"));

        university.add(computerInstitute);
        university.add(infoEngineerInstitute);

        university.show();
    }
}