package pl.edu.uwr.loginapp;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static final String PREFS_NAME = "user_prefs";
    private static final String USERS_KEY = "users";
    private static List<User> users = new ArrayList<>();

    // Metoda do inicjalizacji danych
    public static void initialize(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String json = prefs.getString(USERS_KEY, null);

        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<User>>() {}.getType();
            users = gson.fromJson(json, type);
        }
    }
    public static void initializeDefaultUsers(Context context) {
        if (users.isEmpty()) {
            users.add(new User("user1", "password1"));
            users.add(new User("user2", "password2"));
            users.add(new User("user3", "password3"));
            users.add(new User("user4", "password4"));
            users.add(new User("user5", "password5"));

            saveUsers(context); // Zapisz użytkowników w SharedPreferences
        }
    }
    // Pobieranie listy użytkowników
    public static List<User> getUsers() {
        return users;
    }

    // Dodanie nowego użytkownika
    public static void addUser(Context context, String username, String password) {
        users.add(new User(username, password));
        saveUsers(context);
    }

    // Zapisanie użytkowników do SharedPreferences
    private static void saveUsers(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        Gson gson = new Gson();
        String json = gson.toJson(users);
        editor.putString(USERS_KEY, json);
        editor.apply();

        System.out.println("Użytkownicy zapisani: " + json);
    }
}
