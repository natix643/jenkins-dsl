package jenkins.dsl

import org.junit.Test

class LifeTest {

    def life = new Life()

    @Test
    void iChoseLife() {
        assert life.chooseIt() == 'your future'
    }

    @Test
    void iChoseNotToChooseLife() {
        assert life.chooseSomethingElse() == 'heroin'
    }
}