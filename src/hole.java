
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class hole implements Comparable<hole>{
    private String  name;
    private boolean isEmpty ;  //true if hole
    private int startaddress;
    private int size;
    private boolean gotdrawn;
    public hole ()
    {
        name=null;
        isEmpty=true;
        startaddress=0;
        size=0;
        gotdrawn=false;
    }
    public hole(String s, boolean t,int sz,int add)
    {
        name=s;
        isEmpty=t;
        size=sz;
        startaddress=add;
        gotdrawn=false;
    }
    public void setDrawn(boolean b)
    {
        gotdrawn=b;
    }
    public void setName(String s)
    {
        name =s;
    }
    public void setisEmpty(boolean b)
    {
        isEmpty=b;
    }
    public void setAddress(int add)
    {
        startaddress=add;
    }
    public void setSize(int ss)
    {
        size=ss;
    }
    public int getAddress(){return startaddress;}
    public String getName(){return name;}
    public boolean getisEmpty(){return isEmpty;}
    public int getSize(){return size;}
    public boolean getGotDrawn(){return gotdrawn;}
    public void add(hole h) 
            
    {
        size+=h.size;
    }
    @Override
    public int compareTo(hole o) {
        return startaddress-o.getAddress();
    }
 
    public void compaction(LinkedList<hole> todraw)
    {
        Iterator it =todraw.iterator();
       LinkedList ll=new LinkedList();
       hole bighole=new hole();
       int flg=1;
       while(it.hasNext())
        {
            hole h =new hole();
            h=(hole) it.next();
            if(h.getisEmpty()&&flg==0)
            {  
                bighole=h;
                flg=1;
            }
            if(h.getisEmpty())
            {
                bighole.add(h);
            }
            
            
        }
       
    }
}

