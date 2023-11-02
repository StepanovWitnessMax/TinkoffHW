package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParseContacts {

    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    private ParseContacts() {
    }

    public static Contacts[] parseContacts(String[] notProcessedContacts, String mark) {
        if (notProcessedContacts == null) {
            return new Contacts[] {};
        }
        if ((!mark.equals(ASC)) && (!mark.equals(DESC))) {
            throw new IllegalArgumentException("Некорректный метод сортировки");
        }
        List<Contacts> contactsList = new ArrayList<>();
        for (String contact : notProcessedContacts) {
            contactsList.add(new Contacts(contact));
        }

        if (mark.equals(ASC)) {
            contactsList.sort(Comparator.comparing(Contacts::getCoreName));
        } else {
            contactsList.sort(Comparator.comparing(Contacts::getCoreName).reversed());
        }
        return contactsList.toArray(new Contacts[notProcessedContacts.length]);
    }
}
