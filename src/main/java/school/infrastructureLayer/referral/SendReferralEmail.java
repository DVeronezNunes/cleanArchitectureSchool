package school.infrastructureLayer.referral;

import school.domainLayer.student.Student;

public class SendReferralEmail implements school.applicationLayer.SendReferralEmail {
    @Override
    public void sendTo(Student referredStudent) {
        //TODO: Send email with lib Java mail

    }
}
