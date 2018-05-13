package books.thinkigInJava._4ThEdition.chapters.generics.mixins.usingTheDecoratorPattern;

class Decoration {

    TimeStamped t = new TimeStamped(new Basic());
    TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));

    SerialNumbered s = new SerialNumbered(new Basic());
    SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
}
