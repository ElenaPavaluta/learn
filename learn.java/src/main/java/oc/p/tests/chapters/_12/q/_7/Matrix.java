package oc.p.tests.chapters._12.q._7;

class Matrix {
    private int level = 1;

    class Deep {
        private int level = 2;

        class Deeper{
            private int level=3;

            void printReality(){
                System.out.println(level);  //3
                System.out.println(Deep.this.level);  //2
                System.out.println(Deep.this.level);  //2
            }
        }
    }

    public static void main(String[] args) {
        Matrix.Deep.Deeper mdd= new Matrix().new Deep().new Deeper();
        mdd.printReality();
    }
}
