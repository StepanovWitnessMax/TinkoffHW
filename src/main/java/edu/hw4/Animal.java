package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collection;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public static List<Animal> task1(List<Animal> listAnimal) {
        return listAnimal.stream()
            .sorted(Comparator.comparing(Animal::height))
            .toList();
    }

    public static List<Animal> task2(List<Animal> listAnimal, int limit) {
        return listAnimal.stream()
            .sorted((o1, o2) -> Integer.compare(o2.weight(), o1.weight()))
            .limit(limit)
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> listAnimal) {
        return listAnimal.stream()
            .collect(groupingBy(
                Animal::type,
                collectingAndThen(counting(), Long::intValue)
            ));
    }

    public static Optional<Animal> task4(List<Animal> listAnimal) {
        return listAnimal.stream().max(Comparator.comparingInt(o -> o.name().length()));
    }

    public static Sex task5(List<Animal> listAnimal) {
        return listAnimal.stream()
            .map(a -> (a.sex() == Animal.Sex.M ? 1 : -1))
            .reduce(0, Integer::sum) >= 0 ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> listAnimal) {
        return listAnimal.stream()
            .collect(toMap(
                Animal::type,
                Function.identity(),
                (a, b) -> a.weight() > b.weight() ? a : b
            ));
    }

    public static Optional<Animal> task7(List<Animal> listAnimal, int k) {
        return listAnimal.stream()
            .sorted((o1, o2) -> -Integer.compare(o1.age(), o2.age()))
            .limit(k)
            .reduce((a, b) -> b);
    }

    public static Optional<Animal> task8(List<Animal> listAnimal, int k) {
        return listAnimal.stream()
            .filter(t -> t.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(List<Animal> listAnimal) {
        return listAnimal.stream().map(Animal::paws).reduce(0, Integer::sum);
    }

    public static List<Animal> task10(List<Animal> listAnimal) {
        return listAnimal.stream()
            .filter(t -> t.age() != t.paws())
            .toList();
    }

    public static List<Animal> task11(List<Animal> listAnimal) {
        final int MINHEIGHT = 100;
        return listAnimal.stream()
            .filter(t -> t.height() > MINHEIGHT && t.bites())
            .toList();
    }

    public static Integer task12(List<Animal> listAnimal) {
        return listAnimal.stream()
            .filter(t -> t.weight() > t.height())
            .map(e -> 1)
            .reduce(0, Integer::sum);
    }

    public static List<Animal> task13(List<Animal> listAnimal) {
        final int THREE = 3;
        return listAnimal.stream()
            .filter(t -> {
                String[] lst = t.name().split(" ");
                return lst.length >= THREE;
            })
            .toList();
    }

    public static Boolean task14(List<Animal> listAnimal, int k) {
        return listAnimal.stream()
            .anyMatch(t -> t.type() == Animal.Type.DOG && t.height() > k);
    }

    public static Integer task15(List<Animal> listAnimal, int k, int l) {
        return listAnimal.stream()
            .filter(t -> t.age() >= k && t.age() <= l)
            .map(Animal::weight)
            .reduce(0, Integer::sum);
    }

    public static List<Animal> task16(List<Animal> listAnimal) {
        return listAnimal.stream()
            .sorted(
                Comparator.comparing(Animal::type)
                    .thenComparing(Animal::sex)
                    .thenComparing(Animal::name))
            .toList();
    }

    public static Boolean task17(List<Animal> listAnimal) {
        if (listAnimal.stream().noneMatch(t -> t.type() == Animal.Type.SPIDER)) {
            return false;
        }
        if (listAnimal.stream().noneMatch(t -> t.type() == Animal.Type.DOG)) {
            return false;
        }
        Double spiders = listAnimal.stream()
            .filter(t -> t.type() == Animal.Type.SPIDER)
            .collect(Collectors.averagingDouble(t -> t.bites() ? 1 : 0));
        Double dogs = listAnimal.stream()
            .filter(t -> t.type() == Animal.Type.DOG)
            .collect(Collectors.averagingDouble(t -> t.bites() ? 1 : 0));
        return spiders > dogs;
    }

    public static Optional<Animal> task18(List<Animal>... lists) {
        return Stream.of(lists)
            .flatMap(Collection::stream)
            .filter(t -> t.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Map<String, Set<ValidationError>> task19(List<Animal> listAnimal) {
        return listAnimal.stream()
            .filter(animal -> !Validator.getErrors(animal).isEmpty())
            .collect(Collectors.toMap(Animal::name, Validator::getErrors));
    }

    public static Map<String, String> task20(List<Animal> listAnimal) {
        return listAnimal.stream()
            .filter(animal -> !Validator.getErrors(animal).isEmpty())
            .collect(
                Collectors.toMap(
                    Animal::name,
                    t -> Validator.getErrors(t).stream()
                        .map(ValidationError::getMessage)
                        .collect(Collectors.joining("\n"))
                )
            );
    }
}
