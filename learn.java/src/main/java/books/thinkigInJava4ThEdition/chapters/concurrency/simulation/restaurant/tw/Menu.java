package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.restaurant.tw;

import java.util.Random;

class Menu {

    private static Random rand = new Random(47);

    SingleCourse randomSelect(CourseType courseType) {
        switch(courseType) {
            case FIRST:
                return FirtCourse.randomSelect();
            case SECOND:
                return SecondCourse.randomSelect();
            case DESET:
                return Desert.randomSelect();
        }
        return null;
    }

    enum CourseType {
        FIRST,
        SECOND,
        DESET;
    }

    enum FirtCourse implements SingleCourse {
        FC_A(230, 100), FC_B(210, 110), FC_C(270, 120), FC_D(295, 130), FC_E(125, 200), FC_F(300, 100), FC_G(300, 200);

        private int prepareTime;
        private int eatTime;

        FirtCourse(int prepareTime, int eatTime) {
            this.prepareTime = prepareTime;
            this.eatTime = eatTime;
        }


        static FirtCourse randomSelect() {
            int pos = rand.nextInt(FirtCourse.values().length);
            return FirtCourse.values()[pos];
        }

        @Override
        public int prepareTime() {
            return prepareTime;
        }

        @Override
        public int eatTime() {
            return eatTime;
        }

        @Override
        public String dishName() {
            return name();
        }


    }

    enum SecondCourse implements SingleCourse {
        SC_A(230, 110), SC_B(290, 130), SC_C(270, 160), SC_D(190, 190), SC_E(250, 150), SC_F(290, 110), SC_G(140, 150);

        private int prepareTime;
        private int eatTime;

        SecondCourse(int prepareTime, int eatTime) {
            this.prepareTime = prepareTime;
            this.eatTime = eatTime;
        }

        static SingleCourse randomSelect() {
            int pos = rand.nextInt(SecondCourse.values().length);
            return SecondCourse.values()[pos];
        }

        @Override
        public int prepareTime() {
            return prepareTime;
        }

        @Override
        public int eatTime() {
            return eatTime;
        }

        @Override
        public String dishName() {
            return name();
        }


    }

    enum Desert implements SingleCourse {
        D_A(190, 70), D_B(150, 80), D_C(160, 50), D_D(140, 70), D_E(180, 80), D_F(120, 120), D_G(100, 120);

        private int prepareTime;
        private int eatTime;

        Desert(int prepareTime, int eatTime) {
            this.prepareTime = prepareTime;
            this.eatTime = eatTime;
        }

        static Desert randomSelect() {
            int pos = rand.nextInt(Desert.values().length);
            return Desert.values()[pos];
        }

        @Override
        public int prepareTime() {
            return prepareTime;
        }

        @Override
        public int eatTime() {
            return eatTime;
        }

        @Override
        public String dishName() {
            return name();
        }
    }
}
