package Lab_3_13;

// Класс запроса
public class Request
{
    private String place; // Место встречи
    private int day; // День недели
    private int start_hour; // Время время начала
    private int end_hour; // Время окончания

    // Констурктор по умолчанию
    public Request()
    {
        this.place = "";
        this.day = 0;
        this.start_hour = 0;
        this.end_hour = 0;
    }

    // Конструктор с параметрами
    public Request(String place, int day, int from, int to)
    {
        this.place = place;
        this.day = day;
        this.start_hour = from;
        this.end_hour = to;
    }

    // Вернуть место встречи
    public String get_place()
    {
        return place;
    }

    // Вернуть день недели встречи
    public int get_day()
    {
        return day;
    }

    // Вернуть время начала встречи
    public int get_start_hour()
    {
        return start_hour;
    }

    // Вернуть время завершения встречи
    public int get_end_hour()
    {
        return end_hour;
    }
}