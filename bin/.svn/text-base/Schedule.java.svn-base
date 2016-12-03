import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {
    private static final char SPACE = ' ';

    private static final int VALID_DATE_CHECK_INDEX = 10;
    private static final int BEGIN_INDEX = 6;
    private static final int END_INDEX = 19;

    public String startDate;
    public String finishDate;
    public MeetingTime meetingTime;

    public Schedule(String startDate, String finishDate, MeetingTime meetingTime){
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.meetingTime = meetingTime;
    }

    public Schedule(){}

    public String toString(){
        convertDate();

        return "StartDate: " + startDate + " FinishDate: " + finishDate + " " + meetingTime;
    }

    private void convertDate(){
        if(startDate != null){
            if(startDate.charAt(VALID_DATE_CHECK_INDEX) != SPACE) {
                startDate = startDate.substring(BEGIN_INDEX, END_INDEX);
                finishDate = finishDate.substring(BEGIN_INDEX, END_INDEX);

                long start = Long.parseLong(startDate);
                long finish = Long.parseLong(finishDate);

                Date sdt = new Date(start);
                Date fdt = new Date(finish);

                SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                startDate = sfd.format(sdt);
                finishDate = sfd.format(fdt);
            }
        }
    }
}
