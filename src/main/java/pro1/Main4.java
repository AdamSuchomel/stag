package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Teacher;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
         printShortestEmails("KIKM",5);
    }

    public static void printShortestEmails(String department, int count)
    {
        String json2 = Api.getTeachersByDepartment(department);
        TeachersList teachers = new Gson().fromJson(json2, TeachersList.class);

        // uložení do listu, kde se nejdřív vyfiltruje, jestli ten učitel vůbec má email a potom se to seřadí (default podle nejmenšího) a tam se nastaví limit, kde do listu se dostane jen ten počet, co je v limitu.
        List<Teacher> result = teachers.items.stream().filter(t->t.email != null).sorted(Comparator.comparing(t->t.email.length())).limit(count).toList();

        // TODO 4.1: Vypiš do konzole "count" nejkratších učitelských emailových adres
        for(Teacher t : result)
            System.out.println(t.email);

        // 2. varianta -> forEach rovnou v tom
        //teachers.items.stream().filter(t->t.email != null).sorted(Comparator.comparing(t->t.email.length())).limit(count).forEach(t->System.out.println(t.email));
    }
}