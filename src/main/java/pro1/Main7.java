package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.DeadlineList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class Main7 {

    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }

    public static String specializationDeadlines(int year)
    {
        String json = Api.getSpecializations(year);
        DeadlineList deadlines = new Gson().fromJson(json, DeadlineList.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy"); // z netu, když jsem zjišťoval, jak funguje řazení a převádění toho stringu na LocalDate

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d.M.yyyy"); // to taky


        return deadlines.items.stream().filter(a -> a.eprDeadlinePrihlaska.value != null).map(a-> LocalDate.parse(a.eprDeadlinePrihlaska.value, formatter)).distinct().sorted().map(outputFormatter::format).collect(Collectors.joining(","));
    }
}
