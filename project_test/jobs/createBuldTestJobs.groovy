#!groovy
import groovy.io.FileType
import hudson.FilePath
import hudson.*



job("project_test/test") {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell "ls -al /var/lib/jenkins/workspace/cloneFromGit"
    }
//    steps {
//
//        dsl {
//            external "test/jobs/createBuldTestJobs.groovy"
//        }
//    }
}
