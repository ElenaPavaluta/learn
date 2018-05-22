package oc.p.chapters.c_8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.serializableInterface;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ComplexClass implements Serializable {

    private static String staticString;

    static {
        staticString = "This is a static String";
    }

    private final LocalDateTime localDateTime;
    private final transient String transientString;
    private Integer id;
    private MemberClass memberClass;
    private StaticClass staticClass;

    {
        localDateTime = LocalDateTime.now();
        transientString = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public ComplexClass(Integer id, MemberClass memberClass, StaticClass staticClass) {
        this.id = id;
        this.memberClass = memberClass;
        this.staticClass = staticClass;
    }

    public static String getStaticString() {
        return staticString;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public MemberClass getMemberClass() {
        return memberClass;
    }

    public StaticClass getStaticClass() {
        return staticClass;
    }

    public String getTransientString() {
        return transientString;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ComplexClass{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", memberClass=" + memberClass +
                ", staticClass=" + staticClass +
                ", transientString='" + transientString + '\'' +
                '}' +
                "staticString=" + staticString;
    }

    static class StaticClass implements Serializable {
        String name;
        transient String password;

        public StaticClass(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "StaticClass{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    class MemberClass implements Serializable{
        String name;
        transient String password;

        public MemberClass(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "MemberClass{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

}
