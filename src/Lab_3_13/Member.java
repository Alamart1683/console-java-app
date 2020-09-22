package Lab_3_13;
import java.util.ArrayList;
import java.util.Scanner;

public class Member extends User
{
    // Список дней
    private ArrayList<Request>  member;
    private Request request = new Request();

    // Конструктор с параметрами
    Member(String username, String password)
    {
        super(username, password);
        member = new ArrayList<Request>(6);
        for (int index = 0; index < 7; index++)
            member.add(request);
    }

    // Получение списка дней
    public ArrayList<Request> get_member()
    {
        return member;
    }

    // Обновление списка дней
    public void set_member(ArrayList<Request> new_member)
    {
        member = new_member;
    }

    // Метод меню члена команды
    public void use_menu()
    {
        int command;
        Scanner input = new Scanner(System.in);
        show_menu();
        do
            {
            System.out.print("\nВведите комманду: ");
            while (!input.hasNextInt())
            {
                System.out.println("Ошибка ввода");
                System.out.print("\nВведите команду: ");
                input.next();
            }
            command = input.nextInt();
            switch (command)
            {
                case 1:
                    // Вывести список уже заполненных дней
                    output_member();
                    break;
                case 2:
                    // Добавить расписание для дня
                    GroupMeetSystem.add_day();
                    break;
                case 3:
                    show_menu();
                    break;
                case 4:
                    // Вернуться в главное меню
                    System.out.println("Возвращение в главное меню");
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
        while (command != 4);
    }

    // Метод вывода меню члена команды
    public void show_menu()
    {
        System.out.println("Меню члена команды " + get_username() + " ");
        System.out.println("1. Показать список дней с расписанием");
        System.out.println("2. Добавить расписание для нового дня");
        System.out.println("3. Повторный вывод меню");
        System.out.println("4. Вернуться в главное меню");
    }

    // Метод вывода заполненных дней
    public void output_member()
    {
        System.out.println("Список уже заполненных дней");
        for (int index = 0; index < member.size(); index++)
        {
            if (member.get(index).get_start_hour() > 0 && member.get(index).get_end_hour() > 0)
            {
                System.out.println("День №" + (index + 1) + " время: с " + member.get(index).get_start_hour() + " по " + member.get(index).get_end_hour() + " в месте " + member.get(index).get_place());
            }
        }
    }
}
