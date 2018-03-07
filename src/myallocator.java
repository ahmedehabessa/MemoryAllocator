
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class myallocator {
 
    public myallocator()
    {
        
    }
    public LinkedList firstfit(LinkedList holes,LinkedList processes,boolean compaction)
    {
       LinkedList<hole> todraw=new LinkedList<hole>();
//       Iterator ith=holes.iterator();
       Iterator itp=processes.iterator();
       int flg=0;
       
       while(itp.hasNext()){
       hole p=new hole();
       
       p=(hole) itp.next();
       
       Iterator ith=holes.iterator();
      while(ith.hasNext())
       {
           hole h;
           h=(hole) ith.next();
           if(h.getisEmpty())
           {
               if(h.getSize()==p.getSize())
               {
                   h.setisEmpty(false);
                   p.setAddress(h.getAddress());
                   p.setDrawn(true);
                   todraw.add(p);
                   break;
               }
               else if (h.getSize()>p.getSize())
               {
                   p.setAddress(h.getAddress());
                   h.setAddress(h.getAddress()+p.getSize());
                   h.setSize(h.getSize()-p.getSize());
                   p.setDrawn(true);
                   todraw.add(p);
                   break;
               }
           
           }
           
       }
       }
       Iterator it=holes.iterator();
       if(!compaction)
       while(it.hasNext())
       {
           hole h=new hole();
           h=(hole) it.next();
           if(h.getisEmpty())
               todraw.add(h);
       }
       else
       {
           hole bighole=new hole();
        while(it.hasNext())
       {
           hole h=new hole("hole",false,0,0);
           h=(hole) it.next();
           if(h.getisEmpty())
           { 
              bighole.add(h);  
           }
       }   
        Collections.sort(todraw);
       bighole.setAddress(todraw.getLast().getAddress()+todraw.getLast().getSize());
       todraw.add(bighole);
       }
       Collections.sort(todraw);
      
       /*
       Collections.sort(todraw, new Comparator<hole>()
       {
    public int compare(hole one, hole two)
    {
        return one.getSize()-two.getSize();
    
    }
       });*/
       /*
       Collections.sort(todraw, new Comparator<hole>()
       {
    public int compare(hole one, hole two)
    {
        return two.getSize()-one.getSize();
    
    }
       });*/

       return todraw;
    }
    
    public LinkedList bestfit(LinkedList holes,LinkedList processes,boolean compaction)
    {
        LinkedList<hole> todraw=new LinkedList<hole>();
         
        Iterator itp=processes.iterator();
        
       Collections.sort(holes, new Comparator<hole>()
       {
    public int compare(hole one, hole two)
    {
        return one.getSize()-two.getSize();
    
    }
        });
       
    while(itp.hasNext()){
       hole p=new hole();
       
       p=(hole) itp.next();
       
       Iterator ith=holes.iterator();
      while(ith.hasNext())
       {
           hole h;
           h=(hole) ith.next();
           if(h.getisEmpty())
           {
               if(h.getSize()==p.getSize())
               {
                   h.setisEmpty(false);
                   p.setAddress(h.getAddress());
                   p.setDrawn(true);
                   todraw.add(p);
                   break;
               }
               else if (h.getSize()>p.getSize())
               {
                   p.setAddress(h.getAddress());
                   h.setAddress(h.getAddress()+p.getSize());
                   h.setSize(h.getSize()-p.getSize());
                   p.setDrawn(true);
                   todraw.add(p);
                   break;
               }
           
           }
           
       }
       }
       Iterator it=holes.iterator();
       if(!compaction)
       while(it.hasNext())
       {
           hole h=new hole();
           h=(hole) it.next();
           if(h.getisEmpty())
               todraw.add(h);
       }
       else
       {
           hole bighole=new hole();
        while(it.hasNext())
       {
           hole h=new hole("hole",false,0,0);
           h=(hole) it.next();
           if(h.getisEmpty())
           { 
              bighole.add(h);  
           }
       }
           Collections.sort(todraw);
       bighole.setAddress(todraw.getLast().getAddress()+todraw.getLast().getSize());
       todraw.add(bighole);
       
       }
       
       Collections.sort(todraw);
         
    
       
       return todraw;
    }
    
    
    public LinkedList worstfit(LinkedList holes,LinkedList processes,boolean compaction)
    {
        LinkedList<hole> todraw=new LinkedList<hole>();
         
        Iterator itp=processes.iterator();
        
       Collections.sort(holes, new Comparator<hole>()
       {
    public int compare(hole one, hole two)
    {
        return two.getSize()-one.getSize();
    
    }
        });
       
    while(itp.hasNext()){
       hole p=new hole();
       
       p=(hole) itp.next();
       
       Iterator ith=holes.iterator();
      while(ith.hasNext())
       {
           hole h;
           h=(hole) ith.next();
           if(h.getisEmpty())
           {
               if(h.getSize()==p.getSize())
               {
                   h.setisEmpty(false);
                   p.setAddress(h.getAddress());
                   p.setDrawn(true);
                   todraw.add(p);
                   break;
               }
               else if (h.getSize()>p.getSize())
               {
                   p.setAddress(h.getAddress());
                   h.setAddress(h.getAddress()+p.getSize());
                   h.setSize(h.getSize()-p.getSize());
                   p.setDrawn(true);
                   todraw.add(p);
                   break;
               }
           
           }
           
       }
       }
       Iterator it=holes.iterator();
       if(!compaction)
       while(it.hasNext())
       {
           hole h=new hole();
           h=(hole) it.next();
           if(h.getisEmpty())
               todraw.add(h);
       }
       else
       {
           hole bighole=new hole();
        while(it.hasNext())
       {
           hole h=new hole("hole",false,0,0);
           h=(hole) it.next();
           if(h.getisEmpty())
           { 
              bighole.add(h);  
           }
       }
           Collections.sort(todraw);
       bighole.setAddress(todraw.getLast().getAddress()+todraw.getLast().getSize());
       todraw.add(bighole);
       
       }
       Collections.sort(todraw);
         
    
       
       return todraw;
    }
}
