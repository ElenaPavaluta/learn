package oc.p.tests.chapters._12.q._2;

enum DaysOff{
    Thanksgiving, PresidentsDay, ValentinesDay
}

class Vacantion {

    public static final void main(String[] args) {
        final DaysOff input = DaysOff.Thanksgiving;

        switch (input){
            default:
            case ValentinesDay:
                System.out.println("1");
                break;
            case PresidentsDay:
                System.out.println("2");
                break;
        }
    }
}
