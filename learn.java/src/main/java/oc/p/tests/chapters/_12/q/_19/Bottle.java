package oc.p.tests.chapters._12.q._19;

class Bottle {
    static class Ship {

        enum Sail {
            TALL("Tall") {
                protected int getHeight() {
                    return 100;
                }
            },
            SHORT("Short") {
                @Override
                protected int getHeight() {
                    return 2;
                }
            };

            private String name;

            Sail(String name) {
                this.name = name;
            }

            String getName() {
                return name;
            }

            protected abstract int getHeight();
        }

        Sail getSail() {
            return Sail.TALL;
        }
    }

    public static void main(String[] args) {
        Bottle bottle = new Bottle();

        Bottle.Ship ship = new Ship();
        Ship ship2 = new Ship();

        Bottle.Ship ship3 = new Bottle.Ship();
        Ship ship4  = new Bottle.Ship();
    }
}
