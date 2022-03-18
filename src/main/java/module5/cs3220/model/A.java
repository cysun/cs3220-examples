package module5.cs3220.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class A {

    int id = 0;

    String name = "cs3220";

    String[] weekdays = { "mon", "tue", "wed", "thr", "fri" };

    List<Double> numbers;

    Date date;

    public A()
    {
        numbers = new ArrayList<Double>();
        for( int i = 0; i < 10; ++i )
            numbers.add( i + Math.random() );
        date = new Date();
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String[] getWeekdays()
    {
        return weekdays;
    }

    public void setWeekdays( String[] weekdays )
    {
        this.weekdays = weekdays;
    }

    public List<Double> getNumbers()
    {
        return numbers;
    }

    public void setNumbers( List<Double> numbers )
    {
        this.numbers = numbers;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate( Date date )
    {
        this.date = date;
    }

}
