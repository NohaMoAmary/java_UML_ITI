
package stringdetails;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 *
 * @author noham
 */
public class StringDetails {

    public static String betterString (String str1,String str2,BiPredicate<String,  String> p)
    {
     String better ;
     if (p.test(str1, str2))
     {return str1;}
     else 
     {return str2;}
    }
    public static boolean isLetter (String str1,Predicate<String> p)
    {
        return p.test(str1);
    }
    
    public static void main(String[] args) {
        String s1= "noha" ;
        String s2 = "MoAmary";
        String s3 ="Mo7ammad";
        String longer;  
        longer = StringDetails.betterString(s1, s2, (sr1, sr2) -> sr1.length()> sr2.length());
        String first;
        first = StringDetails.betterString(s1, s2,(t1,t2) -> true);
        System.out.println(longer);
        System.out.println(first);
        boolean check ;
        check = StringDetails.isLetter(s3, (x)->x.chars().allMatch(Character::isLetter));
        System.out.println(check);
        check = StringDetails.isLetter(s1, (x)->x.chars().allMatch(Character::isLetter));
        System.out.println(check);
    }
    
}
