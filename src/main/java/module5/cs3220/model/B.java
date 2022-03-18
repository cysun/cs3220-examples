package module5.cs3220.model;

import java.util.ArrayList;
import java.util.List;

public class B {

    A a0;

    List<A> listA;

    public B()
    {
        a0 = new A();

        listA = new ArrayList<A>();
        for( int i = 0; i < 10; ++i )
        {
            A a = new A();
            a.setId( i + 1 );
            listA.add( a );
        }
    }

    public A getA0()
    {
        return a0;
    }

    public void setA0( A a0 )
    {
        this.a0 = a0;
    }

    public List<A> getListA()
    {
        return listA;
    }

    public void setListA( List<A> listA )
    {
        this.listA = listA;
    }

}
