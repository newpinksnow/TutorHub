package com.exampl.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // ✅ Хэширование пароля
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    // ✅ Проверка пароля (сравнивает введенный пароль с хэшем)
    public static boolean checkPassword(String enteredPassword, String hashedPassword) {
        return BCrypt.checkpw(enteredPassword, hashedPassword);
    }
}
