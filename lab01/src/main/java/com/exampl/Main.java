package com.exampl;

import com.example.model.*;
import com.exampl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Открываем Hibernate-сессию
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // 🔹 1. Используем уже существующие типы пользователей (id 1 – Преподаватель, id 2 – Студент)
            UserType studentType = session.get(UserType.class, 2);
            UserType tutorType = session.get(UserType.class, 1);

            if (studentType == null || tutorType == null) {
                throw new RuntimeException("❌ Ошибка: Не найдены записи UserType с ID 1 и 2!");
            }

            // 🔹 2. Используем уже существующие записи в UserTypeInfo
            UserTypeInfo studentGradeInfo = session.get(UserTypeInfo.class, 2); // "Класс обучения"
            UserTypeInfo tutorExperienceInfo = session.get(UserTypeInfo.class, 1); // "Опыт работы"

            if (studentGradeInfo == null || tutorExperienceInfo == null) {
                throw new RuntimeException("❌ Ошибка: Не найдены записи UserTypeInfo с ID 1 и 2!");
            }

            // 🔹 3. Создаем пользователей (студент и преподаватель)
            User student = new User("Анна", "Иванова", new Date(), "anna@example.com",
                    "+79001234567", "@anna_iv", "пароль123", studentType);
            session.save(student);

            User tutor = new User("Дмитрий", "Петров", new Date(), "dmitry@example.com",
                    "+79005556677", "@dmitry_petrov", "секретныйпароль", tutorType);
            session.save(tutor);

            // 🔹 4. Добавляем информацию студенту (Класс обучения) и преподавателю (Опыт работы)
            UserInfo studentInfo = new UserInfo(studentGradeInfo, student, "10 класс");
            session.save(studentInfo);

            UserInfo tutorInfo = new UserInfo(tutorExperienceInfo, tutor, "5 лет");
            session.save(tutorInfo);

            // 🔹 5. Связываем студента и преподавателя
            StudentsTutors studentsTutors = new StudentsTutors(student, tutor);
            session.save(studentsTutors);

            // 🔹 6. Создаем домашнее задание
            Homework homework = new Homework(5, "Геометрия", "Доказать теорему Пифагора", null, null);
            session.save(homework);

            // 🔹 7. Связываем ученика с домашним заданием и ставим оценку
            StudentsHomework studentsHomework = new StudentsHomework(student, homework, 90);
            session.save(studentsHomework);

            // 🔹 8. Добавляем дополнительные материалы студенту
            AdditionalMaterials additionalMaterials = new AdditionalMaterials(student, null);
            session.save(additionalMaterials);

            // 🔹 9. Создаем расписание (урок для ученика)
            Timetable timetable = new Timetable(student, new Date());
            session.save(timetable);

            // 🔹 10. Добавляем оплату ученика (без сеттеров)
            Paying paying = new Paying (student, 4500.00, 8, new Date(), new Date(), "Оплачено");
            session.save(paying);

            // Подтверждаем транзакцию
            transaction.commit();

            // Выводим данные в консоль
            System.out.println("✅ Данные успешно добавлены!");
            System.out.println("📌 Тип пользователя (студент): " + studentType);
            System.out.println("📌 Тип пользователя (преподаватель): " + tutorType);
            System.out.println("📌 Преподаватель: " + tutor);
            System.out.println("📌 Студент: " + student);
            System.out.println("📌 Информация о студенте: " + studentInfo);
            System.out.println("📌 Информация о преподавателе: " + tutorInfo);
            System.out.println("📌 Связь студент-репетитор: " + studentsTutors);
            System.out.println("📌 Домашнее задание: " + homework);
            System.out.println("📌 Оценка за дз: " + studentsHomework);
            System.out.println("📌 Доп. материалы: " + additionalMaterials);
            System.out.println("📌 Расписание: " + timetable);
            System.out.println("📌 Оплата: " + paying);

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Закрываем Hibernate
        HibernateUtil.shutdown();
    }
}
