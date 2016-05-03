package entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EntityClassExplorer {

    public <T> List<Field> retrieveFieldsFromEntity(Class<T> typeOfCurrentClass) {
        //***Gathering all fields in a chosen class from user "typeOfCurrentClass"
        if (typeOfCurrentClass != null) {
            Class superClass = typeOfCurrentClass.getSuperclass();
            List<Field> fieldsInClasses = new ArrayList();
            while (superClass != null) {
                List<Field> reversing = Arrays.asList(superClass.getDeclaredFields());
                Collections.reverse(reversing);
                fieldsInClasses.addAll(reversing);
                superClass = superClass.getSuperclass();
            }
            Collections.reverse(fieldsInClasses);
            fieldsInClasses.addAll(Arrays.asList(typeOfCurrentClass.getDeclaredFields()));
            return fieldsInClasses;
        } else {
            return null;
        }
        //***"fieldsInClasses" now has all fields including super class info
    }
}
