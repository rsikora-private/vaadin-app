import spock.lang.Specification;

/**
 * Created by robertsikora on 15.05.2016.
 */
public class SpockExample extends Specification {

    def "maximum of two numbers"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }
}
