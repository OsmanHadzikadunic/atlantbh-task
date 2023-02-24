package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class Randomizer {
    private static Faker faker = new Faker();

    public static String randomEmailAddress() {
        return String.format("%s.%s.%s@gmail.com", faker.name().firstName(), faker.name().lastName().toLowerCase(),
                    faker.name().lastName().toLowerCase(),
                    faker.random().nextInt(1000));
    }
    public static String randomName() {
        return faker.name().firstName();
    }
    public static String randomLastName() {
        return faker.name().lastName();
    }
    public static String randomAddress() {
        return faker.address().fullAddress();
    }
    public static String randomZipcode() {
        String zipcode = "";
        while (!zipcode.startsWith("7")) {
            zipcode = faker.address().zipCode().replace("[x-]", "").substring(0, 5);
        }
        return String.format("%05d", Integer.parseInt(zipcode));
    }
    public static String randomCity() {
        return faker.address().city();
    }
    public static String randomPhoneNumber() {
        String phoneNumber = faker.phoneNumber().phoneNumber().replaceAll("[x-]", "");
        return phoneNumber;
    }
    public static String randomPassword() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }

}
