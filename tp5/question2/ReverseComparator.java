package question2;
import java.util.Comparator;

/**
 * Write a description of class propreClasseComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReverseComparator implements Comparator<String>
{
   
     public int compare(String obj1, String obj2) {
    if (obj1 == obj2) {
        return 0;
    }
    if (obj1 == null) {
        return 1;
    }
    if (obj2 == null) {
        return -1;
    }
    int i= obj1.compareTo(obj2);
    return -i;
  }
}
