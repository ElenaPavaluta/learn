package oc.p.tests.chapters._12.q._22;

class Woods {

    public static void main(String[] args) {
        int water = 10 + 5;
//        water = 7;

        final class Oak extends Tree {
            int getWater() {
                return water;  //allowed since water is effective final
            }
        }
        System.out.println(new Oak().getWater());
    }

    static class Tree {
    }
}
