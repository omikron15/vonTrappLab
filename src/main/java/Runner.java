import db.DBChild;
import models.Child;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Child liesl = new Child("Liesl", 16, "Soprano");
        Child friedrich = new Child("Friedrich", 14, "Tenor");
        Child louisa = new Child("Louisa", 13, "Contralto");
        Child kurt = new Child("Kurt", 11, "Tenor");
        Child brigitta = new Child("Brigitta", 10, "Soprano");
        Child marta = new Child("Marta", 7, "Mezzo-Soprano");
        Child gretl = new Child("Gretl", 5, "Soprano");

        DBChild.save(liesl);
        DBChild.save(friedrich);
        DBChild.save(louisa);
        DBChild.save(kurt);
        DBChild.save(brigitta);
        DBChild.save(marta);
        DBChild.save(gretl);


        List<Child> childList = DBChild.getAll();

        Child foundChild = DBChild.find(kurt.getName());

        List<Child> ordered =  DBChild.orderByAge();

        List<Child> soprano = DBChild.getSoprano();

        friedrich.setAge(15);
        friedrich.setRange("Bass");
        DBChild.update(friedrich);
        Child foundChild2 = DBChild.find(friedrich.getName());
        List<Child> lessThanTen = DBChild.lessThanTen();

    }


}
