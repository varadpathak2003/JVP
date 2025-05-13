import java.util.*;
import java.util.stream.Collectors;
class Main {
    public static void main(String[] args) {
        
        List <String> names=List.of("Ram","Shyam","Hari");
        
        System.out.println("Printing names using lambda function ");
        names.forEach(name->System.out.println(name));

        System.out.println("Use of Optional ");
        Optional <String> optional=Optional.ofNullable(null);
        System.out.println("Optional Value : "+optional.orElse("Null"));
        
         System.out.println("Using Map to map uppercase names ");
        List <String> upperNames=names.stream().map(String::toUpperCase).collect(Collectors.toList()); 
        upperNames.forEach(name->System.out.println(name));
        
        
         System.out.println("Filtering out names containing 'm'");
        List <String> aNames=names.stream().filter(name->name.contains("m")).collect(Collectors.toList());
         aNames.forEach(name->System.out.println(name));
         
          System.out.println("Addition of numbers using reduce ");
          List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
          int sum=numbers.stream().reduce(0,Integer::sum);
          System.out.println("Sum: " + sum);
    }
}
