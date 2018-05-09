package books.thinkigInJava._4ThEdition.chapters.generics.theActionAtTheBoundaries;

class SimpleHolder {

    private Object obj;

    Object getObj() {
        return obj;
    }

    void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.setObj("Item");
        String s = (String) holder.getObj();
    }
}
