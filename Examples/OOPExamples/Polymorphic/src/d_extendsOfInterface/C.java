package d_extendsOfInterface;

/**
 * 接口的拓展，一一个接口可以拓展多个接口的功能
 * 这样的话C接口就也具备了A，B接口的方法，因此实现C接口的类就需要实现A，B，C的所有方法
 */
public interface C extends A, B{
    void funcC();
}
