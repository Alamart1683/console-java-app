package Lab_3_13;
import java.util.Scanner;

public class Admin extends User
{
    // Конструктор с параметрами
    Admin(String username, String password)
    {
        super(username, password);
    }

    // Метод меню администратора
    public void use_menu()
    {
        int command;
        Scanner input = new Scanner(System.in);
        show_menu();
        do
        {
            System.out.print("\nВведите команду: ");
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
                    // Очистка списка пользователей
                    GroupMeetSystem.users_clear();
                    break;
                case 2:
                    // Добавление нового места встречи
                    GroupMeetSystem.add_place();
                    break;
                case 3:
                    // Вывод уже добавленных мест встречи
                    GroupMeetSystem.show_places();
                    break;
                case 4:
                    // Повторный вывод меню
                    show_menu();
                    break;
                case 5:
                    // Вернуться в главное меню
                    System.out.println("Возвращение в главное меню");
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
        while (command != 5);
    }

    // Метод вывода меню администратора
    public void show_menu()
    {
        System.out.println("Меню действий администратора");
        System.out.println("1 - Очистить базу данных пользователей");
        System.out.println("2 - Добавить новое место встречи");
        System.out.println("3 - Показать список мест встречи");
        System.out.println("4 - Повторный вывод меню");
        System.out.println("5 - Возврат в главное меню");
    }
}

