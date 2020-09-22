package Lab_3_13;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupMeetSystem
{
    // Поля класса
    private static List<String> places; // Список мест для встречи
    private static ArrayList<User> users; // Список пользователей
    private static User current_user;

    // Основной метод
    public static void main (String[] args)
    {
        int command;
        Scanner input = new Scanner(System.in);
        places = new ArrayList<String>();
        users = new ArrayList<User>();
        show_menu(); // Основное меню программы
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
            // Обработка опций
            switch (command)
            {
                case 1:
                    // Вход в систему
                    system_enter();
                    break;
                case 2:
                    // Регистрация пользователя
                    register_user();
                    break;
                case 3:
                    // Вывести список зарегистрированных пользователей
                    output_users();
                    break;
                case 4:
                    //Опредедлить возможные дни встречи всех членов команды
                    process_request();
                case 5:
                    // Повторный вывод меню
                    show_menu();
                    break;
                case 6:
                    // Выход из программы
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
        while (command != 6);
    }

    // Метод входа в систему
    public static void system_enter()
    {
        current_user = login_user();
        if (current_user == null)
        {
            System.out.println("Возвращение в главное меню");
        }
        else current_user.use_menu();
    }

    // Метод вывода списка зарегистрированных пользователей
    public static void output_users()
    {
        int size = users.size();
        System.out.println("Текущий список пользователей: ");
        if (size != 0)
        {
            for (int index = 0; index < size; index++)
            {
                System.out.println((index + 1) + ". " + users.get(index).get_username());
            }
        }
        else System.out.println("Список пуст");
    }

    // Метод основного меню программы
    public static void show_menu()
    {
        System.out.println("Главное меню:");
        System.out.println("1. Войти в систему");
        System.out.println("2. Зарегистрироваться");
        System.out.println("3. Вывести список зарегистрированных пользователей");
        System.out.println("4. Опредедлить возможные дни встречи всех членов команды");
        System.out.println("5. Повторный вывод меню");
        System.out.println("6. Выход из программы");
    }

    // Метод входа в систему
    public static User login_user()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String current_username = scanner.nextLine();
        System.out.print("Введите пароль пользователя: ");
        String current_password = scanner.nextLine();
        User temp_user = new User();
        // Проверка существования пользователя
        boolean user_exists = false;
        int size = users.size();
        for (int index = 0; index < size; index++)
        {
            if (users.get(index).get_username().equals(current_username))
            {
                user_exists = true;
                temp_user = users.get(index);
                break;
            }
        }
        if (user_exists == false)
        {
            System.out.println("Ошибка ввода имени пользователя");
            return null;
        }
        else
        {
            // Проверка соответствия пароля пользователя
            if (temp_user.get_password().equals(current_password))
            {
                System.out.println("Вход произведён успешно");
                System.out.println();
                return temp_user;
            }
            else
            {
                System.out.println("Ошибка ввода пароля пользователя");
                return null;
            }
        }
    }

    // Метод регистрации пользователя
    public static void register_user()
    {
        int command;
        Scanner input = new Scanner(System.in);
        show_register_menu(); // Меню регистрации
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
                    // Регистрация администратора
                    register_admin();
                    break;
                case 2:
                    // Регистрация фаната
                    register_member();
                    break;
                case 3:
                    // Повторный вывод меню
                    show_register_menu();
                    break;
                case 4:
                    // Возвращение в главное меню
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
        while (command != 4 && command != 1 && command != 2);
        System.out.println("Возвращение в главное меню");
    }

    // Метод вывода меню регистрации
    public static void show_register_menu()
    {
        System.out.println("Меню регистрации пользователя:");
        System.out.println("1. Администратор");
        System.out.println("2. Член команды");
        System.out.println("3. Повторный вывод меню");
        System.out.println("4. Вернуться в главное меню");
    }

    // Метод регистрации администратора
    public static void register_admin()
    {
        System.out.println("Регистрация администратора");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String current_username = scanner.nextLine();
        System.out.print("Введите пароль пользователя: ");
        String current_password = scanner.nextLine();
        Admin admin = new Admin(current_username, current_password); // Создание нового администратора
        // Проверка существования пользователя
        boolean user_exists = false;
        int size = users.size();
        for (int index = 0; index < size; index++)
        {
            if (users.get(index).get_username().equals(current_username))
            {
                user_exists = true;
                break;
            }
        }
        if (user_exists == false)
        {
            users.add(admin);
            System.out.println("Администратор зарегистрирован");
        }
        else System.out.println("Ошибка: пользователь с таким именем уже существует");
    }

    // Метод регистрации члена команды
    public static void register_member()
    {
        System.out.println("Регистрация члена команды");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String current_username = scanner.nextLine();
        System.out.print("Введите пароль пользователя: ");
        String current_password = scanner.nextLine();
        Member member = new Member(current_username, current_password); //Создание нового члена команды
        // Проверка существования пользователя
        boolean user_exists = false;
        int size = users.size();
        for (int index = 0; index < size; index++)
        {
            if (users.get(index).get_username().equals(current_username))
            {
                user_exists = true;
                break;
            }
        }
        if (user_exists == false)
        {
            users.add(member);
            System.out.println("Член комманды зарегистрирован");
        }
        else System.out.println("Ошибка: пользователь с таким именем уже существует");
    }

    // Метод очистки списка пользователей
    public static void users_clear()
    {
        System.out.println("Список пользователей очищен");
        users.clear();
    }

    // Метод добавления нового места встречи
    public static void add_place()
    {
        String place = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Введите новое место для встреч: ");
        do
        {
            place = input.next();
        }
        while (place == "");
        places.add(place);
        System.out.println("Место встречи успешно добавлено");
    }

    // Метод показа списка мест встречи
    public static void show_places()
    {
        for (int index = 0; index < places.size(); index++)
        {
            System.out.println("Место встречи № " + (index + 1) + " - " + places.get(index));
        }
    }

    // Метод заполнения дня встречи для члена команды
    public static void add_day()
    {
        int from;
        int to;
        int day;
        int place_number;
        Scanner input = new Scanner(System.in);
        // Поиск члена команды
        int index = 0;
        while (current_user.get_username() != users.get(index).get_username() && index < users.size())
        {
            index++;
        }
        // Проверка на найденность
        if (current_user.get_username() == users.get(index).get_username())
        {
            System.out.println("Введите день недели, в который намереваетесь добавить расписание: ");
            while (!input.hasNextInt())
            {
                System.out.println("Ошибка ввода");
                System.out.print("Введите день: ");
                input.next();
            }
            day = input.nextInt() - 1;
            // Проверказа невыход рамок недели
            if (day <= 7 && day >= 0)
            {
                // Ввод времени начала
                System.out.print("Введите время начала возможной встречи: ");
                while (!input.hasNextInt())
                {
                    System.out.println("Ошибка ввода");
                    System.out.print("Введите время: ");
                    input.next();
                }
                from = input.nextInt();
                // Ввод времени конца
                System.out.print("Введите время конца возможной встречи: ");
                while (!input.hasNextInt())
                {
                    System.out.println("Ошибка ввода");
                    System.out.print("Введите время: ");
                    input.next();
                }
                to = input.nextInt();
                // Показ списка возможных мест для встречи
                show_places();
                // Выбор места встречи
                System.out.print("Введите номер места встречи: ");
                while (!input.hasNextInt())
                {
                    System.out.println("Ошибка ввода");
                    System.out.print("Введите номер: ");
                    input.next();
                }
                place_number = input.nextInt() - 1;
                Request request = new Request(places.get(place_number), day, from, to); // Добавляемый запрос
                ArrayList<Request> current_member = ((Member) users.get(index)).get_member(); // Имеющийся список дней
                current_member.set(day, request);
                User update_user = users.get(index);
                ((Member) update_user).set_member(current_member);
                users.set(index, update_user);
                System.out.println("День был успешно добавлен");
            }
            else
            {
                System.out.println("Введен некорректный номер дня недели");
            }
        }
        else
        {
            System.out.println("Член комманды не найден");
        }
    }

    // Метод составления списка дней, когда все члены команды смогут встретиться
    public static void process_request()
    {
        // Проверка на заполненность
        if (users.size() > 2)
        {
            User current_member = ((Member)users.get(1)); // Член команды, с которого начнется поиск
            User compared_member; // Сравниваемый с ним член команды
            boolean flag = true; // Логическая переменная
            System.out.println("Список возможных встреч по дням");
            for (int index = 0; index < 7; index++)
            {
                // Проверка всех членов команды для текущего дня недели
                for (int index_user = 2; index_user < users.size(); index_user++)
                {
                    compared_member = users.get(index_user);
                    if (((Member) current_member).get_member().get(index).get_start_hour() != ((Member) compared_member).get_member().get(index).get_start_hour()
                    || ((Member) current_member).get_member().get(index).get_end_hour() != ((Member) compared_member).get_member().get(index).get_end_hour()
                    || ((Member) current_member).get_member().get(index).get_place() != ((Member) compared_member).get_member().get(index).get_place()
                    || ((Member) current_member).get_member().get(index).get_start_hour() <= 0 || ((Member) current_member).get_member().get(index).get_end_hour() <= 0
                    || ((Member) current_member).get_member().get(index).get_place() == ""  || ((Member) compared_member).get_member().get(index).get_start_hour() <= 0
                    || ((Member) compared_member).get_member().get(index).get_end_hour() <= 0 || ((Member) compared_member).get_member().get(index).get_place() == "")
                    {
                        flag = false;
                    }
                }
                // Если все члены команды совпадают
                if (flag)
                {
                    int final_start_hour = ((Member) current_member).get_member().get(index).get_start_hour();
                    int final_end_hour = ((Member) current_member).get_member().get(index).get_end_hour();
                    String final_place = ((Member) current_member).get_member().get(index).get_place();
                    System.out.println("В " + (index + 1) + " день недели члены команды смогут провести встречу с " + final_start_hour + " по " + final_end_hour + " в " + final_place);
                }
                else
                {
                    flag = true;
                }
            }
        }
        else
        {
            System.out.println("Список членов команды не был заполнен \n");
        }
    }
}
