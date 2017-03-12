#!groovy
import groovy.io.FileType
import hudson.FilePath
import hudson.*



job("${pathWorkspace}/${folderName}/test") {
    logRotator(-1, 10)

    triggers {
        // githubPush()
        scm('H/2 * * * *')
    }
    steps{
        shell "ls -al ${pathWorkspace}/${folderName}"
    }
//    steps {
//
//        dsl {
//            external "test/jobs/createBuldTestJobs.groovy"
//        }
//    }
}