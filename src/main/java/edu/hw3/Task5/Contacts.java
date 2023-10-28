package edu.hw3.Task5;

public class Contacts {

    private final String name;
    private final String surname;

    public Contacts(String notProcessedContact) {
        if (notProcessedContact.contains(" ")) {
            name = notProcessedContact.split(" ")[0];
            surname = notProcessedContact.split(" ")[1];
        } else {
            name = notProcessedContact;
            surname = null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Contacts comparisonObj)) {
            return false;
        }

        if (this.surname == null) {
            if (comparisonObj.surname == null) {
                return this.name.equals(comparisonObj.name);
            }
            return false;
        }
        return this.name.equals(comparisonObj.name) && this.surname.equals(comparisonObj.surname);
    }

    @Override
    public int hashCode() {
        return (name.length() * 3) + surname.length() * 5;
    }

    public String getCoreName() {
        if (surname == null) {
            return name;
        }
        return surname;
    }
}
