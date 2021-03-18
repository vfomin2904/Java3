public class Application {
    private static Character currentAlpha = 'A';
    private static Object mon = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            for(int i = 0; i< 5; i++) {
                synchronized (mon) {
                    while (!currentAlpha.equals('A')) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println('A');
                    currentAlpha = 'B';
                    mon.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i< 5; i++) {
                synchronized (mon) {
                    while (!currentAlpha.equals('B')) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println('B');
                    currentAlpha = 'C';
                    mon.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i< 5; i++) {
                synchronized (mon) {
                    while (!currentAlpha.equals('C')) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println('C');
                    currentAlpha = 'A';
                    mon.notifyAll();
                }
            }
        }).start();

    }
}
