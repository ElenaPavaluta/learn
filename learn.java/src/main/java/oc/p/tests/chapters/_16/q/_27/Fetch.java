package oc.p.tests.chapters._16.q._27;

class Fetch {

    int play (String dogName) throws Exception{
        try{
            throw new RuntimeException(dogName);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new Fetch().play("Webby");
        new Fetch().play("Gerorgette");
    }

}
