package utils;

/**
 * @author Zeller
 * @Link <a href=" "> </a>
 * @Description
 * @Date 2018/11/21
 **/
public class MethodTimeUtils {

    private long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        if (startTime == 0) return;
        System.out.println("use time:" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = 0;
    }

    public static MethodTimeUtils getInstance() {
        return Singleton.INSTANCE;
    }

    public static class Singleton {
        public static MethodTimeUtils INSTANCE = new MethodTimeUtils();
    }
}
