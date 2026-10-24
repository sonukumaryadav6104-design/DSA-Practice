
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,String arriveBob, String leaveBob) {

        int Aad = Integer.parseInt(arriveAlice.substring(3, 5));
        int Aam = Integer.parseInt(arriveAlice.substring(0, 2));
        int Ald = Integer.parseInt(leaveAlice.substring(3, 5));
        int Alm = Integer.parseInt(leaveAlice.substring(0, 2));
        int Bad = Integer.parseInt(arriveBob.substring(3, 5));
        int Bam = Integer.parseInt(arriveBob.substring(0, 2));
        int Bld = Integer.parseInt(leaveBob.substring(3, 5));
        int Blm = Integer.parseInt(leaveBob.substring(0, 2));

        int month[] = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};

        int last_arrival_month = Math.max(Aam, Bam);

        int first_leave_month = Math.min(Alm, Blm);

        int last_arrival_date = (Aam == Bam) ? Math.max(Aad, Bad) : (Aam > Bam ? Aad : Bad);

        int first_leave_date = (Alm == Blm) ? Math.min(Ald, Bld) : (Alm < Blm ? Ald : Bld);

        if (last_arrival_month > first_leave_month){
            return 0;
        }

        if (last_arrival_month == first_leave_month) {

            if (last_arrival_date > first_leave_date){
                return 0;
            }

            return first_leave_date - last_arrival_date + 1;

        } else {
            
            int ans = 0;

            ans += month[last_arrival_month - 1] - last_arrival_date + 1;

            int i = last_arrival_month;

            while (i < first_leave_month - 1) {
                ans += month[i];
                i++;
            }

            return ans + first_leave_date;
        }
    }
}
