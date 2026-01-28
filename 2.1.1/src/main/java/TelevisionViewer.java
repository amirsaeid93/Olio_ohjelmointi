public class TelevisionViewer {
    public static void main(String[] args) {
        Television tv = new Television();
        int days = 10;
        int channelsPerDay = 3;

        for (int day = 1; day <= days; day++) {
            System.out.println("Woke up, day " + day);
            tv.watchChannels(channelsPerDay);
            tv.fallAsleep();
        }
    }
}
