package lab_3_sort;

public class Watch {
    private long timeStart = 0;
    private long memoryStart = 0;
    private long timeEnd = 0;
    private long memoryEnd = 0;

    public void start() {
        timeStart = System.nanoTime();
        memoryStart = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    }

    public void stop() {
        timeEnd = System.nanoTime();
        memoryEnd = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    }

    public long getTime() {
        return timeEnd - timeStart;
    }

    public long getMemory() {
        return memoryEnd - memoryStart;
    }

    public  void printInfo(String name){
        System.out.println(name + ": nanosec:\t"
                + this.getTime()
                + "\t memory:\t"
                + this.getMemory());
    }
}
