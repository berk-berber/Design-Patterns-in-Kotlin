public class SingletonMainClass {
    public static void main(String[] args) {
        SingletonPattern singletonPattern = SingletonPattern.getInstance();
        singletonPattern.writeHelloWorld();
    }
}
class SingletonPattern {
    private static SingletonPattern singletonPattern;
    private static Object synchronizedObject = new Object();

    private SingletonPattern() { }

    public static SingletonPattern getInstance() {
        if (singletonPattern == null) {
            synchronized (SingletonPattern.class) {
                if (singletonPattern == null) {
                    singletonPattern = new SingletonPattern();
                }
            }
        }
        return singletonPattern;
    }

    public void writeHelloWorld() {
        System.out.println("Hello world!");
    }
}