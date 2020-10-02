package Chapter3.Question3_7;

import java.sql.Timestamp;
import java.util.LinkedList;

class Question {

    public static abstract class Animal {
        String name;
        Timestamp timestamp;

        public Animal(String name) {
            this.name = name;
        }

        public void setTime() {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("    Set time " + this.timestamp + " for animal: " + this.name);
        }

        public Timestamp getTime() {
            return this.timestamp;
        }

        public String getName() {
            return this.name;
        }

        public abstract boolean isDog();
        public abstract boolean isCat();
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        public boolean isDog() {
            return true;
        }

        public boolean isCat() {
            return false;
        }
    }

    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        public boolean isDog() {
            return false;
        }

        public boolean isCat() {
            return true;
        }
    }

    public static class AnimalQueue {
        LinkedList<Animal> animals;

        public void enqueue(Animal animal) {
            this.animals.add(animal);
        }

        public Animal dequeue() {
            return this.animals.removeFirst();
        }

        public Animal peekFirst() {
            return this.animals.peekFirst();
        }

        public AnimalQueue() {
            this.animals = new LinkedList<>();
        }
    }

    public static class AnimalShelter {
        AnimalQueue dogs;
        AnimalQueue cats;

        public AnimalShelter() {
            this.dogs = new AnimalQueue();
            this.cats = new AnimalQueue();
        }

        public void takeAnimal(Animal animal) {
            animal.setTime();
            if (animal.isDog()) {
                dogs.enqueue(animal);
            } else if (animal.isCat()) {
                cats.enqueue(animal);
            }
        }

        public Animal giveAwayDog() {
            return dogs.dequeue();
        }

        public Animal giveAwayCat() {
            return cats.dequeue();
        }

        public Animal giveAwayAnimal() {
            Animal cat = cats.peekFirst();
            Animal dog = dogs.peekFirst();
            if (cat.getTime().before(dog.getTime())) {
                return cats.dequeue();
            } else {
                return dogs.dequeue();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat1 = new Cat("Otis");
        Cat cat2 = new Cat("Azula");
        Cat cat3 = new Cat("Garfield");
        Dog dog1 = new Dog("Adam");
        Dog dog2 = new Dog("Darwin");
        Dog dog3 = new Dog("Riley");
        animalShelter.takeAnimal(cat1);
        Thread.sleep(100);
        animalShelter.takeAnimal(dog1);
        Thread.sleep(100);
        animalShelter.takeAnimal(cat2);
        Thread.sleep(100);
        animalShelter.takeAnimal(cat3);
        Thread.sleep(100);
        animalShelter.takeAnimal(dog2);
        Thread.sleep(100);
        animalShelter.takeAnimal(dog3);
        Thread.sleep(100);

        Animal testAnimal;


        System.out.println("Test #1:");
        testAnimal = animalShelter.giveAwayAnimal();
        System.out.println("  Actual Animal Name: " + testAnimal.getName());
        System.out.println("  Expected Animal Name: Otis");

        System.out.println("Test #2:");
        testAnimal = animalShelter.giveAwayCat();
        System.out.println("  Actual Cat Name: " + testAnimal.getName());
        System.out.println("  Expected Cat Name: Azula");

        System.out.println("Test #3:");
        testAnimal = animalShelter.giveAwayDog();
        System.out.println("  Actual Dog Name: " + testAnimal.getName());
        System.out.println("  Expected Dog Name: Adam");

        System.out.println("Run complete.");

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(1 + ", ");
        sb.append(2 + ", ");
        sb.append(3 + ", ");
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());

    }
}

// Notes
//
// 1) Must label abstract methods in abstract class.