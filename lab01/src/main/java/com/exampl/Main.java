package com.exampl;

import com.example.model.*;
import com.exampl.utils.HibernateUtil;
import com.exampl.utils.PasswordUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

//             🔹 1. Берем уже существующие типы пользователей
            UserType studentType = session.get(UserType.class, 2);
            if (studentType == null) {
                throw new RuntimeException("❌ Ошибка: Не найден UserType с ID 2!");
            }

            // 🔹 2. Создаем студента с паролем "пароль123"
            User student = new User("Анна", "Сергеевна", new Date(), "a@example.com",
                    "+79001134568", "@anna_iv", "пароль12", studentType);
            session.save(student);

            transaction.commit();
            System.out.println("✅ Пользователь успешно добавлен!");

            // 🔹 3. Проверяем, правильный ли введенный пароль
            String enteredPassword = "пароль12";
            boolean isPasswordCorrect = PasswordUtil.checkPassword(enteredPassword, student.getPasswordHash());

            System.out.println("🔑 Проверка пароля: " + (isPasswordCorrect ? "✅ Пароль верный" : "❌ Пароль неверный"));

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.shutdown();
    }
}
