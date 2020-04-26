package e.com.greenworldar.notifications;

import java.util.List;

public class UserNotificationsDto {

    private long server_time;
    private List<UserReports> user_reports;

    public long getServer_time() {
        return server_time;
    }

    public List<UserReports> getUser_reports() {
        return user_reports;
    }

    public class UserReports{
        private int report_id;
        private int created_by;
        private long date_posted;
        private String person_name;
        private String contact_info;
        private String person_location;
        private String report_summary;

        public int getReport_id() {
            return report_id;
        }

        public void setReport_id(int report_id) {
            this.report_id = report_id;
        }

        public int getCreated_by() {
            return created_by;
        }

        public void setCreated_by(int created_by) {
            this.created_by = created_by;
        }

        public long getDate_posted() {
            return date_posted;
        }

        public void setDate_posted(long date_posted) {
            this.date_posted = date_posted;
        }

        public String getPerson_name() {
            return person_name;
        }

        public void setPerson_name(String person_name) {
            this.person_name = person_name;
        }

        public String getContact_info() {
            return contact_info;
        }

        public void setContact_info(String contact_info) {
            this.contact_info = contact_info;
        }

        public String getPerson_location() {
            return person_location;
        }

        public void setPerson_location(String person_location) {
            this.person_location = person_location;
        }

        public String getReport_summary() {
            return report_summary;
        }

        public void setReport_summary(String report_summary) {
            this.report_summary = report_summary;
        }
    }
}
