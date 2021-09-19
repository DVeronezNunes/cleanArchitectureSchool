package school.applicationLayer;

import school.domainLayer.student.Student;

public interface SendReferralEmail {
    void sendTo(Student referredStudent);
}
