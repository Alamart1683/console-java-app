package Lab_3_13;

// Наследуемый класс пользователя
public class User
{
    // Имя пользователя
    private String username;
    // Пароль пользователя
    private String password;

    // Метод установки значения имени пользователя
    public void set_username(String string)
    {
        username = string;
    }

    // Метод установки значения пароля пользователя
    public void set_password(String string)
    {
        password = string;
    }

    // Метод получения значения имени пользователя
    public String get_username()
    {
        return username;
    }

    // Метод получения значения пароля пользователя
    public String get_password()
    {
        return password;
    }

    // Конструктор по-умолчанию
    User()
    {

    }

    // Конструктор с параметрами
    User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    // Метод меню
    public void use_menu()
    {

    }

    // Метод вывода меню
    public void show_menu()
    {

    }
}
