package module6.cs3220.model;

import java.util.Date;

public class Employee {

    Integer id;

    String username;

    String password;

    Date birthday;

    double salary;

    public Employee()
    {
    }

    public Employee( Integer id, String username, String password,
        Date birthday, double salary )
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.salary = salary;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday( Date birthday )
    {
        this.birthday = birthday;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary( double salary )
    {
        this.salary = salary;
    }

}
