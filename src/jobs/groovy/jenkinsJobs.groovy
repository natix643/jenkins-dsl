import groovy.transform.Field
import groovy.transform.TypeChecked

@Field String GIT_REPO = 'git@github.com:natix643/jenkins-dsl.git'

@TypeChecked
makeJobs() {
    job("jenkins-dsl - master - build") {
        scm {
            git {
                remote {
                    url GIT_REPO
                    branch 'master'
                }
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
