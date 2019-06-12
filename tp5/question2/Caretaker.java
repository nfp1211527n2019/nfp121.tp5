package question2;
import java.util.ArrayList;

public class Caretaker
{
    ArrayList<Memento>savedArticles = new ArrayList<Memento>();

    
    public Caretaker() 
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addMemento(Memento m)
    {savedArticles.add(m);
        
    }
   
    public Memento getMemento(int index)
    {
        return savedArticles.get(index);
        
    }
}
