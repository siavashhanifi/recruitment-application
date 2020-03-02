package kth.iv1201.grupp10.recruitmentApplication.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MockApplications {

    private String applications;

    /**
     * Hard coded model of applications. TODO: fetch data from database.
     */
    public MockApplications() {
        this.applications = "["
              + "{"
              + "\"applicantName\": \"Sebastian\","
              + "\"applicantSsn\": 123456,"
              + "\"availability\": ["
                + "{"
                  + "\"fromDate\": \"2020/6/15\","
                  + "\"toDate\": \"2020/8/20\""
                + "},"
                + "{"
                  + "\"fromDate\": \"2021/1/25\","
                  + "\"toDate\": \"2021/4/15\""
                + "}"
              + "],"
              + "\"competenceProfile\": {"
                  + "\"competence\": ["
                    + "{\"name\": \"it\"},"
                    + "{\"name\": \"cooking\"}"
                  + "],"
                  + "\"yearsOfExperience\": 31"
                + "}"
            + "},"
      
            + "{"
              + "\"applicantName\": \"Sia\","
              + "\"applicantSsn\": 234567,"
              + "\"availability\": ["
                + "{"
                  + "\"fromDate\": \"2020/6/15\","
                  + "\"toDate\": \"2020/8/20\""
                + "},"
                + "{"
                  + "\"fromDate\": \"2021/1/25\","
                  + "\"toDate\": \"2021/4/15\""
                + "}"
              + "],"
              + "\"competenceProfile\": {"
                  + "\"competence\": ["
                    + "{\"name\": \"dancing\"},"
                    + "{\"name\": \"singing\"}"
                  + "],"
                  + "\"yearsOfExperience\": 25"
                + "}"
            + "},"
      
            + "{"
              + "\"applicantName\": \"Björn\","
              + "\"applicantSsn\": 345678,"
              + "\"availability\": ["
                + "{"
                  + "\"fromDate\": \"2020/6/15\","
                  + "\"toDate\": \"2020/8/20\""
                + "},"
                + "{"
                  + "\"fromDate\": \"2021/1/25 \","
                  + "\"toDate\": \"2021/4/15\""
                + "}"
              + "],"
              + "\"competenceProfile\": {"
                  + "\"competence\": ["
                    + "{\"name\": \"rollercoasters\"},"
                    + "{\"name\": \"popcorn\"}"
                  + "],"
                  + "\"yearsOfExperience\": 49"
                + "}"
                + "}"
                + "]";
    }

    /**
     * Getter
     * @return all applications
     */
    public String getApplications() {
        return this.applications;
    }
}