package oc.p.tests.chapters._16.q._39;

class DiskPlayer implements AutoCloseable {
    @Override
    public void close() throws Exception {

    }
}

class LightCycle {

    static void m() {
        try (DiskPlayer dp = new DiskPlayer()) {
            System.out.println("ping");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("pong");
        }
        System.out.println("return");
    }

    public static void main(String[] args) {
        m();
    }
}
