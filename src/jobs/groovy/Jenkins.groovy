import groovy.transform.Field
import groovy.transform.TypeChecked

@Field String GIT_URL = 'git@github.com:natix643/jenkins-dsl.git'

@TypeChecked
def makeJobs() {
    job("master - build") {
        scm {
            git {
                remote {
                    url GIT_URL
                }
                branch 'master'
            }
        }

        triggers {
            scm 'H/2 * * * *'
        }

        steps {
            gradle {
                tasks 'clean build'
                makeExecutable true
            }
        }
    }
}

makeJobs()
