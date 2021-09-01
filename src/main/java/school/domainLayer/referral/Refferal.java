package school.domainLayer.referral;

import school.domainLayer.student.Student;

import java.time.LocalDateTime;

public class Refferal {

    private Student student;
    private Student referredStudent;
    private LocalDateTime referralDate;

    public Refferal(Student student, Student referredStudent) {
        this.student = student;
        this.referredStudent = referredStudent;
        this.referralDate = LocalDateTime.now();
    }

    public Student getStudent() {
        return student;
    }

    public Student getReferredStudent() {
        return referredStudent;
    }

    public LocalDateTime getReferralDate() {
        return referralDate;
    }
}
