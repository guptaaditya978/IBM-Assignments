import java.util.ArrayList;
import java.util.List;
interface Human{
    void eat();
}
 
 
class Akhil implements Human{
    @Override
    public void eat(){
        System.out.println("Akhil's eat");
    }
}
 
class Sailesh implements Human{
    @Override
    public void eat(){
        System.out.println("Sailesh's eat");
    }
}
 
class GenericsPlay{
    public static void main(String[] args) {
            ArrayList<Object> list = new ArrayList<>();
 
            list.add(new Akhil());
            // list.add(new Sailesh());
 
            // new GenericsPlay().traverse(list);
            new GenericsPlay().traverseSecond(list);
 
    }
 
    //This methods takes any list of Generic Parameter Human or any subtype of Human
    void traverse(List<? extends Human> list){
        for (Human ref : list) {
            ref.eat();
        }
 
        // list.add(new Akhil()); //Now an error
 
 
    }
 
 
//  This accepts any list of Generic Parameter Human or any super type of Human,
    // And we can add to this list a well(but in a restricted manner)
    void traverseSecond(List<? super Human> list){
        list.add(new String("")); // Works here with <? super Type>
    }
 
    // Object h = new Akhil();
 
}
 
    // Set<? extends Human> set = new TreeSet<? extends Human>();  //Wrong, doesn't work
 
    // Set<?> set =  new HashSet<Human>(); // Works, Can't add to it
 
 
    // Set<Object> set = new HashSet<>();//Works, can add to it
 
    // List<?> list;
 
    // List<? super Object> list;