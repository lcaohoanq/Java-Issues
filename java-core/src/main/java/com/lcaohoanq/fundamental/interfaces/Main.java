public class Main {

    static class Dog extends BaseAnimal implements Terrestrialable {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        void getColor() {

        }

        @Override
        public String toString() {
            return "Dog{" +
                "name='" + name + '\'' +
                '}';
        }

        @Override
        public void eat() {
            System.out.println("Not eat...");
        }

        @Override
        public void sleep() {

        }

        @Override
        public void run() {

        }

        @Override
        public boolean isAnimal(Object type) {
            return false;
        }

        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.setName("Milu");
            dog.eat(); //Eating...
            // This method is a default method from Animalizable interface so it can be called directly from the object
            // default method of interface can be overridden by the class that implements the interface
            // Not eat...

            System.out.println(dog.isAnimal(dog)); //true
            dog.walk(); //Walking...

            System.out.println(dog);
        }

        @Override
        public void walk() {
            System.out.println("Walking...");
        }
    }

    static class Cat extends BaseAnimal {

        public static void main(String[] args) {

            // Anonymous class instantiation of BaseAnimal
            BaseAnimal anonymousAnimal = new BaseAnimal() {
                @Override
                void getColor() {
                    System.out.println("Black");
                }
            };

            // Calling the method on the anonymous instance
            anonymousAnimal.getColor();
        }

        @Override
        void getColor() {
            System.out.println("Default Cat Color");
        }
    }


    static class Bird extends BaseAnimal implements Flyable {

        @Override
        void getColor() {

        }

        @Override
        public void fly() {

        }

        @Override
        public void sleep() {

        }

        @Override
        public void run() {

        }

        @Override
        public boolean isAnimal(Object type) {
            return false;
        }
    }

    static class Fish extends BaseAnimal implements Aquaticlable {

        @Override
        public void swim() {

        }

        @Override
        public void sleep() {

        }

        @Override
        public void run() {

        }

        @Override
        public boolean isAnimal(Object type) {
            return false;
        }

        @Override
        void getColor() {

        }
    }

}
