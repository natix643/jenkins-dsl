import groovy.transform.Field
import groovy.transform.TypeChecked

@Field String GIT_REPO = 'git@github.com:natix643/jenkins-dsl.git'
@Field List<String> branches = ['master', 'development']

@TypeChecked
makeJobs() {
    branches.each { branchName ->

        job("jenkins-dsl - $branchName - build") {
            scm {
                git {
                    remote {
                        url GIT_REPO
                        branch branchName
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
}

makeJobs()
