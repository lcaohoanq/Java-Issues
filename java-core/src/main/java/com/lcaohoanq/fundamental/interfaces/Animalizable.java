public interface Animalizable<T> {
   
    default void eat(){
        System.out.println("Eating...");
    };
    
    void sleep();
    void run();
    boolean isAnimal(T type);
    
}
