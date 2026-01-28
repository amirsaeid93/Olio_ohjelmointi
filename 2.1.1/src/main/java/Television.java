public class Television {
    private int currentChannel = 1;

    public void watchChannels(int numberOfChannels) {
        for (int i = 0; i < numberOfChannels; i++) {
            System.out.println("Watching channel " + currentChannel);
            currentChannel++;
            if (currentChannel > 10) {
                currentChannel = 1;
            }
        }
    }

    public void fallAsleep() {
        System.out.println("Falling asleep");
    }
}