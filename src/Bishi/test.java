package Bishi;

import org.junit.Test;

public class test {
    class A {

    }

    class B extends A {

    }

    class C extends B {

    }

    @Test
    public void main() {
        A a0 = new A();
        A a1 = new B();
        A a2 = new C();

    }
}
