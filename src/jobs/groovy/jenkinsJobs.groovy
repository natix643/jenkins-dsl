import groovy.transform.Field
import groovy.transform.TypeChecked

@Field String GITHUB_REPO = 'natix643/jenkins-dsl'

@TypeChecked
def makeJobs() {
    job("master - build") {
        scm {
            github(GITHUB_REPO, 'master')
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
