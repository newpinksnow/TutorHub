import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeName;

    @OneToMany(mappedBy = "userType")
    private List<User> users;
}

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String subject;
    private String className;
    private String email;
    private String phone;
    private String telegramm;
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    @OneToMany(mappedBy = "student")
    private List<Points> points;

    @OneToMany(mappedBy = "student")
    private List<StudentsHomework> studentsHomework;

    @OneToOne(mappedBy = "student")
    private AdditionalMaterials additionalMaterials;

    @OneToMany(mappedBy = "student")
    private List<Paying> payments;

    @OneToMany(mappedBy = "student")
    private List<Timetable> timetables;
}

@Entity
@Table(name = "paying")
public class Paying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payingId;
    private double money;
    private int numberLesson;
    private Date dataStart;
    private Date dataFinish;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;
}

@Entity
@Table(name = "timetable")
public class Timetable {
    @EmbeddedId
    private TimetableId id;
    private String nameMonth;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, insertable = false, updatable = false)
    private User student;
}

@Embeddable
class TimetableId {
    private int studentId;
    private int monthId;
}

@Entity
@Table(name = "timetable_day")
public class TimetableDay {
    @EmbeddedId
    private TimetableDayId id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "studentId", insertable = false, updatable = false),
            @JoinColumn(name = "month_id", referencedColumnName = "monthId", insertable = false, updatable = false)
    })
    private Timetable timetable;
}

@Embeddable
class TimetableDayId {
    private int studentId;
    private int monthId;
    private String dayId;
}
