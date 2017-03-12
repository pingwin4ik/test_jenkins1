#!groovy
import groovy.io.FileType
import hudson.FilePath
import hudson.*



job('test') {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell 'ls -al ${pathWorkspace}'
    }
//    steps {
//
//        dsl {
//            external "test/jobs/createBuldTestJobs.groovy"
//        }
//    }
}