package jenkins.dsl

import spock.lang.Specification

class LifeTest extends Specification{

    def life = new Life()

    def 'I chose life'() {
        assert life.chooseIt() == 'your future'
    }

    def 'I chose not to choose life'() {
        assert life.chooseSomethingElse() == 'heroin'
    }
}